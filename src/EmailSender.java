
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ROMIT
 */
public class EmailSender {
    static String from;
    static Session session;
    static String to;
    static String Cc;
    static String subject;
    static String emailMessage;
    static boolean status =false;
    static JProgressBar prog;

    
    public static void sendIt(ActionEvent e,MessageForm m){
    to = m.getTo();
    Cc = m.getCc();
    subject = m.getSubject();
    session = EmailTaker.getSession();
   from = EmailTaker.getFrom();
     emailMessage = m.getBody();
   MimeMessage message = new MimeMessage(session);
    //MimeBodyPart attachment = new MimeBodyPart();
    MimeBodyPart messagePart = new MimeBodyPart();
   // FileDataSource fds = new FileDataSource( fileName );

    try {
        message.setRecipients( Message.RecipientType.TO, InternetAddress.parse( to ) );
        message.setFrom( new InternetAddress(from) );
        message.setSubject(subject);
        message.setText( emailMessage );
       // attachment.setDataHandler( new DataHandler( fds ) );
       // attachment.setFileName( fileName );
        messagePart.setText( emailMessage );
        Multipart hotmailMP = new MimeMultipart();
        //hotmailMP.addBodyPart(attachment);
        hotmailMP.addBodyPart( messagePart );
        message.setContent( hotmailMP );
        Transport transport = session.getTransport("smtp");
        
        transport.send(message);
       
        JOptionPane.showMessageDialog(null, "Email Sent");
    }  catch(Exception exc) {
        JOptionPane.showMessageDialog(null, "Enter Email and try again");
    }
        }


   
    
}
