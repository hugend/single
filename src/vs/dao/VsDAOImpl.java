package vs.dao;

import static fw.DBUtil.close;
import static vs.query.VsQuery.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vs.dto.VsCmtDTO;
import vs.dto.VsDTO;
public class VsDAOImpl implements VsDAO {
	
	@Override
	public int insert(VsDTO post, Connection con) throws SQLException {	// vs게시글 작성
		System.out.println("DAO요청");
		int result = 0;
		PreparedStatement ptmt = con.prepareStatement(INSERT_POST);
		ptmt.setString(1, post.getVs_title());
		ptmt.setString(2, post.getVs_optionA());
		ptmt.setString(3, post.getVs_optionB());
		ptmt.setString(4, post.getVs_txt());
		ptmt.setString(5, post.getMe_id());
		
		result = ptmt.executeUpdate();
		System.out.println(result);
		close(ptmt);
		return result;
	}

	@Override
	public ArrayList<VsDTO> read(Connection con) throws SQLException {	// vs게시글 목록
		System.out.println("DAO요청");
		ArrayList<VsDTO> posts = new ArrayList<VsDTO>();
		VsDTO post = null;
		PreparedStatement ptmt = con.prepareStatement(READ_POSTS);
		ResultSet rs = ptmt.executeQuery();
		while (rs.next()) {
			post = new VsDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getDate(9));
			posts.add(post);
		}
		close(rs);
		close(ptmt);
		return posts;
	}

	@Override
	public int update(int vs_no, String option, Connection con) throws SQLException {	// 투표수 업데이트
		System.out.println("DAO요청");
		int result = 0;
		String sql = "";
		if(option.equals("A")){
			sql = UPDATE_OPTA;
		}else if(option.equals("B")){
			sql = UPDATE_OPTB;
		}
		PreparedStatement ptmt = con.prepareStatement(sql);
		ptmt.setInt(1, vs_no);
		result = ptmt.executeUpdate();
		close(ptmt);
		return result;
	}
	
	@Override
	public int voting(int vs_no, String me_id, String opt, Connection con) throws SQLException {	// 중복 투표 방지
		System.out.println("DAO요청");
		int result = 0;
		PreparedStatement ptmtCh = con.prepareStatement(CHECK_VOTING);
		ptmtCh.setInt(1, vs_no);
		ptmtCh.setString(2, me_id);
		ResultSet rs = ptmtCh.executeQuery();
		if (rs.next()) {	// 이미 투표함
			result = 1;		
		}else {		// 처음 투표 할 때 insert
			PreparedStatement ptmtVT = con.prepareStatement(INSERT_VOTING);
			ptmtVT.setInt(1, vs_no);
			ptmtVT.setString(2, me_id);
			ptmtVT.setString(3, opt);
			ptmtVT.executeUpdate();
		}		
		close(ptmtCh);
		return result;
	}

	@Override
	public int insert(VsCmtDTO comment, Connection con) throws SQLException {	// vs댓글 작성
		System.out.println("DAO요청");
		int result = 0;
		PreparedStatement ptmt = con.prepareStatement(INSERT_COMMENT);
		ptmt.setString(1, comment.getVs_cmt_txt());
		ptmt.setInt(2, comment.getVs_no());
		ptmt.setString(3, comment.getMe_id());
		
		result = ptmt.executeUpdate();
		System.out.println(result);
		close(ptmt);
		return result;
	}

	@Override
	public ArrayList<VsCmtDTO> read(int vs_no, Connection con) throws SQLException {	// vs댓글 목록
		System.out.println("DAO요청");
		ArrayList<VsCmtDTO> comments = new ArrayList<VsCmtDTO>();
		VsCmtDTO comment = null;
		PreparedStatement ptmt = con.prepareStatement(READ_COMMENTS);
		ptmt.setInt(1, vs_no);
		ResultSet rs = ptmt.executeQuery();
		while (rs.next()) {
			comment = new VsCmtDTO(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getInt(4), rs.getString(5));
			comments.add(comment);
		}
		close(rs);
		close(ptmt);
		return comments;
	}

}
