package friends.controller;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.Session;

public class EmailAlarm{
	public void connectEmail(String email,String sender){
		String to1=email; // 인증위해 사용자가 입력한 이메일주소
		String host="smtp.gmail.com"; // smtp 서버
		String subject="single 쪽지알림 "; // 보내는 제목 설정
		String fromName="single관리자"; // 보내는 이름 설정
		String from="singlemgr1@gmail.com"; // 보내는 사람(구글계정)
		String content=sender+"님으로 부터 새로운 쪽지가 도착했습니다."; // 이메일 내용 설정
		
        // SMTP 이용하기 위해 설정해주는 설정값들
		try{
		Properties props=new Properties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", host);
		props.setProperty
                       ("mail.smtp.socketFactory.class",
                        "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.port","465");
		props.put("mail.smtp.user",from);
		props.put("mail.smtp.auth","true");
		
		Session mailSession 
           = Session.getInstance(props,new javax.mail.Authenticator(){
			    protected PasswordAuthentication getPasswordAuthentication(){
				    return new PasswordAuthentication
                                        ("singlemgr1@gmail.com","manager1!"); // gmail계정
			}
		});
		
		Message msg = new MimeMessage(mailSession);
		InternetAddress []address1 = {new InternetAddress(to1)};
		msg.setFrom(new InternetAddress
                      (from, MimeUtility.encodeText(fromName,"EUC-KR","B")));
		msg.setRecipients(Message.RecipientType.TO, address1); // 받는사람 설정
		msg.setSubject(subject); // 제목설정
		msg.setSentDate(new java.util.Date()); // 보내는 날짜 설정
		msg.setContent(content,"text/html; charset=EUC-KR"); // 내용설정
		
		Transport.send(msg); // 메일보내기
		}catch(MessagingException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

