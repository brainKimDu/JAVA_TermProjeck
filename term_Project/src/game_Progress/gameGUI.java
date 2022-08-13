/*
- 저자 (author)
 brainKimDu
- 만든 일자 (date to create)
2020년 5월 15일
- 수정 일자 (date to update)
2020년 6월 16일
- 프로그램 내용(purpose of the program)
	게임의 전반적인 모든 동작을 담당하는 클래스
- 함수/메소드 (purpose of method)
	public class gameGUI extends JFrame		: 게임의 전반적인 모든 동작과 GUI를 담당하는 클래스	( 구매, 판매, 레벨업 ) 
		public gameGUI() 			: 생성자로 GUI와 기타 계산들을 모두 담당한다.
			puchasesGUI();	// 구매 관련 GUI 
			SellGUI();		// 판매 관련 GUI
			levelUPGUI();	// 레벨업에 관련된 GUI
			TimeThGUI();	// 스레드 GUI
		class ClickMouse extends MouseAdapter : 마우스 입력에 대한 리스너 
		class TimerThread extends Thread	: 판매할 떄 30초안에 판매를 하게 구현하여 30초간 타이머가 동작하는 스레드이다.
		
- GUI와 자잘한 변수를 제외한 변수
		FileIO File = new FileIO();
	
	// @ 플레이어의 정보에 관련한 변수 
	player_Infor_Get userInfor = new player_Infor_Get("UserData.txt");		// txt파일을 통해  UserData.txt 파일을 가져온다.
	gamer_Information user = new gamer_Information(userInfor.returnInfor());	// UserData에서 가저온 문자열을 통해 유저 정보 객체 생성 
	stock playerstock = new stock();		// 재고 txt 에서 재고를 불러와 객체를 생성한다.
	today today = new today();			// 날짜 객체
	Purchase p = new Purchase();		// 모든 농작물 리스트를 가지는 객체를 생성해서
	makeproduct m = new makeproduct();	// 그 리스트에서 하나를 골라 농작물 객체를 만든다.
	product vegetable = new product(m.productname(), m.productprice(), m.productImage());
				// 판매를 하게될 농작물의 객체를 생성한다. 
	selectProduct originalPrice = new selectProduct();		// 원래의 가격을 가지는 농작물 객체를 생성하자.
	Sell S = new Sell();		// 판매에 관한 객체 생성
	int choiceprice = 0;		// 유저가 입력한 개당 판매가격
	int OriginalProductPrice = originalPrice.OriginalPrice(playerstock.returnproductname()); 
			// 원래의 가격은 플레이어의 재고에 들어있는 농산물의 이름을 통해 알아낸다.
	product Sellvegetable = new product(playerstock.returnproductname(), OriginalProductPrice, playerstock.returnimage());
			// 플레이어가 현재 가지고 있는 재고의 농산품을 판매해야함으로 재고.txt 객체의 농산물 이름을 받아와서 농산품 객체를 생성한다.
	int fixbugsell = 0;
			// 버그를 픽스하였다. 만패결과를 보고, 다시 판매할 개당 가격을 입력하지 못하게 하기 위해
*/
package game_Progress;

import fileIO.*;
import weather.*;
import Initial_Screen.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



// 메인 클래스로 GUI와 기타 동작들을 모두 담당한다.
public class gameGUI extends JFrame {
	
	// @ 스레드에서 사용하는 변수 
	JLabel ThLabel = new JLabel();		// 스레드 레이블 
	private TimerThread TimerTh = new  TimerThread(ThLabel);	// 타이머 스레드 객체 생성
	
	// @ 파일입출력에 관련한 파일입출력 객체 생성
	FileIO File = new FileIO();
	
	// @ 플레이어의 정보에 관련한 변수 
	String userData = File.player_Infor_Get("UserData.txt");		// txt파일을 통해  UserData.txt 파일을 가져온다.
	gamer_Information user = new gamer_Information(userData);	// UserData에서 가저온 문자열을 통해 유저 정보 객체 생성 
	stock playerstock = new stock();		// 재고 txt 에서 재고를 불러와 객체를 생성한다.
	today today = new today();			// 날짜 객체를 생성한다.
	
	// @ 구매와 관련한 변수
	Purchase p = new Purchase();		// 모든 농작물 리스트를 가지는 객체를 생성해서
	makeproduct m = new makeproduct();	// 그 리스트에서 하나를 골라 농작물 객체를 만든다.
	product vegetable = new product(m.product.getName(), m.product.getproductPrice(),
									m.product.getImage());
				// 판매를 하게될 농작물의 객체를 생성한다. 
	JTextField Field = new JTextField();		// 구매할 농작물의 개수를 입력받는다.
	JLabel PLabel[] = new JLabel[9];		// 구매하기 판매하기에서  공용으로 사용할 레이블
		// 0 : 구매하기
		// 1 : 오늘 판매할 농산물의 이름을 알려준다.
		// 2 : 오늘 판매할 농산물의 가격을 알려준다.
		// 3 : 가격변화 원인과 변동 퍼센트를 알려준다.
		// 4 : 몇개를 구매할 것인지 물어본다.
		// 5 : 구매하는 개수를 알려준다.	 판매하는 개수를 알려준다.
		// 6 : 얼마에 판매할 것이냐?
		// 7 : 유저가 원하는 개당 판매가격 출력
		// 8 : 판매가 몇% 되었는지 알려준다.
	
	JButton PButton[] = new JButton[3];		// 구매하기 판매하기에서 공용으로 사용할 레이블
	
	// @ 판매와 관련한 변수
	selectProduct originalPrice = new selectProduct();		// 원래의 가격을 가지는 농작물 리스트를 생성하자.
	Sell S = new Sell();		// 판매에 관한 객체 생성
	int choiceprice = 0;		// 유저가 입력한 개당 판매가격
	int OriginalProductPrice = originalPrice.OriginalPrice(playerstock.returnproductname()); 
			// 원래의 가격은 플레이어의 재고에 들어있는 농산물의 이름을 통해 알아낸다.
	product Sellvegetable = new product(playerstock.returnproductname(), OriginalProductPrice, playerstock.returnimage());
			// 플레이어가 현재 가지고 있는 재고의 농산품을 판매해야함으로 재고.txt 객체의 농산물 이름을 받아와서 농산품 객체를 생성한다.
	int fixbugsell = 0;
			// 버그를 픽스하였다. 판매결과를 보고, 다시 판매할 개당 가격을 입력하지 못하게 하기 위해
	
	JTextField SField= new JTextField();		// 판매할 개수를 입력한다.
	JTextField SField2 = new JTextField();		// 판매금액을 입력한다. 
	int EA = 0;		// 재고의 개수
	
	// @ 물류와 관련한 변수
	Move move = new Move();
	
	
	// @ 초기 뼈대를 구성하는 GUI
	JLabel Label[] = new JLabel[3];
		// 0 : 플레이어의 정보를 나타내는 레이블
		// 1 : 오늘은 무엇을 하는 날인가 알려주는 레이블
		// 2 : 일요일에 나타나는 레이블
	JButton button[] = new JButton[3];
		// 0 :  매수하기 혹은 매도하기 버튼
		// 1 : 	다음날로 가는 버튼
		// 2 :  구매하기 버튼		, 판매확정하기
		
	Container c = getContentPane();		// 컨텐트팬 알아내기
	
	JLabel STLabel = new JLabel(); 	 // 플레이어의 재고를 알려준다. 
	JButton mainMenuButton = new JButton("메인메뉴");		// 메인 메뉴로 나가는 버튼 
	
	
	// @레벨업에 사용하는 GUI
	JLabel Levelup[] = new JLabel[2];		// 레벨업에서 사용할 레이블	
		// 0 : 레벨업 가격
		// 1 : 레벨업 결과를 알려준다.
	JButton LevelupBu = new JButton();		// 레벨업 버튼
	int cost;		// 레벨업의 비용
	
	
	// @ 이미지 레이블
	JLabel imageLabel2 = new JLabel();	
	JLabel imageLabel = new JLabel();
	JLabel imageTruck[] = new JLabel[10];	// 재고에 따라 트럭을 보여준다.
	
	
	
	public gameGUI() {
		setTitle("메인메뉴");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setLayout(null);
		c.setBackground(Color.WHITE);
		
		main_GUI();	// GUI의 뼈대
		puchasesGUI();	// 구매 관련 GUI 
		SellGUI();		// 판매 관련 GUI
		levelUPGUI();	// 레벨업에 관련된 GUI
		
		// 스레드 시작지점 !
		TimeThGUI();
		
		
		

		setSize(1000,900);
		setVisible(true);		
	}
	
	// GUI의 뼈대를 담당하는 메소드
	public void main_GUI() {
		
		// @ 일요일에 나타나는 레이블
		Label[2] = new JLabel("");
		Label[2].setLocation(500,10);
		Label[2].setSize(500,50);
		c.add(Label[2]);
			// 만약 일요일 이라면
			if(user.gamerDay() == 1) {
				Label[2].setText("물품이 모두 폐기되었습니다. 매주 일요일 유지비 1000원이 결제되었습니다.");
			}		// 해당 문자열을 출력한다.
				
		// @ 플레이어의 현재 상태를 출력하는 레이블		
		Label[0] = new JLabel("이름 : " + user.gamerName() + "    자산: " +  user.gamerMoney() + 
							"    레벨: " + user.gamerLevel() + "    요일: " + today.getToday(user.gamerDay()));
		Label[0].setLocation(10,10);
		Label[0].setSize(1000,50);
		c.add(Label[0]);
		
		// @ 플레이어의 재고를 출력하는 레이블
		STLabel = new JLabel("현재 재고 " + playerstock.returnproductname() + " : " + playerstock.returnEA() + " 개 있습니다." );
		STLabel.setFont(new Font("고딕", Font.BOLD, 20));
		STLabel.setLocation(500, 30);
		STLabel.setSize(500, 50);
		c.add(STLabel);
		
		// @ 플레이어가 가지고 있는 재고에서 재고의 농산품에 대한 이미지를 출력하는 레이블
		imageLabel2.setSize(300,300);
		imageLabel2.setLocation(450,280);
		ImageIcon image2 = new ImageIcon(playerstock.returnimage());
		imageLabel2.setIcon(image2);
		c.add(imageLabel2);
		
		// @ 플레이어가 가지고 있는 재고의 개수 / 100 만큼 트럭의 개수가 나타난다. 
		for(int i = 0; i<user.gamerLevel(); i++) {		// 레벨만큼 돌면서
			if(playerstock.returnEA() != 0) {		// 0개 일때는 돌지않고
				if(i<(playerstock.returnEA()/100  +1 )) {		// 재고를 100으로 나눠서 1을 더한 값보다 작으면 진행한다.
					ImageIcon truk = new ImageIcon("트럭.png");	// 트럭 이미지를 불러와서
					imageTruck[i] = new JLabel(truk);	// 트럭레이블을 만들고, 프레임에 부착한다.
					imageTruck[i].setSize(100,50);
					imageTruck[i].setLocation(800,300 + (50 * i));
					c.add(imageTruck[i]);
				}
			}
		}
		
		
		// @ 오늘은 무엇을 하는 날인지 알려주는 레이블로 매입하기, 매도하기를 선택할 수 있다.
		Label[1] = new JLabel();
		Label[1].setLocation(10,30);
		Label[1].setSize(1000,50);
		
		// @ 매수하기 혹은 매도하기 버튼
		button[0] = new JButton();
		button[0].setLocation(10,700);
		button[0].setSize(200, 100);
			// 오늘이 일요일이면 매입을 하는 날이이다.
			if(today.getToday(user.gamerDay()) == "일요일") {
				Label[1].setText("오늘은 매입을 하는 날입니다.");		
				c.add(Label[1]);
				button[0].setText("매입하기");		// 버튼의 text를 매입하기로 바꾸고
				button[0].addMouseListener(new ClickMouse());	// 마우스 리스너를 등록한다.
				c.add(button[0]);
			}
			// 그 외의 요일에는 판매를 하게 된다
			else {	
				Label[1].setText("오늘은 판매를 하는 날입니다.");
				c.add(Label[1]);
				button[0].setText("매도하기");			//  버튼의 text를 매도하기로 바꾸고 	
				button[0].addMouseListener(new ClickMouse());	// 마우스 리스너를 등록한다.
				c.add(button[0]);
			}
		
		
		// 다음날로 이동하는 버튼
		button[1] = new JButton("다음날");
		button[1].setLocation(300,700);
		button[1].setSize(200,100);
		button[1].addMouseListener(new ClickMouse());		// 버튼이 눌릴 경우에 해당하는 마우스 리스너 등록
		c.add(button[1]);
		
		// 메인메뉴로 가는 버튼
		mainMenuButton.setLocation(500, 700);
		mainMenuButton.setSize(200,100);
		mainMenuButton.setBackground(Color.LIGHT_GRAY);
		mainMenuButton.addMouseListener(new ClickMouse());
		c.add(mainMenuButton);
		
		// 이미지를 그리기 때문에 리페인트를 해준다.
		c.repaint();
	}
	
	// 구매 관련 GUI 메소드
	public void puchasesGUI() {
		vegetable.changePrice(p.returnPercentage());	// 랜덤으로 생성한 농작물 객체
		
		// 판매 레이블 0
		PLabel[0] = new JLabel(" ");
		PLabel[0].setFont(new Font("돋움d", Font.BOLD, 50));
		PLabel[0].setLocation(30, 100);
		PLabel[0].setSize(500,100);
		PLabel[0].setVisible(false);
		c.add(PLabel[0]);
		
		// 판매 레이블 1~9
		for(int i=1; i<9; i++) {
		PLabel[i] = new JLabel(" ");
		PLabel[i].setFont(new Font("돋움d", Font.BOLD, 20));
		PLabel[i].setLocation(30, 100 + (50*i));
		PLabel[i].setSize(800,100);
		PLabel[i].setVisible(false);
		c.add(PLabel[i]);
		}
		
		// 버튼 2번의 구매하기를 누르면 총 구매가격을 계산해준다.
		button[2] = new JButton();
		button[2].setSize(200,100);
		button[2].setLocation(500, 700);
		button[2].addMouseListener(new ClickMouse());	// 버튼이 눌리는 경우의 클릭리스너 등록
		button[2].setVisible(false);
		c.add(button[2]);
		
		
		// @ 구매할 농산물의 개수를 입력하는 텍스트 필드
		Field = new JTextField();		
		Field.setSize(300,50);
		Field.setLocation(30, 400);
		Field.setVisible(false);
		c.add(Field);
		// 텍스트 필드에 입력하고 엔터를 누를 경우의 익명 액션 클래스
		Field.addActionListener(new ActionListener() {
			// 렌터 입력이 발생하는 경우
 			public void actionPerformed(ActionEvent e) {
				JTextField String = (JTextField)e.getSource();
				try {
						EA = Integer.parseInt(String.getText());	// 입력된 문자열 정수형으로 바꿔서 EA에 저장
						Field.setText("");		// 텍스트 필드 비우기
						PLabel[5].setSize(500, 100);
						PLabel[5].setLocation(30, 500);
						PLabel[5].setText("총 : " + EA + "개");		// 총 몇개 살거다라는 것을 알려준다.
						PLabel[5].setVisible(true);
			
						button[2].setText("구매하기");		// 2번 버튼의 텍스트를 구매하기로 바꾸고
						button[0].setVisible(false);	// 매수하기 매도하기 버튼을 안보이게한다.
						button[2].setVisible(true);
					}
				catch(NumberFormatException er) {		// 만약 정수형을 입력받지 못했다면
					Field.setText("");				// 텍스트 필드를 비우고
					PLabel[5].setLocation(30, 500);
					PLabel[5].setText("정수만 입력하셔야 합니다. 다시 입력하세요.");	// 해당 레이블을 보인다. 
					PLabel[5].setVisible(true);
				}
			}

		});
		
	}
	
	
	// 판매에 관련된 GUI
	public void SellGUI() {
		Sellvegetable.changePrice(S.returnPercentage());
		
		
		//  @ 판매할 개수를 적는 텍스트 필드
		SField = new JTextField();		
		SField.setSize(300,50);
		SField.setLocation(30, 400);
		SField.setVisible(false);
		c.add(SField);
		// 해당 텍스트 필드에서 입력이 발생한 경우
		SField.addActionListener(new ActionListener() {
			//엔터키를 입력한 경우
			public void actionPerformed(ActionEvent e) {
				JTextField String = (JTextField)e.getSource();
				try {
						EA = Integer.parseInt(String.getText());		// 입력한 개수를 정수형으로 저장한다.
						SField.setText("");			// 텍스트를 비윤다.
						PLabel[5].setSize(500, 100);
						PLabel[5].setLocation(30, 420);
						if(EA <= playerstock.returnEA()) {		// 플레이어의 재고보다 적게 입력해야 한다.
							PLabel[5].setText("총 : " + EA + "개");	// 5번 레이블에서 입력된 수를  레이블에 출력한다.
							PLabel[5].setVisible(true);		
			
							button[0].setVisible(false);		// 매수하기 매도하기 안보이게 한다.
							button[2].setVisible(false);		// 구매하기 판매하기 또한 안보이게 한다.
							SField2.setVisible(true);			// 다음 텍스트 필드가 보이게 한다.
							PLabel[7].setVisible(false);		// 7번 레이블을 안보이게 한다.	
				
							PLabel[6].setLocation(30, 450);		
							PLabel[6].setSize(500,100);
							PLabel[6].setText("개당 얼마에 판매하시겠습니까?");	// 얼마에 판매할 것인지 물어보는 레이블을 보이게 한다.
							PLabel[6].setVisible(true);
						}
						else{	// 현재 재고보다 많이 입력할 경우
							PLabel[5].setText("현재 재고보다 많이 판매할 수 없습니다. ");		//해당 레이블 문자열을 출력하고 
							PLabel[5].setVisible(true);		
			
							button[0].setVisible(false);		// 판매관련 레이블들을 안보이게 한다.
							button[2].setVisible(false);
							SField2.setVisible(false);
							PLabel[6].setVisible(false);
						}
				}
				catch(NumberFormatException er) {		// 만약에 정수이외의 것이 입력되었다면
					Field.setText("");
					PLabel[5].setLocation(30, 500);
					PLabel[5].setText("정수만 입력하셔야 합니다. 다시 입력하세요.");		// 해당 레이블을 출력한다.
					PLabel[5].setVisible(true);
				}
			}

		});
		
		fixbugsell = 1;	// 버그를 방지하기 위해 1로 한다, 판매가격을 보고 다시 가격을 적을 수 있는 것을 방지
		
		// @ 판매할 개당 가격를 적는 텍스트 필드
		SField2 = new JTextField();		
		SField2.setSize(300,50);
		SField2.setLocation(30, 530);
		SField2.setVisible(false);
		c.add(SField2);
		
		// 텍스트 필드의 이벤트 액션 리스너
		SField2.addActionListener(new ActionListener() {
			// 엔터키가 눌리는 경우
			public void actionPerformed(ActionEvent e) {
			JTextField String = (JTextField)e.getSource();	// 눌려진 값을 알아낸다.
			if(fixbugsell == 1) {		// 버그 픽스가 1이라면 진행한다.
				try {
				
					choiceprice = Integer.parseInt(String.getText());		// 유저가 입력한 가격을 저장하고
					SField2.setText("");		// 텍스트 필드 지우고
					PLabel[7].setSize(500, 100);
					PLabel[7].setLocation(30, 550);
					PLabel[7].setText("개당 " +choiceprice + " 원에 판매하시겠습니까?");	// 7번 레이블의 해당 문자 출력
					PLabel[7].setVisible(true);
			
					button[2].setText("판매확정하기");		// 2번 버튼의 텍스트를 판매확정하기로 변경한다.
					button[2].setBackground(Color.CYAN);
					button[2].setVisible(true);
			
					}
				catch(NumberFormatException er) {		// 만약 정수를 입력하지 않았다면
					Field.setText("");
					PLabel[5].setLocation(30, 500);
					PLabel[5].setText("정수만 입력하셔야 합니다. 다시 입력하세요.");	// 해당 레이블을 출력한다.
					PLabel[5].setVisible(true);
				
					}
				}
			
			else {		// 버그 픽스
				PLabel[5].setText("이미 판매가 완료되었습니다. 되돌릴 수 없습니다. 다음날로 이동하세요.");
			}
			
			}

		});
		
		
		
		
	}
	
	// 레벨업에 관련된 GUI
	public void levelUPGUI() {
		cost = user.gamerLevel() * 50000;		// 레벨업 비용은 유저레벨에 50000배
		Levelup[0] = new JLabel(" ");
		Levelup[0].setText("다음 레벨업 " + cost +"원 필요합니다.");		// 해당 GUI는 레벨업 비용을 알려준다.
		Levelup[0].setLocation(700,100);
		Levelup[0].setSize(500,100);
		c.add(Levelup[0]);
		
		Levelup[1] = new JLabel(" ");		// 레벨업 하는 경우 현재 레벨을 알려준다.
		Levelup[1].setLocation(700,200);
		Levelup[1].setSize(500,100);
		c.add(Levelup[1]);
		
		
		LevelupBu = new JButton("레벨업");		// 레벨업 버튼
		LevelupBu.setLocation(700,180);
		LevelupBu.setSize(100,50);
		LevelupBu.addMouseListener(new ClickMouse());		// 버튼이 눌릴 경우의 리스너
		c.add(LevelupBu);
		
	}
	
	// 스레드에서 사용하는 GUI 메소드 	(30초 동안  타이머를 작동한다)
	public void TimeThGUI() {
		ThLabel.setFont(new Font("고딕", Font.BOLD, 20));		// 폰트 
		ThLabel.setLocation(400, 600);		//위치
		ThLabel.setSize(500,50);		//크기
		c.add(ThLabel);		// 프레임에 붙인다.
	}
	
	
	// 버튼 입력에 대한 마우스리스너
	class ClickMouse extends MouseAdapter {			
		// 버튼이 눌리는 경우
		public void mousePressed(MouseEvent e) {
			JButton b = (JButton)e.getSource();	// 어떤 버튼이 눌렸는지 알아낸다.
			// 눌린 버튼이 다음날이라면
			if(b.getText().equals("다음날")) {
				// 만약 플레이어의 재고가 0이라면 일요일로 간다.
				if(playerstock.returnEA() == 0) {
					c.removeAll();			// 현재 GUI를 모두 지운다.
					user.setSunday();		// 일요일로 바꾸고
					user.setmoney(1000);	// 유지비 1000원
					// 만약 플레이어의 돈이 0보다 작다면
					if(user.gamerMoney() <= 0) {
						new GameOver();		// 게임오버 클래스를 실행하고
						setVisible(false);		// 현재 GUI를 종료한다.
					}
					else {		// 아니라면
					File.player_Infor_Make(user);		// 현재의 진행사항을 UserData.txt에 저장하고
					setVisible(false);		// 종료한다.
					
					new gameGUI();		// 현재 클래스를 다시 실행한다.
					}
					
				}
				// 현재 재고가 0이 아니라면
				else {		
				c.removeAll();	// 현재GUI를 모두 지운다.
				user.setDay();	// 다음날로 이동한다.
				if(user.gamerDay() == 1 ) 	// 만약 다음날이 일요일이면
					File.delete_File("재고.txt");		// 재고.txt를 삭제한다.
				File.player_Infor_Make(user);		// 현재의 진행사항을 UserData.txt에 저장하고
				setVisible(false);		// 종료하고
				
				new gameGUI();		// 현재 클래스를 다시 실행한다.
				}
			}
			
			// 눌린 버튼이 매입하기라면
			if(b.getText().equals("매입하기")) {
				mainMenuButton.setVisible(false);		// 메인메뉴로 나가는 버튼 비활성화
				
				// 버튼 2의 구매하기를 보이고, 매입하기 버튼은 보이지 않게한다.
				button[2].setText("구매하기");
				button[2].setVisible(true);
				button[0].setVisible(false);
				
				// PLabel은 구매하기 문자열을 출력한다.
				PLabel[0].setText("구매하기");
				PLabel[0].setVisible(true);
				
				// 오늘 판매할 농산품의 이름을 알려준다.
				PLabel[1].setText("오늘의 상품 : " + vegetable.getName());
				PLabel[1].setVisible(true);
				
				// 오늘 판매할 농산품의 가격을 알려준다.
				PLabel[2].setText("오늘의 가격 : " + vegetable.getproductPrice());
				PLabel[2].setVisible(true);
				
				// 농작물의 이미지를 표시한다.
				imageLabel.setSize(300,300);
				imageLabel.setLocation(500,350);
				ImageIcon image = new ImageIcon(vegetable.getImage());	// 농작물의 이미지를 아이콘으로 하여 Label에 생성
				imageLabel.setIcon(image);
				c.add(imageLabel);
					
				Double percentage = p.returnPercentage();	// 가격변화확률을 가져온다.
				// 가격변화원인과 변동퍼센트를 알려준다.
				PLabel[3].setText("가격변화 원인 : " + p.returnCase() + " / 변동 퍼센트 : " + percentage + " %"   );
				PLabel[3].setVisible(true);
				
				// 몇개 구매할 것인지 물어본다.
				PLabel[4].setText("몇개 구매하시겠습니까?");
				PLabel[4].setVisible(true);
			
				// 몇개를 입력할지 입력받는 텍스트 필드를 보이게한다.
				Field.setVisible(true);
				
				// 이미지가 있으므로 다시그린다.
				c.repaint();
				
			
				
			}
			
			// 눌린 버튼이 구매하기라면
			if(b.getText().equals("구매하기")) {
				// 입력한 수가 0이 아니여야지 동작한다.
				if(EA != 0) {
					// 유저는 레벨 X100 만 구매가능하다.
					if(EA < (user.gamerLevel() * 100) +1) {
						// 6번 레이블이 구매 개수와 총 가격을 알려준다.
						PLabel[6].setSize(800,100);
						PLabel[6].setLocation(30,600);
						PLabel[6].setText(vegetable.getName() + " 을 " + EA + " 개 구입합니다. 총 가격은 " + EA *vegetable.getproductPrice() + "입니다." );
						PLabel[6].setVisible(true);
						// 총가격보다 돈이 많다면
						if((EA *vegetable.getproductPrice()) <= user.gamerMoney()) {
							button[2].setVisible(false);
							button[0].setText("구매확정하기");		// 버튼을 해당 텍스트로 교체한다.
							button[0].setBackground(Color.CYAN);	// 배경색 하늘색
							button[0].setVisible(true);
						}
						else {	// 아니라면 돈이 부족한 경우이다.
							button[2].setVisible(false);
							button[0].setText("돈이 부족합니다.");		//해당 텍스트로 교체한다.
							button[0].setBackground(Color.RED);		// 배경색 빨간색
							button[0].setVisible(true);
						}
						
					}
					else {	// 만약 레벨보다 더 많은 양을 입력한 경우
						PLabel[6].setSize(800,100);
						PLabel[6].setLocation(30,600);
						// 6번 레이블을 통해 레벨이 부족함을 알린다.
						PLabel[6].setText("레벨이 부족합니다. 당신의 레벨은 현재 " + user.gamerLevel() + "입니다. 그러므로 총 " + user.gamerLevel()*100 + "개 구매가능합니다." );
						PLabel[6].setVisible(true);
						
					}
				}
				// 눌린 개수가 0일 경우
				if(EA == 0) {
					PLabel[6].setLocation(30,600);
					PLabel[6].setText("구매할 개수를 다시 입력하세요.");
					//구매할 개수를 다시 입력해달라고한다.
					PLabel[6].setVisible(true);
				}
			}
			
			// 눌린 버튼이 구매확정하기라면
			if(b.getText().equals("구매확정하기")){
				user.setmoney(EA*vegetable.getproductPrice());	// 판매가격 * 구매를 원하는 갯수를 플레이어의 돈에 뺀다.
				c.removeAll();		// 현재 GUI를 모두 지운다.
				user.setDay();		// 다음날로 이동하고
				File.player_Infor_Make(user);		// 파일입출력의 player_Infor_Make 클래스를 실행한다.
				setVisible(false);
				
				File.delete_File("재고.txt");		// 재고.txt를 삭제하고
				File.File_Input_product(vegetable.getName(), EA, vegetable.getImage());	
							// 구매한 농작물과 개수 이미지를 저장한다.
				
				new gameGUI();		// 해당 클래스를 다시 실행한다.
			}
				
			// 눌린 버튼이 매도하기라면	
			if(b.getText().equals("매도하기")) {
				mainMenuButton.setVisible(false);	// 메인 메뉴를 보이지 않게 한다.
				// 2번 버튼 판매하기 버튼
				button[2].setText("판매하기");
				button[2].setVisible(true);
				button[0].setVisible(false);
					
				// 0번 레이블을 판매하기러 바꾼다.
				PLabel[0].setText("판매하기");
				PLabel[0].setVisible(true);
				
				// 1번 레이블에 판매할 상품을 표시하고
				PLabel[1].setText("판매할 상품 : " +playerstock.returnproductname() );
				PLabel[1].setVisible(true);
				
				// 2번 레이블에 물류가격을 표시한다.
				PLabel[2].setText("물류가격 : " + move.returnMovePrice() * user.gamerLevel() + " 원인: " + move.returnCase());
				PLabel[2].setVisible(true);
				
				// 3번 레이블에 가격이 변하는 원인을 알려준다.
				PLabel[3].setText("가격변화 원인 : " + S.returnCase() );
				PLabel[3].setVisible(true);
				
				// 몇개를 팔건지 물어본다.
				PLabel[4].setText("몇개를 판매하시겠습니까? 원가 : " +  OriginalProductPrice + "원");
				PLabel[4].setVisible(true);
				
				// 판매에서 사용하는 텍스트 필드를 보이게한다.
				SField.setVisible(true);
				
				
				// 타이머를 시작한다.
				TimerTh.start();
				
				
			}
			
			
			// 눌린 버튼이 판매확정하기라면
			if(b.getText().equals("판매확정하기")) {
				// 8번 레이블을 비우고
				PLabel[8].setText("");
				PLabel[8].setLocation(30, 600);
				// 보이게 한다.
				PLabel[8].setVisible(true);
				
				// 소비자가를 계산한다. 	판매가에 마진가 1.1배를 곱한다.
				double consumerPrice = Sellvegetable.getproductPrice() * 1.1;
				double sellEA;	// 판매할 개수
				double totalprice;	// 총 가격
				// 만약 플레이어가 입력한 개당가격이 소비자가에 1.1배안이라면	100%판매완료
				if(choiceprice <= (consumerPrice*1.1)) {
					totalprice = (choiceprice*EA) - (move.returnMovePrice()* user.gamerLevel());
					user.Sellmoney((int)totalprice);
					// 그래서 총판매금액을 더하고 물류가격을 뺀다.	 물류비용은 레벨에 따라 증가한다.
					PLabel[8].setText("100% 판매완료  / " +  choiceprice + " X  " + EA  + " - " +
											move.returnMovePrice()* user.gamerLevel() + " = 이득 : " + (int)totalprice + " 원"   );		
					//100% 판매완료
				}
				// 만약 플레이어가 입력한 개당가격이 소비자가에 1.1배 에서 1.2배 사이라면 80% 판매완료
				if((choiceprice > (consumerPrice*1.1)) && (choiceprice <= (consumerPrice*1.2))) {
					 sellEA = EA * 0.8;		//판매 개수는 0.8배 된다.
					 totalprice = (choiceprice*sellEA -(move.returnMovePrice()* user.gamerLevel()));
					 // 총 가격은 80퍼 개수 곱하기 유저가 선택한 가격에 물류가격을 뺀 것
					user.Sellmoney((int)totalprice);
					// 유저 가격 조정
						PLabel[8].setText("80% 판매완료 나머지는 폐기처분  / "+  choiceprice + " X  " + (int)sellEA  + " - " +
								move.returnMovePrice()* user.gamerLevel() + " = 이득 : " + (int)totalprice + " 원" );	// 80퍼센트만 판매되고 나머지는 폐기처분된다.
				}
				// 1.2배에서 1.3배 라면		50% 판매완료
				if((choiceprice > (consumerPrice*1.2)) && (choiceprice <= (consumerPrice*1.3))){
					 sellEA = EA * 0.5;		// 입력한 재고중 반만 판매완료된다.
					 totalprice = ((choiceprice*sellEA) - (move.returnMovePrice() * user.gamerLevel()));
					user.Sellmoney((int)totalprice);
					PLabel[8].setText("50% 판매완료 나머지는 폐기처분 / "+  choiceprice + " X  " + (int)sellEA  + " - " +
							move.returnMovePrice()* user.gamerLevel() + " = 이득 : " + (int)totalprice + " 원" );	// 80퍼센트만 판매되고 나머지는 폐기처분된다.
		
				}
				// 만약 1.3배보다 높다면 모두 폐기처분된다.
				if(choiceprice > (consumerPrice*1.3)) {
					PLabel[8].setText("판매실패 모두 폐기처분되었음 ");
					user.setmoney(move.returnMovePrice()* user.gamerLevel());
					// 물류가격만큼 돈을 뺀다.
				}
				
				playerstock.sell(EA);		// 재고에 입력한 재고만큼 뺀다.
				
				// 재고가 0이라면 재고.txt를 삭제한다.
				if(playerstock.returnEA() == 0) {
					File.delete_File("재고.txt");
				}
				// 0보다 크면 
				if(playerstock.returnEA() > 0) {
					File.delete_File("재고.txt");		// 재고.txt를 삭제하고
					File.File_Input_product(playerstock.returnproductname(), playerstock.returnEA(), playerstock.returnimage());
					// 현재의 개수로 txt파일을 재작성한다.
				}
				
				fixbugsell = 0;	// 버그픽스를 다시 0으로 한다.
				
				
				button[2].setVisible(false);		// 구매확정하기 버튼을 보이지 않게하고
				button[1].setBackground(Color.RED);		// 1번 버튼을 빨간색으로 한다.
				
				TimerTh.interrupt();		// 판매가 완료되었으니 타이머 스레드 종료하자.
				ThLabel.setText("트럭이 출발했습니다.");	// 타이머 레이블을 해당 문자열로 바꾼다.
			}
			
			
			// 버튼의 텍스트가 레벨업인 경우
			if(b.getText().equals("레벨업")) {
				//	레벨업 가격보다 플레이어의 돈이 많아야 한다.
					if(user.gamerMoney() >= cost) {
						cost = user.gamerLevel() * 50000;		// 가격은 레벨 곱하기 50000
						user.Levelup(cost);	// user 객체의 레벨업 메소드를 사용한다.
						Label[0].setText("이름 : " + user.gamerName() + "    자산: " +  user.gamerMoney() + 
								"    레벨: " + user.gamerLevel() + "    요일: " + today.getToday(user.gamerDay()));
								// 레벨업을 하였음으로 해당 레이블을 최신화한다.
						Levelup[0].setText("다음 레벨업 " + (cost + 50000) +"원 필요합니다.");	// 다음 레벨업 가격을 표시
						Levelup[1].setText("레벨업하였습니다. 현재 레벨" + user.gamerLevel());	// 레벨업 결과와 현재의 레벨 알려준다.
					
						cost  += 50000;	// 레벨업 가격 인상
					}
					// 돈이 부족한 경우
					if(user.gamerMoney() < cost) {
						LevelupBu.setBackground(Color.RED);
						Levelup[1].setText("돈이 부족합니다.");		// 돈이 부족 함을 알린다.
					}
				
			}

			// 버튼의 텍스트가 메인메뉴인 경우
			if(b.getText().equals("메인메뉴")) {
				new initialGUI();		// 메인메뉴를 실행하고
				setVisible(false);		// 종료한다.
			}
		}
	}
	
	// 타이머 스레드로 스레드를 상속받는  스레드 클래스
	class TimerThread extends Thread{
		private JLabel timerLabel;		// 타이머 레이블
		
		// 생성자는 메인 GUI에서 타이머레이블을 인자로 받는다. 
		public TimerThread(JLabel timerLabel) {
			this.timerLabel = timerLabel;	// 현재의 타이머레이블을 인자로 받아온 타이머 레이블로 한다.
		}
		
		// 타이머 스레드의 동작
		public void run() {
			int n= 30;		// 30초 동안 타이머를 돌리므로 30으로 잡는다. 
			while(true) {		// 무한루프
				timerLabel.setText(Integer.toString(n) + "초 후에 트럭이 출발합니다." );
				n--;		// 30초 타이머를 작동
				if(n<10) {		// 10보다 작아지면 글자색을 빨간색으로 변경한다.
					timerLabel.setForeground(Color.RED);
				}
				
				if(n<0) {	// 0초가 되면
					timerLabel.setText("트럭이 출발했습니다!!!!");		// 트럭이 출발하고
					button[2].setVisible(false);		// 판매 버튼을 사라지게 만든다.
					button[1].setBackground(Color.CYAN);	// 다음날로 가는 버튼의 배경색을 하늘색으로 한다.
					break;
				}
			try {
				Thread.sleep(1000);	//1초간 대기
			}
			
			catch(InterruptedException e) {		// 만약 인터럽트가 발생한다면 종료한다.
				return;
			}
			}
			
		}
	}
	
}





		
