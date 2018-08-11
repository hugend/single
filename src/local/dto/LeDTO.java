package local.dto;

import java.sql.Date;

public class LeDTO {
	private String le_title;
	private Date le_start;
	private Date le_end;
	private String le_addr1;
	private String le_addr2;
	private String le_cid;
	private String le_img;
	
	public LeDTO() {}
	public LeDTO(String le_title, Date le_start, Date le_end, String le_addr1, String le_addr2, String le_cid,
			String le_img) {
		super();
		this.le_title = le_title;
		this.le_start = le_start;
		this.le_end = le_end;
		this.le_addr1 = le_addr1;
		this.le_addr2 = le_addr2;
		this.le_cid = le_cid;
		this.le_img = le_img;
	}
	@Override
	public String toString() {
		return "LeDTO [le_title=" + le_title + ", le_start=" + le_start + ", le_end=" + le_end + ", le_addr1="
				+ le_addr1 + ", le_addr2=" + le_addr2 + ", le_cid=" + le_cid + ", le_img=" + le_img + "]";
	}
	public String getLe_title() {
		return le_title;
	}
	public void setLe_title(String le_title) {
		this.le_title = le_title;
	}
	public Date getLe_start() {
		return le_start;
	}
	public void setLe_start(Date le_start) {
		this.le_start = le_start;
	}
	public Date getLe_end() {
		return le_end;
	}
	public void setLe_end(Date le_end) {
		this.le_end = le_end;
	}
	public String getLe_addr1() {
		return le_addr1;
	}
	public void setLe_addr1(String le_addr1) {
		this.le_addr1 = le_addr1;
	}
	public String getLe_addr2() {
		return le_addr2;
	}
	public void setLe_addr2(String le_addr2) {
		this.le_addr2 = le_addr2;
	}
	public String getLe_cid() {
		return le_cid;
	}
	public void setLe_cid(String le_cid) {
		this.le_cid = le_cid;
	}
	public String getLe_img() {
		return le_img;
	}
	public void setLe_img(String le_img) {
		this.le_img = le_img;
	}
	
}
