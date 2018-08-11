package free.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import free.service.FreeService;
import free.service.FreeServiceImpl;
@WebServlet(name = "fr/report", urlPatterns = { "/fr/report.do" })
public class ReportUserServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("euc-kr");
		res.setContentType("text/html;charset=euc-kr");

		// 1. 요청정보 추출
		String me_id = req.getParameter("id");
		int no = Integer.parseInt(req.getParameter("no"));

		// 2. 비지니스 메소드 호출
		FreeService service = new FreeServiceImpl();
		int result = service.report(me_id);

		// 요청재지정
		res.sendRedirect("/single/fr/read.do?no="+no+"&action=read");
	}
}
