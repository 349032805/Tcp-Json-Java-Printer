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
	private static final String SERVER = "smtp.163.com";
	private static final String SEND_USER = "printer_exception@163.com";
	private static final String PASSWORD = "eparty001";
	
	private static final String TO_USER = "349032805@qq.com";

	public static void main(String[] args) throws MessagingException {

		Properties properties = new Properties();
		properties.setProperty("mail.smtp.auth", "true");// 服务器需要认证
		properties.setProperty("mail.transport.protocol", "smtp");// 声明发送邮件使用的端口

		Session session = Session.getInstance(properties);
		session.setDebug(true);// 同意在当前线程的控制台打印与服务器对话信息

		Message message = new MimeMessage(session);// 构建发送的信息
		message.setSubject("来自易趴Java打印控件的消息");
		message.setText("欢迎使用易趴打印服务!");// 信息内容
		message.setFrom(new InternetAddress(SEND_USER)); // 发件人

		Transport transport = session.getTransport();
		transport.connect(SERVER, 25, SEND_USER, PASSWORD); // 连接发件人使用发件的服务器
		transport.sendMessage(message, new Address[] { new InternetAddress(TO_USER) });// 接受邮件
		transport.close();
	}

	public static void sendMail(String content) {

		try {
			Properties properties = new Properties();
			properties.setProperty("mail.smtp.auth", "true");// 服务器需要认证
			properties.setProperty("mail.transport.protocol", "smtp");// 声明发送邮件使用的端口

			Session session = Session.getInstance(properties);
			session.setDebug(true);// 同意在当前线程的控制台打印与服务器对话信息

			Message message = new MimeMessage(session);// 构建发送的信息
			message.setSubject("来自易趴Java打印控件的消息");
			 message.setText(content);// 信息内容
//			message.setContent(content, "text/html;charset=utf-8");
			message.setFrom(new InternetAddress(SEND_USER)); // 发件人

			Transport transport = session.getTransport();
			transport.connect(SERVER, 25, SEND_USER, PASSWORD); // 连接发件人使用发件的服务器
			transport.sendMessage(message, new Address[] { new InternetAddress(TO_USER) });// 接受邮件
			transport.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
