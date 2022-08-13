/*
- ���� (author)
 brainKimDu
- ���� ���� (date to create)
2020�� 5�� 15��
- ���� ���� (date to update)
2020�� 6�� 16��
- ���α׷� ����(purpose of the program)
	���θ޴��� ������ �����ϰų� ���ӹ���� ���ų� �̾��ϱ⸦ �� �� �ִ� GUI�̴�.
- �Լ�/�޼ҵ� (purpose of method)
	�����ڿ� Ŭ���޼ҵ�� ���� (GUI)
*/

package Initial_Screen;


	import java.awt.*;
	import javax.swing.*;
	import java.awt.event.*;
	import java.io.*;
	
	import game_Progress.*;
	import developer_Mode.*;

	/* ���� �޴� GUI */


public class initialGUI extends JFrame {
		
		private JButton[] menuBar = new JButton[5];
		private String[] Str = {"���ӽ���", "�̾��ϱ�", "���ӹ��", "�����ڸ��", "��������" };
		// ��ư�� ������� ���ӽ���, �̾��ϱ�, ���ӹ��, �����ڸ��, �������Ḧ ������.
		
		Container c = getContentPane();
		// �������� ����Ʈ���� �˾Ƴ���.
		JLabel Label = new JLabel("����� ������ �����ϴ�.");
		// ���࿡ �̾��ϱ⿡�� UserData�� ���� ��쿡 ����ϴ� ���̺�
		
		
		// ������
		public  initialGUI() {
			setTitle("���θ޴�");		// ����
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//x�� ������
			c.setLayout(null);		//��ġ ������ ����
			c.setBackground(Color.WHITE);		// ������ �Ͼ��
			 
			JLabel Title  = new JLabel("���ǰ ���� ����");		// Ÿ��Ʋ JLabel
			Title.setLocation(300,30);				
			Title.setFont(new Font("�ü�", Font.BOLD, 50));
			Title.setSize(600,200 );		// ũ��� ��ġ ��Ʈ ����
			c.add(Title);		// �����ӿ� ����
			
			// 5�� ���鼭 5���� ��ư�� �����Ѵ�.
			for(int i=0; i<5; i++) {
			menuBar[i] = new JButton(Str[i]);		//�ش� ���ڿ��� ������ ��ư ����
			menuBar[i].setLocation(400,200 + (100*i));
			menuBar[i].setFont(new Font("�ü�", Font.BOLD, 30));
			menuBar[i].setBackground(Color.LIGHT_GRAY);
			menuBar[i].setSize(200,50 );		//��ġ�� ��Ʈ ���� ũ�� ����
			menuBar[i].addMouseListener(new ClickMouse());		// ���콺 Ŭ�� ������ ���
			c.add(menuBar[i]);		// �����ӿ� ����
			}
			
			// @�����̰� �������� �˷��ִ� ���̺�
			JLabel Maker  = new JLabel("Designed by brainKimDu");		
			Maker.setLocation(10,10);
			Maker.setFont(new Font("�ü�", Font.BOLD, 20));
			Maker.setForeground(Color.DARK_GRAY);
			Maker.setSize(500,100);		// ��ü����, ��ġ����, ��Ʈ, ����, ũ�� ���� �Ŀ� ����
			c.add(Maker);
			
			// @����� ������ ������ ��Ÿ���� ���̺�
			Label.setLocation(30,600);		
			Label.setFont(new Font("����d", Font.BOLD, 30));
			Label.setSize(800,200);
			Label.setVisible(false);
			c.add(Label);	//��ġ����, ��Ʈ, ����, ũ�� ���� �Ŀ� ����
			
			
			setSize(1000,900);	// ������ ũ��
			setVisible(true);		// ���̰��ϼ���.
		}
		
		/*
		 * ���콺 Ŭ���� ������ ������ Ŭ����
		 */
		class ClickMouse extends MouseAdapter {			
			// ��ư�� Ŭ���� ��쿡 �����ϴ� �޼ҵ�
			public void mousePressed(MouseEvent e) {
				JButton b = (JButton)e.getSource();	// ���� ��ư�� �������� ã�´�.
				// ������ư�� ���ӽ����̶��
				if(b.getText().equals("���ӽ���")) {
					new insertinformation();	// �̸��� �Է��ϴ� GUI�� �����Ѵ�.
					setVisible(false);		// ����â�� �ݴ´�.
				}
				// ������ư�� �̾��ϱ��̶��
				if(b.getText().equals("�̾��ϱ�")) {
					File file = new File("UserData.txt");		//UserData.txt������ �ִ��� Ȯ���ϱ����� ���ϰ�ü����
					boolean isExists = file.exists();		// ������ �ִ��� �Ǵ��ϴ� �Ҹ�����
					if(isExists) {		// ������ �����Ѵٸ�
						System.out.println("UserData.txt�� �ֽ��ϴ�."); 
						new gameGUI();		// ���ӽ���Ŭ���� ����
						setVisible(false);		// �׸��� �����Ѵ�.
					} 
					else { 	// ���ٸ�
					System.out.println("UserData.txt�� �����ϴ�.");	 
					Label.setVisible(true);	// ���ٴ� ���� �˷��ִ� ���̺� ���̰� �Ѵ�.
					
					}
				}
				// ������ư�� ���ӹ���̶��
				if(b.getText().equals("���ӹ��")) {
					new HowToPlay();	// ���ӹ�� Ŭ���� �����ϰ� 
					setVisible(false);		// ������ �ʰ� �Ѵ�.
				}
				// ������ư�� ������ ����̶��
				if(b.getText().equals("�����ڸ��")) {
					new developer_mode();	// �����ڸ�� Ŭ���� �����ϰ�
					setVisible(false);	//������ �ʰ� �Ѵ�.
				}
				// ������ư�� ���������̶��
				if(b.getText().equals("��������"))
					setVisible(false);	// �����Ѵ�.
			}
		}
	}


