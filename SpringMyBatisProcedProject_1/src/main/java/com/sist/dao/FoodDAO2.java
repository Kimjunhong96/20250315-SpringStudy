package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
public class FoodDAO2 {
	@Autowired
	private FoodMapper mapper;
	
	// public int foodTotalPage() 
	public int foodTotalPage() {
		return mapper.foodTotalPage();
	}
	/*
	 *  
	 */
	public List<FoodVO> foodListData(Map map){
		mapper.foodListData(map);
		return (List<FoodVO>)map.get("pResult");
	}
}
