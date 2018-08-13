package local.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import local.dto.LocalDTO;
//지역정보 
public class GetLocalList {
	public ArrayList<LocalDTO> getLocalList(){
		ArrayList<LocalDTO> locallist = new ArrayList<LocalDTO>();
		try {
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			String eventurl = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaCode";
			//String key = "I8D75wKPpAZsS%2By%2FnPRx1lBAn758Wn1C4VkbUAmkbJr7YfuIXv77WgHujBFuM%2FCVZZK7IfCiRdWebdYCf6S7%2Fg%3D%3D";
			String key = "awXAezeT7c3zw%2BPOuXQjQSfoYr%2F9a51vEId%2BOw03z7fw6t9%2FI42xr3raGyNCXcW1LR6Msdmtb7zZFS5jMqydWQ%3D%3D";
			
			for (int i = 1; i <= 2; i++) {
				// 페이지수
				int pageNo = i;
				String param = "&MobileOS=ETC&pageNo="+pageNo+"&MobileApp=AppTest";
				String realUrl = eventurl + "?ServiceKey=" + key + param;
				XmlPullParser pullparser = factory.newPullParser();
				URL url = new URL(realUrl);
				BufferedInputStream bis = new BufferedInputStream(url.openStream());
				pullparser.setInput(bis, "UTF-8");
				int eventType = pullparser.getEventType();
				String tagName = "";
				String text = "";
				LocalDTO local = null;
				while (eventType != XmlPullParser.END_DOCUMENT) {
					if (eventType == XmlPullParser.START_TAG) {
						tagName = pullparser.getName();
						if(tagName.equals("item")){
							local = new LocalDTO();
						}
					} else if (eventType == XmlPullParser.TEXT) {
						if (!pullparser.getText().contains("\n")) {
							if (tagName.equals("code")) {
								text = pullparser.getText();
								local.setCode(text);
							} else if (tagName.equals("name")) {
								text = pullparser.getText();
								local.setName(text);
							}
						}
					} else if (eventType == XmlPullParser.END_TAG) {
						tagName = pullparser.getName();
						if (tagName.equals("item")) {
							locallist.add(local);
						}
					}
					eventType = pullparser.next();
				}
			}
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return locallist;
	}
}
