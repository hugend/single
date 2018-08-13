package member.query;
public class MemberQuery {
	public static final String USER_INSERT
				="insert into member "
				+ "values(?,?,?,?,?,?,?,?,?,?,0,0,'»õ½Ï',?,'t',?,?,0)";
	public static final String LOGIN
				="select * from member where me_id=? and me_pwd=?";
	public static final String USERINFO
				="select * from member where me_id=?";
	public static final String USER_UPDATE
				="update member "
				+ "set me_pwd=?, me_phone=?, "
				+ "me_telnum=?, me_telchk=?, me_email=?, "
				+ "me_addr=?, me_character=?, me_img=? "
				+ "where me_id=?";
	
	public static final String USER_WITHDRAWAL
				="update member set me_state='f' where me_id=?";
	
	public static final String USER_POINT_UPDATE
				="update member set me_point=? where me_id=?";
}
