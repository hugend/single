package point.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import point.dto.PointDTO;
import point.service.PointService;
import point.service.PointServiceImpl;

@WebServlet(name = "po/insert", urlPatterns = { "/po/insert.do" })
public class PointInsertServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		
		//파일업로드
		String savaFolder = "/upload";
		String encType = "euc-kr";
		int size = 5*1024*1024; 
		String realpath = "";
		
		ServletContext context = getServletContext();
		realpath = context.getRealPath(savaFolder);
		MultipartRequest multipart = new MultipartRequest(request, realpath, size, encType, new DefaultFileRenamePolicy());
		
		String po_title = multipart.getParameter("po_title");
		String po_txt = multipart.getParameter("po_txt");
		String po_img = "";
		Enumeration<String> files = multipart.getFileNames();
		while(files.hasMoreElements()){
			String file = files.nextElement();
			po_img = multipart.getFilesystemName(file);
		}
		if(po_img==null){
			po_img = "225x160.gif";
		}
		int po_pt = Integer.parseInt(multipart.getParameter("po_pt"));
		int po_state = Integer.parseInt(multipart.getParameter("po_state"));
		
		PointDTO dto = new PointDTO(po_title, po_txt, po_img,  po_pt, po_state);
		int result = 0;
		PointService service = new PointServiceImpl();
		result = service.po_insert(dto);
		
		RequestDispatcher rd = request.getRequestDispatcher("/po/list.do");
		rd.forward(request, response);
		
	
	}

}
