package local.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class GetTotalCount {
	public int getTotalCount(String areaCode){
		int totalCount = 0;
		String total = null;
		try {
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			String eventurl = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchFestival";
			//String key = "I8D75wKPpAZsS%2By%2FnPRx1lBAn758Wn1C4VkbUAmkbJr7YfuIXv77WgHujBFuM%2FCVZZK7IfCiRdWebdYCf6S7%2Fg%3D%3D";
			String key = "awXAezeT7c3zw%2BPOuXQjQSfoYr%2F9a51vEId%2BOw03z7fw6t9%2FI42xr3raGyNCXcW1LR6Msdmtb7zZFS5jMqydWQ%3D%3D";
			//String key= "Ptrpg9vwh%2BM%2FwcNhdxTTrDESZ72kDCPisr5pgUQ8IoGfQgeJn2Jr3oEsWLfgAOn8l8%2B1VT5%2FwfJ%2B%2BKeyUZ%2FgCA%3D%3D";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			Calendar today = new GregorianCalendar();
			String eventStartDate = sdf.format(today.getTime());
			
			String param ="";
			if(areaCode==null || areaCode.equals("null")){
				param = "&numOfRows=9&MobileOS=ETC&MobileApp=single&arrange=A&listYN=Y"
						+"&eventStartDate="+eventStartDate;
			}else{
				param = "&numOfRows=9&MobileOS=ETC&MobileApp=single&arrange=A&listYN=Y&areaCode="+areaCode
						+"&eventStartDate="+eventStartDate;
			}
			String realUrl = eventurl + "?ServiceKey=" + key + param;
			XmlPullParser pullparser = factory.newPullParser();
			URL url = new URL(realUrl);
			BufferedInputStream bis = new BufferedInputStream(url.openStream());
			pullparser.setInput(bis, "UTF-8");
			int eventType = pullparser.getEventType();
			String tagName = "";
			while (eventType != XmlPullParser.END_DOCUMENT) {
				if (eventType == XmlPullParser.START_TAG) {
					tagName = pullparser.getName();
					if(tagName.equals("totalCount")){
						eventType = pullparser.next();
						total = pullparser.getText();
					}
				} 
				eventType = pullparser.next();
			}
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		totalCount = Integer.parseInt(total);
		return totalCount;
	}
}
