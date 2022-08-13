/*
- 저자 (author)
 brainKimDu
- 만든 일자 (date to create)
2020년 5월 15일
- 수정 일자 (date to update)
2020년 6월 16일
- 프로그램 내용(purpose of the program)
프로젝트의 개발자 모드에 관련한 클래스, 농작물의 종류를 추가하거나, 구매, 판매, 물류의 가격 변화 원인을 추가할 수 있다.
- 함수/메소드 (purpose of method)
	public class developer_mode extends JFrame : 개발자 모드 클래스로 GUI와 전체적인 흐름을 관리한다.
		 	imageField.addActionListener(new ActionListener()	: JTextfield에서 문자열을 입력(이미지)받는 익밍클래스
		 	Field.addActionListener(new ActionListener()	: JTextfield1에서 문자열을 입력(원인, 상품명)을 받는 익명클래스
		 	Field2.addActionListener(new ActionListener()	: JTextfield2에서 실수를 입력(확률, 가격)을 받는 익명클래스
		class ClickMouse extends MouseAdapter : 마우스 클릭에 관한 리스너로 JButton를 클릭할 경우에 발생하는 이벤트들을 다룬다. 
		class MyItemListener implements ItemListener : 체크박스에 관한 리스너로 어떤 텍스트 파일에 저장할지 결정하게된다. 
		
		public void printTxt(String txt) : 체크박스가 눌릴경우 눌려진 체크박스에 해당하는 txt에 저장되어 있는 내용들을 불러와서 텍스트에리어에 나타내는 메소드
		public void printstockTxt(String txt) :  농작물의 경우 이미지저장경로도 필요하기 때문에 메소드를 새로만들었다.
*/

/*
 *  현재 클래스의 동작 상세설명
 * 		제목 : 개발자 모드
 * 		내용 : 농작물의 가격변화 원인, 판매가격의 변화 원인, 수요가격의 변화 원인, 물류가격의 변화원인을 입력받아 각각의 txt 파일에 저장하는 역할을 하는 클래스이다.
 * 			상단부의 체크박스를 통해 어느 txt에 저장할지 고를 수 있다.
 * 			그 밑의 textArea에는 선택된 txt파일을 읽어와서 현재 저장되어 있는 텍스트를을 보여준다. 
 * 			그밑에는 원인(혹은 상품명), 변화확률(혹은 가격)을 텍스트필드에 입력하고 추가할 수 있다.
 * 			농작물의 경우 이미지의 위치명을 입력하면 나타난다.
 * 
 * 			모든 값을 입력받으면, 해당하는 txt에 추가할 수 있다. 이는 fileIO 패키지의 fileIO 클래스를 통해 이루어진다. 
 * 			잘못된 변수를 입력하거나, 텍스를 ,로 분리하기 때문에 ,가 입력되었을 때 발생하는 문제들을 해결하기 위해 필요한 조치를 취하였다.
 */
package developer_Mode;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

// 초기화면 패키지의 메인메뉴 클래스를 불러옵니다. 
import Initial_Screen.initialGUI;
// 텀프로젝트의 파일입출력에 관련한 패키지를 불러옵니다.
import fileIO.*;

// 메인 클래스로 GUI와 개발자모드 클래스의 전반적인 동작을 담당한다.
public class developer_mode extends JFrame{
	JLabel Label[] = new JLabel[7];
	/*
	  0 : 상단에 "개발자 모드" 출력  / 1: "원인을 입력하세요. 절대로 ,를 사용하지 마세요."을 출력하는 레이블  / 2: "가격변화 비율을 입력하세요."을 출력하는 레이블
	  3 : 원인을 입력받으면 입력된 원인이 뭔지 출력 / 4: 확률 혹은 가격을 입력 받으면 출력 / 5:저장이 완료되었거나 문제가 발생하였을 때 출력하는 레이블
	  6 : 농작물 이미지 입력에 관련한 문제 출력
	 */
	
	JTextField Field = new JTextField();
	// 원인혹은 농작물 이름을 입력받는 텍스트 필드
	JTextField Field2 = new JTextField();
	// 확률 혹은 가격을 입력받는 텍스트 필드
	JTextArea Field3 = new JTextArea();
	// 텍스트에 저장된 문자들을 출력해 보여주는 텍스트 에리어
	JButton Button[] = new JButton[3];
	/*
	 *  0: 추가하기  / 1 : 뒤로 가기 (메인메뉴) / 2: 농작물 추가에 관한 JButton 다른 메소드를 사용하기 때문에 JButton을 바꿈. 
	 */
	
	JTextField imageField  = new JTextField();
	// 이미지의 저장경로를 입력받는 JTextField
	
	JRadioButton[] txt = new JRadioButton[4];
	// 0 ~ 4  : 공급가격변화원인.txt , 수요가격변화원인.txt, 물류가격변화원인.txt, 농작물.txt 을 선택할 수 있으며, 해당 체크박스를 누르면 
	// 텍스트 에리어에 저장된 txt를 보여주고, 해당 txt에 저장을 할 수 있게된다.
	String txtFile[] = {"공급가격변화원인.txt", "수요가격변화원인.txt", "물류가격변화원인.txt" , "농작물.txt"};
	// 체크박스에서 사용하기위한 문자열 배열변수 선언

	Container c = getContentPane();	// 프레임의 컨테트팬을 알아낸다. 이는 전역변수로 선언하여 다른 클래스에서 접근이 가능하게 한다.
	FileIO File = new FileIO();	// 파일입출력 클래스로 txt 작성을 주로 담당하는 클래스이다.
	
	int set = 0;		//체크박의 선택에 따라  0~3의 수를 가지고 texFile 문자열의 배열에 넣어 텍스트를 선태하게 된다.
	String FileStr = " "; 	// 입력받은 농작물 이름 
	String FileName = "d.txt"; // 파일의 txt 파일명
	String reason;		// 입력받은 원인 

	double percentage = 0;	// 입력받은 변화 확률
	int changeInt;		// 입력받은 가격
	
	String imageProduct = null;	// 입력받은 이미지 경로
	JLabel imageLabel = new JLabel();	// 이미지객체로 입력받으면 저장되는 이미지가 무엇인지 미리 보여준다.
	
	
	// 생성자로 GUI생성을 담당한다.
	public developer_mode() {
		setTitle("개발자 메뉴");		//제목
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//x로 나가기
		c.setLayout(null);		// 배치관리자 제거
		c.setBackground(Color.WHITE);	// 배경색을 하얀색으로 한다.
		
		// @체크박스
		// 체크박스의 그룹을 생성한다.
		ButtonGroup g = new ButtonGroup();		
		// 체크박스를 생성하고 c에 붙이고 체크박스의 그룹을 만드는 과정이다.
		for(int i=0; i<4; i++) {
			txt[i] = new JRadioButton(txtFile[i]);		// J라디오 버튼은 문자열 txtFile[]을 문자열로 가진다. 객체생성
			g.add(txt[i]);			// 그룹을 생성
			txt[i].setLocation(100 + (200 * i), 100);
			txt[i].setSize(200,100);		// 위치와 크기 지정
			txt[i].addItemListener(new MyItemListener());	//체크박스가 선택되는 경우에 해당하는 아이템리스너 등록
			c.add(txt[i]);		// 프레임에 부착
		}
		
		
		// @txtArea에 해당 
		Field3 = new JTextArea(" ");		// txt 파일을 가져와서 텍스트 필드에 보여주는 역할을 하는 에리어 객체 생성
		JScrollPane scrollPane = new JScrollPane(Field3);	// 스크롤을 가지게 한다.
		scrollPane.setLocation(100,200);		
		scrollPane.setSize(800,300);		// 위치와 크기 지정
		c.add(scrollPane);		// 프레임에 부착
		
		// @상단의 개발자 모드 문자열 레이블형으로 출력
		Label[0] = new JLabel("개발자 모드");	//레이블 객체 생성
		Label[0].setLocation(300, 10);
		Label[0].setSize(1000,100);		// 위치 크기 지정
		Label[0].setFont(new Font("궁서", Font.BOLD, 50));	//폰트 조절
		c.add(Label[0]);		//프레임 부착
		
		// @ 하단의 원인을 입력받을 떄 사용하느 레이블
		Label[1] = new JLabel("원인을 입력하세요. 절대로 ,를 사용하지 마세요.");		// 레이블 객체 생성
		Label[1].setFont(new Font("고딕", Font.BOLD, 20));		// 폰트 조절
		Label[1].setLocation(100, 500);
		Label[1].setSize(1000,30);		// 위치 크기 지정
		c.add(Label[1]);		// 프레임에 부착
		
		// @ 원인을 입력받을 때 사용하는 텍스트 필드 
		JTextField Field = new JTextField();	//텍스트 필드 객체 생성		
		Field.setSize(300,50);	
		Field.setLocation(100, 550);		// 위치와 크기 지정
		c.add(Field);		// 프레임에 부착
		
		// @ 가격변화 비율 혹은 농작물의 가격을 입력 받을 때 사용하는 레이블
		Label[2] = new JLabel("가격변화 비율을 입력하세요.");		// 레이블 객체 생성
		Label[2].setFont(new Font("고딕", Font.BOLD, 20));	//폰트 크기 지정
		Label[2].setLocation(100, 580);
		Label[2].setSize(1000,100);		// 크기와 위치 지정
		c.add(Label[2]);	// 프레임에 부착
		
		// @ 가격변화의 비율 혹은 종작물의 가격을 입력받는 텍스트 필드
		JTextField Field2 = new JTextField();		// 텍스트 필드 객체	
		Field2.setSize(300,50);	
		Field2.setLocation(100, 650);	// 위치와 크기 조절
		c.add(Field2);		// 프레임에 부착
		
		// @ 입력받은 것이 어떤 것인지 출력하는 레이블 
		Label[3] = new JLabel(" ");		// 레이블 객체 생성
		Label[3].setFont(new Font("돋움d", Font.BOLD, 20));	// 폰트 조절
		Label[3].setLocation(100, 680);
		Label[3].setSize(1000,100);		// 크기와 위치 조절
		c.add(Label[3]);		// 프레임에 부착
		
		// @ 입력받은 가격이나 변화확률이 무엇인지 출력하는 레이블
		Label[4] = new JLabel(" ");		// 레이블 객체 생성
		Label[4].setFont(new Font("돋움d", Font.BOLD, 20));	// 폰트 조절
		Label[4].setLocation(100, 710);
		Label[4].setSize(1000,100);		// 크기와 위치 조절
		c.add(Label[4]);	// 프레임에 부착
		
		// @ 문제발생이나 저장에 관한 레이블
		Label[5] = new JLabel(" ");	//레이블 객체 생성
		Label[5].setFont(new Font("돋움d", Font.BOLD, 20));	// 폰트 조절
		Label[5].setLocation(100, 900);		
		Label[5].setSize(1000,100);		//크기와 위치 조절
		c.add(Label[5]);		//프레임에 부착
			
		// @ 이미지입력에 사용하는 레이블
		Label[6] = new JLabel(" ");	//레이블 객체 생성	
		Label[6].setFont(new Font("돋움d", Font.BOLD, 10));		// 폰트조절
		Label[6].setLocation(500, 480);			
		Label[6].setSize(1000,100);		// 크기와 위치 조절
		c.add(Label[6]);		// 프레임에 부착
		
		// @ 농작물 입력시 이미지 위치를 입력받는 텍스트 필드
		JTextField imageField = new JTextField("농작물 입력시 입력하세요.");	 //택스트 필드 객체 생성		
		imageField.setSize(300,50);		
		imageField.setLocation(500, 550);		// 크기와 위치 조절
		c.add(imageField);		// 프레임 부착
		
		
		
		/* 클래스 제목 : 이미지 텍스트에서 엔터 입력이 발생하는 경우에 사용하는 리스너 익명 클래스
		 *  	동작 : 입력받은 파일의 위치에 해당하는 이미지를 가지는 레이블 객체를 생성한다.
		 */
		 imageField.addActionListener(new ActionListener() {
			 // 엔터가 입력되는 경우
			public void actionPerformed(ActionEvent e) {
				JTextField String = (JTextField)e.getSource();	// 입력된 문자열을 가지는 JText필드
				imageProduct = "재고\\" + String.getText();	// 이미지 문자열은 재고파일안에 있는 파일이름을 가진다.
				// @fix bug
				imageProduct = imageProduct.replaceAll(",","");	// 혹시 ,가 있다면 비운다 (오류를 방지하기 위함)
				
				ImageIcon image = new ImageIcon(imageProduct);	// 해당 위치위 이미지파일을 불러온다.
				imageLabel.setIcon(image);		// 이미지 파일을 가지는 레이블 
				imageLabel.setSize(300,300);	
				imageLabel.setLocation(500,600);	// 위치와 크기조절
				imageLabel.setVisible(true);
				c.add(imageLabel);	// 프레임에 부착
				
				// @ fix bug
				c.repaint();  		// 이걸 하지 않으면 이미지가 빠르게 로딩되지 않는다.
				
				imageField.setText("");		// 이미지 텍스트필드를 비운다.
				
			}
		});
		
		 /* 클래스 제목 : 원인이나 농작물 이름을 입력하는 텍스트에서 엔터 입력이 발생하는 경우에 사용하는 리스너 익명 클래스
			 *  	동작 : 입력받은  원인을 문자열 reason에 저장한다.
			 */
		Field.addActionListener(new ActionListener() {
			// 엔터가 눌리는 경우
			public void actionPerformed(ActionEvent e) {
				JTextField String = (JTextField)e.getSource();	// 입력된 문자를 알아낸다.
				reason = String.getText();		// 문자열 변수는 입력된 문자를 가진다.
				Field.setText("");		// 원인 텍스트 필드를 지운다.
				// @ fix bug 
				reason = reason.replace(',', ' ');	// ,을 띄어 쓰기로 바꾼다.	
				Label[3].setText("원인은 : " + reason); 	// 레이블을 통해 입력된 원인이 무엇인지 알려준다.
			}
		});
		
		 /* 클래스 제목 : 가격이나 확룰을 입력하는 텍스트에서 엔터 입력이 발생하는 경우에 사용하는 리스너 익명 클래스
		 *  	동작 : 입력받은  가격이나 확률을 percentage에 저장한다.
		 */
		Field2.addActionListener(new ActionListener() {
			// 엔터가 눌리는 경우
			public void actionPerformed(ActionEvent e) {
				try {
					JTextField String = (JTextField)e.getSource();		// 입력된 문자를 알아낸다.
					percentage = Double.parseDouble(String.getText());		// 더블형 으로 변환해서 저장
					Field2.setText("");		// 입력받는 텍스트 필드를 비운다.
					Label[4].setText("확률은 : " + percentage );	// 입력된 확률이나 가격을 알려준다.
				}
				catch(NumberFormatException er) {	// 숫자가 아닌게 입력될 경우
					Label[4].setText("실수형으로 입력하세요. 가격의 경우 정수로 입력하세요. " );	// 해당 문자열을 레이블을 통해 출력한다.
				}
					
			}
		});
		
		// @ txt에 추가하는 버튼
		Button[0] = new JButton("추가하기");		//버튼 객체 만들기
		Button[0].setLocation(800, 700);		
		Button[0].setSize(100,100);				// 크기와 위치 조절
		Button[0].addMouseListener(new ClickMouse());	// 마우스 클릭 리스너 설정
		c.add(Button[0]);		// 프레임에 부착
		
		// @ 매인메뉴로 가는 버튼
		Button[1] = new JButton("뒤로가기");		// 버튼 객체 생성
		Button[1].setLocation(800, 600);
		Button[1].setSize(100,100);			//크기와 위치 조절
		Button[1].addMouseListener(new ClickMouse());		// 마우스 클릭 리스너 설정
		c.add(Button[1]);			// 프레임에 부착
		
		// @ 농작물을 추가하는 경우에 사용하는 버튼
		Button[2] = new JButton("재고 추가하기");		// 버튼 객체 만들기
		Button[2].setLocation(800, 700);
		Button[2].setSize(100,100);				// 크기와 위치 조절
		Button[2].addMouseListener(new ClickMouse());		// 마우스 클릭 리스너 설정
		c.add(Button[2]);		// 프레임에 부착
		
		
		setSize(1000,1000);
		setVisible(true);			// 전체적인 GUI크기와 보이게 하는 것
	}
	
	 /* 클래스 제목 : 버튼이 클릭되는 경우에 발생하는 리스너
	 *  	동작 : txt에 입력받은 것을 추가하거나 메인메뉴로 가거나 한다.
	 */
	class ClickMouse extends MouseAdapter {			
		// 마우스로 클릭하는 경우
		public void mousePressed(MouseEvent e) {	
			JButton b = (JButton)e.getSource();		// 눌린 것이 무엇인지 알아낸다.
			// 눌린 버튼이 추가하기라면
			if(b.getText().equals("추가하기")) {
				if((reason != null) && (percentage != 0) ) {	// 모두 입력되었다면
					Label[5].setText("저장이 완료되었습니다.");		// 저장되었다고 문자열을 나타내고
					Label[3].setText(" ");
					Label[4].setText(" ");		// 레이블을 모두 지운다.
					File.File_Input_Reason(txtFile[set], reason, Double.toString(percentage));	
					// fileIO의 Input_Reason 클래스를 통해 해당 txt에 원인과 가격을 모두 저장한다.
					reason = null;	
					percentage = 0;	// 입력받은 값을 모두 비운다.
				}
			
				else
					Label[5].setText("입력을 먼저하세요. 엔터를 입력하셔야합니다.");	// 입력받은 값이 없으면 레이블을 통해 출력
			}
			
			// 눌린 버튼이 재고 추가하기라면
			if(b.getText().equals("재고 추가하기")) {
				if((reason != null) && (percentage != 0) ) {		// 입력받은 것이 있다면 진행
					if(imageProduct != null) {		// 이미지를 입력받았다면 진행
					Label[5].setText("저장이 완료되었습니다.");		// 레이블 출력
					Label[3].setText(" ");			// 레이블을 비운다.
					Label[4].setText(" ");
					imageLabel.setVisible(false);	//이미지레이블 지우기
					changeInt = (int)percentage;		// 가격을 받아온다.
					File.File_Input_product(txtFile[set], reason, Integer.toString(changeInt), imageProduct);
					// fileIO의 Input_Reason 클래스를 통해 해당 txt에 원인과 가격을 모두 저장한다.
					reason = null;
					percentage = 0;
					imageProduct = null;	//모두 비우게 된다.
					}
				}
			
				else
					Label[5].setText("입력을 먼저하세요. 엔터를 입력하셔야합니다."); // 입력받은 값이 없다면 레이블을 통해 출력
			}
			// 만약 뒤로가리 라면
			if(b.getText().equals("뒤로가기")) {
				new initialGUI();
				setVisible(false);		// 메인메뉴로 간다.
			}
		}
	}
	

	 /* 클래스 제목 : 체크박스 어떤것이 선택되었는가에 따라서
	 *  	동작 : txt를 읽어서 출력하고 선택된 txt에 저장한다.
	 */
	class MyItemListener implements ItemListener{
		// 선택된 체크박스가 무엇인가?
		public void itemStateChanged(ItemEvent e) {
			// 아무것도 선택안하면 가만히 있어라.
			if(e.getStateChange() == ItemEvent.DESELECTED)
				return;
			// 0번이 선택된 경우 즉 공급가격변화원인.txt
			if(txt[0].isSelected()) {
				Field3.setText("");		// 텍스트에리어를 모두 비우고
				set=0;					// 0번의 문자열 공급가격변화원인.txt
				printTxt(txtFile[set]);		// 텍스트에리어에 저장된 문자열을 모두 출력하는 메소드 실행
				Label[1].setText("원인을 입력하세요.");		
				Label[2].setText("가격변화 비율을 입력하세요.");		//레이블을 해당 문자열로 교체하고
				Button[2].setVisible(false);		//재고추가하기 버튼을 비활성화한다.
				Button[0].setVisible(true);		//추가하기 버튼을 활성화한다.
			}
			// 1번이 선택된 경우 수요가격변화원인.txt	동작은 위와 같다.
			if(txt[1].isSelected()) {
				Field3.setText("");
				set=1;
				printTxt(txtFile[set]);
				Label[1].setText("원인을 입력하세요.");
				Label[2].setText("가격변화 비율을 입력하세요.");
				Button[2].setVisible(false);
				Button[0].setVisible(true);
			}
			// 2번 선택된 경우 물류가격변화원인.txt	동작은 위와 같다.
			if(txt[2].isSelected()) {
				Field3.setText("");
				set=2;
				printTxt(txtFile[set]);
				
				Label[1].setText("원인을 입력하세요.");
				Label[2].setText("가격변화 비율을 입력하세요.");
				Button[2].setVisible(false);
				Button[0].setVisible(true);
			}
			
			// 3번이 선택된 경우 농작물.txt 
			if(txt[3].isSelected()) {
				Field3.setText("");
				set=3;
				printstockTxt(txtFile[set]);		// 이는 농작물의 경우 정수형 변수와 이미지 객체까지 불러오기 때문에 다른 메소드를 사용한다.
				
				Label[1].setText("농작물 이름을 입력하세요.");
				Label[2].setText("가격을 입력하세요.");
				Label[6].setText("농작물 이미지 사진의 이름을 입력하세요. 200*200크기의 이미지가 있어야합니다.");
				
				Button[0].setVisible(false);
				Button[2].setVisible(true);
			}
		}
		
		// 메소드 제목 : 현재 저장된 텍스트를 읽어오기
		public void printTxt(String txt) {
			try {	
				Scanner fscanner = new Scanner(new FileReader(txt));	// 한줄씩 읽기 위해 파일스캐너를 선언한다.
				while(fscanner.hasNext()) {				// 줄이 끝날때까지 읽는다.
					String a = fscanner.nextLine();		// 한줄을 읽어서
					String line = a.replace("\n", "");		// 뒤에 /n을 지우고 
					String split[] = line.split(",");		// ,로 구분되어 있는 것을 나눈다.
					for(int i=0; i<(split.length/2); i+=2) {		// 줄의길이의 반만큼 돌면서
							Field3.append(split[i] + "\t");		// 맨앞의 원인을 출력하고
							Field3.append(split[i+1] + "\n");	// 뒤의 변화 원인을 출력한다.
					}
				
				}
			}	
			catch (IOException IOe) {		// 파일 입출력에 문자가 발생한다면 Error 출력
				System.out.println("Error");
			}
			c.repaint();		// 텍스트 필드에 추가된걸 다시 보여주어라.
		}
		
		// 메소드 제목 : 현재 저장된 택스트를 읽어온다. 농작물에서 사용
		public void printstockTxt(String txt) {
			try {
				Scanner fscanner = new Scanner(new FileReader(txt));
				while(fscanner.hasNext()) {
					String a = fscanner.nextLine();
					String line = a.replace("\n", "");
					String split[] = line.split(",");
					for(int i=0; i<(split.length/2); i+=2) {
							Field3.append(split[i] + "\t");
							Field3.append(split[i+1] + "\t");
							Field3.append(split[i+2] + "\n");		// 이미지 파일 경로가 추가되어 이 부분만 추가되었다.
							
					}
				}
			}	
			catch (IOException IOe) {
				System.out.println("Error");
			}
			c.repaint();
		}
		
	}
}
