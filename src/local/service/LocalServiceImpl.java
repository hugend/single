package local.service;

import static fw.DBUtil.close;
import static fw.DBUtil.getConnect;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import local.dao.LocalDAO;
import local.dao.LocalDAOImpl;
import local.dto.LeDTO;
import member.dao.MemberDAOImpl;

public class LocalServiceImpl implements LocalService {

	@Override
	public ArrayList<LeDTO> geteventlist() {
		ArrayList<LeDTO> eventlist = null;
		LocalDAO dao = new LocalDAOImpl();
		Connection con = null;
		try{
			con = getConnect();
			eventlist = dao.geteventlist(con);
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				close(con);
			}
			
		return eventlist;
	}
}
