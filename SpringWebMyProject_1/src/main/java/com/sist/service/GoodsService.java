package com.sist.service;

import java.util.List;
import java.util.Map;

import com.sist.vo.GoodsVO;

public interface GoodsService {
	public List<GoodsVO> goodsListData(Map map);
	public int goodsTotalPage();
	public List<GoodsVO> goodsFindData(Map map);
	public int goodsFindTotalPage(Map map);
}
