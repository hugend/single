package local.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import local.dto.EventDTO;

public class GetEventList {
	public ArrayList<EventDTO> getEventList(String areaCode){
		ArrayList<EventDTO> eventlist = new ArrayList<EventDTO>();
		GetTotalCount tc = new GetTotalCount();
		int totalCount = tc.getTotalCount(areaCode);
				
		try {
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			String eventurl = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchFestival";
			//String key = "I8D75wKPpAZsS%2By%2FnPRx1lBAn758Wn1C4VkbUAmkbJr7YfuIXv77WgHujBFuM%2FCVZZK7IfCiRdWebdYCf6S7%2Fg%3D%3D";
			//String key = "awXAezeT7c3zw%2BPOuXQjQSfoYr%2F9a51vEId%2BOw03z7fw6t9%2FI42xr3raGyNCXcW1LR6Msdmtb7zZFS5jMqydWQ%3D%3D";
			String key= "Ptrpg9vwh%2BM%2FwcNhdxTTrDESZ72kDCPisr5pgUQ8IoGfQgeJn2Jr3oEsWLfgAOn8l8%2B1VT5%2FwfJ%2B%2BKeyUZ%2FgCA%3D%3D";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			Calendar today = new GregorianCalendar();
			String eventStartDate = sdf.format(today.getTime());
			int page = 0;
			if(totalCount%9==0){
				page = totalCount/9;
			}else{
				page = totalCount/9 + 1;
			}
			for (int i = 1; i <= page; i++) {
				// 페이지수
				int pageNo = i;
				// 시작일 처리
				String param ="";
				if(areaCode==null || areaCode.equals("null")){
					param = "&numOfRows=9&MobileOS=ETC&MobileApp=single&arrange=A&listYN=Y&pageNo="+pageNo
							+"&eventStartDate="+eventStartDate;
				}else{
					param = "&numOfRows=9&MobileOS=ETC&MobileApp=single&arrange=A&listYN=Y&areaCode="+areaCode+"&pageNo="+pageNo
							+"&eventStartDate="+eventStartDate;
				}
				String realUrl = eventurl + "?ServiceKey=" + key + param;
				XmlPullParser pullparser = factory.newPullParser();
				URL url = new URL(realUrl);
				BufferedInputStream bis = new BufferedInputStream(url.openStream());
				pullparser.setInput(bis, "UTF-8");
				int eventType = pullparser.getEventType();
				String tagName = "";
				String text = "";
				EventDTO event = null;
				while (eventType != XmlPullParser.END_DOCUMENT) {
					if (eventType == XmlPullParser.START_TAG) {
						tagName = pullparser.getName();
						if(tagName.equals("item")){
							event = new EventDTO();
						}
					} else if (eventType == XmlPullParser.TEXT) {
						if (!pullparser.getText().contains("\n")) {
							if (tagName.equals("addr1")) {
								text = pullparser.getText();
								event.setAddr1(text);
							} else if (tagName.equals("areacode")) {
								text = pullparser.getText();
								event.setAreacode(text);
							} else if (tagName.equals("contentid")) {
								text = pullparser.getText();
								event.setContentid(text);
							} else if (tagName.equals("eventenddate")) {
								text = pullparser.getText();
								event.setEventenddate(text);
							} else if (tagName.equals("eventstartdate")) {
								text = pullparser.getText();
								event.setEventstartdate(text);
							} else if (tagName.equals("firstimage")) {
								text = pullparser.getText();
								event.setFirstimage(text);
							} else if (tagName.equals("mapx")) {
								text = pullparser.getText();
								event.setMapx(text);
							} else if (tagName.equals("mapy")) {
								text = pullparser.getText();
								event.setMapy(text);
							} else if (tagName.equals("readcount")) {
								text = pullparser.getText();
								event.setReadcount(text);
							}else if (tagName.equals("title")) {
								text = pullparser.getText();
								event.setTitle(text);
							}
						}
					} else if (eventType == XmlPullParser.END_TAG) {
						tagName = pullparser.getName();
						if (tagName.equals("item")) {
							if(event.getFirstimage()!=null){
								eventlist.add(event);
							}
						}
					}
					eventType = pullparser.next();
				}
			}
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return eventlist;
	}
}
