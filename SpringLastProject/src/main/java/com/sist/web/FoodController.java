package com.sist.web;
import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.service.*;
import com.sist.vo.*;
@Controller
@RequestMapping("food/")
/*
 * 
 */
public class FoodController {
	@Autowired
	  private FoodService service;
	
	@GetMapping("list.do")
	public String food_list(Model model) {
		model.addAttribute("main_jsp","../food/list.jsp");
		return "main/main";
	}
	@GetMapping("detail.do")
	public String food_detail(int fno,Model model, HttpSession session) {
		  FoodVO vo=service.busanFoodDetailData(fno);
		  List<String> list=new ArrayList<String>();
		  String[] images=vo.getImages().split(",");
		  list=Arrays.asList(images);
		  // 배열 => List로 변경 asList
		  String id=(String)session.getAttribute("userid");
		  model.addAttribute("sessionId",id);
		  model.addAttribute("vo", vo);
		  model.addAttribute("list", list);
		  model.addAttribute("main_jsp", "../food/detail.jsp");
		  return "main/main";
	}
}
