package free.dao;

import static fw.DBUtil.close;
import static free.query.FreeQuery.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import free.dto.FreeDTO;

public class FreeDAOImpl implements FreeDAO {

	@Override
	public int insert(FreeDTO post, Connection con) throws SQLException {
		int result = 0;

		PreparedStatement ptmt = con.prepareStatement(INSERT_POST);
		ptmt.setString(1, post.getFr_title());
		ptmt.setString(2, post.getFr_txt());
		ptmt.setString(3, post.getFr_ctg());
		ptmt.setString(4, post.getFr_img());
		ptmt.setString(5, post.getMe_id());

		result = ptmt.executeUpdate();

		close(ptmt);
		return result;
	}

	@Override
	public int update(FreeDTO post, Connection con) throws SQLException {
		int result = 0;

		PreparedStatement ptmt = con.prepareStatement(UPDATE_POST);
		ptmt.setString(1, post.getFr_title());
		ptmt.setString(2, post.getFr_txt());
		ptmt.setString(3, post.getFr_ctg());
		ptmt.setString(4, post.getFr_img());
		ptmt.setInt(5, post.getFr_no());

		result = ptmt.executeUpdate();

		close(ptmt);
		return result;
	}

	@Override
	public int delete(int fr_no, Connection con) throws SQLException {
		int result = 0;

		PreparedStatement ptmt = con.prepareStatement(DELETE_POST);
		ptmt.setInt(1, fr_no);

		result = ptmt.executeUpdate();

		close(ptmt);
		return result;
	}

	@Override
	public FreeDTO read(int fr_no, Connection con) throws SQLException {
		FreeDTO post = null;
		int result = 0;

		PreparedStatement ptmt = con.prepareStatement(READ_POST);
		PreparedStatement ptmt2 = con.prepareStatement(READ_POST_HITS);
		PreparedStatement ptmt3 = con.prepareStatement(COUNT_CMT);

		ptmt.setInt(1, fr_no);
		ResultSet rs = ptmt.executeQuery();

		if (rs.next()) {
			post = new FreeDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5),
					rs.getInt(6) + 1, rs.getString(7), rs.getString(8));
		}

		ptmt2.setInt(1, post.getFr_hits());
		ptmt2.setInt(2, fr_no);
		result = ptmt2.executeUpdate();

		ptmt3.setInt(1, fr_no);
		rs = ptmt3.executeQuery();
		if (rs.next()) {
			post.setCmtcount(rs.getInt(1));
		}

		close(rs);
		close(ptmt);
		close(ptmt2);
		close(ptmt3);

		return post;
	}

	@Override
	public ArrayList<FreeDTO> getPostList(Connection con) throws SQLException {
		ArrayList<FreeDTO> postlist = new ArrayList<FreeDTO>();
		FreeDTO post = null;

		PreparedStatement ptmt = con.prepareStatement(SELECT_POST_ALL);
		ResultSet rs = ptmt.executeQuery();

		while (rs.next()) {
			post = new FreeDTO(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getInt(4), rs.getString(5));
			postlist.add(post);
		}

		if (postlist.size() != 0) {

			PreparedStatement ptmt2 = con.prepareStatement(COUNT_CMT);
			for (int i = 0; i < postlist.size(); i++) {
				ptmt2.setInt(1, postlist.get(i).getFr_no());
				rs = ptmt2.executeQuery();

				while (rs.next()) {
					postlist.get(i).setCmtcount(rs.getInt(1));
				}
			}
			close(ptmt2);
		}
		close(ptmt);

		return postlist;
	}

	@Override
	public ArrayList<FreeDTO> getCtgList(String fr_ctg, Connection con) throws SQLException {
		ArrayList<FreeDTO> postlist = new ArrayList<FreeDTO>();

		FreeDTO post = null;
		PreparedStatement ptmt = con.prepareStatement(SELECT_POST_CTG);
		ptmt.setString(1, fr_ctg);
		ResultSet rs = ptmt.executeQuery();

		while (rs.next()) {
			post = new FreeDTO(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getInt(4), rs.getString(5));
			postlist.add(post);
		}

		if (postlist.size() != 0) {

			PreparedStatement ptmt2 = con.prepareStatement(COUNT_CMT);
			for (int i = 0; i < postlist.size(); i++) {
				ptmt2.setInt(1, postlist.get(i).getFr_no());
				rs = ptmt2.executeQuery();

				while (rs.next()) {
					postlist.get(i).setCmtcount(rs.getInt(1));
				}
			}
			close(ptmt2);
		}
		close(rs);
		close(ptmt);
		return postlist;
	}

	@Override
	public int report(String me_id, Connection con) throws SQLException {
		int result = 0;

		PreparedStatement ptmt = con.prepareStatement(REPORT_USER);
		ptmt.setString(1, me_id);

		result = ptmt.executeUpdate();

		close(ptmt);
		return result;
	}

	@Override
	public ArrayList<FreeDTO> search(String column, String search, Connection con) throws SQLException {
		ArrayList<FreeDTO> postlist = new ArrayList<FreeDTO>();
		FreeDTO post = null;

		String sql = "";
		if (column.equals("title")) {
			sql = SEARCH_TITLE;
		} else if (column.equals("content")) {
			sql = SEARCH_TXT;
		} else if (column.equals("writer")) {
			sql = SEARCH_WRITER;
		} else {
			sql = SEARCH_ALL;
		}

		PreparedStatement ptmt = con.prepareStatement(sql);
		if (sql.equals(SEARCH_ALL)) {
			ptmt.setString(1, "%" + search + "%");
			ptmt.setString(2, "%" + search + "%");
			ptmt.setString(3, "%" + search + "%");
		} else {
			ptmt.setString(1, "%" + search + "%");
		}

		ResultSet rs = ptmt.executeQuery();

		while (rs.next()) {
			post = new FreeDTO(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getInt(4), rs.getString(5));
			postlist.add(post);
		}

		if (postlist.size() != 0) {

			PreparedStatement ptmt2 = con.prepareStatement(COUNT_CMT);
			for (int i = 0; i < postlist.size(); i++) {
				ptmt2.setInt(1, postlist.get(i).getFr_no());
				rs = ptmt2.executeQuery();

				while (rs.next()) {
					postlist.get(i).setCmtcount(rs.getInt(1));
				}
			}
			close(ptmt2);
		}

		close(rs);
		close(ptmt);
		return postlist;
	}

}
