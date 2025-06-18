package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;
/*
 *  1. DAO => Repository : table 한개 제어
 *  2. 
 */
@Repository
public class EmpDAO {
	// 구현을 스플링에서 구현 => 구현된 메모리 주소값 받기
	@Autowired // 자동 주입 
	private EmpMapper mapper;
	public List<EmpVO> empListData()
	{
		return mapper.empListData();
	}
	
	public List<DeptVO> deptListData(){
		return mapper.deptListData();
	}
}
