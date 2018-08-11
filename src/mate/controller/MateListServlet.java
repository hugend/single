package mate.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mate.dto.MateDTO;
import mate.service.MateService;
import mate.service.MateServiceImpl;

@WebServlet(name = "mt/list", urlPatterns = { "/mt/list.do" })
public class MateListServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("euc-kr");
		ArrayList<MateDTO> dtolist = null;
		MateService service = new MateServiceImpl();
		dtolist = service.group();
		System.out.println("소그룹리스트");
		
		request.setAttribute("dtolist", dtolist);
		//RequestDispatcher rd = request.getRequestDispatcher("/pages/mate/mate_mainview.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("/mt/map.do");
		rd.forward(request, response);
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request, response);
		
	}
	
}
