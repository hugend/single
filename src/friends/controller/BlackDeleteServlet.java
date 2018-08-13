package friends.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import friends.service.FriendsService;
import friends.service.FriendsServiceImpl;

@WebServlet(name = "black/delete", urlPatterns = { "/black/delete.do" })
public class BlackDeleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("euc-kr");
		System.out.println("Servlet요청성공");

		String me_id = req.getParameter("id");

		FriendsService service = new FriendsServiceImpl();
		int result = service.deleteBlack(me_id);

		res.sendRedirect("/single/black/blacklist.do");
	}
}
