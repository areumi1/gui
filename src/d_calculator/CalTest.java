package d_calculator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class CalTest {
	
	// 1. 멤버변수 선언
	
	JFrame f;
	JTextField tf;
	JButton[] bNum = new JButton[10] ; // 0~ 9 숫자 표현할 버튼
	JButton []bOp = new JButton[4];  // +,-,*,/ 연산자를 표현할 버튼들
	JButton bEqual;
	// 계산을 하기위해 필요한 변수
	int first, second;
	String op;
	
	String Op[] = {"+","-","*","/"} ;
	
	
	// 2. 객체 생성
	CalTest(){
		f = new JFrame("유치원 계산기");
		tf = new JTextField();
		bEqual = new JButton("=");
		for (int i=0; i<bNum.length; i++) {
			bNum[i] = new JButton(String.valueOf(i));
		}
		for (int i =0 ; i < bOp.length; i++) {
			bOp[i] = new JButton(Op[i]);
		}
		
		
		
	}// end of CalTest()
	
	// 3. 화면구성 및 화면 출력
	void addLayout() {
		f.setLayout(new BorderLayout());
		f.add(tf , BorderLayout.NORTH);
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(5,3));
		for (int i = 1; i<10;i++) {
			center.add(bNum[i]);
		}
		center.add(bOp[0]);
		center.add(bNum[0]);
		center.add(bEqual);
		center.add(bOp[1]);
		center.add(bOp[2]);
		center.add(bOp[3]);
		f.add(center, BorderLayout.CENTER);
		
		
		f.setBounds(500, 500, 500, 350);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	} // end of addLayout()

	// 4. 이벤트 처리
	void eventProc() {
		// 숫자 버튼이 눌렸을 때
		for(int i=0; i<bNum.length; i++) { //배열로 선언했기 때문에 반드시 for문
			bNum[i].addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) { 
					// 이벤트가 발생한 컴포넌트의 참조를 얻어옴
					JButton eBtn = (JButton)e.getSource();	//이번트가 발생되어 있는 버튼(객체)을 선택하면 그 버튼(객체)의 정보(주소)를 넘겨줌
					String su = eBtn.getText();
					tf.setText(su);
				
				}
			});
		}
		
		// 연산자 버튼이 눌렸을 때
		for(int i=0; i<bOp.length; i++) { // 위에 이미 방의 값을 입력했기때문에 출력만 하면됨
			bOp[i].addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) { 
					// 이벤트가 발생한 컴포넌트의 참조를 얻어옴
					JButton eVnt = (JButton)e.getSource();	//이번트가 발생된 애의 정보를 넘겨줌
					String un = eVnt.getText();
					tf.setText(un);
					//tf.setText(tf.getText()+evt.getText()); // 발생되어 입력된 숫자와 발생된 숫자 같이 입력
				
					
				}
			});
		}
		
		
		// = 버튼이 눌렸을때
		bEqual.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				JOptionPane.showMessageDialog(null, "계산");
			}
		});
	
		
	}// end of eventProc()

	public static void main(String[] args) {
		CalTest cal = new CalTest();
		cal.addLayout();
		cal.eventProc();

	}

}
