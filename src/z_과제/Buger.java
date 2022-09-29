package z_과제;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Buger extends JPanel{
	

	MainTest mt;//메인테스트 출력
    JButton []menu = new JButton[6];
    String[] ma = {"불고기버거","빅맥","상하이버거","베이컨디럭스","슈비버거","1955버거"};
    JButton [] price = new JButton[6];
    int []pr = {2300,4900,4900,5800,5800,6000};
    
	public Buger(MainTest maintest) {
		
		mt = maintest;
		
		eventproc();
		addLayout();
		

	}// end of buger
	
	void eventproc() {
		for (int i=0; i<menu.length; i++) {				
			menu[i] = new JButton(ma[i]);
		}
		for (int i =0 ; i < price.length; i++) {
			price[i] = new JButton(String.valueOf(pr[i]));
		}
		
		menu[0] = new JButton("불고기버거  ₩2,300", new ImageIcon("src\\z_과제\\bu\\bul.png"));
		menu[1] = new JButton("빅맥  ₩4,900" ,new ImageIcon("src\\z_과제\\bu\\big.png"));
		menu[2] = new JButton("상하이버거  ₩4,900",new ImageIcon("src\\z_과제\\bu\\sang.png"));
		menu[3] = new JButton("베이컨디럭스버거  ₩5,800",new ImageIcon("src\\z_과제\\bu\\di.png"));
		menu[4] = new JButton("슈비버거  ₩5,800",new ImageIcon("src\\z_과제\\bu\\subi.png"));
		menu[5] = new JButton("1955버거  ₩6,000 ",new ImageIcon("src\\z_과제\\bu\\1955.png"));
		for (int i=0; i<menu.length; i++) {
		menu[i].setHorizontalTextPosition(JButton.CENTER);
		menu[i].setVerticalTextPosition(JButton.BOTTOM);
		}
		
		for(int i=0; i<menu.length; i++) { //배열로 선언했기 때문에 반드시 for문
			String num = Integer.toString(i);
			menu[i].addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) { 
		               mt.sumPrice += pr[Integer.parseInt(num)];
		               mt.orderhistory.append("\t"+ma[Integer.parseInt(num)] + " \t\t" + pr[Integer.parseInt(num)]+"\t\t\t"+ pr[Integer.parseInt(num)]+ "\n");
		               mt.tf.setText(String.valueOf(mt.sumPrice));
					}
		});
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
		

	} //end of addlayout
	
}
	
			





