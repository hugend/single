package mate.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mate.dto.MateDTO;
import mate.service.MateService;
import mate.service.MateServiceImpl;


@WebServlet(name = "mt/insert.do", urlPatterns = { "/mt/insert.do" })
public class MateInsertServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html; charset=euc-kr");
		String me_id = request.getParameter("me_id");
		String mt_title = request.getParameter("mt_title");
		String mt_ctg = request.getParameter("mt_ctg");
		String mt_map = request.getParameter("mt_map");
		String mt_cnt = request.getParameter("mt_cnt");
		String mt_txt = request.getParameter("mt_txt");
		String mt_img = request.getParameter("mt_img");
		String mt_file = request.getParameter("mt_file");
		
		MateDTO dto = new MateDTO(mt_title, mt_txt, mt_file, mt_map, mt_ctg, Integer.parseInt(mt_cnt), me_id, mt_img);
		System.out.println(dto);
		MateService service = new MateServiceImpl();
		int result = service.insert_mt(dto);
		System.out.println("result값"+result);
		String msg = "";
		if(result > 0){
			msg= "입력성공";
		}else{
			msg= "입력실패";
		}
		System.out.println(msg);
		
		RequestDispatcher rd = request.getRequestDispatcher("/mt/list.do");
		rd.forward(request, response);
		
	}
}