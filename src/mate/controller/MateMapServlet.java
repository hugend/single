package mate.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "mt/map", urlPatterns = { "/mt/map.do" })
public class MateMapServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=euc-kr");
		response.setHeader("cache-control", "no-cache, no-store");
		String mapinfo = request.getParameter("result");
		System.out.println(mapinfo);
		request.setAttribute("mapinfo", mapinfo);
		RequestDispatcher rd = request.getRequestDispatcher("/pages/mate/mate_readview.jsp");
		rd.forward(request, response);
	}
}