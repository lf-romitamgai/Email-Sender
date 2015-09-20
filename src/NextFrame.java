
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ROMIT
 */
public class NextFrame extends JFrame{
     MessageForm childPanel;

    public NextFrame(){
        childPanel = new MessageForm(this);

        add(childPanel);
        pack();

        setTitle("Email Sender");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocation(500, 100);
        //setSize(400,400);
    }
}
