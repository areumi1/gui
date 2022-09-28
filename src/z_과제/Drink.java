package z_과제;

import java.awt.BorderLayout;
import java.awt.Dimension;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Drink extends JPanel{
	//JFrame f = new JFrame("Drink");
	JLabel la = new JLabel("맥카페 & 음료");
	JButton bcoke, bcokez, bsprite, biceAa, bVanilla, bMilk;
	
	public Drink () {
		initial();
		addLayout();
		eventProc();


	}
	



	void initial() {
		
		bcoke = new JButton("Coca-Cola  ₩1,500", new ImageIcon("src\\z_과제\\imgs\\콜라.png"));
		bcoke.setHorizontalTextPosition(JButton.CENTER);
		bcoke.setVerticalTextPosition(JButton.BOTTOM);
		bcokez = new JButton("Coca-Cola Zero  ₩1,500" ,new ImageIcon("src\\z_과제\\imgs\\콜라제로.png"));
		bcokez.setHorizontalTextPosition(JButton.CENTER);
		bcokez.setVerticalTextPosition(JButton.BOTTOM);
		bsprite = new JButton("Sprite  ₩1,500",new ImageIcon("src\\z_과제\\imgs\\사이다.png"));
		bsprite.setHorizontalTextPosition(JButton.CENTER);
		bsprite.setVerticalTextPosition(JButton.BOTTOM);
		biceAa = new JButton("IceAmericano  ₩1,500",new ImageIcon("src\\z_과제\\imgs\\아아.png"));
		biceAa.setHorizontalTextPosition(JButton.CENTER);
		biceAa.setVerticalTextPosition(JButton.BOTTOM);
		bVanilla = new JButton("VanillaLatte  ₩4,200",new ImageIcon("src\\z_과제\\imgs\\바닐라라떼.png"));
		bVanilla.setHorizontalTextPosition(JButton.CENTER);
		bVanilla.setVerticalTextPosition(JButton.BOTTOM);
		bMilk = new JButton("Milk , ₩1,500 ",new ImageIcon("src\\z_과제\\imgs\\우유.png"));
		bMilk.setHorizontalTextPosition(JButton.CENTER);
		bMilk.setVerticalTextPosition(JButton.BOTTOM);
		
	}
	void addLayout() {
		setLayout(new BorderLayout());
		add(la, BorderLayout.NORTH);
			JPanel pan = new JPanel();
			pan.setLayout(new GridLayout(2, 3,10,15));
			pan.add(bcoke);
			pan.add(bcokez);
			pan.add(bsprite);
			pan.add(biceAa);
			pan.add(bVanilla);
			pan.add(bMilk);
		add(pan,BorderLayout.CENTER);
		

	}
	
	void eventProc() {
        bcoke.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new zCoke(); 
            }
        });// end of addActionListener
        
        bcokez.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new zCokez(); 
            }
        });// end of addActionListener
        
        biceAa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new zIceAa(); 
            }
        });// end of addActionListener
        
        bsprite.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new zSprite(); 
            }
        });// end of addActionListener
       
        bVanilla.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new zVanilla(); 
            }
        });// end of addActionListener
       
        bMilk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new zMilk(); 
            }
        });// end of addActionListener
				
		
	}
	
	
	

}




	
