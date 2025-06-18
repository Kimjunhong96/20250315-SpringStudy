import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PetFacility {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:oracle:thin:@211.238.142.124:1521:XE";
        String username = "hr_2";
        String password = "happy";

        String excelFilePath = "C:\\Users\\sist-116\\Desktop\\2차 프로젝트\\애완동물시설크롤링.xlsx"; 

        try (
            FileInputStream inputStream = new FileInputStream(excelFilePath);
            Workbook workbook = new XSSFWorkbook(inputStream);
            Connection conn = DriverManager.getConnection(jdbcUrl, username, password)
        ) {
            Sheet firstSheet = workbook.getSheetAt(0);
            int rowCount = 0;

            for (Row row : firstSheet) {
                if (rowCount == 0) { // 헤더는 skip
                    rowCount++;
                    continue;
                }

                String sql = "INSERT INTO P_PET_FACILITY (FCLTY_NM, CTGRY_ONE_NM, CTGRY_TWO_NM, CTGRY_THREE_NM, " +
                        "CTPRVN_NM, SIGNGU_NM, LEGALDONG_NM, LI_NM, LNBR_NO, ROAD_NM, BULD_NO, " +
                        "LC_LA, LC_LO, ZIP_NO, RDNMADR_NM, LNM_ADDR, TEL_NO, HMPG_URL, " +
                        "RSTDE_GUID_CN, OPER_TIME, PARKNG_POSBL_AT, UTILIIZA_PRC_CN, PET_POSBL_AT, PET_INFO_CN, " +
                        "ENTRN_POSBL_PET_SIZE_VALUE, PET_LMTT_MTR_CN, IN_PLACE_ACP_POSBL_AT, OUT_PLACE_ACP_POSBL_AT, " +
                        "FCLTY_INFO_DC, PET_ACP_ADIT_CHRGE_VALUE, LAST_UPDT_DE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    for (int i = 0; i < 31; i++) {
                        Cell cell = row.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                        String value = getCellValue(cell);

                        // 빈 값이 들어가면 안 되는 컬럼: NOT NULL 컬럼 기본값 대체
                        if ((i == 7 || i == 8 || i == 9 || i == 10 || i == 11 || i == 14 || i == 15 || i == 16 || i == 17 || i == 18 || i == 24 || i == 25 || i == 26 || i == 27)) {
                            if (value == null || value.trim().isEmpty()) {
                                value = "-";
                            }
                        }

                        pstmt.setString(i + 1, value);
                    }

                    pstmt.executeUpdate();
                }
                rowCount++;
            }

            System.out.println("전체 데이터 입력 완료: " + (rowCount - 1) + "건.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getCellValue(Cell cell) {
        if (cell == null) return "";

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            default:
                return "";
        }
    }
}



