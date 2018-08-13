package friends.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import friends.service.FriendsService;
import friends.service.FriendsServiceImpl;
import member.dto.MemberDTO;
import member.service.MemberService;
import member.service.MemberServiceImpl;
// 模备包府
@WebServlet(name = "friendslist", urlPatterns = { "/friends/list.do" })
public class FriendsListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		System.out.println("Servlet夸没己傍");

		String me_id = request.getParameter("me_id");
		
		if(me_id==null){
			HttpSession ses = request.getSession(false);
			MemberDTO loginUser = (MemberDTO) ses.getAttribute("loginUser");
			me_id=loginUser.getMe_id();
		}
		FriendsService service = new FriendsServiceImpl();
		ArrayList<String> friendslist = service.friendsList(me_id);
		int size = friendslist.size();

		MemberService memberservice = new MemberServiceImpl();
		ArrayList<MemberDTO> friends = new ArrayList<MemberDTO>();
		MemberDTO friend = new MemberDTO();
		
		for (int i = 0; i < size; i++) {
			friend = memberservice.getUserInfo(friendslist.get(i));
			friends.add(friend);
		}

		request.setAttribute("friends", friends);
				
		RequestDispatcher rd = request.getRequestDispatcher("/pages/friends/friendsview.jsp");
		rd.forward(request, response);
	}
}
