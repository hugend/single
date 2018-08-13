package friends.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import friends.dto.MsgDTO;
import friends.service.FriendsService;
import friends.service.FriendsServiceImpl;
import member.dao.MemberDAO;
import member.dto.MemberDTO;
import member.service.MemberService;
import member.service.MemberServiceImpl;
import vs.dto.VsDTO;
import vs.service.VsService;
import vs.service.VsServiceImpl;
// 쪽지 보내기
@WebServlet(name = "msg_insert", urlPatterns = { "/msg/msg_insert.do" })
public class MsgInsertServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		System.out.println("Servlet요청성공");
		
		String sender = request.getParameter("sender");
		String receiver = request.getParameter("receiver");
		String msg_title = request.getParameter("msg_title");
		String msg_txt = request.getParameter("msg_txt");
		
		FriendsService service = new FriendsServiceImpl();
		MsgDTO msg = new MsgDTO(sender, receiver, msg_title, msg_txt);
		System.out.println(msg);
		int result = service.insertMsg(msg);
		
		String message = "";
		if (result >= 1) {
			message = result + "개 행 삽입 성공";
		} else {
			message = "삽입실패";
		}
		
		//쪽지알림
		MemberService service2 = new MemberServiceImpl();
		MemberDTO user = service2.getUserInfo(receiver);
		String email = user.getMe_email();
		EmailAlarm ea = new EmailAlarm();
		ea.connectEmail(email,sender);
		
		response.sendRedirect("/single/friends/list.do");
	}
}
