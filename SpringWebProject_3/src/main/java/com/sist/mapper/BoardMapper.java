package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;
public interface BoardMapper {
	@Select("SELECT no,subject,name,hit,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,num "
			+"FROM (SELECT no,subject,name,hit,regdate,rownum as num "
			+"FROM (SELECT no,subject,name,hit,regdate "
			+"FROM freeboard ORDER BY no DESC)) "
			+"WHERE num BETWEEN #{start} AND #{end}")
	public List<BoardVO> boardListData(@Param("start") int start,@Param("end") int end);
	// boardListData(1,10) => param
	// hashMap �� �±׷� ����
	@Select("SELECT CEIL(COUNT(*)/10.0) FROM freeboard")
	public int boardTotalPage();
	// �󼼺���
	@Update("UPDATE freeboard SET "
			+"hit=hit+1 "
			+ "WHERE no=#{no}")
	public void hitIncrement(int no);
	@Select("SELECT no,name,subject,content,hit,TO_CHAR(regdate,'YYYY-MM-DD') as dbday "
			+"FROM freeboard "
			+ "WHERE no=#{no}")
	public BoardVO boardDetailData(int no);
	
	// �߰� 
	@Insert("INSERT INTO freeboard VALUES(" 
			+"(SELECT NVL(MAX(no)+1,1) FROM freeboard)," 
			+"#{name},#{subject},#{content},#{pwd}," 
			+"SYSDATE,0)")
	public void boardInsert(BoardVO vo);
	// 수정
	@Select("SELECT pwd FROM freeboard "
			+"WHERE no=#{no}")
	public String boardGetPassword(int no);
	
	@Update("UPDATE freeboard SET "
			+"name=#{name},subject=#{subject}, "
			+"content=#{content} "
			+"WHERE no=#{no}")
	public void boardUpdate(BoardVO vo);
	// 삭제
	@Delete("DELETE FROM freeboard "
			+"WHERE no=#{no}")
	public void boardDelete(int no);
}
