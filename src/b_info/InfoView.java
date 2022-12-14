package b_info;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;
import java.util.*;

public class InfoView {

	// 1. 멤버변수 선언
	JFrame f;
	JTextField tfname, tfId, tfTel, tfGender, tfAge, tfHome;
	JTextArea ta;
	JButton bAdd, bShow, bSearch, bDelete, bCancel, bExit;

	ArrayList<PersonVO> list = new ArrayList<PersonVO>();

	// 2. 멤버변수 객체생성

	InfoView() {
		f = new JFrame("DBTest"); // 프레임 생성

		ta = new JTextArea(40, 20); // 영문자기준 몇줄 몇자 여러줄 출력

		tfname = new JTextField(15); // 영문자기준 몇자 텍스트 길이 한줄 출력
		tfId = new JTextField(15);
		tfTel = new JTextField(15);
		tfGender = new JTextField(15);
		tfAge = new JTextField(15);
		tfHome = new JTextField(15);

		bAdd = new JButton("Add", new ImageIcon("src\\b_info\\imgs\\6.png")); // "Add"버튼출력 및 이미지 설정
		bAdd.setHorizontalTextPosition(JButton.CENTER);
		bAdd.setVerticalTextPosition(JButton.BOTTOM);
		bShow = new JButton("Show", new ImageIcon("src\\b_info\\imgs\\5.png"));
		bShow.setHorizontalTextPosition(JButton.CENTER);
		bShow.setVerticalTextPosition(JButton.BOTTOM);
		bSearch = new JButton("Search", new ImageIcon("src\\b_info\\imgs\\4.png"));
		bSearch.setHorizontalTextPosition(JButton.CENTER);
		bSearch.setVerticalTextPosition(JButton.BOTTOM);
		bDelete = new JButton("Delete", new ImageIcon("src\\b_info\\imgs\\3.png"));
		bDelete.setHorizontalTextPosition(JButton.CENTER);
		bDelete.setVerticalTextPosition(JButton.BOTTOM);
		bCancel = new JButton("Cancel", new ImageIcon("src\\b_info\\imgs\\2.png"));
		bCancel.setHorizontalTextPosition(JButton.CENTER);
		bCancel.setVerticalTextPosition(JButton.BOTTOM);
		bExit = new JButton("Exit(art+x)", new ImageIcon("src\\b_info\\imgs\\1.png"));
		bExit.setHorizontalTextPosition(JButton.CENTER); // 버튼의 수평맞추기 // 가운데로
		bExit.setVerticalTextPosition(JButton.BOTTOM);// 버튼의(글자) 수직맞추기 // 하단에
		bExit.setRolloverIcon(new ImageIcon("src\\b_info\\imgs\\6.png")); // 마우스 가져다 되면 이미지 변경
		bExit.setPressedIcon(new ImageIcon("src\\b_info\\imgs\\5.png"));
		; // 버튼 클릭시 이미지 변경
		bExit.setToolTipText("프로그램을 종료합니다."); // 마우스를 가져다 되면 메세지 뜨게 설정
		bExit.setMnemonic('x');
	}
	// Icon 인터페이스 추상
	// 물려받은 자식클래스를 찾아 사용 ImageIcon
	// 주소를 불러올때 역슬러시\ 두개사용 \\.

	// 3. 화면구성하고 출력
	/*
	 * 전체 프레임 BorderLayout 지정 - WEST : JPanel 붙이기 ( GridLayout(6,2)) - CENTER :
	 * TextArea - SOUTH : JPanel 붙이기 ( GridLayout(1,6))
	 */
	void addLayout() {
		f.setLayout(new BorderLayout()); // 동서남북가운데 정렬/출력
		JPanel west = new JPanel();
		west.setLayout(new GridLayout(6, 2));
		west.add(new JLabel("Name", JLabel.CENTER)); // 중간정렬
		west.add(tfname);
		west.add(new JLabel("ID", JLabel.CENTER));
		west.add(tfId);
		west.add(new JLabel("Tel", JLabel.CENTER));
		west.add(tfTel);
		west.add(new JLabel("Sex", JLabel.CENTER));
		west.add(tfGender);
		west.add(new JLabel("Age", JLabel.CENTER));
		west.add(tfAge);
		west.add(new JLabel("Home", JLabel.CENTER));
		west.add(tfHome);
		f.add(west, BorderLayout.WEST);

		f.add(ta, BorderLayout.CENTER);
		JPanel south = new JPanel();
		south.setLayout(new GridLayout(1, 6)); // 열맞춰서 정렬/출력
		south.add(bAdd);
		south.add(bShow);
		south.add(bSearch);
		south.add(bDelete);
		south.add(bCancel);
		south.add(bExit);
		f.add(south, BorderLayout.SOUTH);

		f.setBounds(500, 1000, 900, 400);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// 이벤트 처리 함수
	public void eventProc() {
		// 'Add' 버튼이 눌렸을때 이벤트 발생
		bAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputData(); /// 텍스트 입력
				clearTextField(); // 텍스트 삭제
				selectAll(); /// 입력할때마다 창에 띄워줌
			}
		});
		// 'Show' 버튼 클릭시 리스트에 저장된 정보를 모두 텍스트에어리어에 출력
		bShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectAll();
			}
		});

		// 'SEARCH' 버튼이 눌렸을때
		bSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectByTel();
				selectAll();
			}// 고유넘버로 사용자를 찾음 주민번호는 금지므로 요즘은 연락처로 정보확인// 고유넘버를 키라고 함.
		});

		// 'SEARCH' 버튼을 누르지 않고 전화번호 입력후 엔터쳤을때
		tfTel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectByTel();
			} // end of actionPerformed
		}); // end of addActionListener

		
		bDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteByTel();
			}
		});
		bCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Cancel 이벤트발생");
			}
		});
		bExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Exit 이벤트발생");
			}
		});

		// 주민번호 입력창에서 엔터 쳤을 때 이벤트 발생
		tfId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getJuminInfo();
			} // end of actionPerformed
		}); // end of addActionListener

		// 주민번호 입력 창에서 포커스 발생했을때 (고객이 엔터를 치지않고 다른 칸을 불러왔을때)
		tfId.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				// 포커스를 얻었을때 이벤트

			}

			public void focusLost(FocusEvent e) {
				// 포커스를 잃었을때 이벤트
				getJuminInfo(); // 메소드 getJuminInfo 호출
			} // end of
		}); // end of addFocusListener

		// 'CANCLE' 버튼 눌렸을때
		bCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearTextField();
			}
		});// end of addActionListener

	} // end of eventProc()

	/*
	 * 'ADD' 버튼이 눌렸을 때 텍스트필드에 입력한 사용자의 값들을 PersunVO에 저장
	 */
	void inputData() {
		// (1) 각각의 텍스트필드의 입력값을 얻어오기
		String age = tfAge.getText();
		String gender = tfGender.getText();
		String home = tfHome.getText();
		String id = tfId.getText();
		String name = tfname.getText();
		String tel = tfTel.getText();

		// (2) 1번의 값들은 PersonVO 멤버변수에 저장 ( setter / constructor)
		PersonVO vo = new PersonVO();
		vo.setName(name);
		vo.setGender(gender);
		vo.setId(id);
		vo.setTel(tel);
		vo.setHome(home);
		vo.setAge(Integer.parseInt(age));

		// (3) 입력받은 전체 값을 저장
		list.add(vo);

		// (1,2) 동시선언
		/*
		 * vo.setName(tfname.getText()); vo.setGender(tfGender.getText());
		 * vo.setId(tfId.getText()); vo.setTel(tfTel.getText());
		 * vo.setHome(tfHome.getText()); vo.setAge(Integer.parseInt(tfAge.getText()));
		 */

	} // end of inputData()

	/*
	 * 'Show' 버튼 클릭시 리스트에 저장된 정보를 모두 텍스트에어리어에 출력
	 */
	void selectAll() {
		ta.setText("--------- 전체 목록 ----------\n\n");
		for (PersonVO vo : list) {
			ta.append(vo.toString());
		} // .append // 기본있는 자료에 추가
	} // end of selectAll

	void deleteByTel() {
		// (1) 입력한 전화번호값을 얻어오기
			String tel = tfTel.getText();
		// (2) 입력받은 전화번호가 공백이라면 "전화번호를 입력하세요"메세지창을 출력
			if(tel.equals("")) {
				JOptionPane.showMessageDialog(null, "전화번호를 입력하세요");
				return; // 제어권 반환 // 종료// 밑에기능을 못하게 막아줌
				}// 문자열 비교는 무조건 .equals 로 비교해줘야한다.
				
		// 리스트에 저장된 PerSonVO의 전화번호와 비교하여
		// 해당 전화번호가 있으면 그 해당하는 PersonVO를 리스트에서 삭제
		// (참고) 삭제하고 나서 break로 반복문 끝내기
		// 데이터를 관리하기 위해서 데이터베이스에 저장해야함 
			for(PersonVO vo : list) {
				if(tel.equals(vo.getTel()));
				list.remove(vo);
				tfname.setText(null);
				tfAge.setText(null);
				tfGender.setText(null);
				tfHome.setText(null);
				tfId.setText(null); 
				tfTel.setText(null);
				break;
			}
			
			
	}


	/*
	 * 'Search' 버튼이 눌렸을 때 함수명 : selectByTel 인자 : 없음 리턴값 : void 역할 :
	 */
	void selectByTel() {
		// (1) 입력한 전화번호값을 얻어오기
		String tel = tfTel.getText();
		// (2) 입력받은 전화번호가 공백이라면 "전화번호를 입력하세요"메세지창을 출력
		if (tel.equals("")) {
			JOptionPane.showMessageDialog(null, "전화번호를 입력하세요");
			return; // 제어권 반환 // 종료// 밑에기능을 못하게 막아줌
		} // 문자열 비교는 무조건 .equals 로 비교해줘야한다.

		// 리스트에 저장된 PerSonVO의 전화번호와 비교하여
		// 해당 전화번호가 있으면 그 내용을 각각의 텍스트필드에 출력
		for (PersonVO vo : list) {
			if (tel.equals(vo.getTel()));
			tfname.setText(vo.getName());
			tfAge.setText(String.valueOf(vo.getAge()));
			tfGender.setText(vo.getGender());
			tfHome.setText(vo.getHome());
			tfId.setText(vo.getId());
		}

	}

	/*
	 * 각각의 텍스트필드와 텍스트에어리어의 값을 지우기
	 */

	void clearTextField() {
		ta.setText(null);
		// 나머지 텍스트필드도 지우기
		tfAge.setText(null);
		tfGender.setText(null);
		tfHome.setText(null);
		tfId.setText(null);
		tfname.setText(null);
		tfTel.setText(null);

	} // end of clearTextField()

	void getJuminInfo() { // 코딩은 중복되면 안되기때문에 두번이상 사용할경우 메소드 에 코딩후 호출
		String jumin = tfId.getText(); // 사용자가 입력한 값 불러와 jumin 변수에 저장
		if (jumin.length() < 14) {
			JOptionPane.showMessageDialog(null, jumin + "- 포함한 15자를 맞춰주세요");
			return;
		} // end of if

		// (1) 주민번호의 7번째 문자로 성별을 구하여 성별창에 출력
		char sung = jumin.charAt(7);
		String man = null; // String man = 초기값 설정

		if (sung == '1' || sung == '3' || sung == '9') { // if 충족시 String man 변수에 남자값 설정
			man = "남자";
		} else if (sung == '2' || sung == '4' || sung == '0') { // else if 충족시 String man 변수에 여자값 설정
			man = "여자";
		}

		tfGender.setText(man); /// tfGender에 set 으로 man(if문 값에 따라 남자 or 여자) 불러오다.

		// (2) 주민번호의 8번째 문자로 출신지를 구하여 출신지창에 출력
		char chul = jumin.charAt(8);
		String home = null;

		switch (chul) { // 문자, 정수, 문자열
		case '0':
			home = "서울";
			break;
		case '1':
			home = "인천/부산";
			break;
		case '2':
			home = "경기";
			break;
		case '9':
			home = "제주";
			break;
		}

		tfHome.setText(home);

		// (3) 주민번호에서 년도에 의해 나이를 구해서 나이창에 출력
		String nai = jumin.substring(0, 2);
		int sunai = Integer.parseInt(nai);
		int age = 0;
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);

		if (sung == '1' || sung == '2') {
			sunai += 1900;
		} else if (sung == '3' || sung == '4') {
			sunai += 2000;
		} else if (sung == '9' || sung == '0') {
			sunai += 1800;
		}
		age = year - sunai + 1;
		// String age2 = String.valueOf(age); // int값 String 으로 변환
		// tfAge.setText(age2); // setText 는 String 값만 출력 가능
		tfAge.setText(String.valueOf(age)); // Strinf.Valueof()를 변수 선언없이 바로 변경후 출력

	}

	public static void main(String[] args) {

		InfoView info = new InfoView();
		info.addLayout();
		info.eventProc();

	}

}
