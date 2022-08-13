/*
- ���� (author)
 brainKimDu
- ���� ���� (date to create)
2020�� 5�� 15��
- ���� ���� (date to update)
2020�� 6�� 16��
- ���α׷� ����(purpose of the program)
	���ӹ���� GUI�� �����ִ� Ŭ����
- �Լ�/�޼ҵ� (purpose of method)
	���� �޼ҵ�  : GUI�� ����Ѵ�.
*/


package Initial_Screen;
/* ���ӹ�� ����*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

// ����Ŭ������ GUI�� ����Ѵ�.
public class HowToPlay extends JFrame {
	public HowToPlay() {
		setTitle("���ӹ��");		//����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//x�� ������
		
		
		Container c = getContentPane();		// �������� ����Ʈ�� �˾Ƴ���
		c.setLayout(null);		// ��ġ������ ����
		c.setBackground(Color.WHITE);		// ���� �Ͼ��
		
		JLabel HowText2 = new JLabel("���� ������ ���ݿ� ��깰�� �����ϰ�, ���� ��Ѱ��ݿ� �Ǹ��ϼ���.\n");	// ���̺� �ش� ���ڿ��� ������ ��ü ����
		HowText2.setFont(new Font("���", Font.BOLD, 20));		//���̺��� ��Ʈ ����
		HowText2.setLocation(100,80);
		HowText2.setSize(900,500);		//���̺��� ��ġ�� ũ�� ����
		c.add(HowText2);		//������ c�� �����Ѵ�.
		
		JLabel HowText3 = new JLabel("��� ��깰�� �Ͽ��Ͽ� ������ �� �ְ�, �� ���� ���Ͽ� �Ǹ��� �� �ֽ��ϴ�.\n");	// ���̺� �ش� ���ڿ��� ������ ��ü ����
		HowText3.setFont(new Font("���", Font.BOLD, 20));		//���̺��� ��Ʈ ����
		HowText3.setLocation(100,110);
		HowText3.setSize(900,500);		//���̺��� ��ġ�� ũ�� ����
		c.add(HowText3);		//������ c�� �����Ѵ�.
		
		JLabel HowText4 = new JLabel("�Ͽ����̵Ǹ� ��� ���� ���˴ϴ�. \n");	// ���̺� �ش� ���ڿ��� ������ ��ü ����
		HowText4.setFont(new Font("���", Font.BOLD, 20));		//���̺��� ��Ʈ ����
		HowText4.setLocation(100,140);
		HowText4.setSize(900,500);		//���̺��� ��ġ�� ũ�� ����
		c.add(HowText4);		//������ c�� �����Ѵ�.
		
		// @ ���θ޴��� ���ư� JButton ����
		JButton back = new JButton("�ڷΰ���");
		back.setSize(100,100);		
		back.setLocation(800,600);		// ũ��� ��ġ ����
		back.addMouseListener(new ClickMouse());		// ���콺 Ŭ�� ������ ���
		c.add(back);		// �����ӿ� �����ϱ�
		
		setSize(1000,900);	//������ ũ�� ����
		setVisible(true);		// ���̰� �Ѵ�.
		
	}
	
	// ���콺�� ������ ��쿡 �����ϴ� ���콺 Ŭ�� ������
	class ClickMouse extends MouseAdapter {			
		// ��ư�� Ŭ���ϴ� ���
		public void mousePressed(MouseEvent e) {	
			new initialGUI();		// ����ȭ���� ������ ���� ȭ�� ���� 
			setVisible(false);
		}
	}
}
