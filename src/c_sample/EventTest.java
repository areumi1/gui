package c_sample;

import java.awt.*; // * 모든것// 클래스만 import
import java.awt.event.*;	// 폴더는 포함되지않음 따로 import
import javax.swing.*;


/*
 * 화면(JFrame)에 '확인' 버튼 하나 출력
 *  
 */

public class EventTest {
	JFrame f ;
	JButton jbt;
	
	EventTest(){
		f = new JFrame();
		jbt = new JButton("확인");
		
		// (2) 핸들러 객체 생성
		MyHandler hdlr = new MyHandler(); // 객체생성
		// (3) 이벤트 발생할 컴포넌트와 연결
		jbt.addActionListener(hdlr); // jbt 이벤트 발생시 actionPerformed 함수를 불러줌  hdlr 출력
	}
	
	// (1) 이벤트 핸들러 만들기
	//		핸들러 - 이벤트 처리 클래스
	class MyHandler implements ActionListener{ // 이너클래스 : 클래스안 클래스 상속 
		@Override
		public void actionPerformed(ActionEvent e) {  // 오버라이딩 
			JOptionPane.showMessageDialog(null, "이벤트발생");
			
		}
		
	}
		
	
	void addLayout() {
		f.setLayout(new FlowLayout());
		f.add(jbt);
		
		f.setBounds(500, 500, 500, 350);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	

	public static void main(String[] args) {

		EventTest event = new EventTest();
		event.addLayout();

	}
	
	/*
	extends
		클래스 한 개만 상속 받을 수 있으며, 자식 클래스는 부모 클래스의 기능을 사용할 수 있다.
	implements (도구) (interface 구현)
		여러 개의 interfaces를 상속 받을 수 있으며, 자식 클래스는 부모의 기능을 다시 정의해서 사용해야한다.
	*/
}
