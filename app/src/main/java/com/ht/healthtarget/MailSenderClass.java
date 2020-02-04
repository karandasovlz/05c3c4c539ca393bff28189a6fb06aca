package com.ht.healthtarget;

import android.util.Log;
import java.security.Security;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailSenderClass extends Authenticator {
    private final static String FILENAME2 = "2.txt";
    private String mailhost = "smtp.gmail.com";
    private String user;
    private String password;
    private Session session;
    private Multipart _multipart;

    static {
        Security.addProvider(new JSSEProvider());
    }

    public MailSenderClass(String user, String password) {
        this.user = "app82226@gmail.com";
        this.password = "a44ZpZuWTLfS";
        this._multipart = new MimeMultipart();
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host", this.mailhost);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.quitwait", "false");
        this.session = Session.getDefaultInstance(props, this);
    }

    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(this.user, this.password);
    }


    public synchronized void sendMail(String subject, String body, String sender, String recipients, String filename) throws Exception {
        try {

            MimeMessage message = new MimeMessage(this.session);
            message.setSender(new InternetAddress(sender));
            message.setSubject(subject);
            message.setRecipient(RecipientType.TO, new InternetAddress(recipients));

            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(body);
            this._multipart.addBodyPart(messageBodyPart);
            if (!filename.equalsIgnoreCase("")) {
                BodyPart attachBodyPart = new MimeBodyPart();
                DataSource source = new FileDataSource(filename);
                attachBodyPart.setDataHandler(new DataHandler(source));
                attachBodyPart.setFileName(filename);
                this._multipart.addBodyPart(attachBodyPart);
            }

            message.setContent(this._multipart);
            Transport.send(message);
        } catch (Exception e) {
            Log.e("sendMail", "Ошибка отправки функцией sendMail! "+ e.getMessage());
        }

    }
}
