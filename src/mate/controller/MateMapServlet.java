package mate.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mate.dto.MateDTO;

@WebServlet(name = "mt/map", urlPatterns = { "/mt/map.do" })
public class MateMapServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
			
		
			//1. ¿¸√º∏ÆΩ∫∆Æ ø°º≠ loc, map ¡§∫∏∏∏
			//2. json∆ƒΩÃ
			//3. ∏ ø° ª—∑¡¡‹
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			ArrayList<MateDTO> list = (ArrayList<MateDTO>) request.getAttribute("dtolist");
			
			for (int i = 0; i < list.size(); i++) {
				list.get(i).getMt_map();
				list.get(i).getMt_loc();
				
			}
			
			
	}

	
}
