/*
- 저자 (author)
 brainKimDu
- 만든 일자 (date to create)
2020년 5월 15일
- 수정 일자 (date to update)
2020년 6월 16일
- 프로그램 내용(purpose of the program)
	첫시작시에 이름을 입력하여 UserData.txt를 작성하는 Gui 클래스
- 함수/메소드 (purpose of method)
	GUI를 담당하는 생성자와 클릭마우스리스너로 구성
*/

package Initial_Screen;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import fileIO.*;

import game_Progress.*;


// 메인 클래스로 정보를 입력받는 클래스
public class insertinformation extends JFrame {
	
	public String UserName;		// 우저이름을 가지는 문자열 변수
	JLabel check = new JLabel();	// 이름이 입력되었는지 채크하는 레이블
	Container c = getContentPane();	//컨텐트팬 알아내기
	FileIO File = new FileIO();		// 파일입출력 클래스의 객체 생성
	
	// 생성자
	public insertinformation() {
		c.setLayout(null);		//배치관리자 제거
		c.setBackground(Color.WHITE);	// 배경색 하얀색
		
		// @ 당신의 이름은 하고 물어보는 레이블
		JLabel yourname = new JLabel("당신의 이름은? (입력 후 Enter를 클릭하세요.) 저장데이터가 삭제됩니다.");	// 객체
		yourname.setSize(800, 200);		//크기
		yourname.setLocation(100, 50);	//위치
		yourname.setFont(new Font("고딕", Font.BOLD, 20));	//폰트
		c.add(yourname);		//등록
		
		// @ 이름을 입력받는 텍스트필드 객체 
		JTextField Field = new JTextField();		//객체
		Field.setSize(300,50);			//크기
		Field.setLocation(300, 200);		//위치
		c.add(Field);		//등록
		
		// @ 이름을 입력하였는지 여부를 판단
		check = new JLabel(" ");		// 객체생성
		check.setSize(800, 200);		//크기
		check.setLocation(250, 350);	//위치
		check.setFont(new Font("고딕", Font.BOLD, 20));	//폰트
		c.add(check);		//등록
		
		// 텍스트 필드에서 엔터 입력이 발생한 경우의 액션리스너클래스 (익명)
		Field.addActionListener(new ActionListener() {
			// 엔터입력이 발생한 경우 메소드
			public void actionPerformed(ActionEvent e) {
				JTextField name = (JTextField)e.getSource();	// 입력된 문자열을 알아낸다.
				UserName = name.getText();		// 이름에 입력된 문자열을 저장한다.
				UserName = UserName.replace(',',' ');	// 만약에 ,가 있다면 뛰어쓰기로 변경한다.
				Field.setText(" ");		//필드를 비운다
				File.player_Infor_Make(UserName, 10000, 1, 1);	// 이름과 기본적으로 주어지는 돈10000, 레벨 1, 1 = 일요일 을 저장한다.
							//UserData.txt 생성한다.
				check.setText("당신의 이름은 " + UserName + " \"다음\" 버튼을 눌러 게임을 시작합니다.");	// 입력여부를 채크하는 레이블의 텍스트를 변경한다.
			}
		});
		

		//@ 게임을 시작하는 버튼 
		JButton next = new JButton("다음");		//객체
		next.setSize(500,100);			//크기
		next.setLocation(200,550);		//위치
		next.setFont(new Font("고딕", Font.BOLD, 20));		//폰트
		next.setBackground(Color.CYAN);			//배경색
		next.addMouseListener(new ClickMouse());		// 마우스 클릭 리스너 등록
		c.add(next);			// 프레임 등록
		
		// @ 메인메유로 가는 버튼
		JButton back = new JButton("메인메뉴");		// 객체
		back.setSize(500,100);			//크기
		back.setLocation(200,700);		//위치
		back.setFont(new Font("고딕", Font.BOLD, 20));		//폰트
		back.setBackground(Color.LIGHT_GRAY);		//배경색
		back.addMouseListener(new ClickMouse());		//클릭 메소드 실행
		c.add(back);			//등록
		
		
		setSize(1000,900);
		setVisible(true);		//프레임 크기와 보이게하기
	}
	
	// 마우스 클릭에 관한 리스너
	class ClickMouse extends MouseAdapter {	
		// 버튼이 눌리는 경우에 실행하는 메소드
		public void mousePressed(MouseEvent EVe) {	
			JButton b = (JButton)EVe.getSource();	// 눌린 버튼이 무엇인지 알아냅니다.
			if(UserName != null) {		// UserName이 입력되었다면
				File.delete_File("재고.txt");				// 재고를 삭제하고
				new gameGUI();		//게임시작으로 갑니다.
				setVisible(false);		// 종료합니다.
			}
			
			else
				check.setText("당신의 이름을 먼저 입력하세요.");	//이름을 입력하지 않았다면 레이블을 출력합니다.
		
			//	눈린 버튼이 메인메뉴라면
			if(b.getText().equals("메인메뉴")) {
				new initialGUI();	// 메인메뉴로 가고
				setVisible(false);	// 현재 창을 종료합니다.
			}
			
		}
	}
	
	
	
}

