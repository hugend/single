package mate.dto;

public class MateDTO {
	private int mt_no;
	private String mt_title;
	private String mt_txt;
	private String mt_date;
	private int mt_hits;
	private String mt_file;
	private String mt_map;
	private String mt_lat;
	private String mt_lng;
	private String mt_ctg;
	private int mt_cnt;
	private String me_id;
	private String mt_img;
	private String mt_particpant;
	
	

	public MateDTO(String mt_title, String mt_txt, String mt_file, String mt_map, String mt_lat, String mt_lng, String mt_ctg, int mt_cnt,
			String me_id, String mt_img) {
		this.mt_title = mt_title;
		this.mt_txt = mt_txt;
		this.mt_file = mt_file;
		this.mt_map = mt_map;
		this.mt_lat = mt_lat;
		this.mt_lng = mt_lng;
		this.mt_ctg = mt_ctg;
		this.mt_cnt = mt_cnt;
		this.me_id = me_id;
		this.mt_img = mt_img;
	}
	public MateDTO(int mt_no, String mt_title, String mt_txt, String mt_date, int mt_hits, String mt_file,
			String mt_map, String mt_lat, String mt_lng, String mt_ctg, int mt_cnt, String me_id, String mt_img,
			String mt_particpant) {
		super();
		this.mt_no = mt_no;
		this.mt_title = mt_title;
		this.mt_txt = mt_txt;
		this.mt_date = mt_date;
		this.mt_hits = mt_hits;
		this.mt_file = mt_file;
		this.mt_map = mt_map;
		this.mt_lat = mt_lat;
		this.mt_lng = mt_lng;
		this.mt_ctg = mt_ctg;
		this.mt_cnt = mt_cnt;
		this.me_id = me_id;
		this.mt_img = mt_img;
		this.mt_particpant = mt_particpant;
	}
	public MateDTO() {
	}
	public String getMt_lat() {
		return mt_lat;
	}
	public void setMt_lat(String mt_lat) {
		this.mt_lat = mt_lat;
	}
	public String getMt_lng() {
		return mt_lng;
	}
	public void setMt_lng(String mt_lng) {
		this.mt_lng = mt_lng;
	}
	
	public int getMt_no() {
		return mt_no;
	}
	public void setMt_no(int mt_no) {
		this.mt_no = mt_no;
	}
	public String getMt_title() {
		return mt_title;
	}
	public void setMt_title(String mt_title) {
		this.mt_title = mt_title;
	}
	public String getMt_txt() {
		return mt_txt;
	}
	public void setMt_txt(String mt_txt) {
		this.mt_txt = mt_txt;
	}
	public String getMt_date() {
		return mt_date;
	}
	public void setMt_date(String mt_date) {
		this.mt_date = mt_date;
	}
	public int getMt_hits() {
		return mt_hits;
	}
	public void setMt_hits(int mt_hits) {
		this.mt_hits = mt_hits;
	}
	public String getMt_file() {
		return mt_file;
	}
	public void setMt_file(String mt_file) {
		this.mt_file = mt_file;
	}
	public String getMt_map() {
		return mt_map;
	}
	public void setMt_map(String mt_map) {
		this.mt_map = mt_map;
	}
	public String getMt_ctg() {
		return mt_ctg;
	}
	public void setMt_ctg(String mt_ctg) {
		this.mt_ctg = mt_ctg;
	}
	public int getMt_cnt() {
		return mt_cnt;
	}
	public void setMt_cnt(int mt_cnt) {
		this.mt_cnt = mt_cnt;
	}
	public String getMe_id() {
		return me_id;
	}
	public void setMe_id(String me_id) {
		this.me_id = me_id;
	}
	public String getMt_img() {
		return mt_img;
	}
	public void setMt_img(String mt_img) {
		this.mt_img = mt_img;
	}
	public String getMt_particpant() {
		return mt_particpant;
	}
	public void setMt_particpant(String mt_particpant) {
		this.mt_particpant = mt_particpant;
	}


}
