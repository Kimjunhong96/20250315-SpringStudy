package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;
@Repository
public class BoardDAO {
	@Autowired
	private BoardMapper mapper;
	
	/*
	 * public List<BoardVO> boardListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/10.0) FROM vueBoard")
	public int boardTotalPage();
	 */
	public List<BoardVO> boardListData(Map map){
		return mapper.boardListData(map);
	}
	public int boardTotalPage() {
		return mapper.boardTotalPage();
	}
/*
 * @Insert("INSERT INTO vueBoard(no,name,subject,content,pwd) "
	  		+ "VALUES(vue_no_seq.nextval,#{name},#{subject},#{content},#{pwd})")
	  public void boardInsert(BoardVO vo);
 */
	public void boardInsert(BoardVO vo) {
		mapper.boardInsert(vo);
	}
	/*
	 * 
	 */
	 public BoardVO boardDetailData(int no) {
		 mapper.hitIncrement(no);
		 return mapper.boardDetailData(no);
	 }
	 public BoardVO boardUpdateData(int no)
	  {
		  return mapper.boardDetailData(no);
	  }
	 /*
	  * @Select("SELECT pwd FROM vueBoard "
	  		+ "WHERE no=#{no}")
	  public String boardGetPassword(int no);
	  
	  @Update("UPDATE vueBoard SET "
	  		+ "name=#{name},subject=#{subject},content=#{content} "
	  		+ "WHERE no=#{no}")
	  public void boardUpdate(BoardVO vo);
	  */
	 public String boardUpdate(BoardVO vo) {
		 String result="no";
		 String db_pwd=mapper.boardGetPassword(vo.getNo());
		 if(db_pwd.equals(vo.getPwd())) {
			 result="yes";
			 mapper.boardUpdate(vo);
		 }
		 return result;
	 }
}
