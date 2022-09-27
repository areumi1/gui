package b_info2;

import java.awt.*;
import javax.swing.*;

public class InfoView {
	
	//1. 멤버변수 선언
	JFrame f;
	JTextField tfname, tfId, tfTel, tfGender, tfAge, tfHome;
	JTextArea ta;
	JButton bAdd, bShow, bSearch, bDelete, bCancel, bExit;

	
	//2. 멤버변수 객체생성
	
	InfoView(){
		f = new JFrame("DBTest");
		
		ta = new JTextArea(40,20);
		
		tfname = new JTextField(15);
		tfId = new JTextField(15);
		tfTel = new JTextField(15);
		tfGender = new JTextField(15);
		tfAge = new JTextField(15);
		tfHome = new JTextField(15);
		
		bAdd = new JButton("Add");
		bShow = new JButton("Show");
		bSearch = new JButton("Search");
		bDelete = new JButton("Delete");
		bCancel = new JButton("Cancel");
		bExit = new JButton("Exit");
		
	}
	

	
	//3. 화면구성하고 출력
	/*
	 *  전체 프레임 BorderLayout 지정 
	 *  	- WEST 	: JPanel 붙이기 ( GridLayout(6,2))
	 *  	- CENTER : TextArea
	 *  	- SOUTH : JPanel 붙이기 ( GridLayout(1,6))
	 */
	void addLayout() {
		f.setLayout(new BorderLayout());
		JPanel west = new JPanel();
		west.setLayout(new GridLayout(6,2));
		west.add(new JLabel("Name", JLabel.CENTER));
		west.add(tfname);
		west.add(new JLabel("ID", JLabel.CENTER));
		west.add(tfId);
		west.add(new JLabel("Tel", JLabel.CENTER));
		west.add(tfTel);
		west.add(new JLabel("Sex", JLabel.CENTER));
		west.add(tfGender);
		west.add(new JLabel("Age", JLabel.CENTER));
		west.add(tfAge);
		west.add(new JLabel("Home", JLabel.CENTER));
		west.add(tfHome);
		f.add(west , BorderLayout.WEST);
		f.add(ta, BorderLayout.CENTER);
		JPanel south = new JPanel();
		south.setLayout(new GridLayout(1,6));
		south.add(bAdd);
		south.add(bShow);
		south.add(bSearch);
		south.add(bDelete);
		south.add(bCancel);
		south.add(bExit);
		f.add(south, BorderLayout.SOUTH);
		
		f.setBounds(500, 1000, 900, 400);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {

		InfoView info = new InfoView();
		info.addLayout();

	}

}
