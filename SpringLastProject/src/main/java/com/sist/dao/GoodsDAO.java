package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;
/*
 *  
 */
@Repository
public class GoodsDAO {
	// 스프링에서 구현된 Mapper 의 주소 읽기
	@Autowired
	private GoodsMapper mapper;
	
	public List<GoodsVO> busanGoodsListData(int start,int end){
		return mapper.busanGoodsListData(start, end);
	}
	public int busanGoodsTotalPage() {
		return mapper.busanGoodsTotalPage();
	}
	public GoodsVO busanGoodsDetailData(int no) {
		return mapper.busanGoodsDetailData(no);
	}
}
