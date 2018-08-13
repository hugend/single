package point.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import point.dto.PointDTO;
import static point.query.PointQuery.*;
import static fw.DBUtil.*;

public class PointDAOImpl implements PointDAO {

	@Override
	public int po_insert(PointDTO dto, Connection con) throws SQLException {
		int result = 0;
		PreparedStatement ptmt = null;
		ptmt = con.prepareStatement(PRD_INSERT);
		ptmt.setString(1, dto.getPo_title());
		ptmt.setString(2, dto.getPo_txt());
		ptmt.setString(3, dto.getPo_img());
		ptmt.setInt(4, dto.getPo_pt());
		ptmt.setInt(5, dto.getPo_state());
		ptmt.setInt(6, dto.getPo_count());
		
		result=ptmt.executeUpdate();
		close(ptmt);
		return result;
	}

	@Override
	public ArrayList<PointDTO> po_list(Connection con) throws SQLException {
		ArrayList<PointDTO> dtolist = new ArrayList<PointDTO>();
		PointDTO dto = null;
		PreparedStatement ptmt = null;
		ptmt = con.prepareStatement(PRD_LIST);
	
		ResultSet rs = 	ptmt.executeQuery();
		while(rs.next()){
			dto =  new PointDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getInt(5), rs.getDate(6), rs.getInt(7), rs.getInt(8));
			
			dtolist.add(dto);
		}
		close(ptmt);
		return dtolist;
	}

	@Override
	public PointDTO po_read(int po_no, Connection con) throws SQLException {
		PointDTO dto = null;
		PreparedStatement ptmt = null;
		ptmt = con.prepareStatement(PRD_READ);
		ptmt.setInt(1, po_no);
		ResultSet rs= ptmt.executeQuery();
		while(rs.next()){
			dto =  new PointDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getInt(5), rs.getDate(6), rs.getInt(7), rs.getInt(8));
		}
		close(ptmt);
		return dto;
	}

	@Override
	public int po_delete(String po_no, Connection con) throws SQLException {
		int result = 0;
		PreparedStatement ptmt = null;
		
		ptmt = con.prepareStatement(PRD_DELETE);
		ptmt.setString(1, po_no);
		
		result=ptmt.executeUpdate();
		
		close(ptmt);
		return result;
	}

	@Override
	public int po_update(PointDTO prd, Connection con) throws SQLException {
		int result = 0;
		PreparedStatement ptmt = null;
		ptmt = con.prepareStatement(PRD_UPDATE);
		
		ptmt.setString(1, prd.getPo_title());
		ptmt.setString(2, prd.getPo_txt());
		ptmt.setString(3, prd.getPo_img());
		ptmt.setInt(4, prd.getPo_pt());
		ptmt.setInt(5, prd.getPo_state());
		ptmt.setInt(6, prd.getPo_count());
		ptmt.setInt(7, prd.getPo_no());
		
		result=ptmt.executeUpdate();
		
		close(ptmt);
		
		return result;
	}

	@Override
	public int count_update(int po_no, Connection con) throws SQLException {
		int result = 0;
		PreparedStatement ptmt = con.prepareStatement(PRD_COUNT_UPDATE);
		ptmt.setInt(1, po_no);
		result=ptmt.executeUpdate();
		
		close(ptmt);
		return result;
	}

	@Override
	public int po_state_update(int po_state, int po_no, Connection con) throws SQLException {
		int result = 0;
		PreparedStatement ptmt = con.prepareStatement(PRD_STATE_UPDATE);
		ptmt.setInt(1, po_state);
		ptmt.setInt(2, po_no);
		result = ptmt.executeUpdate();
		
		close(ptmt);
		return 0;
	}
}
