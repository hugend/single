package point.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import point.service.PointService;
import point.service.PointServiceImpl;

@WebServlet(name = "po/delete", urlPatterns = { "/po/delete.do" })
public class PointDeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		String po_no = request.getParameter("po_no");
		PointService service = new PointServiceImpl();
		
		int result = service.po_delete(po_no);
	
		response.sendRedirect("/single/po/list.do");
	}
}
