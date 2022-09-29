package z_과제;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Drink extends JPanel{
	//JFrame f = new JFrame("Drink");


	JButton []menu = new JButton[6];
	String[] ma = {"코카콜라","코카콜라 제로","스프라이트","아아","바닐라 라떼","우유"};
	JButton []price = new JButton[6];
	int []pr = {1500,1500,1500,1500,4200,1500};

	
	MainTest parent;
	
	
	public Drink (MainTest t) {
		parent = t;
		
		
		initial();
		addLayout();
		eventProc();

	}
	



	void initial() {
		for (int i=0; i<menu.length; i++) {				
			menu[i] = new JButton(ma[i]);
			
		}
		
		
		for (int i =0 ; i < price.length; i++) {
			price[i] = new JButton(String.valueOf(pr[i]));
		}
		
		menu[0] = new JButton("코카콜라  ₩1,500", new ImageIcon("src\\z_과제\\imgs\\콜라.png"));
		menu[1] = new JButton("코카콜라 제로  ₩1,500" ,new ImageIcon("src\\z_과제\\imgs\\콜라제로.png"));
		menu[2] = new JButton("스프라이트  ₩1,500",new ImageIcon("src\\z_과제\\imgs\\사이다.png"));
		menu[3] = new JButton("아이스 아메리카노  ₩1,500",new ImageIcon("src\\z_과제\\imgs\\아아.png"));
		menu[4] = new JButton("바닐라 라떼  ₩4,200",new ImageIcon("src\\z_과제\\imgs\\바닐라라떼.png"));
		menu[5] = new JButton("우유  ₩1,500 ",new ImageIcon("src\\z_과제\\imgs\\우유.png"));
		for (int i=0; i<menu.length; i++) {
		menu[i].setHorizontalTextPosition(JButton.CENTER);
		menu[i].setVerticalTextPosition(JButton.BOTTOM);
		}

		
	}
	void addLayout() {
		setLayout(new BorderLayout());
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(2,3));
		
		
		for (int i = 0; i<menu.length;i++) {
			center.add(menu[i]);
		}
		add(center, BorderLayout.CENTER);
		

	}
	
	void openDialog()
	{
		new zCoke(parent); 
	}
	void eventProc() {
		
		for(int i=0; i<menu.length; i++) { //배열로 선언했기 때문에 반드시 for문
			String num = Integer.toString(i);
			menu[i].addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) { 
		               parent.sumPrice += pr[Integer.parseInt(num)];
		               parent.orderhistory.append("\t"+ma[Integer.parseInt(num)] + " \t\t" + pr[Integer.parseInt(num)]+"\t\t\t"+ pr[Integer.parseInt(num)]+ "\n");
		               parent.tf.setText(String.valueOf(parent.sumPrice));
					}
		});
	        menu[0].addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	              openDialog();
	           } 
	        });// end of addActionListener

	}
	}

		
		

        
 //       bcokez.addActionListener(new ActionListener() {
//           public void actionPerformed(ActionEvent e) {                
//		new zCokez(); 
//            }
//        });// end of addActionListener
//        
//        biceAa.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                new zIceAa(); 
//            }
//        });// end of addActionListener
//        
//        bsprite.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                new zSprite(); 
//            }
//        });// end of addActionListener
//       
//        bVanilla.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                new zVanilla(); 
//            }
//        });// end of addActionListener
//       
//        bMilk.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                new zMilk(); 
//            }
//        });// end of addActionListener
				
		
	
	
	
	

}




	
