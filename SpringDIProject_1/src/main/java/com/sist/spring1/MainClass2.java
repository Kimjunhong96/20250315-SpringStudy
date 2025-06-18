package com.sist.spring1;
/*
 *  1. 개발자 => 클래스 메모리 할당을 하지 않는다 
 *             -------------- 모든 클래스의 메모리 할당 요청
 *                            --------
 *                             관리할 수 있게 만든다 
 *                             ---------------- XML , Annotation 이용 
 *                               생성 ~ 소멸 
 *                               --- 변수의 초기화 
 *                               | 메모리 누수 현상 방지 
 *                               
 *      스프링은 클래스 관리자 => 컨테이너 
 *      					 경량 => 클래스간의 연관 관계가 단순하다 
 *      
 *      spring => 클래스 관리 (컨테이너)
 *               ---------- 가능한 가지고 있다 (컴포넌트)
 *               
 *               XML => 동작을 위한 메뉴열 작업
 *               클래스의 클래스의 연관관계를 설정
 *               ------------------------ DI
 *               | DI / AOP / 트랜잭션 / MVC 
 *               
 */
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
