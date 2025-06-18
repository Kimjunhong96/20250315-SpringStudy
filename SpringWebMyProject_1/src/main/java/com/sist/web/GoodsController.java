package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.sist.vo.*;
import com.sist.commons.CommonsPagination;
import com.sist.service.*;
@Controller
public class GoodsController {
	@Autowired
	private GoodsService service;
	
	// 목록 
	@GetMapping("goods_list.do") // Target: Method
	public String goods_list(String page,Model model) {
		//void는 download , 전송할데이터 필요할때 model
		// 처음 => null 값 포함 => 매개변수 => String으로 받는다 
		if(page==null)
			page="1";
		
		int curpage=Integer.parseInt(page);
		Map map=new HashMap();
		int rowSize=12;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		map.put("start", start);
		map.put("end", end);
		List<GoodsVO> list=service.goodsListData(map);
		int totalpage=service.goodsTotalPage();
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		// 1(1~10)  11 21 
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		// 10 20 
		if(endPage>totalpage)
			endPage=totalpage;
		
		// goods_list 로 전송
		model.addAttribute("list", list);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		return "goods/goods_list";
	}
	@GetMapping("goods/detail.do")
	public String goods_detail(int no, Model model) {
		
		return "main/main";
	}
	@GetMapping("goods/find.do")
	public String goods_find(String page, String fd, Model model) {
		// request => Model을 이용해서 전송 
		   Map map=CommonsPagination.pageConfig(page, 12);
		   //            => request가 포함 
		   int curpage=(int)map.get("curpage");
		   // map => start/end 
		   if(fd==null)
			   fd="감자";
		   map.put("fd", fd);
		   List<GoodsVO> list=service.goodsFindData(map);
		   final int BLOCK=10;
		   int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		   int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		   int totalpage=service.goodsFindTotalPage(map);
		   if(endPage>totalpage)
			   endPage=totalpage;
		   
		   model.addAttribute("list", list);
		   model.addAttribute("startPage", startPage);
		   model.addAttribute("endPage", endPage);
		   model.addAttribute("curpage", curpage);
		   model.addAttribute("totalpage", totalpage);
		   model.addAttribute("fd", fd); // JSP(X) => Ajax , Vue
		   
		   model.addAttribute("main_jsp", "../goods/find.jsp");
		return "main/main";
	}
	// 쿠키 
	@GetMapping("goods_detail_before.do")
	public String goods_detail_before(int fno,HttpServletResponse response,RedirectAttributes ra) {
		Cookie cookie=new Cookie("spring_"+fno, String.valueOf(fno));
		cookie.setPath("/");
		cookie.setMaxAge(60*60*24);
		response.addCookie(cookie);
		
		ra.addAttribute("fno", fno); // sendRedirect
		// ? 대신 사용한다
		return "redirect:goods_detail.do";
	}
	// 상세보기 
	@GetMapping("goods_detail.do")
	public String goods_detail(int fno,Model model) {
		GoodsVO vo = service.goodsDetailData(fno);
		model.addAttribute("vo", vo);
		return "goods/goods_detail";
	}
}
