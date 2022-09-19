package in.satish.custom;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {

	@Autowired
	private JavaMailSender mailSender;
	
	public boolean sentEmail(String toEmail, String subject, String body) {
		boolean isMailSent = false;

		try {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
	
		helper.setTo(toEmail);
		helper.setSubject(subject);
		helper.setText(body, true);
		mailSender.send(message);
		System.out.println("Mail Send...");
		isMailSent = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return isMailSent;
	}
}
