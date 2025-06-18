package com.sist.dao;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
public class DataBoardDAO {
	@Autowired
	private DataBoardMapper mapper;
	
	public List<DataBoardVO> boardListData(int start,int end){
		return mapper.boardListData(start, end);
	}
	public int boardRowCount() {
		return mapper.boardRowCount();
	}
	public int boardInsert(DataBoardVO vo) {
		mapper.boardInsert(vo);
		return mapper.boardCurentNoData(); // 현제 번호
	}
	/*
	 * @Update("UPDATE springDataBoard SET "
			+"hit=hit+1 "
			+"WHERE no=#{no}")
	public void hitIncrement(int no);
	
	@Select("SELECT * FROM springdataboard "
		+"WHERE no=#{no}")
	public DataBoardVO databoardDetailData(int no);
	 */
	public DataBoardVO databoardDetailData(int no) {
		mapper.hitIncrement(no);
		return 
	}
}
