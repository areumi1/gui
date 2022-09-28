package e_tabbedpane연습;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PanelA extends JPanel{
	
	JLabel aLa = new JLabel("판데기 A");
	JButton aBtn = new JButton("A 버튼");
	
	MainTest parent;
	
	public PanelA(MainTest mainTest) {
		
		parent = mainTest;
		setBackground(new Color(255,0,0));	// 컴퓨터에서 칼라를 RGB (Red, Green, Blue) 라 부름  //최대치 255
		addLayout();
		eventProc();
	}

	void addLayout() {
		add(aLa);
		add(aBtn);
	}
	void eventProc() {
		aBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.la.setText("안녕하세요");
			}
		});
		
		
	}
}
