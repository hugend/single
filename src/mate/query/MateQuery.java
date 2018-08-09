package mate.query;

public class MateQuery {
	public static final String MATE_INSERT =
			"insert into mate_board values(mate_seq.nextval, ?, ?, sysdate, 0, ? ,?, ?, ?, ?, ?, ?, '')";
	public static final String MATE_LIST =
			"select * from mate_board order by mt_no desc";
	public static final String MATE_READ =
			"select * from mate_board where mt_no = ?";
	public static final String MATE_UPDATE_HITS = 
			"update mate_board set mt_hits = nvl(mt_hits, 0)+1 where mt_no = ?";
	public static final String MATE_REPLY_INSERT =
			"insert into mate_cmt values(mate_cmt_seq.nextval, ?, sysdate, ?, ?)";
	public static final String MATE_REPLY_READ = 
			"select * from mate_cmt where mt_no = ? order by mt_cmt_date";
	public static final String MATE_REPLY_DELETE = 
			"delete from mate_cmt where mt_cmt_no=?";
}
/*mt_cmt_no number,
mt_cmt_txt varchar2(500),
mt_cmt_date date,
mt_no number,
me_id varchar2(30));

sequence mate_cmt_seq;*/
/*
 * mate_seq
 * create table mate_board(	
 
mt_no number,
mt_title varchar2(100),
mt_txt varchar2(1000),
mt_date date,
mt_hits number,
mt_file varchar2(200),
mt_map varchar2(200),
mt_ctg varchar2(30),
mt_cnt number,
me_id varchar2(30),
mt_img varchar2(200),
mt_participant varchar2(200));*/