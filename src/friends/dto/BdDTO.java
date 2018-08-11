package friends.dto;

public class BdDTO {
	
	private String me_id;
	private String bd_id;

	public BdDTO(){}

	public BdDTO(String me_id, String bd_id) {
		super();
		this.me_id = me_id;
		this.bd_id = bd_id;
	}

	public String getMe_id() {
		return me_id;
	}

	public void setMe_id(String me_id) {
		this.me_id = me_id;
	}

	public String getBd_id() {
		return bd_id;
	}

	public void setBd_id(String bd_id) {
		this.bd_id = bd_id;
	}

	@Override
	public String toString() {
		return "BdDTO [me_id=" + me_id + ", bd_id=" + bd_id + "]";
	}
	
	

}
