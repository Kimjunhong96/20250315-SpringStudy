package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.manager.*;
import com.sist.mapper.BusanInfoMapper;
import com.sist.vo.*;
@Repository
public class BusanInfoDAO {
	@Autowired
	// 스프링에서 메모리 할당을 한 클래스의 주소를 받는 경우 => 클래스 객체 주소만 받을 수 있다
	private BusanInfoMapper mapper;
	
	// 구현 
	/*
	 *  MyBatis : XML , Annotation
	 *           => XML + Annotation 
	 *                    ==== 간단한 SQL 
	 *             ===== 동적 쿼리 / SQL문장이 긴 경우
	 *             => <select> @Select()
	 *             => resultType parameterType
	 */
	public List<BusanInfoVO> busanInfoListData(Map map){
		return mapper.busanInfoListData(map);
		// MyBatis 에서 구현된 메소드 호출
	}
	
	public int busanInfoTotalPage(int cno) {
		return mapper.busanInfoTotalPage(cno);
	}
	/*
	 *  
	 */
	public BusanInfoVO busanInfoDetailData(int no) {
		return mapper.busanInfoDetailData(no);
	}
}
