
package com.sist.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.vo.SawonVO;

// Spring => ????? ???? => ~Controller
// Struts => ~Action
// ????? => ~Model
@Controller
public class SawonController {
    @RequestMapping("sawon/insert.do")
    public String swaon_insert(HttpServletRequest request,
    		HttpServletResponse response)
    {
    	
    	return "sawon/insert";
    }
    @RequestMapping("sawon/insert_ok.do")
    public String swaon_insert_ok(HttpServletRequest request,
    		HttpServletResponse response)
    {
    	String sabun=request.getParameter("sabun");
    	String name=request.getParameter("name");
    	String job=request.getParameter("job");
    	String dept=request.getParameter("dept");
    	String loc=request.getParameter("loc");
    	String pay=request.getParameter("pay");
    	SawonVO vo=new SawonVO();
    	vo.setSabun(Integer.parseInt(sabun));
    	vo.setPay(Integer.parseInt(pay));
    	vo.setName(name);
    	vo.setLoc(loc);
    	vo.setJob(job);
    	vo.setDept(dept);
    	
    	request.setAttribute("vo", vo);
        return "sawon/output";	
    }
    /*
     * 	board/list.do?page=10
     *  =>  (String page) (int page) => 모든 데이터를 String 
     *  => 해당 데이터형으로 받을 수 있따
     *  매개변수를 이용해서 데이터를 받는다 
     *  -----------------------------
     * 
     */
    @RequestMapping("sawon/insert_ok2.do")
    public String swaon_insert_ok2(HttpServletRequest request,
    		SawonVO vo)
    {
    	
    	// command 객체
    	request.setAttribute("vo", vo);
        return "sawon/output";	
    }
    
    // [] , List
    // 내장 객체 
    @RequestMapping("sawon/insert_ok3.do")
    public String sawon_insert_ok3(HttpServletRequest request,int sabun,String name,String dept,String loc,String job,int pay) {
    	SawonVO vo=new SawonVO();
    	vo.setSabun(sabun);
    	vo.setPay(pay);
    	vo.setName(name);
    	vo.setLoc(loc);
    	vo.setJob(job);
    	vo.setDept(dept);
    	
    	return "sawon/output";
    }
    /*
     *  class Model
     *  {
     *  	
     *  }
     */
    @RequestMapping("sawon/insert_ok4.do")
    public String swaon_insert_ok4(Model model,
    		SawonVO vo)
    {
    	
    	// Model => 전송 객체 (JSP로 값을 전송할때 사용_\)
    	model.addAttribute("vo", vo);
        return "sawon/output";	
    }
}
