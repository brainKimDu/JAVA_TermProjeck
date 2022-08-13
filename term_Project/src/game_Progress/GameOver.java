/*
- ���� (author)
brainKimDu
- ���� ���� (date to create)
2020�� 5�� 15��
- ���� ���� (date to update)
2020�� 6�� 16��
- ���α׷� ����(purpose of the program)
	���ӿ��� �й��� ��� ����ϴ� Ŭ���� GUI
- �Լ�/�޼ҵ� (purpose of method)
	�����ڸ� ���� �����й踦 �˸��� ��� UserData�� ��� txt�� �����Ѵ�.
*/


package game_Progress;

import fileIO.*;
import game_Progress.gameGUI.ClickMouse;
import Initial_Screen.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// ����Ŭ������ JFrame�� ��ӹ޴´�.
public class GameOver extends JFrame {
	//���� ����¿� ����ϱ� ���� ��ü�� �����Ѵ�.
	FileIO File = new FileIO();
	
	// ������
	public GameOver() {
		setTitle("���θ޴�");		// ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x�� ����
		Container c = getContentPane();		// ����Ʈ�� �˾Ƴ���
		c.setLayout(null);		//��ġ������ ����
		c.setBackground(Color.CYAN);		// ���� �ϴû�
		
		// @ ���ӿ����� ��Ÿ���� ���̺�
		JLabel Label = new JLabel("�Фа��ӿ����Ф�");	// ��ü
		Label.setLocation(400,50);		//��ġ
		Label.setFont(new Font("����d", Font.BOLD, 30));	//��Ʈ
		Label.setSize(400,400);		//ũ��
		c.add(Label);		//������ ���
		
		// @ ���θ޴��� ���� �� �ִ� ��ư
		JButton Button = new JButton("���θ޴�");	//��ü
		Button.setLocation(300,700);		// ��ġ
		Button.setSize(400,100);		//ũ��
		Button.setBackground(Color.white);		// ����
		Button.addMouseListener(new ClickMouse());		// ���콺 Ŭ���� ���� ������
		c.add(Button);		// �����ӿ� ���
		
		setSize(1000,900);
		setVisible(true);		//������ ũ��� �������� ���̰� �Ѵ�.
		
	}
	
	// ���콺 Ŭ���� ���� Ŭ����
	class ClickMouse extends MouseAdapter {			
		// ��ư�� Ŭ���� ��� �����ϴ� �޼ҵ�
		public void mousePressed(MouseEvent e) {
			JButton b = (JButton)e.getSource();		// � ��ư�� ���ȴ��� �˾Ƴ���.
			//���� ��ư�� ���θ޴����
			if(b.getText().equals("���θ޴�")) {	
				File.delete_File("UserData.txt");
				File.delete_File("���.txt");		// userdata.txt�� ���.txt�� �����Ѵ�.
				new initialGUI();		// ���θ޴��� �����ϰ� 
				setVisible(false);		// ���� Ŭ������ �����Ѵ�.
			}
		}
	}
}
