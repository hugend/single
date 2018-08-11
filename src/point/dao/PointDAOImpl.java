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
		ptmt = con.prepareStatement(POINT_INSERT);
		ptmt.setString(1, dto.getPo_title());
		ptmt.setString(2, dto.getPo_txt());
		ptmt.setString(3, dto.getPo_img());
		ptmt.setInt(4, dto.getPo_pt());
		ptmt.setInt(5, dto.getPo_state());
		
		result=ptmt.executeUpdate();
		close(ptmt);
/*		public static final String POINT_INSERT=
				"insert into point values(market_seq.nextval, ? , ?, ?, sysdate ,?)";*/
		return result;
	}

	@Override
	public ArrayList<PointDTO> po_list(Connection con) throws SQLException {
		ArrayList<PointDTO> dtolist = new ArrayList<PointDTO>();
		PointDTO dto = null;
		PreparedStatement ptmt = null;
		ptmt = con.prepareStatement(POINT_LIST);
	
		ResultSet rs = 	ptmt.executeQuery();
		while(rs.next()){
			dto =  new PointDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getInt(5), rs.getString(6), rs.getInt(7));
			
			dtolist.add(dto);
		}
		close(ptmt);
		return dtolist;
	}

	@Override
	public PointDTO po_read(int po_no, Connection con) throws SQLException {
		PointDTO dto = null;
		PreparedStatement ptmt = null;
		ptmt = con.prepareStatement(POINT_READ);
		ptmt.setInt(1, po_no);
		ResultSet rs= ptmt.executeQuery();
		while(rs.next()){
			dto =  new PointDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getInt(5), rs.getString(6), rs.getInt(7));
		}
		close(ptmt);
		return dto;
	}
}
