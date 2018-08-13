package point.service;

import static fw.DBUtil.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import member.dao.MemberDAO;
import member.dao.MemberDAOImpl;
import point.dao.PointDAO;
import point.dao.PointDAOImpl;
import point.dto.PointDTO;

public class PointServiceImpl implements PointService {

	@Override
	public int po_insert(PointDTO dto) {
		int result = 0;
		PointDAO dao = new PointDAOImpl();
		Connection con = null;
		try {
			con = getConnect();
			result = dao.po_insert(dto, con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return result;
	}

	@Override
	public ArrayList<PointDTO> po_list() {
		ArrayList<PointDTO> dtolist = null;
		PointDAO dao = new PointDAOImpl();
		Connection con = null;
		con = getConnect();
		try {
			dtolist = dao.po_list(con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return dtolist;
	}

	@Override
	public PointDTO po_read(int po_no) {
		PointDTO dto = null;
		PointDAO dao = new PointDAOImpl();
		Connection con = getConnect();
		try {
			dto = dao.po_read(po_no, con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return dto;
	}

	@Override
	public int po_delete(String po_no) {
		int result = 0;
		PointDAO dao = new PointDAOImpl();
		Connection con = null;
		try {
			con = getConnect();
			result = dao.po_delete(po_no, con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return result;
	}

	@Override
	public int po_update(PointDTO prd) {
		int result = 0;
		PointDAO dao = new PointDAOImpl();
		Connection con = null;
		try {
			con = getConnect();
			result = dao.po_update(prd, con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return result;
	}

	@Override
	public int buy_update(int me_point, String me_id, int po_no) {
		int result = 0;

		MemberDAO dao1 = new MemberDAOImpl();
		PointDAO dao2 = new PointDAOImpl();
		Connection con = null;
		boolean state = false;

		try {
			con = getConnect();
			con.setAutoCommit(false);
			int a = dao1.point_update(me_point, me_id, con);
			int b = dao2.count_update(po_no, con);
			result = a + b;
			state = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (state) {
					con.commit();
				} else {
					con.rollback();
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
			close(con);
		}
		
		return result;
	}

	@Override
	public int po_state_update(int po_state, int po_no) {
		int result = 0;
		PointDAO dao = new PointDAOImpl();
		Connection con = null;
		try {
			con = getConnect();
			result = dao.po_state_update(po_state, po_no, con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return result;
	}
}
