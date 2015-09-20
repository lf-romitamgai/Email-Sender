import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.mail.MessagingException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ROMIT
 */
public class LoginPanel extends JPanel {

    MainFrame frame;
    JFrame fra;
    private JLabel labEmail;
    private JLabel labPassword;
    private JTextField textEmail;
    private JPasswordField textPass;
    private JButton buttonLogin;

    static int b = 0;

    public LoginPanel(MainFrame a) {
        labEmail = new JLabel("Email:");
        labPassword = new JLabel("Password:");
        textEmail = new JTextField(10);
        textPass = new JPasswordField(10);
        buttonLogin = new JButton("Log In");

        Dimension dim = getPreferredSize();
        dim.width = 250;
        dim.height = 150;
        setPreferredSize(dim);
        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        gc.weightx = 1;
        gc.weighty = 0.1;

//first row
        gc.gridx = 0;
        gc.gridy = 0;
        gc.insets = new Insets(20, 0, 0, 10);
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;

        add(labEmail, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.insets = new Insets(20, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(textEmail, gc);

//second row
        gc.gridy = 1;
        gc.gridx = 0;
        gc.insets = new Insets(0, 0, 0, 10);
        gc.anchor = GridBagConstraints.LINE_END;
        add(labPassword, gc);

        gc.gridy = 1;
        gc.gridx = 1;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(textPass, gc);

//third row
        gc.weightx = 1;
        gc.weighty = 5.0;
        gc.gridy = 2;
        gc.gridx = 1;
        gc.insets = new Insets(10, 0, 0, 0);
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(buttonLogin, gc);

        buttonLogin.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    a.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

                    EmailTaker.creat(e, LoginPanel.this);

                    b = EmailTaker.checkval(e);
                    a.setCursor(Cursor.getDefaultCursor());
                    if (b != 1) {

                        NextFrame frm = new NextFrame();
                        a.dispose();
                    }
                } catch (MessagingException ex) {
                    System.out.println("Error");
                }
            }
        });
    }

    public String getEmail() {
        return textEmail.getText();
    }

    public char[] getPass() {
        return textPass.getPassword();
    }

}
