package com.sist.vo;

import java.util.*;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
/*
 *   1. 유지보수 => 한번에 처리
 *      1) 공통으로 적용하는 코드 => @Aspect
 *      2) 공통으로 처리하는 예외처리 => @ControllerAdvice
 *   2. DAO / SQL
 *   3. Model 에서 전송
 *      ----- 사용자값 받기 / 전송하는 값
 *            | 매개변수    | Model
 *   4. JSP는 변경이없다
 *      ------------ Front (VueJS)
 *      
 *      name="name"  => <input type file[0]>
 */
@Data
public class DataBoardVO {
	private int no,hit,filecount;
	private String name,subject,content,pwd,dbday;
	private Date regdate;
	private List<MultipartFile> files=new ArrayList<MultipartFile>();
	// 여러개 데이터 : List / String[]
}
