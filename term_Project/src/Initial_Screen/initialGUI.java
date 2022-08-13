/*
- 저자 (author)
 brainKimDu
- 만든 일자 (date to create)
2020년 5월 15일
- 수정 일자 (date to update)
2020년 6월 16일
- 프로그램 내용(purpose of the program)
	메인메뉴로 게임을 시작하거나 게임방법을 보거나 이어하기를 할 수 있는 GUI이다.
- 함수/메소드 (purpose of method)
	생성자와 클릭메소드로 구성 (GUI)
*/

package Initial_Screen;


	import java.awt.*;
	import javax.swing.*;
	import java.awt.event.*;
	import java.io.*;
	
	import game_Progress.*;
	import developer_Mode.*;

	/* 메인 메뉴 GUI */


public class initialGUI extends JFrame {
		
		private JButton[] menuBar = new JButton[5];
		private String[] Str = {"게임시작", "이어하기", "게임방법", "개발자모드", "게임종료" };
		// 버튼은 순서대로 게임시작, 이어하기, 게임방법, 개발자모드, 게임종료를 가진다.
		
		Container c = getContentPane();
		// 프레임의 컨텐트팬을 알아낸다.
		JLabel Label = new JLabel("저장된 파일이 없습니다.");
		// 만약에 이어하기에서 UserData가 없는 경우에 출력하는 레이블
		
		
		// 생성자
		public  initialGUI() {
			setTitle("메인메뉴");		// 제목
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//x로 나가기
			c.setLayout(null);		//배치 관리자 제거
			c.setBackground(Color.WHITE);		// 배경색은 하얀색
			 
			JLabel Title  = new JLabel("농산품 관리 게임");		// 타이틀 JLabel
			Title.setLocation(300,30);				
			Title.setFont(new Font("궁서", Font.BOLD, 50));
			Title.setSize(600,200 );		// 크기와 위치 폰트 조절
			c.add(Title);		// 프레임에 부착
			
			// 5번 돌면서 5개의 버튼을 부착한다.
			for(int i=0; i<5; i++) {
			menuBar[i] = new JButton(Str[i]);		//해당 문자열을 가지는 버튼 생성
			menuBar[i].setLocation(400,200 + (100*i));
			menuBar[i].setFont(new Font("궁서", Font.BOLD, 30));
			menuBar[i].setBackground(Color.LIGHT_GRAY);
			menuBar[i].setSize(200,50 );		//위치와 폰트 배경색 크기 조절
			menuBar[i].addMouseListener(new ClickMouse());		// 마우스 클릭 리스너 들록
			c.add(menuBar[i]);		// 프레임에 부착
			}
			
			// @만든이가 누구인지 알려주는 레이블
			JLabel Maker  = new JLabel("Designed by brainKimDu");		
			Maker.setLocation(10,10);
			Maker.setFont(new Font("궁서", Font.BOLD, 20));
			Maker.setForeground(Color.DARK_GRAY);
			Maker.setSize(500,100);		// 객체생성, 위치조절, 폰트, 배경색, 크기 조절 후에 부착
			c.add(Maker);
			
			// @저장된 파일이 없으면 나타나는 레이블
			Label.setLocation(30,600);		
			Label.setFont(new Font("돋움d", Font.BOLD, 30));
			Label.setSize(800,200);
			Label.setVisible(false);
			c.add(Label);	//위치조절, 폰트, 배경색, 크기 조절 후에 부착
			
			
			setSize(1000,900);	// 프레임 크기
			setVisible(true);		// 보이게하세요.
		}
		
		/*
		 * 마우스 클릭에 관련한 리스너 클래스
		 */
		class ClickMouse extends MouseAdapter {			
			// 버튼이 클릭된 경우에 실행하는 메소드
			public void mousePressed(MouseEvent e) {
				JButton b = (JButton)e.getSource();	// 눌린 버튼이 무엇인지 찾는다.
				// 눌린버튼이 게임시작이라면
				if(b.getText().equals("게임시작")) {
					new insertinformation();	// 이름을 입력하는 GUI를 실행한다.
					setVisible(false);		// 현재창을 닫는다.
				}
				// 눌린버튼이 이어하기이라면
				if(b.getText().equals("이어하기")) {
					File file = new File("UserData.txt");		//UserData.txt파일이 있는지 확인하기위해 파일객체생성
					boolean isExists = file.exists();		// 파일이 있는지 판단하는 불린변수
					if(isExists) {		// 파일이 존재한다면
						System.out.println("UserData.txt가 있습니다."); 
						new gameGUI();		// 게임시작클래스 실행
						setVisible(false);		// 그리고 종료한다.
					} 
					else { 	// 없다면
					System.out.println("UserData.txt가 없습니다.");	 
					Label.setVisible(true);	// 없다는 것을 알려주는 레이블 보이게 한다.
					
					}
				}
				// 눌린버튼이 게임방법이라면
				if(b.getText().equals("게임방법")) {
					new HowToPlay();	// 게임방법 클래스 실행하고 
					setVisible(false);		// 보이지 않게 한다.
				}
				// 눌린버튼이 개발자 모드이라면
				if(b.getText().equals("개발자모드")) {
					new developer_mode();	// 개발자모드 클래스 실행하고
					setVisible(false);	//보이지 않게 한다.
				}
				// 눌린버튼이 게임종료이라면
				if(b.getText().equals("게임종료"))
					setVisible(false);	// 종료한다.
			}
		}
	}


