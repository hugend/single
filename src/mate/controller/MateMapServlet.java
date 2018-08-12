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
			
		
			//1. 전체리스트 에서  title,lat, lng, map 정보만
			//2. json파싱
			//3. 맵에 뿌려줌
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
			
			
	/*		String realpath="";
			String saveFolder = "/common/json/json_test6.json";
			ServletContext context = getServletContext();
			realpath = context.getRealPath(saveFolder);
			System.out.println("리얼패쓰"+realpath);*/
			
			System.out.println(myjson.toJSONString());
//			FileWriter fw = new FileWriter("c:\\temp\\test.json", false);
			FileWriter fw = new FileWriter("C:\\ICT\\webwork\\single\\WebContent\\common\\json\\json_test10.json", false);
			fw.write(myjson.toJSONString());
			fw.flush();
			fw.close();
			
			//request.setAttribute("jsonpath", realpath);
			RequestDispatcher rd = request.getRequestDispatcher("/pages/mate/mate_mainview.jsp");
			rd.forward(request, response);
			
			
	}

	
}
