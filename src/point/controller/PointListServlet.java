package point.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import point.dao.PointDAO;
import point.dao.PointDAOImpl;
import point.dto.PointDTO;
import point.service.PointService;
import point.service.PointServiceImpl;

@WebServlet(name = "po/list", urlPatterns = { "/po/list.do" })
public class PointListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		
		request.setCharacterEncoding("euc-kr");
		String page = request.getParameter("page");
		
		String url = "";
		if(page==null){
			url = "/pages/point/pointmarketview.jsp";
		}else{
			url = "/pages/point/pointmarketview.jsp?page="+page;
		}

		ArrayList<PointDTO> prdlist = null;
		PointService service = new PointServiceImpl();
		prdlist = service.po_list();

		request.setAttribute("prdlist", prdlist);
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request, response);
	}
}
