import java.awt.event.ActionEvent;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ROMIT
 */
public class EmailTaker {

    

   

   
   static String username;
   static char[] passwor;
   static String password;
    
    static Session session;
    static int check = 0;

    public static void creat(ActionEvent e, LoginPanel lp) throws AddressException, MessagingException {
    
        username = lp.getEmail();
        passwor = lp.getPass();
        password = new String(passwor);
        
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.live.com");
        props.put("mail.smtp.user", username);
        // Use TLS
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.password", password);

        session = Session.getDefaultInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                if (username == null | password == null) {
                    System.out.println("username or password incorrect");
                    JOptionPane.showMessageDialog(null, "Username/Password blank");
                    check=1;
                }
                
                
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            Transport trans = session.getTransport("smtp");
            trans.connect("smtp.live.com", 25, username, password);
        } catch (Exception as) {
            check = 1;
            JOptionPane.showMessageDialog(null, "Invalid Usename/Password");
            
        }
       

    }
    public static int checkval(ActionEvent e){
      
        return check++;
    }
   public static String getFrom(){
       return username;
   }
   public static Session getSession(){
       return session;
   }
}
