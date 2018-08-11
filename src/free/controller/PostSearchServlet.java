package free.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
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

@WebServlet(name = "fr/search", urlPatterns = { "/fr/search.do" })
public class PostSearchServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=euc-kr");
		
		// 1. 클라이언트의 요청정보 추출
		String column = request.getParameter("column");
		String search = request.getParameter("search");

		System.out.println("검색어: "+search);

		// 2. 비즈니스 메소드 호출
		FreeService service = new FreeServiceImpl();
		ArrayList<FreeDTO> postlist= service.search(column, search);

		// 3. 데이터 공유
		request.setAttribute("postlist", postlist);
		
		// 4. 요청재지정 - forward
		RequestDispatcher rd = request.getRequestDispatcher("/pages/free/freeview.jsp");
		rd.forward(request, response);
		
	}

}
