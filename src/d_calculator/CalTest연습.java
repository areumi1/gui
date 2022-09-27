package d_calculator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class CalTest연습 {
	
	// 1. 멤버변수 선언
	JFrame f;
	JButton[] btn = new JButton[10];
	JButton[] bOp = new JButton[4];
	JButton bEqual;
	JTextField tf;
	
	String[] bop = {"+","-","*","/"};
	// 계산을 하기위해 필요한 변수
	int first;
	int second;
	String op;
	
	
	// 2. 객체 생성
	CalTest연습(){
		tf = new JTextField();
		f = new JFrame("초등학생 계산기");
		bEqual = new JButton("=");
		for (int i=0; i<btn.length; i++) {
			btn[i] = new JButton(String.valueOf(i));
		}
		for (int i=0; i<bOp.length; i++) {
			bOp[i] = new JButton(bop[i]);
		}

	}// end of CalTest()
	
	// 3. 화면구성 및 화면 출력
	void addLayout() {
		f.setBounds(500, 500, 450, 350);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		f.setLayout(new BorderLayout());
		f.add(tf, BorderLayout.NORTH);
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(5, 3));
		for(int i=1; i< 10; i++) {
			center.add(btn[i]);
		}
		center.add(bOp[0]);
		center.add(btn[0]);
		center.add(bEqual);
		center.add(bOp[1]);
		center.add(bOp[2]);
		center.add(bOp[3]);
		f.add(center, BorderLayout.CENTER);
		
		
	
	} // end of addLayout()

	// 4. 이벤트 처리
	void eventProc() {
		// 숫자 버튼이 눌렸을 때
		for(int i=0; i<btn.length; i++) {
			btn[i].addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) { 
					// 이벤트가 발생한 컴포넌트의 참조를 얻어옴
					JButton event = (JButton) e.getSource();
					String su = event.getText();
					tf.setText(tf.getText()+su);
				}	
			});
		}

		// 연산자 버튼이 눌렸을 때
		for(int i=0; i<bOp.length; i++) {
			bOp[i].addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) { 
					// 이벤트가 발생한 컴포넌트의 참조를 얻어옴
					JButton evn = (JButton) e.getSource();
					op = evn.getText();
					first = Integer.parseInt(tf.getText());
					tf.setText("");
				}
			});
		}

		// = 버튼이 눌렸을때
		bEqual.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				second = Integer.parseInt(tf.getText());
				switch(op) {
				case "+": first += second; break;
				case "-": first -= second; break;
				case "*": first *= second; break;
				case "/": first /= second;
				}
				tf.setText(String.valueOf(first));
			}
		});
		
	}// end of eventProc()

	public static void main(String[] args) {
		CalTest연습 cal = new CalTest연습();
		cal.addLayout();
		cal.eventProc();

	}

}
