package mate.service;

import java.sql.Connection;
import java.sql.SQLException;
import static fw.DBUtil.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import mate.dao.MateDAO;
import mate.dao.MateDAOImpl;
import mate.dto.MateCmtDTO;
import mate.dto.MateDTO;

public class MateServiceImpl implements MateService {
	@Override
	public int insert_mt(MateDTO dto) {
		int result = 0;
		Connection con = null;
		con = getConnect();
		MateDAO dao = new MateDAOImpl();
		try {
			result = dao.insert_mt(dto, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(con);
		}

		return result;
	}

	@Override
	public ArrayList<MateDTO> group() {
		ArrayList<MateDTO> dtolist = null;
		Connection con = null;
		MateDAO dao = new MateDAOImpl();
		con = getConnect();
		try {
			dtolist = dao.group(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(con);
		}
		return dtolist;
	}

	@Override
	public MateDTO read_mt(int mt_no) {
		MateDTO dto = null;
		Connection con = null;
		MateDAO dao = new MateDAOImpl();
		con = getConnect();
		try {
			dto = dao.read_mt(mt_no, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(con);
		}
		return dto;
	}

	@Override
	public int update_hits(int mt_no) {
		int result = 0;
		MateDAO dao = new MateDAOImpl();
		Connection con = null;
		try {
			con = getConnect();
			result = dao.update_hits(mt_no, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(con);
		}
		
		return result;
	}

	//**********************메이트 게시판 댓글**********************************
	@Override
	public int insert_mt_cmt(MateCmtDTO dto) {
		int result = 0;
		MateDAO dao = new MateDAOImpl();
		Connection con = getConnect();
		try {
			result = dao.insert_mt_cmt(dto, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(con);
		}
		return result;
	}

	@Override
	public ArrayList<MateCmtDTO> List_mt_cmt(int mt_no) {
		ArrayList<MateCmtDTO> dtolist = null;
		MateDAO dao = new MateDAOImpl();
		Connection con = getConnect();
		try {
			dtolist = dao.List_mt_cmt(mt_no, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		
		return dtolist;
	}

	@Override
	public int delete_mt_cmt(int mt_cmt_no) {
		int result = 0;
		MateDAO dao = new MateDAOImpl();
		Connection con = getConnect();
		try {
			result = dao.delete_mt_cmt(mt_cmt_no, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(con);
		}
		return result;
	}
	

	
	

}
