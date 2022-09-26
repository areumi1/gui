package a_sample;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

/*
 	자바의 GUI (화면)
 	- AWT : 1.2 이전
 	- Swing : 1.2 이후
 				대부분 클래스 앞에 J
 */

// 헤즈어 방식
// 프레임을 직접 생성해 사용
import javax.swing.*;

public class ATest {
	
	JFrame f;
	JButton btn, btnCancel;
	JCheckBox java, oracle;	// 다중선택을 할때 사용
	JRadioButton man, woman;	// 반드시 하나만 체크해야할때 사용 	
	JTextField tf;		// 한줄 입력
	JTextArea ta;		// 여러줄 입력
	// 한번사용하고 사용하지 않을 경우 멤버변수가 아닌 지역변수로 사용
	
	ATest(){
		f = new JFrame("나의 첫창");
		btn = new JButton("클릭");
		btnCancel = new JButton("취소");
		java = new JCheckBox("Java");
		oracle = new JCheckBox("Oracle");
		man = new JRadioButton("남자");
		woman = new JRadioButton("여자");
		ButtonGroup group = new ButtonGroup();	// 라디오버튼은 하나만 선택해야 하므로 그룹을 만들어서 그룹에서 하나만 선택가능하도록 관리
		group.add(man);
		group.add(woman);
		tf = new JTextField(20); // 평균 알파벳의 20자
		ta = new JTextArea(40,20); // 평균 알파벳의 40줄 20자
		
	}
	
	void addLayout() {
		// 붙이는 방법 설정 
//		FlowLayout f1 = new FlowLayout();
//		f.setLayout(f1);
	//	f.setLayout(new FlowLayout()); // 한번 사용하기 떄문에 변수 생략 한줄에 배치
		//f.setLayout(new GridLayout(3, 3));  // 행과 열 에 맞춰 배치
		f.setLayout(new BorderLayout());	// 동/서/남/북/가운데 배치 // 하나씩만 배치되기때문에 중복일시 덮어씜
		
		// 붙이기 작업
		f.add(btn		, BorderLayout.NORTH);
		f.add(btnCancel		,BorderLayout.SOUTH);
		//f.add(java);
		//f.add(oracle);
			JPanel pEast = new JPanel();
			pEast.add(man);
			pEast.add(woman);
		f.add(pEast		,BorderLayout.EAST);
	
		f.add(new JLabel("입력하세요"),BorderLayout.WEST); // 한번만 사용할것 같을때 바로선언 가능
		//f.add(tf		,BorderLayout.EAST);
		f.add(ta		, BorderLayout.CENTER);
		
		// 화면 출력
		f.setBounds(100, 100, 500, 350); // 화면규격
		f.setVisible(true);	//창을 화면에 나타낼 것인지 설정 
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 창 X 버튼 누를시 종료시켜줌, 사용하지 않을시 창을 닫히나 실행은 종료되지 않음.	
		
		
	}

	public static void main(String[] args) {
		ATest a = new ATest();
		a.addLayout();

	}
	// FlowLayout
	// 왼쪽에서 오른쪽으로 배치되며 오른쪽에 더 이상 공간이 없으면 다음 줄로 자동 배치되는 게 특징입니다. 
	// 일반적으로 플로우 레이아웃은 패널에 버튼을 배열하는 데 사용되며,
	// 기본적으로 가운데 정렬

}
