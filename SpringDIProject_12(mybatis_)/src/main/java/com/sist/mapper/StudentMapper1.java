package com.sist.mapper;
/*
 * 	<select id="studentListData" resultType="StudentVO">
   	 SELECT * FROM student
   </select>
   <select id="studentDetailData" resultType="StudentVO" parameterType="int">
     SELECT * FROM student
     WHERE hakbun=#{hakbun}
   </select>
   <insert id="studentInsert" parameterType="StudentVO">
   	<selectKey keyProperty="hakbun" resultType="int" order="BEFORE">
	   SELECT NVL(MAX(hakbun)+1,1) as hakbun FROM student
   	</selectKey>
   	 INSERT INTO student VALUES(
   	 	#{hakbun},#{name},#{kor},#{eng},#{math}
   	 )
   </insert>
   <!-- @Delete -->
   <delete id="studentDelete" parameterType="int">
   	 DELETE FROM student
   	 WHERE hakbun=#{hakbun}
   </delete>
   <!-- @Update -->
   <update id="studentUpdate" parameterType="StudentVO">
   	 UPDATE student SET
   	 name=#{name},kor=#{kor},eng=#{eng},math=#{math}
   	 WHERE hakbun=#{hakbun}
   </update>
 */
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;
public interface StudentMapper1 {
	@Select("SELECT * FROM student")
	public List<StudentVO> studentListData();
	
	@Select("SELECT * FROM student "
			+ "WHERE hakbun=#{hakbun}")
	public StudentVO studentDetailData(int hakbun);
	
	/*
	 * <insert id="studentInsert" parameterType="StudentVO">
   	<selectKey keyProperty="hakbun" resultType="int" order="BEFORE">
	   SELECT NVL(MAX(hakbun)+1,1) as hakbun FROM student
   	</selectKey>
   	 INSERT INTO student VALUES(
   	 	#{hakbun},#{name},#{kor},#{eng},#{math}
   	 )
	 */
	// Sequence / subquery
	@SelectKey(keyProperty = "hakbun",resultType = int.class, before = true, 
			statement = "SELECT NVL(MAX(hakbun)+1,1) as hakbun FROM student")
	@Insert("INSERT INTO student VALUES("
			+ "#{hakbun},#{name},#{kor},#{eng},#{math})")
	public void studentInsert(StudentVO vo);
	/*
	 * <delete id="studentDelete" parameterType="int">
   	 DELETE FROM student
   	 WHERE hakbun=#{hakbun}
   </delete>
	 */
	@Delete("DELETE FROM student "
			+ "WHERE hakbun=#{hakbun}")
	public void studentDelete(int hakbun);
	
	
	@Update("UPDATE student SET "
			+ "name=#{name},kor=#{kor},eng=#{eng},math=#{math} "
			+ "WHERE hakbun=#{hakbun}")
	public void studentUpdate(StudentVO vo);
}
