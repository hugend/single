package free.query;

public class FreeQuery {

	public static final String INSERT_POST 
	= "insert into fr_board values(fr_seq.nextval, ?, ?, ?, sysdate, 0, ?, ?)";	//글 작성
	
	public static final String UPDATE_POST
	= "update fr_board "
			+ "set fr_title=?, fr_txt=?, fr_ctg=?, fr_img=? where fr_no=?";	// 글 수정
	
	public static final String DELETE_POST 
	= "delete from fr_board where fr_no=?";	// 글 삭제
	
	public static final String READ_POST
	= "select * from fr_board where fr_no=?";	// 글 읽기
	
	public static final String READ_POST_HITS
	= "update fr_board set fr_hits = ? where fr_no=?";	// 조회수 증가
	
	public static final String SELECT_POST_ALL
	= "select fr_no, fr_title, fr_date, fr_hits, me_id from fr_board order by fr_no desc";		// 전체 게시글 목록 읽기
	
	public static final String SELECT_POST_CTG
	= "select fr_no, fr_title, fr_date, fr_hits, me_id from fr_board where fr_ctg=? order by fr_no desc";		// 카테고리별 게시글 목록 읽기
	
	
	public static final String INSERT_CMT
	= "insert into fr_cmt values(fr_cmt_seq.nextval, ?, sysdate, ?, 'cmt_test')";		// 댓글 작성

	public static final String UPDATE_CMT
	= "update fr_cmt "
			+ "set fr_cmt_txt=? where fr_cmt_no=?";		// 댓글 수정
	
	public static final String DELETE_CMT 
	= "delete from fr_cmt where fr_cmt_no=?";		// 댓글 삭제
	
	public static final String SELECT_CMT_LIST
	= "select fr_cmt_txt, fr_cmt_date, me_id from fr_cmt where fr_no=?";		// 댓글 읽기
	
	public static final String COUNT_CMT
	= "select count(fr_cmt_no) from fr_cmt where fr_no=?";		// 댓글 갯수
	
	public static final String REPORT_USER
	= "update member set me_black=? where me_id=?"; 		// 게시글 신고
	
	public static final String SEARCH
	= "select fr_no, fr_title, fr_date, fr_hits, me_id from fr_board where fr_title like ? or fr_txt like ? or me_id like ? ";
}



/*

create table fr_board(
fr_no number,
fr_title varchar2(100),
fr_txt varchar2(4000),
fr_ctg varchar2(30)	,
fr_date date,
fr_hits number,	
fr_img varchar2(200),	
me_id varchar2(30)	);

create table fr_cmt(
fr_cmt_no number,
fr_cmt_txt varchar2(1000),
fr_cmt_date date,
fr_no number,
me_id varchar2(30));


create sequence fr_seq;
create sequence fr_cmt_seq;


http://seinarin.tistory.com/1?category=452459 참고
*/