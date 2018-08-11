package vs.query;

public class VsQuery {
	// vs게시글 삽입
	public static final String INSERT_POST = "insert into vs_board values(vs_seq.nextval, ?, ?, ?, ?, ?, 0, 0, sysdate)";
	
	// vs게시글 목록 
	public static final String READ_POSTS = "select * from vs_board order by vs_hitsA+vs_hitsB desc";
	
	// 투표수 업데이트
	public static final String UPDATE_OPTA = "update VS_BOARD set vs_hitsA = vs_hitsA+1 where vs_no=?";
	public static final String UPDATE_OPTB = "update VS_BOARD set vs_hitsB = vs_hitsB+1 where vs_no=?";
	
	// vs게시글 업데이트
	public static final String UPDATE_POST = "update vs_board set vs_title=?, vs_optionA=?, vs_optionB=?, vs_txt=? where vs_no=?";
	
	// vs게시글 삭제
	public static final String DELETE_POST = "delete vs_board where vs_no=?";

	// vs댓글 삽입
	public static final String INSERT_COMMENT = "insert into vs_cmt values(vs_cmt_seq.nextval, ?, sysdate, ?, ?)";
	
	// vs댓글 목록 
	public static final String READ_COMMENTS = "select * from vs_cmt where vs_no=?";
}
