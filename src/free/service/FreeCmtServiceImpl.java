package free.service;

import static fw.DBUtil.close;
import static fw.DBUtil.getConnect;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import free.dao.FreeCmtDAO;
import free.dao.FreeCmtDAOImpl;
import free.dto.FreeCmtDTO;

public class FreeCmtServiceImpl implements FreeCmtService {

	@Override
	public int delete(int fr_cmt_no) {
		int result = 0;
		FreeCmtDAO dao = new FreeCmtDAOImpl();
		Connection con = null;
		try {
			con = getConnect();
			result = dao.delete(fr_cmt_no, con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return result;
	}

	@Override
	public ArrayList<FreeCmtDTO> getCmtList(int fr_no) {
		ArrayList<FreeCmtDTO> cmplist = null;
		FreeCmtDAO dao = new FreeCmtDAOImpl();
		Connection con = null;
		try {
			con = getConnect();
			cmplist = dao.getCmtList(fr_no, con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return cmplist;
	}

	@Override
	public int insert(FreeCmtDTO cmt) {
		int result = 0;
		FreeCmtDAO dao = new FreeCmtDAOImpl();
		Connection con = null;
		try {
			con = getConnect();
			result = dao.insert(cmt, con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return result;
	}

}
