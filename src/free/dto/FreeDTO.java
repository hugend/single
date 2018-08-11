package free.dto;

import java.sql.Date;

public class FreeDTO {

	private int fr_no;
	private String fr_title;
	private String fr_txt;
	private String fr_ctg;
	private Date fr_date;
	private int fr_hits;
	private String fr_img;
	private String me_id;
	
	private int cmtcount;
	
	public int getCmtcount() {
		return cmtcount;
	}

	public void setCmtcount(int cmtcount) {
		this.cmtcount = cmtcount;
	}

	public FreeDTO() {
		
	}

	// 게시글 업데이트용
	public FreeDTO(int fr_no, String fr_title, String fr_txt, String fr_ctg, String fr_img) {
		super();
		this.fr_no = fr_no;
		this.fr_title = fr_title;
		this.fr_txt = fr_txt;
		this.fr_ctg = fr_ctg;
		this.fr_img = fr_img;
	}
	
	// 게시글 목록용
	public FreeDTO(int fr_no, String fr_title, Date fr_date, int fr_hits, String me_id) {
		super();
		this.fr_no = fr_no;
		this.fr_title = fr_title;
		this.fr_date = fr_date;
		this.fr_hits = fr_hits;
		this.me_id = me_id;
	}
	
	
	// 게시글 등록용
	public FreeDTO(String fr_title, String fr_txt, String fr_ctg, String fr_img, String me_id) {
		super();
		this.fr_title = fr_title;
		this.fr_txt = fr_txt;
		this.fr_ctg = fr_ctg;
		this.fr_img = fr_img;
		this.me_id = me_id;
	}
	
	
	public FreeDTO(int fr_no, String fr_title, String fr_txt, String fr_ctg, Date fr_date, int fr_hits, String fr_img,
			String me_id) {
		super();
		this.fr_no = fr_no;
		this.fr_title = fr_title;
		this.fr_txt = fr_txt;
		this.fr_ctg = fr_ctg;
		this.fr_date = fr_date;
		this.fr_hits = fr_hits;
		this.fr_img = fr_img;
		this.me_id = me_id;
	}



	public FreeDTO(int fr_no, String fr_title, String fr_txt, String fr_ctg, Date fr_date, int fr_hits, String fr_img,
			String me_id, int cmtcount) {
		super();
		this.fr_no = fr_no;
		this.fr_title = fr_title;
		this.fr_txt = fr_txt;
		this.fr_ctg = fr_ctg;
		this.fr_date = fr_date;
		this.fr_hits = fr_hits;
		this.fr_img = fr_img;
		this.me_id = me_id;
		this.cmtcount = cmtcount;
	}

	@Override
	public String toString() {
		return "FreeDTO [fr_no=" + fr_no + ", fr_title=" + fr_title + ", fr_txt=" + fr_txt + ", fr_ctg=" + fr_ctg
				+ ", fr_date=" + fr_date + ", fr_hits=" + fr_hits + ", fr_img=" + fr_img + ", me_id=" + me_id
				+ ", cmtcount=" + cmtcount + "]";
	}

	public int getFr_no() {
		return fr_no;
	}

	public void setFr_no(int fr_no) {
		this.fr_no = fr_no;
	}

	public String getFr_title() {
		return fr_title;
	}

	public void setFr_title(String fr_title) {
		this.fr_title = fr_title;
	}

	public String getFr_txt() {
		return fr_txt;
	}

	public void setFr_txt(String fr_txt) {
		this.fr_txt = fr_txt;
	}

	public String getFr_ctg() {
		return fr_ctg;
	}

	public void setFr_ctg(String fr_ctg) {
		this.fr_ctg = fr_ctg;
	}

	public Date getFr_date() {
		return fr_date;
	}

	public void setFr_date(Date fr_date) {
		this.fr_date = fr_date;
	}

	public int getFr_hits() {
		return fr_hits;
	}

	public void setFr_hits(int fr_hits) {
		this.fr_hits = fr_hits;
	}

	public String getFr_img() {
		return fr_img;
	}

	public void setFr_img(String fr_img) {
		this.fr_img = fr_img;
	}

	public String getMe_id() {
		return me_id;
	}

	public void setMe_id(String me_id) {
		this.me_id = me_id;
	}
	
	
}



/*
public class QnaDTO {
	//레코드를 구성하는 컬럼을 DTO클래스의 멤버변수로 정의

	private int board_num;
	private String id;
	private String board_title;
	private String board_content;
	private String board_date;
	private int board_level;
	private int board_pair;

*/