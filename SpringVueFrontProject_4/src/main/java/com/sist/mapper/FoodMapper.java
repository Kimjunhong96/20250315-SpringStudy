package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface FoodMapper {
	@Select("SELECT fno,name,poster,num "
			+"FROM (SELECT fno,name,poster,rownum as num "
			+"FROM (SELECT /*+ INDEX_ASC(project_food pf_fno_pk*/fno,name,poster "
			+"FROM project_food WHERE fno IN(SELECT fno FROM project_food INTERSECT SELECT fno FROM project_food))) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List <FoodVO> foodListData(@Param("start") int start, @Param("end") int end);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM project_food " 
			  +"WHERE fno IN(SELECT fno FROM project_food INTERSECT SELECT fno FROM project_food)")
		public int foodTotalPage();
	
	@Select("SELECT fno,name,poster,num "
			+"FROM (SELECT fno,name,poster,rownum as num "
			+"FROM (SELECT /*+ INDEX_ASC(project_food pf_fno_pk*/fno,name,poster "
			+"FROM project_food WHERE address LIKE '%'||#{fd}||'%')) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List <FoodVO> foodFindListData(Map amp);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM project_food " 
			  +"WHERE address LIKE '%'||#{fd}||'%'")
		public int foodFindTotalPage(String fd);
	
	@Select("SELECT * FROM project_food " 
			+"WHERE fno=#{fno}")
	public FoodVO foodDetailData(int fno);
}
