package cylong.mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Java Mail 示例
 * @author cylong
 * @version 2016年6月20日 下午7:30:18
 */
public class Mail {

	public static void main(String[] args) {
		String from = "cylong1016@163.com";
		String password = "lsy940815";
		String address = "131250129@smail.nju.edu.cn";
		String subject = "我是帅气的云龙";
		String content = "喜欢可爱的思思姐";

		Mail mail = new Mail();
		mail.sendMail(from, password, address, subject, content);
	}

	/**
	 * @param from 发件人邮箱
	 * @param password 发件人密码【如果是网易邮箱这个是授权码
	 * @param address 收件人邮箱
	 * @param subject 邮件主题
	 * @param content 邮件内容
	 * @author cylong
	 * @version 2016年6月20日 下午7:23:39
	 */
	public void sendMail(String from, String password, String address, String subject, String content) {

		Properties props = new Properties();
		// 开启 debug 调试  
		props.setProperty("mail.debug", "true");
		// 邮件发送服务器需要身份验证  
		props.setProperty("mail.smtp.auth", "true");
		// 设置邮件发送服务器主机名  
		// 去你的邮件设置里可以看到 SMTP/POP3/IMAP 服务器地址。我这里用的是网易163邮箱
		props.setProperty("mail.host", "smtp.163.com");
		// 邮件发送协议 SMTP【邮件接收协议是 POP3/IMAP
		props.setProperty("mail.transport.protocol", "smtp");

		// 通过 Properties 生成 Session 服务，并验证发件人身份
		Session session = Session.getInstance(props, new Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});

		// 通过 Session 创建邮件对象，包括邮件标题、发件人、收件人、邮件内容等等
		Message msg = new MimeMessage(session);
		try {
			// 设置邮件主题
			msg.setSubject(subject);
			// 设置邮件内容  
			msg.setText(content);
			// 设置发件人 
			msg.setFrom(new InternetAddress(from));
			// 设置收件人
			msg.setRecipient(RecipientType.TO, new InternetAddress(address));
			Transport.send(msg);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
