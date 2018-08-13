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
// 받은 쪽지, 보낸 쪽지
@WebServlet(name = "msg_read", urlPatterns = { "/msg/msg_read.do" })
public class MsgReadServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		System.out.println("Servlet요청성공");
		
		String me_id = request.getParameter("me_id");
		String option = request.getParameter("option");
		
		FriendsService service = new FriendsServiceImpl();
		ArrayList<MsgDTO> msgs = service.readMsg(option, me_id);
		
		request.setAttribute("msgs", msgs);
		request.setAttribute("option", option);
		System.out.println("메시지들 : "+msgs);
		RequestDispatcher rd = request.getRequestDispatcher("/pages/friends/friendsview_message.jsp");
		rd.forward(request, response);
	}
}
