/*
- 저자 (author)
brainKimDu
- 만든 일자 (date to create)
2020년 5월 15일
- 수정 일자 (date to update)
2020년 6월 16일
- 프로그램 내용(purpose of the program)
	게임에서 패배한 경우 출력하는 클래스 GUI
- 함수/메소드 (purpose of method)
	생성자를 통해 게임패배를 알리고 모든 UserData와 재고 txt를 삭제한다.
*/


package game_Progress;

import fileIO.*;
import game_Progress.gameGUI.ClickMouse;
import Initial_Screen.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// 메인클래스로 JFrame을 상속받는다.
public class GameOver extends JFrame {
	//파일 입출력에 사용하기 위해 객체를 생성한다.
	FileIO File = new FileIO();
	
	// 생성자
	public GameOver() {
		setTitle("메인메뉴");		// 제목
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x로 종료
		Container c = getContentPane();		// 컨텐트팬 알아내기
		c.setLayout(null);		//배치관리자 제거
		c.setBackground(Color.CYAN);		// 배경색 하늘색
		
		// @ 게임오버를 나타내는 레이블
		JLabel Label = new JLabel("ㅠㅠ게임오버ㅠㅠ");	// 객체
		Label.setLocation(400,50);		//위치
		Label.setFont(new Font("돋움d", Font.BOLD, 30));	//폰트
		Label.setSize(400,400);		//크기
		c.add(Label);		//프레임 등록
		
		// @ 메인메뉴로 나갈 수 있는 버튼
		JButton Button = new JButton("메인메뉴");	//객체
		Button.setLocation(300,700);		// 위치
		Button.setSize(400,100);		//크기
		Button.setBackground(Color.white);		// 배경색
		Button.addMouseListener(new ClickMouse());		// 마우스 클릭에 관한 리스너
		c.add(Button);		// 프레임에 등록
		
		setSize(1000,900);
		setVisible(true);		//프레임 크기와 프레임을 보이게 한다.
		
	}
	
	// 마우스 클릭에 관한 클래스
	class ClickMouse extends MouseAdapter {			
		// 버튼이 클릭된 경우 실행하는 메소드
		public void mousePressed(MouseEvent e) {
			JButton b = (JButton)e.getSource();		// 어떤 버튼이 눌렸는지 알아낸다.
			//눌린 버튼이 메인메뉴라면
			if(b.getText().equals("메인메뉴")) {	
				File.delete_File("UserData.txt");
				File.delete_File("재고.txt");		// userdata.txt와 재고.txt를 삭제한다.
				new initialGUI();		// 메인메뉴를 실행하고 
				setVisible(false);		// 현재 클래스를 종료한다.
			}
		}
	}
}
