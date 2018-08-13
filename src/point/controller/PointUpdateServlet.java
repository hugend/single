package point.controller;

import java.io.IOException;
import java.sql.Date;
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

import point.dao.PointDAO;
import point.dto.PointDTO;
import point.service.PointService;
import point.service.PointServiceImpl;

@WebServlet(name = "po/update", urlPatterns = { "/po/update.do" })
public class PointUpdateServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");

		String savaFolder = "/upload";
		String encType = "euc-kr";
		int size = 5 * 1024 * 1024;
		String realpath = "";

		ServletContext context = getServletContext();
		realpath = context.getRealPath(savaFolder);
		MultipartRequest multipart = new MultipartRequest(request, realpath, size, encType,
				new DefaultFileRenamePolicy());

		int po_no = Integer.parseInt(multipart.getParameter("po_no"));
		PointService service = new PointServiceImpl();
		PointDTO prd = service.po_read(po_no);

		String url = "";

		String po_title = multipart.getParameter("po_title");
		String po_txt = multipart.getParameter("po_txt");
		String po_img = null;
		Enumeration<String> files = multipart.getFileNames();
		while (files.hasMoreElements()) {
			String file = files.nextElement();
			po_img = multipart.getFilesystemName(file);
		}
		if (po_img == null) {
			po_img = prd.getPo_img();
		}
		int po_pt = Integer.parseInt(multipart.getParameter("po_pt"));
		int po_state = Integer.parseInt(multipart.getParameter("po_state"));
		int po_count = Integer.parseInt(multipart.getParameter("po_count"));

		PointDTO updateprd = new PointDTO(po_no, po_title, po_txt, po_img, po_pt, po_state, po_count);
		int result = service.po_update(updateprd);

		request.setAttribute("po_no", po_no);
		url = "/po/list.do";

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
