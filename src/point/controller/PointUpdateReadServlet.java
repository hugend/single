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


@WebServlet(name = "po/updateread", urlPatterns = { "/po/updateread.do" })
public class PointUpdateReadServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		int po_no = Integer.parseInt(request.getParameter("po_no"));
		PointService service = new PointServiceImpl();
		PointDTO prd = service.po_read(po_no);
		
		request.setAttribute("prd", prd);
		RequestDispatcher rd = request.getRequestDispatcher("/pages/point/pointmarket_update.jsp");
		rd.forward(request, response);
	}

}
