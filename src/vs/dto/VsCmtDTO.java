package vs.dto;

import java.sql.Date;
public class VsCmtDTO {
	
	private int vs_cmt_no;		// 댓글번호
	private String vs_cmt_txt;	// 댓글내용
	private Date vs_cmt_date;	// 작성일
	private int vs_no;			// 글번호
	private String me_id;		// 작성자ID

	public VsCmtDTO(){}

	// 삽입용
	public VsCmtDTO(String vs_cmt_txt, String me_id, int vs_no) {
		super();
		this.vs_cmt_txt = vs_cmt_txt;
		this.me_id = me_id;
		this.vs_no = vs_no;
	}

	// 조회용
	public VsCmtDTO(int vs_cmt_no, String vs_cmt_txt, Date vs_cmt_date, int vs_no, String me_id) {
		super();
		this.vs_cmt_no = vs_cmt_no;
		this.vs_cmt_txt = vs_cmt_txt;
		this.vs_cmt_date = vs_cmt_date;
		this.vs_no = vs_no;
		this.me_id = me_id;
	}

	@Override
	public String toString() {
		return "VsCmtDTO [vs_cmt_no=" + vs_cmt_no + ", vs_cmt_txt=" + vs_cmt_txt + ", vs_cmt_date=" + vs_cmt_date
				+ ", vs_no=" + vs_no + ", me_id=" + me_id + "]";
	}

	public int getVs_cmt_no() {
		return vs_cmt_no;
	}

	public void setVs_cmt_no(int vs_cmt_no) {
		this.vs_cmt_no = vs_cmt_no;
	}

	public String getVs_cmt_txt() {
		return vs_cmt_txt;
	}

	public void setVs_cmt_txt(String vs_cmt_txt) {
		this.vs_cmt_txt = vs_cmt_txt;
	}

	public String getMe_id() {
		return me_id;
	}

	public void setMe_id(String me_id) {
		this.me_id = me_id;
	}

	public int getVs_no() {
		return vs_no;
	}

	public void setVs_no(int vs_no) {
		this.vs_no = vs_no;
	}

	public Date getVs_cmt_date() {
		return vs_cmt_date;
	}

	public void setVs_cmt_date(Date vs_cmt_date) {
		this.vs_cmt_date = vs_cmt_date;
	}

}