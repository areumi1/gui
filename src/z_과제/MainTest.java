package z_과제;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MainTest {
	
	JFrame f = new JFrame("Drink");
	Drink drink;
	JButton order, delete ;		
	JTextArea orderhistory = new JTextArea(40,20); 
	JTextField tf = new JTextField();
	Buger buger;
	Side side;
	int sumPrice = 0;
	
	MainTest(){
		
		order = new JButton("결제");		// 결제로 가기
		delete = new JButton("주문취소"); 	// area 에서 글삭제
		
		drink = new Drink(this);
		buger = new Buger(this);
		side = new Side(this);
		
		orderhistory.setText("	상품		가격			결제금액\n\n");
		
	}
	
	void addLayout() {
		f.setLayout(new BorderLayout());
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(1,4,25,10));
		pan.add(order);
		pan.add(delete);
		pan.add(new JLabel("상품 총 결제금액 : "));
		pan.add(tf);
		f.add(pan, BorderLayout.SOUTH);
		
		f.add(orderhistory, BorderLayout.CENTER);
		
		JTabbedPane tab = new JTabbedPane();
		tab.addTab("Buger", buger);
		tab.addTab("Side", side);
		tab.addTab("Drink", drink);
		f.add(tab, BorderLayout.NORTH);
		
		f.setBounds(550, 100, 700, 850);
		f.setVisible(true);	
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void evnetProc() {
		order.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	new Jumun();
           }
       }); // end of addActionListener
		
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orderhistory.setText(null);
			}
		});
		
		
	}

	public static void main(String[] args) {
		MainTest main = new MainTest();
		main.addLayout();
		main.evnetProc();
	}

}
