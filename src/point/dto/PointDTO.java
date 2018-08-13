package point.dto;

import java.sql.Date;

public class PointDTO {
	private int po_no;
	private String po_title;
	private String po_txt;
	private String po_img;
	private int po_pt;
	private Date po_date;
	private int po_state;
	private int po_count;
	
	public PointDTO() {
		super();
	}
	//조회용
	public PointDTO(int po_no, String po_title, String po_txt, String po_img, int po_pt, Date po_date, int po_state, int po_count) {
		super();
		this.po_no = po_no;
		this.po_title = po_title;
		this.po_txt = po_txt;
		this.po_img = po_img;
		this.po_pt = po_pt;
		this.po_date = po_date;
		this.po_state = po_state;
		this.po_count = po_count;
	}
	
	//insert용
	public PointDTO(String po_title, String po_txt, String po_img, int po_pt, int po_state, int po_count) {
		super();
		this.po_title = po_title;
		this.po_txt = po_txt;
		this.po_img = po_img;
		this.po_pt = po_pt;
		this.po_state = po_state;
		this.po_count = po_count;
	}

	//update용
	public PointDTO(int po_no, String po_title, String po_txt, String po_img, int po_pt, int po_state, int po_count) {
		super();
		this.po_no = po_no;
		this.po_title = po_title;
		this.po_txt = po_txt;
		this.po_img = po_img;
		this.po_pt = po_pt;
		this.po_state = po_state;
		this.po_count = po_count;
	}
	
	public int getPo_no() {
		return po_no;
	}

	public void setPo_no(int po_no) {
		this.po_no = po_no;
	}

	public String getPo_img() {
		return po_img;
	}

	public void setPo_img(String po_img) {
		this.po_img = po_img;
	}

	public String getPo_title() {
		return po_title;
	}

	public void setPo_title(String po_title) {
		this.po_title = po_title;
	}


	public String getPo_txt() {
		return po_txt;
	}

	public void setPo_txt(String po_txt) {
		this.po_txt = po_txt;
	}

	public int getPo_pt() {
		return po_pt;
	}

	public void setPo_pt(int po_pt) {
		this.po_pt = po_pt;
	}

	public Date getPo_date() {
		return po_date;
	}

	public void setPo_date(Date po_date) {
		this.po_date = po_date;
	}

	public int getPo_state() {
		return po_state;
	}

	public void setPo_state(int po_state) {
		this.po_state = po_state;
	}

	
	public int getPo_count() {
		return po_count;
	}

	public void setPo_count(int po_count) {
		this.po_count = po_count;
	}

	@Override
	public String toString() {
		return "PointDTO [po_no=" + po_no + ", po_title=" + po_title + ", po_txt=" + po_txt + ", po_img=" + po_img
				+ ", po_pt=" + po_pt + ", po_date=" + po_date + ", po_state=" + po_state + "]";
	}

	
}
