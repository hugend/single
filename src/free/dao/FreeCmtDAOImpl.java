package free.dao;

import static free.query.FreeQuery.*;
import static fw.DBUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import free.dto.FreeCmtDTO;

public class FreeCmtDAOImpl implements FreeCmtDAO{
	
	@Override
	public ArrayList<FreeCmtDTO> getCmtList(int fr_no, Connection con) throws SQLException {
		ArrayList<FreeCmtDTO> cmtlist = new ArrayList<FreeCmtDTO>();

		FreeCmtDTO cmt = null;
		PreparedStatement ptmt = con.prepareStatement(SELECT_CMT_LIST);
		ptmt.setInt(1, fr_no);
		
		ResultSet rs = ptmt.executeQuery();
		while (rs.next()) {
			cmt = new FreeCmtDTO(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5));
			cmtlist.add(cmt);
		}

		return cmtlist;
	}
	

	@Override
	public int delete(int fr_cmt_no, Connection con) throws SQLException {
		int result = 0;

		PreparedStatement ptmt = con.prepareStatement(DELETE_CMT);
		ptmt.setInt(1, fr_cmt_no);
		
		result = ptmt.executeUpdate();
		
		close(ptmt);
		return result;
	}

	@Override
	public int insert(FreeCmtDTO cmt, Connection con) throws SQLException {
		int result = 0;
		//System.out.println("´ñ±Û µî·Ï dao: " + cmt);

		PreparedStatement ptmt = con.prepareStatement(INSERT_CMT);
		ptmt.setString(1, cmt.getFr_cmt_txt());
		ptmt.setInt(2, cmt.getFr_no());
		ptmt.setString(3, cmt.getMe_id());

		result = ptmt.executeUpdate();
		
		close(ptmt);
		return result;
	}
	

}
