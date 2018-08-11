package friends.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import friends.service.FriendsService;
import friends.service.FriendsServiceImpl;
import member.dto.MemberDTO;
import member.service.MemberService;
import member.service.MemberServiceImpl;

@WebServlet(name = "friendslist", urlPatterns = { "/friends/list.do" })
public class FriendsListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		System.out.println("Servlet요청성공");

		String me_id = "ocean";
		
		FriendsService service = new FriendsServiceImpl();
		ArrayList<String> friendslist = service.friendsList(me_id);
		int size = friendslist.size();
		
		MemberService memberservice = new MemberServiceImpl();
		ArrayList<MemberDTO> friends = new ArrayList<MemberDTO>();
		MemberDTO friend = null;
		for (int j = 0; j < size; j++) {
			friend = memberservice.getUserInfo(friendslist.get(j));
			friends.add(friend);
		}
		
		request.setAttribute("friends", friends);
		
		RequestDispatcher rd = request.getRequestDispatcher("/pages/friends/friendsview.jsp");
		rd.forward(request, response);
	}
}
