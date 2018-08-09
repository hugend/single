package mate.dao;

import static fw.DBUtil.*;
import static mate.query.MateQuery.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mate.dto.MateCmtDTO;
import mate.dto.MateDTO;
import static mate.query.MateQuery.*;
import static fw.DBUtil.*;
public class MateDAOImpl implements MateDAO {

	@Override
	public int insert_mt(MateDTO dto, Connection con) throws SQLException {
		int result = 0;
		PreparedStatement ptmt = con.prepareStatement(MATE_INSERT);
		ptmt = con.prepareStatement(MATE_INSERT);
		ptmt.setString(1, dto.getMt_title());
		ptmt.setString(2, dto.getMt_txt());
		ptmt.setString(3, dto.getMt_file());
		ptmt.setString(4, dto.getMt_map());
		ptmt.setString(5, dto.getMt_loc());
		ptmt.setString(6, dto.getMt_ctg());
		ptmt.setInt(7, dto.getMt_cnt());
		ptmt.setString(8, dto.getMe_id());
		ptmt.setString(9, dto.getMt_img());
		result = ptmt.executeUpdate();
		close(ptmt);
		return result;
	}

	@Override
	public ArrayList<MateDTO> group(Connection con) throws SQLException {
		ArrayList<MateDTO> dtolist = new ArrayList<MateDTO>();
		MateDTO dto = null;
		
		PreparedStatement ptmt = null;
		ptmt = con.prepareStatement(MATE_LIST);
		
		ResultSet rs = ptmt.executeQuery();
		while(rs.next()){
			dto = new MateDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), 
					rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getString(12), rs.getString(13));
			dtolist.add(dto);
		}
		close(rs);
		close(ptmt);
		return dtolist;
	}

	@Override
	public MateDTO read_mt(int mt_no, Connection con) throws SQLException {
		MateDTO dto = null;
		PreparedStatement ptmt = null;
		ptmt = con.prepareStatement(MATE_READ);
		ptmt.setInt(1, mt_no);
		
		ResultSet rs = ptmt.executeQuery();
		while(rs.next()){
			dto = new MateDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), 
					rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getString(12), rs.getString(13));
		}
		close(rs);
		close(con);
		return dto;
	}

	@Override
	public int update_hits(int mt_no, Connection con) throws SQLException {
		int result = 0;
		PreparedStatement ptmt = con.prepareStatement(MATE_UPDATE_HITS);
		ptmt.setInt(1, mt_no);
		result = ptmt.executeUpdate();
		close(ptmt);
		return result;
	}

	
	
	//**********************메이트 게시판 댓글**********************************
	
	@Override
	public int insert_mt_cmt(MateCmtDTO dto, Connection con) throws SQLException {
		int result = 0;
		PreparedStatement ptmt = con.prepareStatement(MATE_REPLY_INSERT);
		ptmt.setString(1, dto.getMt_cmt_txt());
		ptmt.setInt(2, dto.getMt_no());
		ptmt.setString(3, dto.getMe_id());
		result = ptmt.executeUpdate();
		close(ptmt);
		return result;
	}

	@Override
	public ArrayList<MateCmtDTO> List_mt_cmt(int mt_no, Connection con) throws SQLException {
		ArrayList<MateCmtDTO> dtolist = new ArrayList<MateCmtDTO>();
		MateCmtDTO dto =  null;
		PreparedStatement ptmt = con.prepareStatement(MATE_REPLY_READ);
		ptmt.setInt(1, mt_no);
		ResultSet rs = ptmt.executeQuery();
		while(rs.next()){
			dto = new MateCmtDTO(rs.getInt(1), rs.getString(2),
					rs.getString(3), rs.getInt(4), rs.getString(5));
			
			dtolist.add(dto);
		}
		return dtolist;
	}

	@Override
	public int delete_mt_cmt(int mt_cmt_no, Connection con) throws SQLException {
		int result = 0;
		PreparedStatement ptmt = con.prepareStatement(MATE_REPLY_DELETE);
		ptmt.setInt(1, mt_cmt_no);
		result = ptmt.executeUpdate();
		close(ptmt);
		return result;
	}
	
	
	
	

}
