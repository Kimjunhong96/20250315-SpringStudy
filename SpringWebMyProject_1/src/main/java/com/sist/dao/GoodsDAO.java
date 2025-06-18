package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;
@Repository
public class GoodsDAO {
	@Autowired
	private GoodsMapper mapper;
	/*
	 * @Select("SELECT no,goods_name,goods_sub,goods_price,goods_poster,num "
			+ "FROM (SELECT no,goods_name,goods_sub,goods_price,goods_poster,rownum as num "
			+ "FROM (SELECT no,goods_name,goods_sub,goods_price,goods_poster, "
			+ "FROM goods_all)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<GoodsVO> goodsListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM goods_all ")
	public int goodsTotalPage();
	 */

	public List<GoodsVO> goodsListData(Map map){
		return mapper.goodsListData(map);
	}
	
	public int goodsTotalPage() {
		return mapper.goodsTotalPage();
	}
	 
	public List<GoodsVO> goodsFindData(Map map){
		return mapper.goodsListData(map);
	}
	public int goodsFindTotalPage(Map map) {
		return mapper.goodsFindTotalPage(map);
	}
}
