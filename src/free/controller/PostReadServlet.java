package free.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import free.dto.FreeCmtDTO;
import free.dto.FreeDTO;
import free.service.FreeCmtService;
import free.service.FreeCmtServiceImpl;
import free.service.FreeService;
import free.service.FreeServiceImpl;

@WebServlet(name = "fr/read", urlPatterns = { "/fr/read.do" })
public class PostReadServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("euc-kr");

		// 클라이언트의 요청정보 추출
		int no = Integer.parseInt(req.getParameter("no"));
		String action = req.getParameter("action");
		String view="";
		if(action.equals("modify")){
			view = "/pages/free/freeview_modify.jsp";
		}else{
			view = "/pages/free/freeview_read.jsp";
			
			FreeCmtService service2 = new FreeCmtServiceImpl();
			ArrayList<FreeCmtDTO> cmtlist = service2.getCmtList(no);
			req.setAttribute("cmtlist", cmtlist);
			
		}

		// 비지니스 메소드 호출
		FreeService service = new FreeServiceImpl();
		FreeDTO post = service.read(no);
		
		// 데이터공유
		req.setAttribute("post", post);

		// 요청재지정
		RequestDispatcher rd = req.getRequestDispatcher(view);
		rd.forward(req, res);
	}
}
