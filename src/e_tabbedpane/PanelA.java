package e_tabbedpane;

import java.awt.Color;

import javax.swing.*;

public class PanelA extends JPanel{
	
	JLabel aLa = new JLabel("판데기 A");
	JButton aBtn = new JButton("A 버튼");
	
	public PanelA() {
		setBackground(new Color(255,0,0));	// 컴퓨터에서 칼라를 RGB (Red, Green, Blue) 라 부름  //최대치 255
		addLayout();
		eventProc();
	}

	void addLayout() {
		add(aLa);
		add(aBtn);
	}
	void eventProc() {
		
	}
}
