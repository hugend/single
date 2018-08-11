package mate.service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import mate.dto.MateDTO;

public class MateMapMaker {

	@SuppressWarnings("unchecked")
	public void jsonMaker(ArrayList<MateDTO> list) throws Exception{
		int size = list.size();
		
		JSONObject myjson = new JSONObject();
		JSONArray pos = new JSONArray();
		
		for (int i = 0; i < size; i++) {
			JSONObject poslist = new JSONObject();
			poslist.put("title", list.get(i).getMt_title());
			poslist.put("map", list.get(i).getMt_map());
			poslist.put("lat", list.get(i).getMt_lat());
			poslist.put("lng", list.get(i).getMt_lng());
			pos.add(poslist);
			
		}
		myjson.put("positions", pos);
		System.out.println(myjson.toJSONString());
		FileWriter fw = new FileWriter("/single/common/json/jsontest.json");
		fw.write(myjson.toJSONString());
		fw.flush();
		fw.close();
		
	}
	
}
