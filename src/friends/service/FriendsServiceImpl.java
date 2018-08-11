package friends.service;

import static fw.DBUtil.close;
import static fw.DBUtil.getConnect;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import friends.dao.FriendsDAO;
import friends.dao.FriendsDAOImpl;
import friends.dto.BdDTO;
import friends.dto.MsgDTO;
import member.dto.MemberDTO;

public class FriendsServiceImpl implements FriendsService {

	@Override
	public int insertMsg(MsgDTO msg) {	// 메세지 작성
		System.out.println("Service요청");
		int result = 0;
		Connection con = null;		
		FriendsDAO dao = new FriendsDAOImpl();	
		try {
			con = getConnect();
			result = dao.insertMsg(msg, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(con);
		}
		return result;
	}

	@Override
	public ArrayList<MsgDTO> readMsg(String option, String me_id) {	// 메시지 목록
		System.out.println("Service요청");
		ArrayList<MsgDTO> msgs = null;
		FriendsDAO dao = new FriendsDAOImpl();
		Connection con = null;
		try{
			con = getConnect();
			msgs = dao.readMsg(option, me_id, con);
		} catch (SQLException e){
			e.printStackTrace();
		}
		close(con);
		return msgs;
	}

	@Override
	public int insertBd(BdDTO bd) {	// 친구 추가
		int result = 0;
		Connection con = null;		
		FriendsDAO dao = new FriendsDAOImpl();	
		try {
			con = getConnect();
			result = dao.insertBd(bd, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(con);
		}
		return result;
	}

	@Override
	public int deleteBd(BdDTO bd) {
		int result = 0;
		Connection con = null;		
		FriendsDAO dao = new FriendsDAOImpl();	
		try {
			con = getConnect();
			result = dao.deleteBd(bd, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(con);
		}
		return result;
	}
		
	public ArrayList<String> friendsList(String me_id) {	// 친구 목록
		System.out.println("Service요청");
		ArrayList<String> friends = null;
		FriendsDAO dao = new FriendsDAOImpl();
		Connection con = null;
		try{
			con = getConnect();
			friends = dao.friendsList(me_id, con);
		} catch (SQLException e){
			e.printStackTrace();
		}
		close(con);
		return friends;
	}

	@Override
	public ArrayList<MemberDTO> BckList() {		// 블랙리스트 목록
		System.out.println("Service요청");
		ArrayList<MemberDTO> list = null;
		FriendsDAO dao = new FriendsDAOImpl();
		Connection con = null;
		try{
			con = getConnect();
			list = dao.BckList(con);
		} catch (SQLException e){
			e.printStackTrace();
		}
		close(con);
		return list;
	}
}
