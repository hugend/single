package friends.query;

public class FriendsQuery {
	
	// 메시지 삽입
	public static final String INSERT_MSG = "insert into message values(msg_seq.nextval, ?, ?, ?, ?, sysdate)";

	// 메시지 목록 
	public static final String SEND_MSG = "select * from message where sender=?";
	public static final String RECIEVE_MSG = "select * from message where receiver=?";
	
	// 메시지 삭제
	public static final String DELETE_MSG = "delete from message where msg_no=?";
	
	// 친구 추가
	public static final String INSERT_BD = "insert into bd_list values(?,?)";
	
	// 친구 삭제
	public static final String DELETE_BD = "delete from bd_list where me_id=?, bd_id=?";
	
	// 친구 목록
	public static final String SELECT_FRIENDS = "select * from bd_list where me_id=?";
	
	// 블랙리스트 목록
	public static final String SELECT_BCKLIST = "select * from member where me_black>=10";
	
	// 블랙리스트 삭제
	public static final String UPDATE_BLACK = "update member set me_black=0 where me_id=?";
	
	// 블랙리스트 검색
	public static final String SEARCH_BLACK = "select * from member where me_black>=10 and me_id like ? or me_name like ?";

}
