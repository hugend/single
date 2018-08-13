package member.dao;

import static fw.DBUtil.close;
import static member.query.MemberQuery.*;
import static member.query.MemberQuery.USER_INSERT;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import member.dto.MemberDTO;

public class MemberDAOImpl implements MemberDAO{

	@Override
	public int memberinsert(MemberDTO user, Connection con) throws SQLException {
		int result = 0;
		PreparedStatement ptmt = con.prepareStatement(USER_INSERT);
		
		ptmt.setString(1, user.getMe_id());
		ptmt.setString(2, user.getMe_pwd());
		ptmt.setString(3,user.getMe_name());
		ptmt.setDate(4, user.getMe_birth());
		ptmt.setString(5, user.getMe_gender());
		ptmt.setString(6, user.getMe_phone());
		ptmt.setString(7, user.getMe_telnum());
		ptmt.setString(8, user.getMe_telchk());
		ptmt.setString(9, user.getMe_email());
		ptmt.setString(10, user.getMe_addr());
		ptmt.setString(11, user.getMe_character());
		ptmt.setString(12, user.getMe_img());
		ptmt.setString(13, user.getMe_loc());
	
		result = ptmt.executeUpdate();
		close(ptmt);
		
		return result;
	}

	@Override
	public MemberDTO getLoginUser(String id, String pass, Connection con) throws SQLException {
		MemberDTO loginUser = null;
		PreparedStatement ptmt = con.prepareStatement(LOGIN);
		ptmt.setString(1, id);
		ptmt.setString(2, pass);
		ResultSet rs = ptmt.executeQuery();
		
		if(rs.next()){
			loginUser = new MemberDTO(rs.getString(1), rs.getString(2), 
					rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), 
					rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), 
					rs.getInt(11), rs.getInt(12), rs.getString(13), rs.getString(14), 
					rs.getString(15), rs.getString(16), rs.getString(17), rs.getInt(18));
		}
	
		close(rs);
		close(ptmt);
		
		return loginUser;
	}

	@Override
	public MemberDTO getUserInfo(String id, Connection con) throws SQLException {
		MemberDTO user = null;
		PreparedStatement ptmt = con.prepareStatement(USERINFO);
		ptmt.setString(1, id);
		ResultSet rs = ptmt.executeQuery();
		
		if(rs.next()){
			user = new MemberDTO(rs.getString(1), rs.getString(2), 
					rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), 
					rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), 
					rs.getInt(11), rs.getInt(12), rs.getString(13), rs.getString(14), 
					rs.getString(15), rs.getString(16), rs.getString(17), rs.getInt(18));
		}
	
		close(rs);
		close(ptmt);
		
		return user;
	}

	@Override
	public int memberupdate(MemberDTO user, Connection con) throws SQLException {
		int result = 0;
		PreparedStatement ptmt = con.prepareStatement(USER_UPDATE);
		
		ptmt.setString(1, user.getMe_pwd());
		ptmt.setString(2, user.getMe_phone());
		ptmt.setString(3, user.getMe_telnum());
		ptmt.setString(4, user.getMe_telchk());
		ptmt.setString(5, user.getMe_email());
		ptmt.setString(6, user.getMe_addr());
		ptmt.setString(7, user.getMe_character());
		ptmt.setString(8, user.getMe_img());
		ptmt.setString(9, user.getMe_id());

		result = ptmt.executeUpdate();
		close(ptmt);
		
		return result;
	}

	@Override
	public int memberwithdrawal(String id, Connection con) throws SQLException {
		int result = 0;
		PreparedStatement ptmt = con.prepareStatement(USER_WITHDRAWAL);
		
		ptmt.setString(1, id);

		result = ptmt.executeUpdate();
		close(ptmt);
		
		return result;
	}

	@Override
	public int point_update(int me_point, String me_id, Connection con) throws SQLException {
		int result = 0;
		PreparedStatement ptmt = con.prepareStatement(USER_POINT_UPDATE);
		ptmt.setInt(1, me_point);
		ptmt.setString(2, me_id);
		
		result = ptmt.executeUpdate();
		close(ptmt);
		
		return result;
	}
}
