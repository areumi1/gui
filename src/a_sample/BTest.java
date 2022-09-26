package a_sample;

import javax.swing.JButton;
import javax.swing.JFrame;
// 이즈어 방식 
// 부모객체를 상속받아 사용
public class BTest extends JFrame{
	// 부모클래스는 하나만 상속 가능하다.
	
	JButton btn;
	
	BTest(){
		super("나의 두번째창");
		btn = new JButton("확인2");
		
	}
	
	void addLayout() {
		
		add(btn);
		
		setBounds(100,100,500,350);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		
		BTest b = new BTest();
		b.addLayout();

	}

}
