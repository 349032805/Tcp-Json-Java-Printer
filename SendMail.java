package Demo;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
	 public static void main(String[] args) throws MessagingException { 
	      
		    String sendUserName = "printer_exception@163.com"; 
		    String sendPassword = "eparty001"; 
		    
		    
		      
		    Properties properties = new Properties(); 
		    properties.setProperty("mail.smtp.auth", "true");//服务器需要认证 
		    properties.setProperty("mail.transport.protocol", "smtp");//声明发送邮件使用的端口 
		      
		    Session session = Session.getInstance(properties); 
		    session.setDebug(true);//同意在当前线程的控制台打印与服务器对话信息 
		      
		    Message message = new MimeMessage(session);//构建发送的信息 
		    message.setSubject("范骏自我介绍2");
		    message.setText("你好，我是fanjun！");//信息内容 
		    message.setFrom(new InternetAddress("printer_exception@163.com"));//发件人 
		      
		    Transport transport = session.getTransport(); 
		    transport.connect("smtp.163.com", 25, sendUserName, sendPassword);//连接发件人使用发件的服务器 
		    transport.sendMessage(message, new Address[]{new InternetAddress("349032805@qq.com")});//接受邮件 
		    transport.close(); 
		  } 
}
