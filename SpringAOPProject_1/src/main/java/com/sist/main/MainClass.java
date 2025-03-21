package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.BoardDAO;

public class MainClass {

	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		// TODO Auto-generated method stub
		BoardDAO dao=new BoardDAO();
		dao.boardListData(1);
		dao.boardDetailData("ȫ�浿");
		dao.boardInsert();
		dao.boardUpdate();
		dao.boardDelete();
	}

}
