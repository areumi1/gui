package z_과제;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Jumun extends JFrame{
	JButton cash, card, reset;
    Jumun(){

    	setBounds(400,350,350, 150);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        initial();
        eventProc();
     
    }
    
    void initial() {
    	cash = new JButton("현금 결제");
    	card = new JButton("카드 결제");
    	reset = new JButton("메인메뉴로");
    	
    	setLayout(new BorderLayout());
    	add(new JLabel("결제수단을 선택해 주세요",JLabel.CENTER),BorderLayout.NORTH);
    	JPanel pan = new JPanel();
    	pan.setLayout(new GridLayout(1,3,10,100));
    	pan.add(cash);
    	pan.add(card);
    	pan.add(reset);
    	add(pan , BorderLayout.CENTER);
    }
    
    void eventProc() {
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 dispose();
            }
        }); // end of addActionListener
    }

}
