package free.controller;

import java.io.IOException;
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

@WebServlet(name = "fr/list", urlPatterns = { "/fr/list.do" })
public class PostListServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("euc-kr");
		res.setContentType("text/html;charset=euc-kr");
		
		String category = req.getParameter("category");
		String view="";
		
		FreeService service = new FreeServiceImpl();
		ArrayList<FreeDTO> postlist = null;
		
		if(category.equals("free")){
			view = "/pages/free/freeview_free.jsp";
			postlist = service.getCtgList("자유");

		}else if(category.equals("tip")){
			view = "/pages/free/freeview_tip.jsp";
			postlist = service.getCtgList("정보");

		}else if(category.equals("review")){
			view = "/pages/free/freeview_review.jsp";
			postlist = service.getCtgList("후기");

		}else if(category.equals("recom")){
			view = "/pages/free/freeview_recom.jsp";
			postlist = service.getCtgList("추천");

		}else if(category.equals("all")){
			view = "/pages/free/freeview.jsp";
			postlist = service.getPostList();
		}
		
		// 2.데이터공유
		req.setAttribute("postlist", postlist);

		// 3.요청재지정
		RequestDispatcher rd = req.getRequestDispatcher(view);	
		rd.forward(req, res);
		
	}

}
