package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface GoodsMapper {
	@Select("SELECT no,goods_name,goods_sub,goods_price,goods_poster,num "
			+ "FROM (SELECT no,goods_name,goods_sub,goods_price,goods_poster,rownum as num "
			+ "FROM (SELECT /*+ INDEX_ASC(goods_all ga_no_pk)*/no,goods_name,goods_sub,goods_price,goods_poster "
			+ "FROM goods_all)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<GoodsVO> goodsListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM goods_all ")
	public int goodsTotalPage();
	
	@Select("SELECT * FROM goods_all "
			+"WHERE no=#{no}")
	public GoodsVO goodsDetailData(int no);
	
	public List<GoodsVO> goodsFindData(Map map);
	public int goodsFindTotalPage(Map map);
}
