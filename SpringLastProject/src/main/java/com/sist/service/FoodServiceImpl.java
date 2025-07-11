package com.sist.service;

import java.util.List;

import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.vo.FoodVO;
import com.sist.dao.*;
// 의존성을 낮게 / DAO여러개를 통합해서 사용
@Service
public class FoodServiceImpl implements FoodService {
	@Autowired
	private FoodDAO fDao;
	
	@Override
	public List<FoodVO> busanFoodListData(int start, int end) {
		// TODO Auto-generated method stub
		return fDao.busanFoodListData(start, end);
	}

	@Override
	public int busanFoodTotalPage() {
		// TODO Auto-generated method stub
		return fDao.busanFoodTotalPage();
	}

	@Override
	public FoodVO busanFoodDetailData(int fno) {
		// TODO Auto-generated method stub
		return fDao.busanFoodDetailData(fno);
	}

}
