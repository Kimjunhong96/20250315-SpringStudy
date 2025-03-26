package com.sist.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
/*
 *   기능이 있는 클래스 => 관리를 스프링이 관리함 객체생성 ~ 소멸 
 *                                      -----
 *                                      1. 메모리할당
 *                                      2. 멤버변수의 초기화
 *                                         DI => setXxx() ,생성자
 *                                         -- 값을 주입
 *                                      3. 필요시마다 객체를 찾아서 사용이 가능
 *                                         DL => @Autowired
 *                                     ----------------------------
 *                                      => 클래스 관리자 (Container)
 *                                      => MVC는 스프링의 라이브러리 
 *                                      
 *                                      => @RestController / @ControllerAdvice
 *                                      => 나머지는 개발자 관리
 *                                      
 *                                      => DI
 *                                        ---- 메모리할당하고 관리를 한다 
 *                                        
 *                                        오버로딩 / 오버라이딩
 *                                          |         |   
 *                                         new      modify
 *                                      
 *                AOP : 공통모듈 (여러 위치에 호출) 
 *                     => 보안 / 로깅 / 트랜잭션 
 *                     
 *                 
 *                 중복제거
 *                 ------
 *                  OOP => 객체지향프로그램 메소드 , 메소드 많은 경우 클래스
 *                  AOP => -------------------------------------- 자동호출이 가능
 *                  --- OOP를 보완
 *                  
 *                  
 *                  자동 호출
 *                  --------
 *                  어떤 메소드에서 호출 : PointCut
 *                  메소드 영역안에 어떤 위치에서 호출 : JoinPoint
 *                  -------------------------------------- Advice
 *                  public String display()
 *                  {
 *                  	=> Before
 *                  	try{
 *                  
 *                  	}
 *                  	catch(Exception ex)
 *                  	
 *                  	finally
 *                  	{
 *                  		=> After
 *                  	}
 *                  }
 *                  
 *                  PonintCut
 *                  execution("* 패키지명.클래스.메소드(..)")
 *                            |                    | 
 *                           리턴형                매개변수 (0개 이상)
 *                   within("패키지") => 지정된 패키지에 있는 모든 클래스 적용
 *                   
 *                   => Advice(JoinPoint+PointCut)
 *                      -------------------------- 여러개 ) Aspect
 *                   
 */
@Aspect
@Component
public class ControllerAspect {
	@Around("execution(* com.sist.web.*Controller.*(..))")
	public Object around(ProceedingJoinPoint jp) throws Throwable {
		Object obj=null;
		  long start=System.currentTimeMillis();
		  System.out.println("호출 메소드:"+jp.getSignature().getName());
		  obj=jp.proceed(); 
		  long end=System.currentTimeMillis();
		  System.out.println("수행시간:"+(end-start));
		  return obj;
	}
	@AfterReturning(value= "execution(* com.sist.web.*Controller.*(..))")
	public void afterReturning(Object obj) {
		if(obj!=null) {
			String path=(String)obj;
			System.out.println("호출된 JSP:"+path);
		}
	}
	// => ControllerAdvice
}
