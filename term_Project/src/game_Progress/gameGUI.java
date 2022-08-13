/*
- ���� (author)
 brainKimDu
- ���� ���� (date to create)
2020�� 5�� 15��
- ���� ���� (date to update)
2020�� 6�� 16��
- ���α׷� ����(purpose of the program)
	������ �������� ��� ������ ����ϴ� Ŭ����
- �Լ�/�޼ҵ� (purpose of method)
	public class gameGUI extends JFrame		: ������ �������� ��� ���۰� GUI�� ����ϴ� Ŭ����	( ����, �Ǹ�, ������ ) 
		public gameGUI() 			: �����ڷ� GUI�� ��Ÿ ������ ��� ����Ѵ�.
			puchasesGUI();	// ���� ���� GUI 
			SellGUI();		// �Ǹ� ���� GUI
			levelUPGUI();	// �������� ���õ� GUI
			TimeThGUI();	// ������ GUI
		class ClickMouse extends MouseAdapter : ���콺 �Է¿� ���� ������ 
		class TimerThread extends Thread	: �Ǹ��� �� 30�ʾȿ� �ǸŸ� �ϰ� �����Ͽ� 30�ʰ� Ÿ�̸Ӱ� �����ϴ� �������̴�.
		
- GUI�� ������ ������ ������ ����
		FileIO File = new FileIO();
	
	// @ �÷��̾��� ������ ������ ���� 
	player_Infor_Get userInfor = new player_Infor_Get("UserData.txt");		// txt������ ����  UserData.txt ������ �����´�.
	gamer_Information user = new gamer_Information(userInfor.returnInfor());	// UserData���� ������ ���ڿ��� ���� ���� ���� ��ü ���� 
	stock playerstock = new stock();		// ��� txt ���� ��� �ҷ��� ��ü�� �����Ѵ�.
	today today = new today();			// ��¥ ��ü
	Purchase p = new Purchase();		// ��� ���۹� ����Ʈ�� ������ ��ü�� �����ؼ�
	makeproduct m = new makeproduct();	// �� ����Ʈ���� �ϳ��� ��� ���۹� ��ü�� �����.
	product vegetable = new product(m.productname(), m.productprice(), m.productImage());
				// �ǸŸ� �ϰԵ� ���۹��� ��ü�� �����Ѵ�. 
	selectProduct originalPrice = new selectProduct();		// ������ ������ ������ ���۹� ��ü�� ��������.
	Sell S = new Sell();		// �Ǹſ� ���� ��ü ����
	int choiceprice = 0;		// ������ �Է��� ���� �ǸŰ���
	int OriginalProductPrice = originalPrice.OriginalPrice(playerstock.returnproductname()); 
			// ������ ������ �÷��̾��� ��� ����ִ� ��깰�� �̸��� ���� �˾Ƴ���.
	product Sellvegetable = new product(playerstock.returnproductname(), OriginalProductPrice, playerstock.returnimage());
			// �÷��̾ ���� ������ �ִ� ����� ���ǰ�� �Ǹ��ؾ������� ���.txt ��ü�� ��깰 �̸��� �޾ƿͼ� ���ǰ ��ü�� �����Ѵ�.
	int fixbugsell = 0;
			// ���׸� �Ƚ��Ͽ���. ���а���� ����, �ٽ� �Ǹ��� ���� ������ �Է����� ���ϰ� �ϱ� ����
*/
package game_Progress;

import fileIO.*;
import weather.*;
import Initial_Screen.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



// ���� Ŭ������ GUI�� ��Ÿ ���۵��� ��� ����Ѵ�.
public class gameGUI extends JFrame {
	
	// @ �����忡�� ����ϴ� ���� 
	JLabel ThLabel = new JLabel();		// ������ ���̺� 
	private TimerThread TimerTh = new  TimerThread(ThLabel);	// Ÿ�̸� ������ ��ü ����
	
	// @ ��������¿� ������ ��������� ��ü ����
	FileIO File = new FileIO();
	
	// @ �÷��̾��� ������ ������ ���� 
	String userData = File.player_Infor_Get("UserData.txt");		// txt������ ����  UserData.txt ������ �����´�.
	gamer_Information user = new gamer_Information(userData);	// UserData���� ������ ���ڿ��� ���� ���� ���� ��ü ���� 
	stock playerstock = new stock();		// ��� txt ���� ��� �ҷ��� ��ü�� �����Ѵ�.
	today today = new today();			// ��¥ ��ü�� �����Ѵ�.
	
	// @ ���ſ� ������ ����
	Purchase p = new Purchase();		// ��� ���۹� ����Ʈ�� ������ ��ü�� �����ؼ�
	makeproduct m = new makeproduct();	// �� ����Ʈ���� �ϳ��� ��� ���۹� ��ü�� �����.
	product vegetable = new product(m.product.getName(), m.product.getproductPrice(),
									m.product.getImage());
				// �ǸŸ� �ϰԵ� ���۹��� ��ü�� �����Ѵ�. 
	JTextField Field = new JTextField();		// ������ ���۹��� ������ �Է¹޴´�.
	JLabel PLabel[] = new JLabel[9];		// �����ϱ� �Ǹ��ϱ⿡��  �������� ����� ���̺�
		// 0 : �����ϱ�
		// 1 : ���� �Ǹ��� ��깰�� �̸��� �˷��ش�.
		// 2 : ���� �Ǹ��� ��깰�� ������ �˷��ش�.
		// 3 : ���ݺ�ȭ ���ΰ� ���� �ۼ�Ʈ�� �˷��ش�.
		// 4 : ��� ������ ������ �����.
		// 5 : �����ϴ� ������ �˷��ش�.	 �Ǹ��ϴ� ������ �˷��ش�.
		// 6 : �󸶿� �Ǹ��� ���̳�?
		// 7 : ������ ���ϴ� ���� �ǸŰ��� ���
		// 8 : �ǸŰ� ��% �Ǿ����� �˷��ش�.
	
	JButton PButton[] = new JButton[3];		// �����ϱ� �Ǹ��ϱ⿡�� �������� ����� ���̺�
	
	// @ �Ǹſ� ������ ����
	selectProduct originalPrice = new selectProduct();		// ������ ������ ������ ���۹� ����Ʈ�� ��������.
	Sell S = new Sell();		// �Ǹſ� ���� ��ü ����
	int choiceprice = 0;		// ������ �Է��� ���� �ǸŰ���
	int OriginalProductPrice = originalPrice.OriginalPrice(playerstock.returnproductname()); 
			// ������ ������ �÷��̾��� ��� ����ִ� ��깰�� �̸��� ���� �˾Ƴ���.
	product Sellvegetable = new product(playerstock.returnproductname(), OriginalProductPrice, playerstock.returnimage());
			// �÷��̾ ���� ������ �ִ� ����� ���ǰ�� �Ǹ��ؾ������� ���.txt ��ü�� ��깰 �̸��� �޾ƿͼ� ���ǰ ��ü�� �����Ѵ�.
	int fixbugsell = 0;
			// ���׸� �Ƚ��Ͽ���. �ǸŰ���� ����, �ٽ� �Ǹ��� ���� ������ �Է����� ���ϰ� �ϱ� ����
	
	JTextField SField= new JTextField();		// �Ǹ��� ������ �Է��Ѵ�.
	JTextField SField2 = new JTextField();		// �Ǹűݾ��� �Է��Ѵ�. 
	int EA = 0;		// ����� ����
	
	// @ ������ ������ ����
	Move move = new Move();
	
	
	// @ �ʱ� ���븦 �����ϴ� GUI
	JLabel Label[] = new JLabel[3];
		// 0 : �÷��̾��� ������ ��Ÿ���� ���̺�
		// 1 : ������ ������ �ϴ� ���ΰ� �˷��ִ� ���̺�
		// 2 : �Ͽ��Ͽ� ��Ÿ���� ���̺�
	JButton button[] = new JButton[3];
		// 0 :  �ż��ϱ� Ȥ�� �ŵ��ϱ� ��ư
		// 1 : 	�������� ���� ��ư
		// 2 :  �����ϱ� ��ư		, �Ǹ�Ȯ���ϱ�
		
	Container c = getContentPane();		// ����Ʈ�� �˾Ƴ���
	
	JLabel STLabel = new JLabel(); 	 // �÷��̾��� ��� �˷��ش�. 
	JButton mainMenuButton = new JButton("���θ޴�");		// ���� �޴��� ������ ��ư 
	
	
	// @�������� ����ϴ� GUI
	JLabel Levelup[] = new JLabel[2];		// ���������� ����� ���̺�	
		// 0 : ������ ����
		// 1 : ������ ����� �˷��ش�.
	JButton LevelupBu = new JButton();		// ������ ��ư
	int cost;		// �������� ���
	
	
	// @ �̹��� ���̺�
	JLabel imageLabel2 = new JLabel();	
	JLabel imageLabel = new JLabel();
	JLabel imageTruck[] = new JLabel[10];	// ��� ���� Ʈ���� �����ش�.
	
	
	
	public gameGUI() {
		setTitle("���θ޴�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setLayout(null);
		c.setBackground(Color.WHITE);
		
		main_GUI();	// GUI�� ����
		puchasesGUI();	// ���� ���� GUI 
		SellGUI();		// �Ǹ� ���� GUI
		levelUPGUI();	// �������� ���õ� GUI
		
		// ������ �������� !
		TimeThGUI();
		
		
		

		setSize(1000,900);
		setVisible(true);		
	}
	
	// GUI�� ���븦 ����ϴ� �޼ҵ�
	public void main_GUI() {
		
		// @ �Ͽ��Ͽ� ��Ÿ���� ���̺�
		Label[2] = new JLabel("");
		Label[2].setLocation(500,10);
		Label[2].setSize(500,50);
		c.add(Label[2]);
			// ���� �Ͽ��� �̶��
			if(user.gamerDay() == 1) {
				Label[2].setText("��ǰ�� ��� ���Ǿ����ϴ�. ���� �Ͽ��� ������ 1000���� �����Ǿ����ϴ�.");
			}		// �ش� ���ڿ��� ����Ѵ�.
				
		// @ �÷��̾��� ���� ���¸� ����ϴ� ���̺�		
		Label[0] = new JLabel("�̸� : " + user.gamerName() + "    �ڻ�: " +  user.gamerMoney() + 
							"    ����: " + user.gamerLevel() + "    ����: " + today.getToday(user.gamerDay()));
		Label[0].setLocation(10,10);
		Label[0].setSize(1000,50);
		c.add(Label[0]);
		
		// @ �÷��̾��� ��� ����ϴ� ���̺�
		STLabel = new JLabel("���� ��� " + playerstock.returnproductname() + " : " + playerstock.returnEA() + " �� �ֽ��ϴ�." );
		STLabel.setFont(new Font("���", Font.BOLD, 20));
		STLabel.setLocation(500, 30);
		STLabel.setSize(500, 50);
		c.add(STLabel);
		
		// @ �÷��̾ ������ �ִ� ����� ����� ���ǰ�� ���� �̹����� ����ϴ� ���̺�
		imageLabel2.setSize(300,300);
		imageLabel2.setLocation(450,280);
		ImageIcon image2 = new ImageIcon(playerstock.returnimage());
		imageLabel2.setIcon(image2);
		c.add(imageLabel2);
		
		// @ �÷��̾ ������ �ִ� ����� ���� / 100 ��ŭ Ʈ���� ������ ��Ÿ����. 
		for(int i = 0; i<user.gamerLevel(); i++) {		// ������ŭ ���鼭
			if(playerstock.returnEA() != 0) {		// 0�� �϶��� �����ʰ�
				if(i<(playerstock.returnEA()/100  +1 )) {		// ��� 100���� ������ 1�� ���� ������ ������ �����Ѵ�.
					ImageIcon truk = new ImageIcon("Ʈ��.png");	// Ʈ�� �̹����� �ҷ��ͼ�
					imageTruck[i] = new JLabel(truk);	// Ʈ�����̺��� �����, �����ӿ� �����Ѵ�.
					imageTruck[i].setSize(100,50);
					imageTruck[i].setLocation(800,300 + (50 * i));
					c.add(imageTruck[i]);
				}
			}
		}
		
		
		// @ ������ ������ �ϴ� ������ �˷��ִ� ���̺�� �����ϱ�, �ŵ��ϱ⸦ ������ �� �ִ�.
		Label[1] = new JLabel();
		Label[1].setLocation(10,30);
		Label[1].setSize(1000,50);
		
		// @ �ż��ϱ� Ȥ�� �ŵ��ϱ� ��ư
		button[0] = new JButton();
		button[0].setLocation(10,700);
		button[0].setSize(200, 100);
			// ������ �Ͽ����̸� ������ �ϴ� �����̴�.
			if(today.getToday(user.gamerDay()) == "�Ͽ���") {
				Label[1].setText("������ ������ �ϴ� ���Դϴ�.");		
				c.add(Label[1]);
				button[0].setText("�����ϱ�");		// ��ư�� text�� �����ϱ�� �ٲٰ�
				button[0].addMouseListener(new ClickMouse());	// ���콺 �����ʸ� ����Ѵ�.
				c.add(button[0]);
			}
			// �� ���� ���Ͽ��� �ǸŸ� �ϰ� �ȴ�
			else {	
				Label[1].setText("������ �ǸŸ� �ϴ� ���Դϴ�.");
				c.add(Label[1]);
				button[0].setText("�ŵ��ϱ�");			//  ��ư�� text�� �ŵ��ϱ�� �ٲٰ� 	
				button[0].addMouseListener(new ClickMouse());	// ���콺 �����ʸ� ����Ѵ�.
				c.add(button[0]);
			}
		
		
		// �������� �̵��ϴ� ��ư
		button[1] = new JButton("������");
		button[1].setLocation(300,700);
		button[1].setSize(200,100);
		button[1].addMouseListener(new ClickMouse());		// ��ư�� ���� ��쿡 �ش��ϴ� ���콺 ������ ���
		c.add(button[1]);
		
		// ���θ޴��� ���� ��ư
		mainMenuButton.setLocation(500, 700);
		mainMenuButton.setSize(200,100);
		mainMenuButton.setBackground(Color.LIGHT_GRAY);
		mainMenuButton.addMouseListener(new ClickMouse());
		c.add(mainMenuButton);
		
		// �̹����� �׸��� ������ ������Ʈ�� ���ش�.
		c.repaint();
	}
	
	// ���� ���� GUI �޼ҵ�
	public void puchasesGUI() {
		vegetable.changePrice(p.returnPercentage());	// �������� ������ ���۹� ��ü
		
		// �Ǹ� ���̺� 0
		PLabel[0] = new JLabel(" ");
		PLabel[0].setFont(new Font("����d", Font.BOLD, 50));
		PLabel[0].setLocation(30, 100);
		PLabel[0].setSize(500,100);
		PLabel[0].setVisible(false);
		c.add(PLabel[0]);
		
		// �Ǹ� ���̺� 1~9
		for(int i=1; i<9; i++) {
		PLabel[i] = new JLabel(" ");
		PLabel[i].setFont(new Font("����d", Font.BOLD, 20));
		PLabel[i].setLocation(30, 100 + (50*i));
		PLabel[i].setSize(800,100);
		PLabel[i].setVisible(false);
		c.add(PLabel[i]);
		}
		
		// ��ư 2���� �����ϱ⸦ ������ �� ���Ű����� ������ش�.
		button[2] = new JButton();
		button[2].setSize(200,100);
		button[2].setLocation(500, 700);
		button[2].addMouseListener(new ClickMouse());	// ��ư�� ������ ����� Ŭ�������� ���
		button[2].setVisible(false);
		c.add(button[2]);
		
		
		// @ ������ ��깰�� ������ �Է��ϴ� �ؽ�Ʈ �ʵ�
		Field = new JTextField();		
		Field.setSize(300,50);
		Field.setLocation(30, 400);
		Field.setVisible(false);
		c.add(Field);
		// �ؽ�Ʈ �ʵ忡 �Է��ϰ� ���͸� ���� ����� �͸� �׼� Ŭ����
		Field.addActionListener(new ActionListener() {
			// ���� �Է��� �߻��ϴ� ���
 			public void actionPerformed(ActionEvent e) {
				JTextField String = (JTextField)e.getSource();
				try {
						EA = Integer.parseInt(String.getText());	// �Էµ� ���ڿ� ���������� �ٲ㼭 EA�� ����
						Field.setText("");		// �ؽ�Ʈ �ʵ� ����
						PLabel[5].setSize(500, 100);
						PLabel[5].setLocation(30, 500);
						PLabel[5].setText("�� : " + EA + "��");		// �� � ��Ŵٶ�� ���� �˷��ش�.
						PLabel[5].setVisible(true);
			
						button[2].setText("�����ϱ�");		// 2�� ��ư�� �ؽ�Ʈ�� �����ϱ�� �ٲٰ�
						button[0].setVisible(false);	// �ż��ϱ� �ŵ��ϱ� ��ư�� �Ⱥ��̰��Ѵ�.
						button[2].setVisible(true);
					}
				catch(NumberFormatException er) {		// ���� �������� �Է¹��� ���ߴٸ�
					Field.setText("");				// �ؽ�Ʈ �ʵ带 ����
					PLabel[5].setLocation(30, 500);
					PLabel[5].setText("������ �Է��ϼž� �մϴ�. �ٽ� �Է��ϼ���.");	// �ش� ���̺��� ���δ�. 
					PLabel[5].setVisible(true);
				}
			}

		});
		
	}
	
	
	// �Ǹſ� ���õ� GUI
	public void SellGUI() {
		Sellvegetable.changePrice(S.returnPercentage());
		
		
		//  @ �Ǹ��� ������ ���� �ؽ�Ʈ �ʵ�
		SField = new JTextField();		
		SField.setSize(300,50);
		SField.setLocation(30, 400);
		SField.setVisible(false);
		c.add(SField);
		// �ش� �ؽ�Ʈ �ʵ忡�� �Է��� �߻��� ���
		SField.addActionListener(new ActionListener() {
			//����Ű�� �Է��� ���
			public void actionPerformed(ActionEvent e) {
				JTextField String = (JTextField)e.getSource();
				try {
						EA = Integer.parseInt(String.getText());		// �Է��� ������ ���������� �����Ѵ�.
						SField.setText("");			// �ؽ�Ʈ�� ������.
						PLabel[5].setSize(500, 100);
						PLabel[5].setLocation(30, 420);
						if(EA <= playerstock.returnEA()) {		// �÷��̾��� ����� ���� �Է��ؾ� �Ѵ�.
							PLabel[5].setText("�� : " + EA + "��");	// 5�� ���̺��� �Էµ� ����  ���̺� ����Ѵ�.
							PLabel[5].setVisible(true);		
			
							button[0].setVisible(false);		// �ż��ϱ� �ŵ��ϱ� �Ⱥ��̰� �Ѵ�.
							button[2].setVisible(false);		// �����ϱ� �Ǹ��ϱ� ���� �Ⱥ��̰� �Ѵ�.
							SField2.setVisible(true);			// ���� �ؽ�Ʈ �ʵ尡 ���̰� �Ѵ�.
							PLabel[7].setVisible(false);		// 7�� ���̺��� �Ⱥ��̰� �Ѵ�.	
				
							PLabel[6].setLocation(30, 450);		
							PLabel[6].setSize(500,100);
							PLabel[6].setText("���� �󸶿� �Ǹ��Ͻðڽ��ϱ�?");	// �󸶿� �Ǹ��� ������ ����� ���̺��� ���̰� �Ѵ�.
							PLabel[6].setVisible(true);
						}
						else{	// ���� ����� ���� �Է��� ���
							PLabel[5].setText("���� ����� ���� �Ǹ��� �� �����ϴ�. ");		//�ش� ���̺� ���ڿ��� ����ϰ� 
							PLabel[5].setVisible(true);		
			
							button[0].setVisible(false);		// �ǸŰ��� ���̺���� �Ⱥ��̰� �Ѵ�.
							button[2].setVisible(false);
							SField2.setVisible(false);
							PLabel[6].setVisible(false);
						}
				}
				catch(NumberFormatException er) {		// ���࿡ �����̿��� ���� �ԷµǾ��ٸ�
					Field.setText("");
					PLabel[5].setLocation(30, 500);
					PLabel[5].setText("������ �Է��ϼž� �մϴ�. �ٽ� �Է��ϼ���.");		// �ش� ���̺��� ����Ѵ�.
					PLabel[5].setVisible(true);
				}
			}

		});
		
		fixbugsell = 1;	// ���׸� �����ϱ� ���� 1�� �Ѵ�, �ǸŰ����� ���� �ٽ� ������ ���� �� �ִ� ���� ����
		
		// @ �Ǹ��� ���� ���ݸ� ���� �ؽ�Ʈ �ʵ�
		SField2 = new JTextField();		
		SField2.setSize(300,50);
		SField2.setLocation(30, 530);
		SField2.setVisible(false);
		c.add(SField2);
		
		// �ؽ�Ʈ �ʵ��� �̺�Ʈ �׼� ������
		SField2.addActionListener(new ActionListener() {
			// ����Ű�� ������ ���
			public void actionPerformed(ActionEvent e) {
			JTextField String = (JTextField)e.getSource();	// ������ ���� �˾Ƴ���.
			if(fixbugsell == 1) {		// ���� �Ƚ��� 1�̶�� �����Ѵ�.
				try {
				
					choiceprice = Integer.parseInt(String.getText());		// ������ �Է��� ������ �����ϰ�
					SField2.setText("");		// �ؽ�Ʈ �ʵ� �����
					PLabel[7].setSize(500, 100);
					PLabel[7].setLocation(30, 550);
					PLabel[7].setText("���� " +choiceprice + " ���� �Ǹ��Ͻðڽ��ϱ�?");	// 7�� ���̺��� �ش� ���� ���
					PLabel[7].setVisible(true);
			
					button[2].setText("�Ǹ�Ȯ���ϱ�");		// 2�� ��ư�� �ؽ�Ʈ�� �Ǹ�Ȯ���ϱ�� �����Ѵ�.
					button[2].setBackground(Color.CYAN);
					button[2].setVisible(true);
			
					}
				catch(NumberFormatException er) {		// ���� ������ �Է����� �ʾҴٸ�
					Field.setText("");
					PLabel[5].setLocation(30, 500);
					PLabel[5].setText("������ �Է��ϼž� �մϴ�. �ٽ� �Է��ϼ���.");	// �ش� ���̺��� ����Ѵ�.
					PLabel[5].setVisible(true);
				
					}
				}
			
			else {		// ���� �Ƚ�
				PLabel[5].setText("�̹� �ǸŰ� �Ϸ�Ǿ����ϴ�. �ǵ��� �� �����ϴ�. �������� �̵��ϼ���.");
			}
			
			}

		});
		
		
		
		
	}
	
	// �������� ���õ� GUI
	public void levelUPGUI() {
		cost = user.gamerLevel() * 50000;		// ������ ����� ���������� 50000��
		Levelup[0] = new JLabel(" ");
		Levelup[0].setText("���� ������ " + cost +"�� �ʿ��մϴ�.");		// �ش� GUI�� ������ ����� �˷��ش�.
		Levelup[0].setLocation(700,100);
		Levelup[0].setSize(500,100);
		c.add(Levelup[0]);
		
		Levelup[1] = new JLabel(" ");		// ������ �ϴ� ��� ���� ������ �˷��ش�.
		Levelup[1].setLocation(700,200);
		Levelup[1].setSize(500,100);
		c.add(Levelup[1]);
		
		
		LevelupBu = new JButton("������");		// ������ ��ư
		LevelupBu.setLocation(700,180);
		LevelupBu.setSize(100,50);
		LevelupBu.addMouseListener(new ClickMouse());		// ��ư�� ���� ����� ������
		c.add(LevelupBu);
		
	}
	
	// �����忡�� ����ϴ� GUI �޼ҵ� 	(30�� ����  Ÿ�̸Ӹ� �۵��Ѵ�)
	public void TimeThGUI() {
		ThLabel.setFont(new Font("���", Font.BOLD, 20));		// ��Ʈ 
		ThLabel.setLocation(400, 600);		//��ġ
		ThLabel.setSize(500,50);		//ũ��
		c.add(ThLabel);		// �����ӿ� ���δ�.
	}
	
	
	// ��ư �Է¿� ���� ���콺������
	class ClickMouse extends MouseAdapter {			
		// ��ư�� ������ ���
		public void mousePressed(MouseEvent e) {
			JButton b = (JButton)e.getSource();	// � ��ư�� ���ȴ��� �˾Ƴ���.
			// ���� ��ư�� �������̶��
			if(b.getText().equals("������")) {
				// ���� �÷��̾��� ��� 0�̶�� �Ͽ��Ϸ� ����.
				if(playerstock.returnEA() == 0) {
					c.removeAll();			// ���� GUI�� ��� �����.
					user.setSunday();		// �Ͽ��Ϸ� �ٲٰ�
					user.setmoney(1000);	// ������ 1000��
					// ���� �÷��̾��� ���� 0���� �۴ٸ�
					if(user.gamerMoney() <= 0) {
						new GameOver();		// ���ӿ��� Ŭ������ �����ϰ�
						setVisible(false);		// ���� GUI�� �����Ѵ�.
					}
					else {		// �ƴ϶��
					File.player_Infor_Make(user);		// ������ ��������� UserData.txt�� �����ϰ�
					setVisible(false);		// �����Ѵ�.
					
					new gameGUI();		// ���� Ŭ������ �ٽ� �����Ѵ�.
					}
					
				}
				// ���� ��� 0�� �ƴ϶��
				else {		
				c.removeAll();	// ����GUI�� ��� �����.
				user.setDay();	// �������� �̵��Ѵ�.
				if(user.gamerDay() == 1 ) 	// ���� �������� �Ͽ����̸�
					File.delete_File("���.txt");		// ���.txt�� �����Ѵ�.
				File.player_Infor_Make(user);		// ������ ��������� UserData.txt�� �����ϰ�
				setVisible(false);		// �����ϰ�
				
				new gameGUI();		// ���� Ŭ������ �ٽ� �����Ѵ�.
				}
			}
			
			// ���� ��ư�� �����ϱ���
			if(b.getText().equals("�����ϱ�")) {
				mainMenuButton.setVisible(false);		// ���θ޴��� ������ ��ư ��Ȱ��ȭ
				
				// ��ư 2�� �����ϱ⸦ ���̰�, �����ϱ� ��ư�� ������ �ʰ��Ѵ�.
				button[2].setText("�����ϱ�");
				button[2].setVisible(true);
				button[0].setVisible(false);
				
				// PLabel�� �����ϱ� ���ڿ��� ����Ѵ�.
				PLabel[0].setText("�����ϱ�");
				PLabel[0].setVisible(true);
				
				// ���� �Ǹ��� ���ǰ�� �̸��� �˷��ش�.
				PLabel[1].setText("������ ��ǰ : " + vegetable.getName());
				PLabel[1].setVisible(true);
				
				// ���� �Ǹ��� ���ǰ�� ������ �˷��ش�.
				PLabel[2].setText("������ ���� : " + vegetable.getproductPrice());
				PLabel[2].setVisible(true);
				
				// ���۹��� �̹����� ǥ���Ѵ�.
				imageLabel.setSize(300,300);
				imageLabel.setLocation(500,350);
				ImageIcon image = new ImageIcon(vegetable.getImage());	// ���۹��� �̹����� ���������� �Ͽ� Label�� ����
				imageLabel.setIcon(image);
				c.add(imageLabel);
					
				Double percentage = p.returnPercentage();	// ���ݺ�ȭȮ���� �����´�.
				// ���ݺ�ȭ���ΰ� �����ۼ�Ʈ�� �˷��ش�.
				PLabel[3].setText("���ݺ�ȭ ���� : " + p.returnCase() + " / ���� �ۼ�Ʈ : " + percentage + " %"   );
				PLabel[3].setVisible(true);
				
				// � ������ ������ �����.
				PLabel[4].setText("� �����Ͻðڽ��ϱ�?");
				PLabel[4].setVisible(true);
			
				// ��� �Է����� �Է¹޴� �ؽ�Ʈ �ʵ带 ���̰��Ѵ�.
				Field.setVisible(true);
				
				// �̹����� �����Ƿ� �ٽñ׸���.
				c.repaint();
				
			
				
			}
			
			// ���� ��ư�� �����ϱ���
			if(b.getText().equals("�����ϱ�")) {
				// �Է��� ���� 0�� �ƴϿ����� �����Ѵ�.
				if(EA != 0) {
					// ������ ���� X100 �� ���Ű����ϴ�.
					if(EA < (user.gamerLevel() * 100) +1) {
						// 6�� ���̺��� ���� ������ �� ������ �˷��ش�.
						PLabel[6].setSize(800,100);
						PLabel[6].setLocation(30,600);
						PLabel[6].setText(vegetable.getName() + " �� " + EA + " �� �����մϴ�. �� ������ " + EA *vegetable.getproductPrice() + "�Դϴ�." );
						PLabel[6].setVisible(true);
						// �Ѱ��ݺ��� ���� ���ٸ�
						if((EA *vegetable.getproductPrice()) <= user.gamerMoney()) {
							button[2].setVisible(false);
							button[0].setText("����Ȯ���ϱ�");		// ��ư�� �ش� �ؽ�Ʈ�� ��ü�Ѵ�.
							button[0].setBackground(Color.CYAN);	// ���� �ϴû�
							button[0].setVisible(true);
						}
						else {	// �ƴ϶�� ���� ������ ����̴�.
							button[2].setVisible(false);
							button[0].setText("���� �����մϴ�.");		//�ش� �ؽ�Ʈ�� ��ü�Ѵ�.
							button[0].setBackground(Color.RED);		// ���� ������
							button[0].setVisible(true);
						}
						
					}
					else {	// ���� �������� �� ���� ���� �Է��� ���
						PLabel[6].setSize(800,100);
						PLabel[6].setLocation(30,600);
						// 6�� ���̺��� ���� ������ �������� �˸���.
						PLabel[6].setText("������ �����մϴ�. ����� ������ ���� " + user.gamerLevel() + "�Դϴ�. �׷��Ƿ� �� " + user.gamerLevel()*100 + "�� ���Ű����մϴ�." );
						PLabel[6].setVisible(true);
						
					}
				}
				// ���� ������ 0�� ���
				if(EA == 0) {
					PLabel[6].setLocation(30,600);
					PLabel[6].setText("������ ������ �ٽ� �Է��ϼ���.");
					//������ ������ �ٽ� �Է��ش޶���Ѵ�.
					PLabel[6].setVisible(true);
				}
			}
			
			// ���� ��ư�� ����Ȯ���ϱ���
			if(b.getText().equals("����Ȯ���ϱ�")){
				user.setmoney(EA*vegetable.getproductPrice());	// �ǸŰ��� * ���Ÿ� ���ϴ� ������ �÷��̾��� ���� ����.
				c.removeAll();		// ���� GUI�� ��� �����.
				user.setDay();		// �������� �̵��ϰ�
				File.player_Infor_Make(user);		// ����������� player_Infor_Make Ŭ������ �����Ѵ�.
				setVisible(false);
				
				File.delete_File("���.txt");		// ���.txt�� �����ϰ�
				File.File_Input_product(vegetable.getName(), EA, vegetable.getImage());	
							// ������ ���۹��� ���� �̹����� �����Ѵ�.
				
				new gameGUI();		// �ش� Ŭ������ �ٽ� �����Ѵ�.
			}
				
			// ���� ��ư�� �ŵ��ϱ���	
			if(b.getText().equals("�ŵ��ϱ�")) {
				mainMenuButton.setVisible(false);	// ���� �޴��� ������ �ʰ� �Ѵ�.
				// 2�� ��ư �Ǹ��ϱ� ��ư
				button[2].setText("�Ǹ��ϱ�");
				button[2].setVisible(true);
				button[0].setVisible(false);
					
				// 0�� ���̺��� �Ǹ��ϱⷯ �ٲ۴�.
				PLabel[0].setText("�Ǹ��ϱ�");
				PLabel[0].setVisible(true);
				
				// 1�� ���̺� �Ǹ��� ��ǰ�� ǥ���ϰ�
				PLabel[1].setText("�Ǹ��� ��ǰ : " +playerstock.returnproductname() );
				PLabel[1].setVisible(true);
				
				// 2�� ���̺� ���������� ǥ���Ѵ�.
				PLabel[2].setText("�������� : " + move.returnMovePrice() * user.gamerLevel() + " ����: " + move.returnCase());
				PLabel[2].setVisible(true);
				
				// 3�� ���̺� ������ ���ϴ� ������ �˷��ش�.
				PLabel[3].setText("���ݺ�ȭ ���� : " + S.returnCase() );
				PLabel[3].setVisible(true);
				
				// ��� �Ȱ��� �����.
				PLabel[4].setText("��� �Ǹ��Ͻðڽ��ϱ�? ���� : " +  OriginalProductPrice + "��");
				PLabel[4].setVisible(true);
				
				// �Ǹſ��� ����ϴ� �ؽ�Ʈ �ʵ带 ���̰��Ѵ�.
				SField.setVisible(true);
				
				
				// Ÿ�̸Ӹ� �����Ѵ�.
				TimerTh.start();
				
				
			}
			
			
			// ���� ��ư�� �Ǹ�Ȯ���ϱ���
			if(b.getText().equals("�Ǹ�Ȯ���ϱ�")) {
				// 8�� ���̺��� ����
				PLabel[8].setText("");
				PLabel[8].setLocation(30, 600);
				// ���̰� �Ѵ�.
				PLabel[8].setVisible(true);
				
				// �Һ��ڰ��� ����Ѵ�. 	�ǸŰ��� ������ 1.1�踦 ���Ѵ�.
				double consumerPrice = Sellvegetable.getproductPrice() * 1.1;
				double sellEA;	// �Ǹ��� ����
				double totalprice;	// �� ����
				// ���� �÷��̾ �Է��� ���簡���� �Һ��ڰ��� 1.1����̶��	100%�ǸſϷ�
				if(choiceprice <= (consumerPrice*1.1)) {
					totalprice = (choiceprice*EA) - (move.returnMovePrice()* user.gamerLevel());
					user.Sellmoney((int)totalprice);
					// �׷��� ���Ǹűݾ��� ���ϰ� ���������� ����.	 ��������� ������ ���� �����Ѵ�.
					PLabel[8].setText("100% �ǸſϷ�  / " +  choiceprice + " X  " + EA  + " - " +
											move.returnMovePrice()* user.gamerLevel() + " = �̵� : " + (int)totalprice + " ��"   );		
					//100% �ǸſϷ�
				}
				// ���� �÷��̾ �Է��� ���簡���� �Һ��ڰ��� 1.1�� ���� 1.2�� ���̶�� 80% �ǸſϷ�
				if((choiceprice > (consumerPrice*1.1)) && (choiceprice <= (consumerPrice*1.2))) {
					 sellEA = EA * 0.8;		//�Ǹ� ������ 0.8�� �ȴ�.
					 totalprice = (choiceprice*sellEA -(move.returnMovePrice()* user.gamerLevel()));
					 // �� ������ 80�� ���� ���ϱ� ������ ������ ���ݿ� ���������� �� ��
					user.Sellmoney((int)totalprice);
					// ���� ���� ����
						PLabel[8].setText("80% �ǸſϷ� �������� ���ó��  / "+  choiceprice + " X  " + (int)sellEA  + " - " +
								move.returnMovePrice()* user.gamerLevel() + " = �̵� : " + (int)totalprice + " ��" );	// 80�ۼ�Ʈ�� �Ǹŵǰ� �������� ���ó�еȴ�.
				}
				// 1.2�迡�� 1.3�� ���		50% �ǸſϷ�
				if((choiceprice > (consumerPrice*1.2)) && (choiceprice <= (consumerPrice*1.3))){
					 sellEA = EA * 0.5;		// �Է��� ����� �ݸ� �ǸſϷ�ȴ�.
					 totalprice = ((choiceprice*sellEA) - (move.returnMovePrice() * user.gamerLevel()));
					user.Sellmoney((int)totalprice);
					PLabel[8].setText("50% �ǸſϷ� �������� ���ó�� / "+  choiceprice + " X  " + (int)sellEA  + " - " +
							move.returnMovePrice()* user.gamerLevel() + " = �̵� : " + (int)totalprice + " ��" );	// 80�ۼ�Ʈ�� �Ǹŵǰ� �������� ���ó�еȴ�.
		
				}
				// ���� 1.3�躸�� ���ٸ� ��� ���ó�еȴ�.
				if(choiceprice > (consumerPrice*1.3)) {
					PLabel[8].setText("�ǸŽ��� ��� ���ó�еǾ��� ");
					user.setmoney(move.returnMovePrice()* user.gamerLevel());
					// �������ݸ�ŭ ���� ����.
				}
				
				playerstock.sell(EA);		// ��� �Է��� ���ŭ ����.
				
				// ��� 0�̶�� ���.txt�� �����Ѵ�.
				if(playerstock.returnEA() == 0) {
					File.delete_File("���.txt");
				}
				// 0���� ũ�� 
				if(playerstock.returnEA() > 0) {
					File.delete_File("���.txt");		// ���.txt�� �����ϰ�
					File.File_Input_product(playerstock.returnproductname(), playerstock.returnEA(), playerstock.returnimage());
					// ������ ������ txt������ ���ۼ��Ѵ�.
				}
				
				fixbugsell = 0;	// �����Ƚ��� �ٽ� 0���� �Ѵ�.
				
				
				button[2].setVisible(false);		// ����Ȯ���ϱ� ��ư�� ������ �ʰ��ϰ�
				button[1].setBackground(Color.RED);		// 1�� ��ư�� ���������� �Ѵ�.
				
				TimerTh.interrupt();		// �ǸŰ� �Ϸ�Ǿ����� Ÿ�̸� ������ ��������.
				ThLabel.setText("Ʈ���� ����߽��ϴ�.");	// Ÿ�̸� ���̺��� �ش� ���ڿ��� �ٲ۴�.
			}
			
			
			// ��ư�� �ؽ�Ʈ�� �������� ���
			if(b.getText().equals("������")) {
				//	������ ���ݺ��� �÷��̾��� ���� ���ƾ� �Ѵ�.
					if(user.gamerMoney() >= cost) {
						cost = user.gamerLevel() * 50000;		// ������ ���� ���ϱ� 50000
						user.Levelup(cost);	// user ��ü�� ������ �޼ҵ带 ����Ѵ�.
						Label[0].setText("�̸� : " + user.gamerName() + "    �ڻ�: " +  user.gamerMoney() + 
								"    ����: " + user.gamerLevel() + "    ����: " + today.getToday(user.gamerDay()));
								// �������� �Ͽ������� �ش� ���̺��� �ֽ�ȭ�Ѵ�.
						Levelup[0].setText("���� ������ " + (cost + 50000) +"�� �ʿ��մϴ�.");	// ���� ������ ������ ǥ��
						Levelup[1].setText("�������Ͽ����ϴ�. ���� ����" + user.gamerLevel());	// ������ ����� ������ ���� �˷��ش�.
					
						cost  += 50000;	// ������ ���� �λ�
					}
					// ���� ������ ���
					if(user.gamerMoney() < cost) {
						LevelupBu.setBackground(Color.RED);
						Levelup[1].setText("���� �����մϴ�.");		// ���� ���� ���� �˸���.
					}
				
			}

			// ��ư�� �ؽ�Ʈ�� ���θ޴��� ���
			if(b.getText().equals("���θ޴�")) {
				new initialGUI();		// ���θ޴��� �����ϰ�
				setVisible(false);		// �����Ѵ�.
			}
		}
	}
	
	// Ÿ�̸� ������� �����带 ��ӹ޴�  ������ Ŭ����
	class TimerThread extends Thread{
		private JLabel timerLabel;		// Ÿ�̸� ���̺�
		
		// �����ڴ� ���� GUI���� Ÿ�̸ӷ��̺��� ���ڷ� �޴´�. 
		public TimerThread(JLabel timerLabel) {
			this.timerLabel = timerLabel;	// ������ Ÿ�̸ӷ��̺��� ���ڷ� �޾ƿ� Ÿ�̸� ���̺�� �Ѵ�.
		}
		
		// Ÿ�̸� �������� ����
		public void run() {
			int n= 30;		// 30�� ���� Ÿ�̸Ӹ� �����Ƿ� 30���� ��´�. 
			while(true) {		// ���ѷ���
				timerLabel.setText(Integer.toString(n) + "�� �Ŀ� Ʈ���� ����մϴ�." );
				n--;		// 30�� Ÿ�̸Ӹ� �۵�
				if(n<10) {		// 10���� �۾����� ���ڻ��� ���������� �����Ѵ�.
					timerLabel.setForeground(Color.RED);
				}
				
				if(n<0) {	// 0�ʰ� �Ǹ�
					timerLabel.setText("Ʈ���� ����߽��ϴ�!!!!");		// Ʈ���� ����ϰ�
					button[2].setVisible(false);		// �Ǹ� ��ư�� ������� �����.
					button[1].setBackground(Color.CYAN);	// �������� ���� ��ư�� ������ �ϴû����� �Ѵ�.
					break;
				}
			try {
				Thread.sleep(1000);	//1�ʰ� ���
			}
			
			catch(InterruptedException e) {		// ���� ���ͷ�Ʈ�� �߻��Ѵٸ� �����Ѵ�.
				return;
			}
			}
			
		}
	}
	
}





		
