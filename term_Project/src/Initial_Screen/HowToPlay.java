/*
- 저자 (author)
 brainKimDu
- 만든 일자 (date to create)
2020년 5월 15일
- 수정 일자 (date to update)
2020년 6월 16일
- 프로그램 내용(purpose of the program)
	게임방법을 GUI로 보여주는 클래스
- 함수/메소드 (purpose of method)
	메인 메소드  : GUI를 담당한다.
*/


package Initial_Screen;
/* 게임방법 설명*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

// 메인클래스로 GUI를 담당한다.
public class HowToPlay extends JFrame {
	public HowToPlay() {
		setTitle("게임방법");		//제목
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//x로 나가기
		
		
		Container c = getContentPane();		// 프레임의 컨텐트팬 알아내기
		c.setLayout(null);		// 배치관리자 제거
		c.setBackground(Color.WHITE);		// 배경색 하얀색
		
		JLabel HowText2 = new JLabel("가장 저렴한 가격에 농산물을 구매하고, 가장 비싼가격에 판매하세요.\n");	// 레이블에 해당 문자열을 가지는 객체 생성
		HowText2.setFont(new Font("고딕", Font.BOLD, 20));		//레이블의 폰트 조절
		HowText2.setLocation(100,80);
		HowText2.setSize(900,500);		//레이블의 위치와 크기 조절
		c.add(HowText2);		//프레임 c에 부착한다.
		
		JLabel HowText3 = new JLabel("모든 농산물은 일요일에 구매할 수 있고, 그 외의 요일에 판매할 수 있습니다.\n");	// 레이블에 해당 문자열을 가지는 객체 생성
		HowText3.setFont(new Font("고딕", Font.BOLD, 20));		//레이블의 폰트 조절
		HowText3.setLocation(100,110);
		HowText3.setSize(900,500);		//레이블의 위치와 크기 조절
		c.add(HowText3);		//프레임 c에 부착한다.
		
		JLabel HowText4 = new JLabel("일요일이되면 모든 재고는 폐기됩니다. \n");	// 레이블에 해당 문자열을 가지는 객체 생성
		HowText4.setFont(new Font("고딕", Font.BOLD, 20));		//레이블의 폰트 조절
		HowText4.setLocation(100,140);
		HowText4.setSize(900,500);		//레이블의 위치와 크기 조절
		c.add(HowText4);		//프레임 c에 부착한다.
		
		// @ 메인메뉴로 돌아갈 JButton 생성
		JButton back = new JButton("뒤로가기");
		back.setSize(100,100);		
		back.setLocation(800,600);		// 크기와 위치 조절
		back.addMouseListener(new ClickMouse());		// 마우스 클릭 리스너 등록
		c.add(back);		// 프레임에 부착하기
		
		setSize(1000,900);	//프레임 크기 조절
		setVisible(true);		// 보이게 한다.
		
	}
	
	// 마우스가 눌리는 경우에 실행하는 마우스 클릭 리스너
	class ClickMouse extends MouseAdapter {			
		// 버튼을 클릭하는 경우
		public void mousePressed(MouseEvent e) {	
			new initialGUI();		// 메인화면을 나가고 현재 화면 종료 
			setVisible(false);
		}
	}
}
