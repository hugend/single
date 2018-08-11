package mate.service;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import mate.dto.MateDTO;

public class MateMapMaker {

	public void jsonMaker(ArrayList<MateDTO> list){
		JSONObject myjson = new JSONObject();
		JSONArray maplist = new JSONArray();
		JSONObject mapinfo = new JSONObject();
		
		for (int i = 0; i < list.size(); i++) {
			mapinfo.put("latlng", list.get(i).getMt_lat());
			mapinfo.put("latlng", list.get(i).getMt_lng());
			
			
		}
		
		
	}
	
}
