import java.awt.EventQueue;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ROMIT
 */
public class MainClass {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                MainFrame frame = new MainFrame();
                frame.setVisible(true);

            }
        });
    }

}
