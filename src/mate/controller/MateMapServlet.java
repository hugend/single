package mate.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import mate.dto.MateDTO;
import mate.service.MateService;
import mate.service.MateServiceImpl;

@WebServlet(name = "mt/map", urlPatterns = { "/mt/map.do" })
public class MateMapServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
			
		
			//1. ¿¸√º∏ÆΩ∫∆Æ ø°º≠  title,lat, lng, map ¡§∫∏∏∏
			//2. json∆ƒΩÃ
			//3. ∏ ø° ª—∑¡¡‹
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			ArrayList<MateDTO> list = (ArrayList<MateDTO>) request.getAttribute("dtolist");
			
			int size = list.size();
			
			JSONObject myjson = new JSONObject();
			JSONArray pos = new JSONArray();
			
			for (int i = 0; i < size; i++) {
				JSONObject poslist = new JSONObject();
				poslist.put("title", list.get(i).getMt_title());
				poslist.put("map", list.get(i).getMt_map());
				poslist.put("lat", list.get(i).getMt_lat());
				poslist.put("lng", list.get(i).getMt_lng());
				pos.add(poslist);
				
			}
			myjson.put("positions", pos);
			
			ServletContext context = this.getServletContext();
			String file1 =getServletContext().getRealPath("common/json/location.json");
			String file =getServletContext().getRealPath("/")+"common\\json\\json_test2.json";
			String realpath = context.getRealPath("/common/json/json_test3.json");
			String filepath = request.getContextPath();
			System.out.println(realpath);
			
			
			System.out.println(myjson.toJSONString());
//			FileWriter fw = new FileWriter("c:\\temp\\test.json", false);
			FileWriter fw = new FileWriter(realpath, false);
			fw.write(myjson.toJSONString());
			fw.flush();
			fw.close();
			
			request.setAttribute("jsonpath", realpath);
			RequestDispatcher rd = request.getRequestDispatcher("/pages/mate/mate_mainview.jsp");
			rd.forward(request, response);
			
			
	}

	
}
