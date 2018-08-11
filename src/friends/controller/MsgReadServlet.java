package friends.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import friends.dto.MsgDTO;
import friends.service.FriendsService;
import friends.service.FriendsServiceImpl;

@WebServlet(name = "msg_read", urlPatterns = { "/msg/msg_read.do" })
public class MsgReadServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		System.out.println("Servlet요청성공");

		String me_id = "ocean";
		String option = "A";	// 받은 쪽지, 보낸 쪽지 구분
		
		FriendsService service = new FriendsServiceImpl();
		ArrayList<MsgDTO> msgs = service.readMsg(option, me_id);
		
		System.out.println("메시지"+msgs);
		
		request.setAttribute("msgs", msgs);
		
		RequestDispatcher rd = request.getRequestDispatcher("/pages/friends/friendsview_message.jsp");
		rd.forward(request, response);
	}
}
