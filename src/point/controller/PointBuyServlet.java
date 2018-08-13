package point.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.dto.MemberDTO;
import member.service.MemberService;
import member.service.MemberServiceImpl;
import point.dto.PointDTO;
import point.service.PointService;
import point.service.PointServiceImpl;

@WebServlet(name = "po/buy", urlPatterns = { "/po/buy.do" })
public class PointBuyServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		response.setContentType("text/html;charset=euc-kr");
		
		String id = request.getParameter("userid");
		int po_no = Integer.parseInt(request.getParameter("po_no"));
	
		MemberService service = new MemberServiceImpl();
		MemberDTO userInfo = service.getUserInfo(id);
		
		PointService service2 = new PointServiceImpl();
		PointDTO prdInfo = service2.po_read(po_no);
	
		System.out.println(userInfo.getMe_point());
		System.out.println(prdInfo.getPo_pt());
		
		String state = "";
		if(userInfo.getMe_point()<prdInfo.getPo_pt()){	//유저의 포인트가 적을때
			state = "0";
		}else{
			int me_point = userInfo.getMe_point()-prdInfo.getPo_pt();
			int result = service2.buy_update(me_point, id, po_no);
			
			//세션업데이트
			HttpSession ses = request.getSession();			
			MemberDTO updateloginUser = service.getUserInfo(id);
			ses.setAttribute("loginUser", updateloginUser);
			
			PointDTO prdInfo2 = service2.po_read(po_no);
			if(prdInfo2.getPo_count()==0){
				//수량이 0이 되면 비공개처리
				int result2  = service2.po_state_update(2, po_no);
			}
			
			state = "1";
		}

		RequestDispatcher rd = request.getRequestDispatcher("/po/read.do?po_no="+po_no+"&state="+state);
		rd.forward(request, response);
	}
}
