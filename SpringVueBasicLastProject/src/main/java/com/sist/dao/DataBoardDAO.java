package com.sist.dao;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class DataBoardDAO {
	@Autowired
	private DataBoardMapper mapper;
	
	public List<DataBoardVO> databoardListData(Map map){
		return mapper.databoardListData(map);
	}
	public int databoardTotalPage() {
		return mapper.databoardTotalPage();
	}
	
	public void dataBoardInsert(DataBoardVO vo) {
		mapper.dataBoardInsert(vo);
	}
	/*
	 *  @Update("UPDATE vueDataBoard SET "
			+"hit=hit+1 "
			+"WHERE no=#{no}")
	public void hitIncrement(int no);
	
	@Select("SELECT no,name,subject,content,hit, "
			+"TO_CHAR(regdate,'yyyy-MM-dd') as dbday "
			+"filename,filesize,filecount "
			+"FROM vueDataBoard "
			+"WHERE no=#{no}")
	public  DataBoardVO databoardDetailData(int no);
	 */
	public DataBoardVO databoardDetailData(int no) {
		mapper.hitIncrement(no);
		return mapper.databoardDetailData(no);
	}
	
}
