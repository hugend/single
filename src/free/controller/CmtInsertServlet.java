package free.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import free.dto.FreeCmtDTO;
import free.service.FreeCmtService;
import free.service.FreeCmtServiceImpl;
import member.dto.MemberDTO;
import member.service.MemberService;
import member.service.MemberServiceImpl;

@WebServlet(name = "fr/cmtinsert", urlPatterns = { "/fr/cmtinsert.do" })
public class CmtInsertServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("euc-kr");
		res.setContentType("text/html;charset=euc-kr");
 
		// 클라이언트의 요청정보 추출
		String cmt_txt = req.getParameter("cmt");
		int no = Integer.parseInt(req.getParameter("postno"));
		String me_id = req.getParameter("id");
 
		// 비지니스 메소드 호출
		FreeCmtDTO cmt = new FreeCmtDTO(cmt_txt, no, me_id);
		FreeCmtService service = new FreeCmtServiceImpl();
		int result = service.insert(cmt);

		ArrayList<FreeCmtDTO> cmtlist = service.getCmtList(no);
		req.setAttribute("cmtlist", cmtlist);
		
		// 댓글 작성 포인트 반영
		MemberService service2 = new MemberServiceImpl();
		HttpSession ses = req.getSession();
		MemberDTO loginUser = (MemberDTO) ses.getAttribute("loginUser");
		MemberDTO userInfo = service2.getUserInfo(me_id);
		
		if(result>=1){
			MemberDTO updateloginUser = service2.getUserInfo(me_id);
			ses.setAttribute("loginUser", updateloginUser);
		}
		
		// 요청재지정
		res.sendRedirect("/single/fr/read.do?no="+no+"&action=read");
	}
}