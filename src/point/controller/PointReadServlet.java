package point.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import point.dto.PointDTO;
import point.service.PointService;
import point.service.PointServiceImpl;

@WebServlet(name = "po/read", urlPatterns = { "/po/read.do" })
public class PointReadServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		int po_no = Integer.parseInt(request.getParameter("po_no"));
		String state = request.getParameter("state");
		System.out.println(state);
		PointDTO prd = null;
		PointService service = new PointServiceImpl();
		prd = service.po_read(po_no);
		
		request.setAttribute("prd", prd);
		request.setAttribute("state", state);
		RequestDispatcher rd = request.getRequestDispatcher("/pages/point/pointmarket_read.jsp");
		rd.forward(request, response);
	
	}
}
