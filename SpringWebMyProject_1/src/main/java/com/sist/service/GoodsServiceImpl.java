package com.sist.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.vo.*;
import com.sist.dao.*;
@Service
public class GoodsServiceImpl implements GoodsService{
	/*
	 * @Service
public class FoodRecipeServiceImpl implements FoodRecipeService {
	@Autowired
	private FoodDAO fDao;

	@Override
	public List<FoodVO> foodListData(Map map) {
		// TODO Auto-generated method stub
		return fDao.foodListData(map);
	}

	@Override
	public FoodVO foodDetailData(int fno) {
		// TODO Auto-generated method stub
		return fDao.foodDetailData(fno);
	}
	@Override
	public int foodTotalPage() {
		// TODO Auto-generated method stub
		return fDao.foodTotalPage();
	}
}
	 */
	@Autowired
	private GoodsDAO gDao;

	@Override
	public List<GoodsVO> goodsListData(Map map) {
		// TODO Auto-generated method stub
		return gDao.goodsListData(map);
	}

	@Override
	public int goodsTotalPage() {
		// TODO Auto-generated method stub
		return gDao.goodsTotalPage();
	}

	@Override
	public List<GoodsVO> goodsFindData(Map map) {
		// TODO Auto-generated method stub
		return gDao.goodsFindData(map);
	}

	@Override
	public int goodsFindTotalPage(Map map) {
		// TODO Auto-generated method stub
		return gDao.goodsFindTotalPage(map);
	}
	
}
