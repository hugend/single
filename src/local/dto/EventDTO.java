package local.dto;

public class EventDTO {
	private String addr1;	//주소
	private String areacode;	//지역코드
	private String contentid;	//콘텐츠아이디
	private String eventenddate;	//종료일
	private String eventstartdate;	//시작인
	private String firstimage;	//이미지
	private String mapx;
	private String mapy;	
	private String readcount; //조회수
	private String title;	//타이틀
	
	public EventDTO() {

	}
	public EventDTO(String addr1, String areacode, String contentid, String eventenddate, String eventstartdate,
			String firstimage, String mapx, String mapy, String readcount, String title) {
		super();
		this.addr1 = addr1;
		this.areacode = areacode;
		this.contentid = contentid;
		this.eventenddate = eventenddate;
		this.eventstartdate = eventstartdate;
		this.firstimage = firstimage;
		this.mapx = mapx;
		this.mapy = mapy;
		this.readcount = readcount;
		this.title = title;
	}
	@Override
	public String toString() {
		return "LocalDTO [addr1=" + addr1 + ", areacode=" + areacode + ", contentid=" + contentid + ", eventenddate="
				+ eventenddate + ", eventstartdate=" + eventstartdate + ", firstimage=" + firstimage + 
				", mapx=" + mapx + ", mapy=" + mapy + ", readcount=" + readcount + ", title=" + title + "]";
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAreacode() {
		return areacode;
	}
	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}
	public String getContentid() {
		return contentid;
	}
	public void setContentid(String contentid) {
		this.contentid = contentid;
	}
	public String getEventenddate() {
		return eventenddate;
	}
	public void setEventenddate(String eventenddate) {
		this.eventenddate = eventenddate;
	}
	public String getEventstartdate() {
		return eventstartdate;
	}
	public void setEventstartdate(String eventstartdate) {
		this.eventstartdate = eventstartdate;
	}
	public String getFirstimage() {
		return firstimage;
	}
	public void setFirstimage(String firstimage) {
		this.firstimage = firstimage;
	}
	public String getMapx() {
		return mapx;
	}
	public void setMapx(String mapx) {
		this.mapx = mapx;
	}
	public String getMapy() {
		return mapy;
	}
	public void setMapy(String mapy) {
		this.mapy = mapy;
	}
	public String getReadcount() {
		return readcount;
	}
	public void setReadcount(String readcount) {
		this.readcount = readcount;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
