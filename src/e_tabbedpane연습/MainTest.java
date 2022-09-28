package e_tabbedpane연습;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainTest {
	
	JFrame f;
	JButton btn;
	JLabel la;
	
	PanelA panelA;		// 클래스 변수 선언
	PanelB panelB;
	PanelC panelC;
	
	MainTest(){
		f = new JFrame("나의 창");
		btn = new JButton("확인");
		la = new JLabel("데이터");
		
		panelA = new PanelA(this);  // PanelA클래스에서 MainTest의 변수를 사용하기위해서 주소값이 필요 /this로 MainTest 주소값 첨부
		panelB = new PanelB();	// 객체생성
		panelC = new PanelC();
	}
	
	void addLayout() {
		// 프레임의 기본 레이아웃은 BorderLayout
		
		f.setLayout(new BorderLayout());
		f.add(btn, BorderLayout.EAST);
		f.add(la, BorderLayout.SOUTH);
		
		// 
		JTabbedPane tab = new JTabbedPane(); // JTabbedPane 으로 묶기
		tab.addTab("메인", panelA );	// 처음 입력한거 순서대로 출력됨.
		tab.addTab("서브" , panelB);
		tab.addTab("기타", panelC);
		
		f.add(tab, BorderLayout.CENTER);
		
		f.setBounds(100, 100, 500, 400);
		f.setVisible(true);	// 보열줄지 지정
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	void enventProc() {
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelA.aLa.setText("Welcome");
				
			}
		});
	}

	public static void main(String[] args) {
		
		MainTest test = new MainTest();
		test.addLayout();
		test.enventProc();

	}

}
