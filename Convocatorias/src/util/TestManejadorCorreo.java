package util;

import javax.mail.NoSuchProviderException;

public class TestManejadorCorreo {

	public static void main(String[] args) {
		ManejadorCorreos manejadorCorreos = new ManejadorCorreos();

		try {
			manejadorCorreos.enviarCorreo("jogamaes@ucq.edu.mx", "Prueba de correo");
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (javax.mail.MessagingException e) {
			e.printStackTrace();
		}
		System.out.println("correo enviado");
	}
}
