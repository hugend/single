package friends.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import friends.dto.BdDTO;
import friends.service.FriendsService;
import friends.service.FriendsServiceImpl;
 
@WebServlet(name = "delete_black", urlPatterns = { "/delete_black.do" })
public class DeleteBlackServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("euc-kr");

		// 클라이언트의 요청정보 추출
		String me_id = req.getParameter("id");

		// 비지니스 메소드 호출
		//BdDTO bd = new BdDTO(me_id, bd_id);
		//FriendsService service = new FriendsServiceImpl();
		//int result = service.deleteBd(bd);
		
		// 요청재지정
		//res.sendRedirect("/single/fr/read.do?no="+no+"&action=read");
	}
}
