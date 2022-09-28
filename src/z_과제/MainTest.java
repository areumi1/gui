package z_과제;
import javax.swing.*;
import java.awt.*;
public class MainTest {
	
	JFrame f = new JFrame("Drink");
	Drink drink;
	JButton btn;		// 결제 버튼 
	JTextArea orderhistory; /// 장바구니 클릭시 출력
	
	
	MainTest(){
		
		btn = new JButton("결제");
		drink = new Drink();
	}
	
	void addLayout() {
		f.setLayout(new BorderLayout());
		f.add(btn, BorderLayout.SOUTH);
		
		JTabbedPane tab = new JTabbedPane();
		tab.addTab("Drink", drink);
		f.add(tab, BorderLayout.CENTER);
		
		f.setBounds(100, 100, 800, 600);
		f.setVisible(true);	
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		MainTest main = new MainTest();
		main.addLayout();
	}

}
