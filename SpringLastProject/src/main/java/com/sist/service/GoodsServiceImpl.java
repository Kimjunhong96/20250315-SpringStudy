package com.sist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sist.dao.GoodsDAO;
import com.sist.service.*;
import com.sist.vo.*;
public class GoodsServiceImpl implements GoodsService {
	@Autowired
	private GoodsDAO gDao;

	@Override
	public List<GoodsVO> busanGoodsListData(int start, int end) {
		// TODO Auto-generated method stub
		return gDao.busanGoodsListData(start, end);
	}

	@Override
	public int busanGoodsTotalPage() {
		// TODO Auto-generated method stub
		return gDao.busanGoodsTotalPage();
	}

	@Override
	public GoodsVO busanGoodsDetailData(int no) {
		// TODO Auto-generated method stub
		return gDao.busanGoodsDetailData(no);
	}
	
}
