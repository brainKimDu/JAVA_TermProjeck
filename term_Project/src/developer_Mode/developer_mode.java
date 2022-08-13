/*
- ���� (author)
 brainKimDu
- ���� ���� (date to create)
2020�� 5�� 15��
- ���� ���� (date to update)
2020�� 6�� 16��
- ���α׷� ����(purpose of the program)
������Ʈ�� ������ ��忡 ������ Ŭ����, ���۹��� ������ �߰��ϰų�, ����, �Ǹ�, ������ ���� ��ȭ ������ �߰��� �� �ִ�.
- �Լ�/�޼ҵ� (purpose of method)
	public class developer_mode extends JFrame : ������ ��� Ŭ������ GUI�� ��ü���� �帧�� �����Ѵ�.
		 	imageField.addActionListener(new ActionListener()	: JTextfield���� ���ڿ��� �Է�(�̹���)�޴� �͹�Ŭ����
		 	Field.addActionListener(new ActionListener()	: JTextfield1���� ���ڿ��� �Է�(����, ��ǰ��)�� �޴� �͸�Ŭ����
		 	Field2.addActionListener(new ActionListener()	: JTextfield2���� �Ǽ��� �Է�(Ȯ��, ����)�� �޴� �͸�Ŭ����
		class ClickMouse extends MouseAdapter : ���콺 Ŭ���� ���� �����ʷ� JButton�� Ŭ���� ��쿡 �߻��ϴ� �̺�Ʈ���� �ٷ��. 
		class MyItemListener implements ItemListener : üũ�ڽ��� ���� �����ʷ� � �ؽ�Ʈ ���Ͽ� �������� �����ϰԵȴ�. 
		
		public void printTxt(String txt) : üũ�ڽ��� ������� ������ üũ�ڽ��� �ش��ϴ� txt�� ����Ǿ� �ִ� ������� �ҷ��ͼ� �ؽ�Ʈ����� ��Ÿ���� �޼ҵ�
		public void printstockTxt(String txt) :  ���۹��� ��� �̹��������ε� �ʿ��ϱ� ������ �޼ҵ带 ���θ������.
*/

/*
 *  ���� Ŭ������ ���� �󼼼���
 * 		���� : ������ ���
 * 		���� : ���۹��� ���ݺ�ȭ ����, �ǸŰ����� ��ȭ ����, ���䰡���� ��ȭ ����, ���������� ��ȭ������ �Է¹޾� ������ txt ���Ͽ� �����ϴ� ������ �ϴ� Ŭ�����̴�.
 * 			��ܺ��� üũ�ڽ��� ���� ��� txt�� �������� �� �� �ִ�.
 * 			�� ���� textArea���� ���õ� txt������ �о�ͼ� ���� ����Ǿ� �ִ� �ؽ�Ʈ���� �����ش�. 
 * 			�׹ؿ��� ����(Ȥ�� ��ǰ��), ��ȭȮ��(Ȥ�� ����)�� �ؽ�Ʈ�ʵ忡 �Է��ϰ� �߰��� �� �ִ�.
 * 			���۹��� ��� �̹����� ��ġ���� �Է��ϸ� ��Ÿ����.
 * 
 * 			��� ���� �Է¹�����, �ش��ϴ� txt�� �߰��� �� �ִ�. �̴� fileIO ��Ű���� fileIO Ŭ������ ���� �̷������. 
 * 			�߸��� ������ �Է��ϰų�, �ؽ��� ,�� �и��ϱ� ������ ,�� �ԷµǾ��� �� �߻��ϴ� �������� �ذ��ϱ� ���� �ʿ��� ��ġ�� ���Ͽ���.
 */
package developer_Mode;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

// �ʱ�ȭ�� ��Ű���� ���θ޴� Ŭ������ �ҷ��ɴϴ�. 
import Initial_Screen.initialGUI;
// ��������Ʈ�� ��������¿� ������ ��Ű���� �ҷ��ɴϴ�.
import fileIO.*;

// ���� Ŭ������ GUI�� �����ڸ�� Ŭ������ �������� ������ ����Ѵ�.
public class developer_mode extends JFrame{
	JLabel Label[] = new JLabel[7];
	/*
	  0 : ��ܿ� "������ ���" ���  / 1: "������ �Է��ϼ���. ����� ,�� ������� ������."�� ����ϴ� ���̺�  / 2: "���ݺ�ȭ ������ �Է��ϼ���."�� ����ϴ� ���̺�
	  3 : ������ �Է¹����� �Էµ� ������ ���� ��� / 4: Ȯ�� Ȥ�� ������ �Է� ������ ��� / 5:������ �Ϸ�Ǿ��ų� ������ �߻��Ͽ��� �� ����ϴ� ���̺�
	  6 : ���۹� �̹��� �Է¿� ������ ���� ���
	 */
	
	JTextField Field = new JTextField();
	// ����Ȥ�� ���۹� �̸��� �Է¹޴� �ؽ�Ʈ �ʵ�
	JTextField Field2 = new JTextField();
	// Ȯ�� Ȥ�� ������ �Է¹޴� �ؽ�Ʈ �ʵ�
	JTextArea Field3 = new JTextArea();
	// �ؽ�Ʈ�� ����� ���ڵ��� ����� �����ִ� �ؽ�Ʈ ������
	JButton Button[] = new JButton[3];
	/*
	 *  0: �߰��ϱ�  / 1 : �ڷ� ���� (���θ޴�) / 2: ���۹� �߰��� ���� JButton �ٸ� �޼ҵ带 ����ϱ� ������ JButton�� �ٲ�. 
	 */
	
	JTextField imageField  = new JTextField();
	// �̹����� �����θ� �Է¹޴� JTextField
	
	JRadioButton[] txt = new JRadioButton[4];
	// 0 ~ 4  : ���ް��ݺ�ȭ����.txt , ���䰡�ݺ�ȭ����.txt, �������ݺ�ȭ����.txt, ���۹�.txt �� ������ �� ������, �ش� üũ�ڽ��� ������ 
	// �ؽ�Ʈ ����� ����� txt�� �����ְ�, �ش� txt�� ������ �� �� �ְԵȴ�.
	String txtFile[] = {"���ް��ݺ�ȭ����.txt", "���䰡�ݺ�ȭ����.txt", "�������ݺ�ȭ����.txt" , "���۹�.txt"};
	// üũ�ڽ����� ����ϱ����� ���ڿ� �迭���� ����

	Container c = getContentPane();	// �������� ����Ʈ���� �˾Ƴ���. �̴� ���������� �����Ͽ� �ٸ� Ŭ�������� ������ �����ϰ� �Ѵ�.
	FileIO File = new FileIO();	// ��������� Ŭ������ txt �ۼ��� �ַ� ����ϴ� Ŭ�����̴�.
	
	int set = 0;		//üũ���� ���ÿ� ����  0~3�� ���� ������ texFile ���ڿ��� �迭�� �־� �ؽ�Ʈ�� �����ϰ� �ȴ�.
	String FileStr = " "; 	// �Է¹��� ���۹� �̸� 
	String FileName = "d.txt"; // ������ txt ���ϸ�
	String reason;		// �Է¹��� ���� 

	double percentage = 0;	// �Է¹��� ��ȭ Ȯ��
	int changeInt;		// �Է¹��� ����
	
	String imageProduct = null;	// �Է¹��� �̹��� ���
	JLabel imageLabel = new JLabel();	// �̹�����ü�� �Է¹����� ����Ǵ� �̹����� �������� �̸� �����ش�.
	
	
	// �����ڷ� GUI������ ����Ѵ�.
	public developer_mode() {
		setTitle("������ �޴�");		//����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//x�� ������
		c.setLayout(null);		// ��ġ������ ����
		c.setBackground(Color.WHITE);	// ������ �Ͼ������ �Ѵ�.
		
		// @üũ�ڽ�
		// üũ�ڽ��� �׷��� �����Ѵ�.
		ButtonGroup g = new ButtonGroup();		
		// üũ�ڽ��� �����ϰ� c�� ���̰� üũ�ڽ��� �׷��� ����� �����̴�.
		for(int i=0; i<4; i++) {
			txt[i] = new JRadioButton(txtFile[i]);		// J���� ��ư�� ���ڿ� txtFile[]�� ���ڿ��� ������. ��ü����
			g.add(txt[i]);			// �׷��� ����
			txt[i].setLocation(100 + (200 * i), 100);
			txt[i].setSize(200,100);		// ��ġ�� ũ�� ����
			txt[i].addItemListener(new MyItemListener());	//üũ�ڽ��� ���õǴ� ��쿡 �ش��ϴ� �����۸����� ���
			c.add(txt[i]);		// �����ӿ� ����
		}
		
		
		// @txtArea�� �ش� 
		Field3 = new JTextArea(" ");		// txt ������ �����ͼ� �ؽ�Ʈ �ʵ忡 �����ִ� ������ �ϴ� ������ ��ü ����
		JScrollPane scrollPane = new JScrollPane(Field3);	// ��ũ���� ������ �Ѵ�.
		scrollPane.setLocation(100,200);		
		scrollPane.setSize(800,300);		// ��ġ�� ũ�� ����
		c.add(scrollPane);		// �����ӿ� ����
		
		// @����� ������ ��� ���ڿ� ���̺������� ���
		Label[0] = new JLabel("������ ���");	//���̺� ��ü ����
		Label[0].setLocation(300, 10);
		Label[0].setSize(1000,100);		// ��ġ ũ�� ����
		Label[0].setFont(new Font("�ü�", Font.BOLD, 50));	//��Ʈ ����
		c.add(Label[0]);		//������ ����
		
		// @ �ϴ��� ������ �Է¹��� �� ����ϴ� ���̺�
		Label[1] = new JLabel("������ �Է��ϼ���. ����� ,�� ������� ������.");		// ���̺� ��ü ����
		Label[1].setFont(new Font("���", Font.BOLD, 20));		// ��Ʈ ����
		Label[1].setLocation(100, 500);
		Label[1].setSize(1000,30);		// ��ġ ũ�� ����
		c.add(Label[1]);		// �����ӿ� ����
		
		// @ ������ �Է¹��� �� ����ϴ� �ؽ�Ʈ �ʵ� 
		JTextField Field = new JTextField();	//�ؽ�Ʈ �ʵ� ��ü ����		
		Field.setSize(300,50);	
		Field.setLocation(100, 550);		// ��ġ�� ũ�� ����
		c.add(Field);		// �����ӿ� ����
		
		// @ ���ݺ�ȭ ���� Ȥ�� ���۹��� ������ �Է� ���� �� ����ϴ� ���̺�
		Label[2] = new JLabel("���ݺ�ȭ ������ �Է��ϼ���.");		// ���̺� ��ü ����
		Label[2].setFont(new Font("���", Font.BOLD, 20));	//��Ʈ ũ�� ����
		Label[2].setLocation(100, 580);
		Label[2].setSize(1000,100);		// ũ��� ��ġ ����
		c.add(Label[2]);	// �����ӿ� ����
		
		// @ ���ݺ�ȭ�� ���� Ȥ�� ���۹��� ������ �Է¹޴� �ؽ�Ʈ �ʵ�
		JTextField Field2 = new JTextField();		// �ؽ�Ʈ �ʵ� ��ü	
		Field2.setSize(300,50);	
		Field2.setLocation(100, 650);	// ��ġ�� ũ�� ����
		c.add(Field2);		// �����ӿ� ����
		
		// @ �Է¹��� ���� � ������ ����ϴ� ���̺� 
		Label[3] = new JLabel(" ");		// ���̺� ��ü ����
		Label[3].setFont(new Font("����d", Font.BOLD, 20));	// ��Ʈ ����
		Label[3].setLocation(100, 680);
		Label[3].setSize(1000,100);		// ũ��� ��ġ ����
		c.add(Label[3]);		// �����ӿ� ����
		
		// @ �Է¹��� �����̳� ��ȭȮ���� �������� ����ϴ� ���̺�
		Label[4] = new JLabel(" ");		// ���̺� ��ü ����
		Label[4].setFont(new Font("����d", Font.BOLD, 20));	// ��Ʈ ����
		Label[4].setLocation(100, 710);
		Label[4].setSize(1000,100);		// ũ��� ��ġ ����
		c.add(Label[4]);	// �����ӿ� ����
		
		// @ �����߻��̳� ���忡 ���� ���̺�
		Label[5] = new JLabel(" ");	//���̺� ��ü ����
		Label[5].setFont(new Font("����d", Font.BOLD, 20));	// ��Ʈ ����
		Label[5].setLocation(100, 900);		
		Label[5].setSize(1000,100);		//ũ��� ��ġ ����
		c.add(Label[5]);		//�����ӿ� ����
			
		// @ �̹����Է¿� ����ϴ� ���̺�
		Label[6] = new JLabel(" ");	//���̺� ��ü ����	
		Label[6].setFont(new Font("����d", Font.BOLD, 10));		// ��Ʈ����
		Label[6].setLocation(500, 480);			
		Label[6].setSize(1000,100);		// ũ��� ��ġ ����
		c.add(Label[6]);		// �����ӿ� ����
		
		// @ ���۹� �Է½� �̹��� ��ġ�� �Է¹޴� �ؽ�Ʈ �ʵ�
		JTextField imageField = new JTextField("���۹� �Է½� �Է��ϼ���.");	 //�ý�Ʈ �ʵ� ��ü ����		
		imageField.setSize(300,50);		
		imageField.setLocation(500, 550);		// ũ��� ��ġ ����
		c.add(imageField);		// ������ ����
		
		
		
		/* Ŭ���� ���� : �̹��� �ؽ�Ʈ���� ���� �Է��� �߻��ϴ� ��쿡 ����ϴ� ������ �͸� Ŭ����
		 *  	���� : �Է¹��� ������ ��ġ�� �ش��ϴ� �̹����� ������ ���̺� ��ü�� �����Ѵ�.
		 */
		 imageField.addActionListener(new ActionListener() {
			 // ���Ͱ� �ԷµǴ� ���
			public void actionPerformed(ActionEvent e) {
				JTextField String = (JTextField)e.getSource();	// �Էµ� ���ڿ��� ������ JText�ʵ�
				imageProduct = "���\\" + String.getText();	// �̹��� ���ڿ��� ������Ͼȿ� �ִ� �����̸��� ������.
				// @fix bug
				imageProduct = imageProduct.replaceAll(",","");	// Ȥ�� ,�� �ִٸ� ���� (������ �����ϱ� ����)
				
				ImageIcon image = new ImageIcon(imageProduct);	// �ش� ��ġ�� �̹��������� �ҷ��´�.
				imageLabel.setIcon(image);		// �̹��� ������ ������ ���̺� 
				imageLabel.setSize(300,300);	
				imageLabel.setLocation(500,600);	// ��ġ�� ũ������
				imageLabel.setVisible(true);
				c.add(imageLabel);	// �����ӿ� ����
				
				// @ fix bug
				c.repaint();  		// �̰� ���� ������ �̹����� ������ �ε����� �ʴ´�.
				
				imageField.setText("");		// �̹��� �ؽ�Ʈ�ʵ带 ����.
				
			}
		});
		
		 /* Ŭ���� ���� : �����̳� ���۹� �̸��� �Է��ϴ� �ؽ�Ʈ���� ���� �Է��� �߻��ϴ� ��쿡 ����ϴ� ������ �͸� Ŭ����
			 *  	���� : �Է¹���  ������ ���ڿ� reason�� �����Ѵ�.
			 */
		Field.addActionListener(new ActionListener() {
			// ���Ͱ� ������ ���
			public void actionPerformed(ActionEvent e) {
				JTextField String = (JTextField)e.getSource();	// �Էµ� ���ڸ� �˾Ƴ���.
				reason = String.getText();		// ���ڿ� ������ �Էµ� ���ڸ� ������.
				Field.setText("");		// ���� �ؽ�Ʈ �ʵ带 �����.
				// @ fix bug 
				reason = reason.replace(',', ' ');	// ,�� ��� ����� �ٲ۴�.	
				Label[3].setText("������ : " + reason); 	// ���̺��� ���� �Էµ� ������ �������� �˷��ش�.
			}
		});
		
		 /* Ŭ���� ���� : �����̳� Ȯ���� �Է��ϴ� �ؽ�Ʈ���� ���� �Է��� �߻��ϴ� ��쿡 ����ϴ� ������ �͸� Ŭ����
		 *  	���� : �Է¹���  �����̳� Ȯ���� percentage�� �����Ѵ�.
		 */
		Field2.addActionListener(new ActionListener() {
			// ���Ͱ� ������ ���
			public void actionPerformed(ActionEvent e) {
				try {
					JTextField String = (JTextField)e.getSource();		// �Էµ� ���ڸ� �˾Ƴ���.
					percentage = Double.parseDouble(String.getText());		// ������ ���� ��ȯ�ؼ� ����
					Field2.setText("");		// �Է¹޴� �ؽ�Ʈ �ʵ带 ����.
					Label[4].setText("Ȯ���� : " + percentage );	// �Էµ� Ȯ���̳� ������ �˷��ش�.
				}
				catch(NumberFormatException er) {	// ���ڰ� �ƴѰ� �Էµ� ���
					Label[4].setText("�Ǽ������� �Է��ϼ���. ������ ��� ������ �Է��ϼ���. " );	// �ش� ���ڿ��� ���̺��� ���� ����Ѵ�.
				}
					
			}
		});
		
		// @ txt�� �߰��ϴ� ��ư
		Button[0] = new JButton("�߰��ϱ�");		//��ư ��ü �����
		Button[0].setLocation(800, 700);		
		Button[0].setSize(100,100);				// ũ��� ��ġ ����
		Button[0].addMouseListener(new ClickMouse());	// ���콺 Ŭ�� ������ ����
		c.add(Button[0]);		// �����ӿ� ����
		
		// @ ���θ޴��� ���� ��ư
		Button[1] = new JButton("�ڷΰ���");		// ��ư ��ü ����
		Button[1].setLocation(800, 600);
		Button[1].setSize(100,100);			//ũ��� ��ġ ����
		Button[1].addMouseListener(new ClickMouse());		// ���콺 Ŭ�� ������ ����
		c.add(Button[1]);			// �����ӿ� ����
		
		// @ ���۹��� �߰��ϴ� ��쿡 ����ϴ� ��ư
		Button[2] = new JButton("��� �߰��ϱ�");		// ��ư ��ü �����
		Button[2].setLocation(800, 700);
		Button[2].setSize(100,100);				// ũ��� ��ġ ����
		Button[2].addMouseListener(new ClickMouse());		// ���콺 Ŭ�� ������ ����
		c.add(Button[2]);		// �����ӿ� ����
		
		
		setSize(1000,1000);
		setVisible(true);			// ��ü���� GUIũ��� ���̰� �ϴ� ��
	}
	
	 /* Ŭ���� ���� : ��ư�� Ŭ���Ǵ� ��쿡 �߻��ϴ� ������
	 *  	���� : txt�� �Է¹��� ���� �߰��ϰų� ���θ޴��� ���ų� �Ѵ�.
	 */
	class ClickMouse extends MouseAdapter {			
		// ���콺�� Ŭ���ϴ� ���
		public void mousePressed(MouseEvent e) {	
			JButton b = (JButton)e.getSource();		// ���� ���� �������� �˾Ƴ���.
			// ���� ��ư�� �߰��ϱ���
			if(b.getText().equals("�߰��ϱ�")) {
				if((reason != null) && (percentage != 0) ) {	// ��� �ԷµǾ��ٸ�
					Label[5].setText("������ �Ϸ�Ǿ����ϴ�.");		// ����Ǿ��ٰ� ���ڿ��� ��Ÿ����
					Label[3].setText(" ");
					Label[4].setText(" ");		// ���̺��� ��� �����.
					File.File_Input_Reason(txtFile[set], reason, Double.toString(percentage));	
					// fileIO�� Input_Reason Ŭ������ ���� �ش� txt�� ���ΰ� ������ ��� �����Ѵ�.
					reason = null;	
					percentage = 0;	// �Է¹��� ���� ��� ����.
				}
			
				else
					Label[5].setText("�Է��� �����ϼ���. ���͸� �Է��ϼž��մϴ�.");	// �Է¹��� ���� ������ ���̺��� ���� ���
			}
			
			// ���� ��ư�� ��� �߰��ϱ���
			if(b.getText().equals("��� �߰��ϱ�")) {
				if((reason != null) && (percentage != 0) ) {		// �Է¹��� ���� �ִٸ� ����
					if(imageProduct != null) {		// �̹����� �Է¹޾Ҵٸ� ����
					Label[5].setText("������ �Ϸ�Ǿ����ϴ�.");		// ���̺� ���
					Label[3].setText(" ");			// ���̺��� ����.
					Label[4].setText(" ");
					imageLabel.setVisible(false);	//�̹������̺� �����
					changeInt = (int)percentage;		// ������ �޾ƿ´�.
					File.File_Input_product(txtFile[set], reason, Integer.toString(changeInt), imageProduct);
					// fileIO�� Input_Reason Ŭ������ ���� �ش� txt�� ���ΰ� ������ ��� �����Ѵ�.
					reason = null;
					percentage = 0;
					imageProduct = null;	//��� ���� �ȴ�.
					}
				}
			
				else
					Label[5].setText("�Է��� �����ϼ���. ���͸� �Է��ϼž��մϴ�."); // �Է¹��� ���� ���ٸ� ���̺��� ���� ���
			}
			// ���� �ڷΰ��� ���
			if(b.getText().equals("�ڷΰ���")) {
				new initialGUI();
				setVisible(false);		// ���θ޴��� ����.
			}
		}
	}
	

	 /* Ŭ���� ���� : üũ�ڽ� ����� ���õǾ��°��� ����
	 *  	���� : txt�� �о ����ϰ� ���õ� txt�� �����Ѵ�.
	 */
	class MyItemListener implements ItemListener{
		// ���õ� üũ�ڽ��� �����ΰ�?
		public void itemStateChanged(ItemEvent e) {
			// �ƹ��͵� ���þ��ϸ� ������ �־��.
			if(e.getStateChange() == ItemEvent.DESELECTED)
				return;
			// 0���� ���õ� ��� �� ���ް��ݺ�ȭ����.txt
			if(txt[0].isSelected()) {
				Field3.setText("");		// �ؽ�Ʈ����� ��� ����
				set=0;					// 0���� ���ڿ� ���ް��ݺ�ȭ����.txt
				printTxt(txtFile[set]);		// �ؽ�Ʈ����� ����� ���ڿ��� ��� ����ϴ� �޼ҵ� ����
				Label[1].setText("������ �Է��ϼ���.");		
				Label[2].setText("���ݺ�ȭ ������ �Է��ϼ���.");		//���̺��� �ش� ���ڿ��� ��ü�ϰ�
				Button[2].setVisible(false);		//����߰��ϱ� ��ư�� ��Ȱ��ȭ�Ѵ�.
				Button[0].setVisible(true);		//�߰��ϱ� ��ư�� Ȱ��ȭ�Ѵ�.
			}
			// 1���� ���õ� ��� ���䰡�ݺ�ȭ����.txt	������ ���� ����.
			if(txt[1].isSelected()) {
				Field3.setText("");
				set=1;
				printTxt(txtFile[set]);
				Label[1].setText("������ �Է��ϼ���.");
				Label[2].setText("���ݺ�ȭ ������ �Է��ϼ���.");
				Button[2].setVisible(false);
				Button[0].setVisible(true);
			}
			// 2�� ���õ� ��� �������ݺ�ȭ����.txt	������ ���� ����.
			if(txt[2].isSelected()) {
				Field3.setText("");
				set=2;
				printTxt(txtFile[set]);
				
				Label[1].setText("������ �Է��ϼ���.");
				Label[2].setText("���ݺ�ȭ ������ �Է��ϼ���.");
				Button[2].setVisible(false);
				Button[0].setVisible(true);
			}
			
			// 3���� ���õ� ��� ���۹�.txt 
			if(txt[3].isSelected()) {
				Field3.setText("");
				set=3;
				printstockTxt(txtFile[set]);		// �̴� ���۹��� ��� ������ ������ �̹��� ��ü���� �ҷ����� ������ �ٸ� �޼ҵ带 ����Ѵ�.
				
				Label[1].setText("���۹� �̸��� �Է��ϼ���.");
				Label[2].setText("������ �Է��ϼ���.");
				Label[6].setText("���۹� �̹��� ������ �̸��� �Է��ϼ���. 200*200ũ���� �̹����� �־���մϴ�.");
				
				Button[0].setVisible(false);
				Button[2].setVisible(true);
			}
		}
		
		// �޼ҵ� ���� : ���� ����� �ؽ�Ʈ�� �о����
		public void printTxt(String txt) {
			try {	
				Scanner fscanner = new Scanner(new FileReader(txt));	// ���پ� �б� ���� ���Ͻ�ĳ�ʸ� �����Ѵ�.
				while(fscanner.hasNext()) {				// ���� ���������� �д´�.
					String a = fscanner.nextLine();		// ������ �о
					String line = a.replace("\n", "");		// �ڿ� /n�� ����� 
					String split[] = line.split(",");		// ,�� ���еǾ� �ִ� ���� ������.
					for(int i=0; i<(split.length/2); i+=2) {		// ���Ǳ����� �ݸ�ŭ ���鼭
							Field3.append(split[i] + "\t");		// �Ǿ��� ������ ����ϰ�
							Field3.append(split[i+1] + "\n");	// ���� ��ȭ ������ ����Ѵ�.
					}
				
				}
			}	
			catch (IOException IOe) {		// ���� ����¿� ���ڰ� �߻��Ѵٸ� Error ���
				System.out.println("Error");
			}
			c.repaint();		// �ؽ�Ʈ �ʵ忡 �߰��Ȱ� �ٽ� �����־��.
		}
		
		// �޼ҵ� ���� : ���� ����� �ý�Ʈ�� �о�´�. ���۹����� ���
		public void printstockTxt(String txt) {
			try {
				Scanner fscanner = new Scanner(new FileReader(txt));
				while(fscanner.hasNext()) {
					String a = fscanner.nextLine();
					String line = a.replace("\n", "");
					String split[] = line.split(",");
					for(int i=0; i<(split.length/2); i+=2) {
							Field3.append(split[i] + "\t");
							Field3.append(split[i+1] + "\t");
							Field3.append(split[i+2] + "\n");		// �̹��� ���� ��ΰ� �߰��Ǿ� �� �κи� �߰��Ǿ���.
							
					}
				}
			}	
			catch (IOException IOe) {
				System.out.println("Error");
			}
			c.repaint();
		}
		
	}
}
