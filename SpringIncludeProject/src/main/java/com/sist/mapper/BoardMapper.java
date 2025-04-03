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
