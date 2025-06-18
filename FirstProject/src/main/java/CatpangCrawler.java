import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.sql.*;
import java.util.*;

public class CatpangCrawler {

    public static void main(String[] args) throws Exception {
        String jdbcUrl = "jdbc:oracle:thin:@211.238.142.124:1521:XE";
        String username = "hr_2";
        String password = "happy";

        Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
        int page = 1;

        while (true) {
            String listUrl = "https://www.catpang.com/shop/goods/goods_list.php?category=001001&page=" + page;
            System.out.println("🌀 페이지 " + page + " 크롤링 중...");
            Document listDoc;

            try {
                listDoc = Jsoup.connect(listUrl)
                        .userAgent("Mozilla/5.0")
                        .timeout(10000)
                        .maxBodySize(0)
                        .get();
            } catch (Exception e) {
                System.out.println("❌ 페이지 로딩 실패: " + listUrl);
                e.printStackTrace();
                break;
            }

            Elements products = listDoc.select("div.flex-item");

            if (products.isEmpty()) {
                System.out.println("✅ 더 이상 상품이 없습니다. 크롤링 종료!");
                break;
            }

            for (Element product : products) {
                Element titleEl = product.selectFirst(".flex-contents span");
                Element priceEl = product.selectFirst(".view-price-new .price");
                Element imageEl = product.selectFirst("img.list-img-source");
                Element linkEl = product.selectFirst("a.flex-link");

                if (titleEl == null || priceEl == null || imageEl == null || linkEl == null) {
                    System.out.println("⚠️ 누락된 요소 발견 - 해당 상품 스킵");
                    continue;
                }

                String title = titleEl.text().trim();
                String price = priceEl.text().trim();
                String imageUrl = imageEl.attr("src");
                String detailUrl = "https://www.catpang.com" + linkEl.attr("href");

                if (isDuplicate(conn, detailUrl)) {
                    System.out.println("⚠️ 중복 상품, 저장 생략: " + title);
                    continue;
                }

                Map<String, String> detailMap;
                try {
                    detailMap = fetchDetailInfo(detailUrl);
                } catch (Exception e) {
                    System.out.println("❌ 상세 페이지 크롤링 실패: " + detailUrl);
                    e.printStackTrace();
                    continue;
                }

                System.out.println("------------------------------------------------");
                System.out.println("상품명: " + title);
                System.out.println("가격: " + price);
                System.out.println("이미지: " + imageUrl);
                System.out.println("상세 URL: " + detailUrl);
                System.out.println("상품설명: " + detailMap.getOrDefault("상품설명", ""));

                try {
                    saveToDatabase(conn, title, price, imageUrl, detailUrl, detailMap);
                    System.out.println("✅ DB 저장 완료");
                } catch (SQLException e) {
                    System.out.println("❌ DB 저장 실패");
                    e.printStackTrace();
                }
            }

            page++;
        }

        conn.close();
    }

    private static boolean isDuplicate(Connection conn, String detailUrl) throws SQLException {
        String sql = "SELECT COUNT(*) FROM P_CAT_FOOD WHERE DETAIL_URL = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, detailUrl);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next() && rs.getInt(1) > 0;
            }
        }
    }

    private static Map<String, String> fetchDetailInfo(String detailUrl) throws Exception {
        Map<String, String> detailMap = new LinkedHashMap<>();

        Document doc = Jsoup.connect(detailUrl)
                .userAgent("Mozilla/5.0")
                .timeout(10000)
                .maxBodySize(0)
                .get();

        Element content = doc.selectFirst("div#content_view_desc");

        if (content != null) {
            Elements blocks = content.select("dl.add-info");

            for (Element block : blocks) {
                String dt = block.selectFirst("dt").text().trim();
                Element dd = block.selectFirst("dd");
                String value = dd != null ? dd.text().trim() : "";
                detailMap.put(dt, value);
            }
        }

        return detailMap;
    }

    private static void saveToDatabase(Connection conn, String title, String price, String imageUrl, String detailUrl, Map<String, String> detailMap) throws SQLException {
        String sql = "INSERT INTO P_CAT_FOOD (TITLE, PRICE, IMAGE_URL, DETAIL_URL, ORIGIN, MANUFACTURER, EXPIRY, AGE_RECOMMENDATION, WEIGHT, INGREDIENTS, NUTRITION, DESCRIPTION) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, title);
            pstmt.setString(2, price);
            pstmt.setString(3, imageUrl);
            pstmt.setString(4, detailUrl);
            pstmt.setString(5, detailMap.getOrDefault("원산지", ""));
            pstmt.setString(6, detailMap.getOrDefault("제조사/수입사", ""));
            pstmt.setString(7, detailMap.getOrDefault("유통기한", ""));
            pstmt.setString(8, detailMap.getOrDefault("권장연령", ""));
            pstmt.setString(9, detailMap.getOrDefault("용량/중량", ""));
            pstmt.setString(10, detailMap.getOrDefault("원료구성", ""));
            pstmt.setString(11, detailMap.getOrDefault("성분구성", ""));
            pstmt.setString(12, detailMap.getOrDefault("상품설명", ""));
            pstmt.executeUpdate();
        }
    }
}
