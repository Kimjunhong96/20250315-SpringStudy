package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
/*
 *  Mapper => ���������� ����
 *  ----------------------
 *          |
 *       BoardDAO
 *          |
 *        Model => JSP 
 *        
 *        forward sendredirect
 *        
 *        1. request�� ���ȹ����� ��� ����  ... Cookie�δ� ������ �ִ� 
 *           ------
 *           1) ��û�� �ޱ� ==> �Ű�����
 *           		         ------
 *                           ������ ���� ���� 
 *                           => ó���ϴ� ���� ��ü�� �޾� ó�� 
 *                           request/response/session
 *                           RedirectAttributes
 *                           => VO 
 *           2) JSP�� ���� ���� ==> Model
 *         
 *        2. �⺻ Ʋ => ���� ���� 
 *                    ------- ��ǰ ���� (CPU/�ϵ��ũ....)
 *            DispatcherServelet : ��û / ����
 *             => web.xml�� ��� 
 *            HandlerMapping : Model�� ã��
 *                           @RequestMapping�� ã�Ƽ� �޼ҵ� ȣ��
 *                           => ����
 *            
 *            ViewResolver : �����(request)�� JSP�� ����
 *                          => ��θ� / Ȯ���� 
 *                          => application-context.xml
 *                         
 *        3. JSP�� ���� ������ ���� 
 *        
 *      => �Ű����� ó�� ����
 *      => request�� ���� => return "jsp���ϸ�"  forward
 *      => request�� ������ => return "redirect:"  sendRedirect    _ok  ���� VO�� �޾ƿö� ����ҰԾ����� sendRedirect���� 
 *      
 *      1. ���� ���� 
 *         ����� ���� => ��û �޾Ƽ� => Model�� ��û�� ���� => �����ͺ��̽� => ��ûó�� => ����� => JSP�� ����
 *         
 *         jsp(forward) => ����� ������ �ִ� ���
 *         jsp(redirect) => ������� ���� ���� => ������ ȭ�� �̵�
 *         
 *         detail.do = detail.jsp
 *         insert_ok.do = list.jsp
 *         update_ok.do = detail.jsp
 */
@Controller  // ȭ�� ���� => forward / sendRedirect
@RequestMapping("board/")  // �� �տ� �̷��� board/ �����س����� �ڿ��� �ߺ��Ȱ� �����Ѵ� 
public class BoardController {
	@Autowired
	private BoardDAO dao;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@RequestMapping("list.do")
	public String board_list(String page,Model model)
	{
		if(page==null)
			page="1";
		
		int curpage=Integer.parseInt(page);
		List<BoardVO> list=dao.boardListData((10*curpage)-9, curpage*10);
		int totalpage=dao.boardTotalPage();
		
		model.addAttribute("curpage",curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("list", list);
		
		return "board/list";
	}
	
	@RequestMapping("insert.do")
	public String board_insert() {
		return "board/insert";
	}
	@RequestMapping("insert_ok.do")
	public String board_insert_ok(BoardVO vo) {
		String pwd=encoder.encode(vo.getPwd());
		vo.setPwd(pwd);
		System.out.println("pwd="+pwd);
		dao.boardInsert(vo);
		
		return "redirect:list.do";
	}
	
	// �󼼺��� ��û
	@RequestMapping("detail.do")
	// �������� => String ���� , �� ������������ ���� �� �ִ� 
	
	public String board_detail(int no,Model model) {
		// Model => ���۰�ü : request�� ��ü 
		/*
		 *  => Cookie
		 */
		BoardVO vo=dao.boardDetailData(no);
		model.addAttribute("vo", vo);
		return "board/detail";
	}
	// ���� / ���� => ��� �˻� 
	/*
	 *   �޼ҵ� ���� �������
	 *   ������
	 *   
	 *   �Ű����� ���
	 */
	@RequestMapping("update.do")
	public String board_update(int no,Model model) {
		BoardVO vo=dao.boardUpdateData(no);
		model.addAttribute("vo", vo);
		return "board/update";
	}
	
	/*
	@RequestMapping("update_ok.do")
	public String board_update_ok(BoardVO vo,Model model) {
		boolean bCheck=dao.boardUpdate(vo);
		model.addAttribute("bCheck",bCheck);
		model.addAttribute("no",vo.getNo());
		
		return "board/update_ok";
	}*/
	/*@RequestMapping("update_ok.do")
	@ResponseBody  ==> �°� 
	// out.write() => �ڹٽ�ũ��Ʈ ���� , JSON , �Ϲݹ��ڿ� ����
	public String board_update_ok(BoardVO vo) {
		String result="";
		boolean bCheck=dao.boardUpdate(vo);
		if(bCheck==true) {
			result="<script>"
					+"location.href=\"detail.do?no="+vo.getNo()+"\""
					+"</script>";
		}
		else {
			result="<script>"
					+"alert(\"Password Fail!!\");"
					+"history.back();"
					+"</script>";
		}
		return result;
	}*/
	// delete.do?no=${vo.no}  데이터형이 다른경우 400
	// 404, 500, 400 , 403
	@RequestMapping("delete.do")
	public String board_delete(int no,Model model) {
		model.addAttribute("no", no);
		return "board/delete";
	}
}
