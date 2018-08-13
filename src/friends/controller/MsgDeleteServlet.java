package friends.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import free.service.FreeService;
import free.service.FreeServiceImpl;
import friends.dto.MsgDTO;
import friends.service.FriendsService;
import friends.service.FriendsServiceImpl;
import member.dto.MemberDTO;

@WebServlet(name = "msg_delete", urlPatterns = { "/msg/msg_delete.do" })
public class MsgDeleteServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("euc-kr");
		System.out.println("Servlet요청성공");

		String msg_no = req.getParameter("msg_no");
		String option = req.getParameter("option");
		
		HttpSession ses = req.getSession(false);
		MemberDTO loginUser = (MemberDTO) ses.getAttribute("loginUser");
		String me_id = loginUser.getMe_id();
		
		FriendsService service = new FriendsServiceImpl();
		int result = service.deleteMsg(msg_no);

		System.out.println(me_id+":"+option);
		res.sendRedirect("/single/msg/msg_read.do?me_id="+me_id+"&option="+option);
	}
}
