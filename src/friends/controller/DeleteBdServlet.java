package friends.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import friends.dto.BdDTO;
import friends.service.FriendsService;
import friends.service.FriendsServiceImpl;
import member.dto.MemberDTO;

@WebServlet(name = "deletefriends", urlPatterns = { "/friends/delete.do" })
public class DeleteBdServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("euc-kr");
		System.out.println("Servlet요청성공");

		String me_id = req.getParameter("id");
		String bd_id = req.getParameter("bd_id");

		BdDTO bd = new BdDTO(me_id, bd_id);
		FriendsService service = new FriendsServiceImpl();
		int result = service.deleteBd(bd);
		
		if(me_id==null){
			HttpSession ses = req.getSession(false);
			MemberDTO loginUser = (MemberDTO) ses.getAttribute("loginUser");
			me_id=loginUser.getMe_id();
		}
		
		res.sendRedirect("/single/friends/list.do?me_id="+me_id);
	}
}
