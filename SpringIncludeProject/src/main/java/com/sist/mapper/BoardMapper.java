package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;

public interface BoardMapper {
	 String sql="SELECT no,subject,name,hit,regdate,num "
			    +"FROM (SELECT no,subject,name,hit,regdate,rownum as num "
			    +"FROM (SELECT no,subject,name,hit,regdate "
			    +"FROM springReplyBoard ORDER BY no DESC)) "
			    +"WHERE num BETWEEN #{start} AND #{end}";
	@Select(sql)
	public List<BoardVO> boardListData(Map map);
}



/*
 * 
 * package com.sist.web.board.mapper;

import java.util.*;
import org.apache.ibatis.annotations.*;

import com.sist.web.board.vo.BoardVO;

@Mapper
public interface BoardMapper {

    // 게시글 목록
    @Select("SELECT * FROM board ORDER BY post_id DESC")
    public List<BoardVO> boardList();

    // 게시글 상세 조회
    @Select("SELECT * FROM board WHERE post_id = #{post_id}")
    public BoardVO boardDetail(@Param("post_id") int post_id);

    // 게시글 작성
    @Insert("""
        INSERT INTO board(post_id, user_no, type, title, content, created_at, views, like_count)
        VALUES (board_seq.nextval, #{user_no}, #{type}, #{title}, #{content}, SYSDATE, 0, 0)
    """)
    public void boardInsert(BoardVO vo);

    // 게시글 수정
    @Update("""
        UPDATE board
        SET title = #{title}, content = #{content}, type = #{type}
        WHERE post_id = #{post_id}
    """)
    public void boardUpdate(BoardVO vo);

    // 게시글 삭제
    @Delete("DELETE FROM board WHERE post_id = #{post_id}")
    public void boardDelete(@Param("post_id") int post_id);

    // 조회수 증가
    @Update("UPDATE board SET views = views + 1 WHERE post_id = #{post_id}")
    public void boardHit(@Param("post_id") int post_id);

    // 게시글 개수 (페이징용)
    @Select("SELECT COUNT(*) FROM board")
    public int boardCount();
}

*/
