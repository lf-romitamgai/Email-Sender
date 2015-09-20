import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ROMIT
 */
public class MainFrame extends JFrame {

    LoginPanel parentPanel;
    MessageForm childPanel;
    JFrame frames;

    public MainFrame() {
        parentPanel = new LoginPanel(this);

        add(parentPanel);
        pack();

        setTitle("Email Sender");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(500, 100);
        //setSize(400,400);
    }

}
