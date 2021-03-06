package util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ManejadorCorreos {

	private Properties props;//datos del correo que enviara el mensaje
	private Session sesion;
	private Transport t;//Objeto donde se abren y cierran las conexiones
	private MimeMessage msg;//Aqui componemos el mensaje
	
	
	public ManejadorCorreos(){
		props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
	}
	
	public void enviarCorreo(String destino, String asunto, String mensaje) throws MessagingException, NoSuchProviderException{
		sesion = Session.getDefaultInstance(props, new javax.mail.Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication("pruebasjosegama@gmail.com","contrasenia");
			}
		});
		
		msg = new MimeMessage(sesion);
		msg.setFrom(new InternetAddress("pruebasjosegama@gmail.com"));
		msg.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));
		msg.setSubject(asunto);
		msg.setText(mensaje, "UTF-8","html");
		t.send(msg, msg.getAllRecipients());
		t.close();
	}
	
}
