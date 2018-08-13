package vs.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vs.dto.VsDTO;
import vs.service.VsService;
import vs.service.VsServiceImpl;

@WebServlet(name = "vs_insert", urlPatterns = { "/vs/vs_insert.do" })
public class VsInsertServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		System.out.println("Servlet요청성공");
		
		String vs_title = request.getParameter("vs_title");
		String vs_optionA = request.getParameter("vs_optionA");
		String vs_optionB = request.getParameter("vs_optionB");
		String vs_txt = request.getParameter("vs_txt");
		String me_id = "ocean";

		if(vs_txt.equals("")){
			vs_txt=" ";	
		}
		VsService service = new VsServiceImpl();
		VsDTO post = new VsDTO(vs_title, vs_optionA, vs_optionB, vs_txt, me_id);
		System.out.println(post);
		int result = service.insert(post);

		String msg = "";
		if (result >= 1) {
			msg = result + "개 행 삽입 성공";
		} else {
			msg = "삽입실패";
		}
		System.out.println(msg);
		
		request.setAttribute("post", post);
		
		response.sendRedirect("/single/vs/vs_read.do");
	}
}
