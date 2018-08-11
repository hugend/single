package local.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import local.dto.EventDTO;
import local.dto.LocalDTO;
@WebServlet(name = "local/list", urlPatterns = { "/local/list.do" })
public class LocalListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String page = request.getParameter("page");
		String areaCode = request.getParameter("areaCode");
		
		String url = "";
		if(areaCode==null&&page==null){
			url = "/pages/local/localview.jsp";
		}else{
			url = "/pages/local/localview.jsp?areaCode="+areaCode+"&page="+page;
		}
		
		GetLocalList ll = new GetLocalList();
		GetEventList el = new GetEventList();
		ArrayList<LocalDTO> locallist = ll.getLocalList();
		ArrayList<EventDTO> eventlist = el.getEventList(areaCode);
		
		request.setAttribute("locallist", locallist);
		request.setAttribute("eventlist", eventlist);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
