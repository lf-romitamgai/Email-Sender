
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
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
public class MessageForm extends JPanel{
    private JLabel to;
    private JLabel cc;
    private JLabel subject;
    private JTextField textCc;
    private JTextField textTo;
    private JTextField textSubject;
    private JTextArea taBody;
    private JButton btnSend;
    private JButton btnLogOut;
    public MessageForm(NextFrame m){
        to = new JLabel("To:");
        cc = new JLabel("Cc:");
        subject = new JLabel("Subject:");
        
        textCc = new JTextField(15);
        textTo = new JTextField(15);
        textSubject = new JTextField(20);
        
        taBody = new JTextArea(18,35);
     
        taBody.setLineWrap (true);
        taBody.setWrapStyleWord (false);
        
        JScrollPane scrollPane = new JScrollPane( taBody );
        
        btnSend = new JButton("Send");
        btnLogOut = new JButton("Log Out");
        
        Dimension dim = getPreferredSize();
        dim.width =400;
        dim.height=400;
        setPreferredSize(dim);
        setLayout(new GridBagLayout());
        
        GridBagConstraints gc = new GridBagConstraints();
       
        gc.weightx = 1;
        gc.weighty = 0.1;
        
//first row
        gc.gridx = 0;
        gc.gridy = 0;
        gc.insets = new Insets(20,3,0,0);
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_START;
        
        add(to,gc);
        
        gc.gridx =0;
        gc.gridy=0;
        gc.insets = new Insets(20,50,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(textTo,gc);
        
////second row
//        gc.gridy = 1;
//        gc.gridx = 0;
//        gc.insets = new Insets(0,3,0,0);
//        gc.anchor = GridBagConstraints.LINE_START;
//        add(cc,gc);
//        
//        gc.gridy =1;
//        gc.gridx =0;
//        gc.insets = new Insets(0,50,0,0);
//        gc.anchor = GridBagConstraints.LINE_START;
//        add(textCc,gc);
        
 //third row
       
        gc.gridy=1;
        gc.gridx=0;
        gc.insets = new Insets(0,3,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(subject,gc);
        
        gc.gridy =1;
        gc.gridx =0;
        gc.insets = new Insets(0,50,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(textSubject,gc);
        
 //fourth row
       
        gc.gridy=2;
        gc.gridx=0;
        gc.insets = new Insets(8,10,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(scrollPane,gc);
    
        
//fifth row
        gc.weightx = 1;
        gc.weighty = 5.0;
        gc.gridy=3;
        gc.gridx=0;
        gc.insets = new Insets(2,0,0,0);
        gc.anchor = GridBagConstraints.LAST_LINE_END;
        add(btnSend,gc);
        
         gc.weightx = 1;
        gc.weighty = 1.0;
        gc.gridy=0;
        gc.gridx=0;
        gc.insets = new Insets(1,0,0,0);
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(btnLogOut,gc);
        
        btnSend.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
             
             EmailSender.sendIt(e,MessageForm.this);
            }
        });
        btnLogOut.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame n = new MainFrame();
                n.setVisible(true);
                m.dispose();
            }
        });
    }
    public String getTo(){
        return textTo.getText();
    }
    public String getCc(){
        return textCc.getText();
    }
    public String getSubject(){
        return textSubject.getText();
    }
    public String getBody(){
        return taBody.getText();
    }
    
}
