package z_과제;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class Drink extends JPanel{
	//JFrame f = new JFrame("Drink");
	JLabel la = new JLabel("맥카페 & 음료");
	JButton bcoke, bcokez, bsprite, biceAa, bVanilla, bMilk;
	
	public Drink () {
		initial();
		addLayout();

	}

	void initial() {
		
		bcoke = new JButton("Coca-Cola", new ImageIcon("src\\z_과제\\imgs\\콜라.png"));
		bcoke.setHorizontalTextPosition(JButton.CENTER);
		bcoke.setVerticalTextPosition(JButton.BOTTOM);
		bcokez = new JButton("Coca-Cola Zero" ,new ImageIcon("src\\z_과제\\imgs\\콜라제로.png"));
		bcokez.setHorizontalTextPosition(JButton.CENTER);
		bcokez.setVerticalTextPosition(JButton.BOTTOM);
		bsprite = new JButton("Sprite",new ImageIcon("src\\z_과제\\imgs\\사이다.png"));
		bsprite.setHorizontalTextPosition(JButton.CENTER);
		bsprite.setVerticalTextPosition(JButton.BOTTOM);
		biceAa = new JButton("IceAmericano",new ImageIcon("src\\z_과제\\imgs\\아아.png"));
		biceAa.setHorizontalTextPosition(JButton.CENTER);
		biceAa.setVerticalTextPosition(JButton.BOTTOM);
		bVanilla = new JButton("VanillaLatte",new ImageIcon("src\\z_과제\\imgs\\바닐라라떼.png"));
		bVanilla.setHorizontalTextPosition(JButton.CENTER);
		bVanilla.setVerticalTextPosition(JButton.BOTTOM);
		bMilk = new JButton("Milk",new ImageIcon("src\\z_과제\\imgs\\우유.png"));
		bMilk.setHorizontalTextPosition(JButton.CENTER);
		bMilk.setVerticalTextPosition(JButton.BOTTOM);
		
	}
	void addLayout() {
		setLayout(new BorderLayout());
		add(la, BorderLayout.NORTH);
			JPanel pan = new JPanel();
			pan.setLayout(new GridLayout(1, 3));
			pan.add(bcoke);
			pan.add(bcokez);
			pan.add(bsprite);
			pan.add(new JLabel("1200"));
			pan.add(new JLabel("1300"));
			pan.add(new JLabel("1400"));
			
			JPanel pan2 = new JPanel();
			pan.setLayout(new GridLayout(1, 3));
			pan2.add(biceAa);
			pan2.add(bVanilla);
			pan2.add(bMilk);
			pan.add(new JLabel("1200"));
			pan.add(new JLabel("1300"));
			pan.add(new JLabel("1400"));
		add(pan,BorderLayout.CENTER);
		

	}
	
	void eventProc() {
		
	}
	
	
	

}
	
