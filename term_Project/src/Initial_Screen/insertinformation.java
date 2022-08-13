/*
- ���� (author)
 brainKimDu
- ���� ���� (date to create)
2020�� 5�� 15��
- ���� ���� (date to update)
2020�� 6�� 16��
- ���α׷� ����(purpose of the program)
	ù���۽ÿ� �̸��� �Է��Ͽ� UserData.txt�� �ۼ��ϴ� Gui Ŭ����
- �Լ�/�޼ҵ� (purpose of method)
	GUI�� ����ϴ� �����ڿ� Ŭ�����콺�����ʷ� ����
*/

package Initial_Screen;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import fileIO.*;

import game_Progress.*;


// ���� Ŭ������ ������ �Է¹޴� Ŭ����
public class insertinformation extends JFrame {
	
	public String UserName;		// �����̸��� ������ ���ڿ� ����
	JLabel check = new JLabel();	// �̸��� �ԷµǾ����� äũ�ϴ� ���̺�
	Container c = getContentPane();	//����Ʈ�� �˾Ƴ���
	FileIO File = new FileIO();		// ��������� Ŭ������ ��ü ����
	
	// ������
	public insertinformation() {
		c.setLayout(null);		//��ġ������ ����
		c.setBackground(Color.WHITE);	// ���� �Ͼ��
		
		// @ ����� �̸��� �ϰ� ����� ���̺�
		JLabel yourname = new JLabel("����� �̸���? (�Է� �� Enter�� Ŭ���ϼ���.) ���嵥���Ͱ� �����˴ϴ�.");	// ��ü
		yourname.setSize(800, 200);		//ũ��
		yourname.setLocation(100, 50);	//��ġ
		yourname.setFont(new Font("���", Font.BOLD, 20));	//��Ʈ
		c.add(yourname);		//���
		
		// @ �̸��� �Է¹޴� �ؽ�Ʈ�ʵ� ��ü 
		JTextField Field = new JTextField();		//��ü
		Field.setSize(300,50);			//ũ��
		Field.setLocation(300, 200);		//��ġ
		c.add(Field);		//���
		
		// @ �̸��� �Է��Ͽ����� ���θ� �Ǵ�
		check = new JLabel(" ");		// ��ü����
		check.setSize(800, 200);		//ũ��
		check.setLocation(250, 350);	//��ġ
		check.setFont(new Font("���", Font.BOLD, 20));	//��Ʈ
		c.add(check);		//���
		
		// �ؽ�Ʈ �ʵ忡�� ���� �Է��� �߻��� ����� �׼Ǹ�����Ŭ���� (�͸�)
		Field.addActionListener(new ActionListener() {
			// �����Է��� �߻��� ��� �޼ҵ�
			public void actionPerformed(ActionEvent e) {
				JTextField name = (JTextField)e.getSource();	// �Էµ� ���ڿ��� �˾Ƴ���.
				UserName = name.getText();		// �̸��� �Էµ� ���ڿ��� �����Ѵ�.
				UserName = UserName.replace(',',' ');	// ���࿡ ,�� �ִٸ� �پ��� �����Ѵ�.
				Field.setText(" ");		//�ʵ带 ����
				File.player_Infor_Make(UserName, 10000, 1, 1);	// �̸��� �⺻������ �־����� ��10000, ���� 1, 1 = �Ͽ��� �� �����Ѵ�.
							//UserData.txt �����Ѵ�.
				check.setText("����� �̸��� " + UserName + " \"����\" ��ư�� ���� ������ �����մϴ�.");	// �Է¿��θ� äũ�ϴ� ���̺��� �ؽ�Ʈ�� �����Ѵ�.
			}
		});
		

		//@ ������ �����ϴ� ��ư 
		JButton next = new JButton("����");		//��ü
		next.setSize(500,100);			//ũ��
		next.setLocation(200,550);		//��ġ
		next.setFont(new Font("���", Font.BOLD, 20));		//��Ʈ
		next.setBackground(Color.CYAN);			//����
		next.addMouseListener(new ClickMouse());		// ���콺 Ŭ�� ������ ���
		c.add(next);			// ������ ���
		
		// @ ���θ����� ���� ��ư
		JButton back = new JButton("���θ޴�");		// ��ü
		back.setSize(500,100);			//ũ��
		back.setLocation(200,700);		//��ġ
		back.setFont(new Font("���", Font.BOLD, 20));		//��Ʈ
		back.setBackground(Color.LIGHT_GRAY);		//����
		back.addMouseListener(new ClickMouse());		//Ŭ�� �޼ҵ� ����
		c.add(back);			//���
		
		
		setSize(1000,900);
		setVisible(true);		//������ ũ��� ���̰��ϱ�
	}
	
	// ���콺 Ŭ���� ���� ������
	class ClickMouse extends MouseAdapter {	
		// ��ư�� ������ ��쿡 �����ϴ� �޼ҵ�
		public void mousePressed(MouseEvent EVe) {	
			JButton b = (JButton)EVe.getSource();	// ���� ��ư�� �������� �˾Ƴ��ϴ�.
			if(UserName != null) {		// UserName�� �ԷµǾ��ٸ�
				File.delete_File("���.txt");				// ��� �����ϰ�
				new gameGUI();		//���ӽ������� ���ϴ�.
				setVisible(false);		// �����մϴ�.
			}
			
			else
				check.setText("����� �̸��� ���� �Է��ϼ���.");	//�̸��� �Է����� �ʾҴٸ� ���̺��� ����մϴ�.
		
			//	���� ��ư�� ���θ޴����
			if(b.getText().equals("���θ޴�")) {
				new initialGUI();	// ���θ޴��� ����
				setVisible(false);	// ���� â�� �����մϴ�.
			}
			
		}
	}
	
	
	
}

