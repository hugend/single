package free.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import free.dto.FreeDTO;
import free.service.FreeService;
import free.service.FreeServiceImpl;

@WebServlet(name = "fr/insert", urlPatterns = { "/fr/insert.do" })
public class PostInsertServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("euc-kr");

		// 파일 업로드 
		String saveFolder = "/pages/free/upload";
		String encType = "euc-kr";
		int size = 5*1024*1024;
		String realpath = "";

		ServletContext context = getServletContext();
		realpath = context.getRealPath(saveFolder);
	
		MultipartRequest multipart 
		= new MultipartRequest(req, realpath, size, encType, new DefaultFileRenamePolicy());

		// 클라이언트의 요청정보 추출
		String me_id = multipart.getParameter("id");
		String title = multipart.getParameter("title");
		String txt = multipart.getParameter("txt");
		String ctg = multipart.getParameter("ctg");
		String fr_img = "";
		Enumeration<String> files = multipart.getFileNames();
		while(files.hasMoreElements()){ 
			String file = files.nextElement(); 
			fr_img = multipart.getFilesystemName(file); 
		}
		
		// 비지니스 메소드 호출
		FreeDTO post = new FreeDTO(title, txt, ctg, fr_img, me_id);
		FreeService service = new FreeServiceImpl();
		int result = service.insert(post);

		// 요청재지정
		res.sendRedirect("/single/fr/list.do?category=all");
	}
}
