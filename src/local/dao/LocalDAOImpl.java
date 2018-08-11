package local.dao;

import static fw.DBUtil.close;
import static local.query.LocalQuery.GET_EVENT_LIST;
import static member.query.MemberQuery.USER_INSERT;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.Connection;

import local.dto.LeDTO;

public class LocalDAOImpl implements LocalDAO {
	@Override
	public ArrayList<LeDTO> geteventlist(Connection con) throws SQLException {
		ArrayList<LeDTO> eventlist = new ArrayList<LeDTO>();
		LeDTO event = null;
		
		PreparedStatement ptmt = con.prepareStatement(GET_EVENT_LIST);
		
		ResultSet rs = ptmt.executeQuery();
		while(rs.next()){
			event = new LeDTO(rs.getString(1), rs.getDate(2), rs.getDate(3), 
					rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
			eventlist.add(event);
		}
		close(rs);
		close(ptmt);
		return eventlist;
	}
}
