package dam;
import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class SendEmail
{
	
	String emailReceipients,emailBody;
	public void setEmailAndMsg(String toEmailAdd,String msg) {
		this.emailReceipients = toEmailAdd;
		this.emailBody = msg;
	}
		
	Session newSession = null;
	MimeMessage mimeMessage = null;
//	public static void main(String args[]) throws AddressException, MessagingException, IOException
//	{
//		SendEmail mail = new SendEmail();
//		mail.setupServerProperties();
//		mail.draftEmail();
//		mail.sendEmail();
//	}

	public void sendEmail() throws MessagingException {
		String fromUser = "doctorappointmentms@gmail.com";  //Enter sender email id
		String fromUserPassword = "ytsgewzoidsngava";  //Enter sender gmail password , this will be authenticated by gmail smtp server
		String emailHost = "smtp.gmail.com";
		Transport transport = newSession.getTransport("smtp");
		transport.connect(emailHost, fromUser, fromUserPassword);
		transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
		transport.close();
		System.out.println("Email successfully sent!!!");
	}

	public MimeMessage draftEmail() throws AddressException, MessagingException, IOException {
		String emailSubject = "Emergency Case";
		mimeMessage = new MimeMessage(newSession);
		
		
		mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailReceipients));
		
		mimeMessage.setSubject(emailSubject);
	
	   
      // CREATE MIMEMESSAGE 
	    // CREATE MESSAGE BODY PARTS 
	    // CREATE MESSAGE MULTIPART 
	    // ADD MESSAGE BODY PARTS ----> MULTIPART 
	    // FINALLY ADD MULTIPART TO MESSAGECONTENT i.e. mimeMessage object 
	    
		 MimeBodyPart msgpart = new MimeBodyPart();
		 msgpart.setText(emailBody);
//		 MimeBodyPart bodyPart = new MimeBodyPart();
//		 bodyPart.setContent(emailBody,"html/text");
		 MimeMultipart multiPart = new MimeMultipart("mixed");
		 multiPart.addBodyPart(msgpart);
//		 multiPart.addBodyPart(bodyPart);
		 mimeMessage.setContent(multiPart);
		 return mimeMessage;
	}

	public void setupServerProperties() {
		Properties properties = System.getProperties();
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		newSession = Session.getDefaultInstance(properties,null);
	}
	
}
