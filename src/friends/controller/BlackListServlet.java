package friends.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import free.dto.FreeDTO;
import free.service.FreeService;
import free.service.FreeServiceImpl;
import friends.service.FriendsService;
import friends.service.FriendsServiceImpl;
import member.dto.MemberDTO;
import member.service.MemberService;
import member.service.MemberServiceImpl;

@WebServlet(name = "black/blacklist", urlPatterns = { "/black/blacklist.do" })
public class BlackListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		System.out.println("Servlet요청성공");
 
		FriendsService service = new FriendsServiceImpl();
		ArrayList<MemberDTO> blacklist = service.BckList();
		
		request.setAttribute("blacklist", blacklist);
		
		RequestDispatcher rd = request.getRequestDispatcher("/pages/blacklist/blacklistview.jsp");
		rd.forward(request, response);
	}
}
