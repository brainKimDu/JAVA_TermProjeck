/*
- ���� (author)
 brainKimDu
- ���� ���� (date to create)
2020�� 5�� 15��
- ���� ���� (date to update)
2020�� 6�� 16��
- ���α׷� ����(purpose of the program)
	>> txt���Ͽ��� ���ΰ� ��ȭȮ���� �о���ͼ� �����Ѵ�. 
	>> txt���Ͽ��� ���۹��� �̸��� ���� �׸��� �̹����� �����´�. 
	
- �Լ�/�޼ҵ� (purpose of method)
	public abstract class allreason		: �Ŀ� �߰������� �ٸ� ���ݺ�ȭ�� ������ �߰��� ��쿡 �����ؾ��� ���̵������ ����
	
	class ChangeReason extends allreason	: 	�߻� �޼ҵ带 ������ ��� ���ε��� ���� Ŭ����
			public ChangeReason()			: 	������
			public ChangeReason(String txt)		: ���� ���� ������ ���ݺ�ȭ�� ���� ������
			public ChangeReason(String txt, int x)	: ���۹��� ���ݺ�ȭ�� ���� ������
			public int returnVectorSize()		: ������ ���� ũ�⸦ �����Ѵ�.
			public double changePercentage(int random) 	: ��ȭ Ȯ�� Ȥ�� ������ �����Ѵ�.
			public String returnCase(int random) 		: ������ �����Ѵ�.
			public String returnimage(int random) 		: �̹����� �����Ѵ�.
			public int OriginalPrice(String name) 		: ��ǰ�� ���� ������ �����Ѵ�.
			
	class PurchaseChangeReason extends  ChangeReason	:���Ű��ݺ�ȭ������ ������ Ŭ���� ��ü ����
	
	class SellChangeReason extends ChangeReason		: �ǸŰ��ݺ�ȭ���ο� ���� Ŭ����	��ü ����

	class MoveChangeReason extends ChangeReason		: �������ݺ�ȭ���ο� ���� Ŭ����	��ü ����
	
	

-  ������ ����
	Vector<String> Vcase			: ������ ������ �ִ� ���ͺ����̴�.
	HashMap<String, Double> HashPercentage	: ������ Ű���ϰ� Ȯ���� value��  ������ �ִ� �ؽ����̴�.
			-> ��� �۵��ϴ°�? 
				������ ������ �װſ� �´� Ȯ���� �����Ѵ�.
	
	HashMap<String, String> Hashimage  : ���������� ���۹��� �̸��� Ű�ΰ�����, ���۹��� �̹��� ��θ� value�� ������.
	String Case;	: ������ ������ ���ڿ� ����
	double percentage = 0;	: Ȯ���� ������ �Ǽ��� ����
	String image;		:  �̹��� ��θ� ������ ���ڿ� ����
	
*/


package game_Progress;

import java.io.*;
import java.util.*;

// ������� ��� �Լ��� �޼ҵ尡 �ʿ��� ���ΰ� ����ϱ� ����. ���̵������ �����Ѵ�.
// �Ŀ� �߰����� ������ �߰��� ��� �������� �����ؾ��ϴ��� ������ ����
public abstract class allreason {
	private Vector<String> Vcase;
	// (������ ������ �����̴�.)
	private HashMap<String, Double> HashPercentage;
	// (������ Ű������ ������, value�� ��ȭȮ���� ������.)  / �� ������ ������ Ű�� ������ ��ȭȮ���� �����Ѵ�.
	public abstract double changePercentage(int random);
		//	��ȭȮ���� �����ϴ� �޼ҵ�
	public abstract String returnCase(int random);
		// ������ �����ϴ� �޼ҵ�
}



// �߻�Ŭ������ ������ ������ ���ΰ� Ȯ���� ��ȯ�ϴ� Ŭ���� ����
class ChangeReason extends allreason{
	private Vector<String> Vcase = new Vector<String>();		
	// ���θ� ������ ���ͺ��� 
	private HashMap<String, Double> HashPercentage = new HashMap<String, Double>();
	// ������ Ű������ ������, value�� ��ȭȮ���� ������. 
	// ���θ� �Է��ϸ�  ��ȭȮ���� ���´�.
	private HashMap<String, String> Hashimage = new HashMap<String, String>();
	// ���۹����� ����ϸ�, ���۹� �̸��� �Է��ϸ� �ش��ϴ� �̹����� ���´�.
	private String Case;		//������ �����ϴ� ������ ����
	private double percentage = 0;		// ��ȭȮ���� �����ϴ� �Ǽ��� ����
	private String image;		// �̹����� ��θ��� �����ϴ� ������ ����
	
	
	// ������
	public ChangeReason() {
	
	}
	
	//���� ���� ������ ���ݺ�ȭ�� ���� ������
	public ChangeReason(String txt) {
		try {
			Scanner fscanner = new Scanner(new FileReader(txt));		//���پ� �б� ���� ���� ��ĳ�� ���
	
			while(fscanner.hasNext()) {		// ���پ� ����д´�. 
				String a = fscanner.nextLine();		// �� ���� ������ ������ ���� a
				String line = a.replace("\n", "");	// a�� \n�� ""���� ��ü ���� �ٽ� line�� �����Ѵ�.
				String split[] = line.split(",");	// �޸��� �������� ������.
				for(int i=0; i<(split.length/2); i++) {	// ���� ���� ��ŭ �ݺ��Ѵ�.
				Vcase.add(split[0]);		// ������ ���Ϳ� �����ϰ�
				HashPercentage.put(split[0], Double.parseDouble(split[1]));		// ��ȭȮ���� �ؽ��ʿ� ���ΰ� �Բ� �����Ѵ�.
				}
			}
		}
		catch (IOException IOe) {		// ����� ������ �߻��ϴ� ���
			System.out.println("Error");		// ������ ǥ���Ѵ�.
		}
		
		
	}
	
	//���۹��� ���ݺ�ȭ�� ���� ������
	public ChangeReason(String txt, int x) {
		try {
			Scanner fscanner = new Scanner(new FileReader(txt));		//���پ� �б� ���� ���� ��ĳ�� ���
	
			while(fscanner.hasNext()) {
				String a = fscanner.nextLine();
				String line = a.replace("\n", "");
				String split[] = line.split(",");
				for(int i=0; i<(split.length/2); i++) {			// ���� ������ �����ϳ� 
				Vcase.add(split[0]);		//������ �����ϰ�
				HashPercentage.put(split[0], Double.parseDouble(split[1]));	//���ΰ� ��ȭȮ���� �����Ѵ�.
				Hashimage.put(split[0], split[2]);		// ���ΰ� �̹��������θ� �ؽ��ʿ� �����Ѵ�.
				}
			}
		}
		catch (IOException IOe) {		// ����� ������ �߻��ϴ� ���
			System.out.println("Error");		// ������ ǥ��
		}
		
		
	}
	// �޼ҵ� ���� : ������ ũ�� ����
	public int returnVectorSize() {
		return Vcase.size();		// ������ ũ�� �����Ѵ�.
	}
	
	// �޼ҵ� ���� : ���ݺ�ȭ Ȯ�� ����, ������ ���ڸ� �޾ƿͼ� ������ ���� ��ȭȮ���� �����Ѵ�.
	public double changePercentage(int random) {
		Case = Vcase.get(random);		// ���Ϳ� �������ڸ� �־ ������ �˾Ƴ���
		percentage = HashPercentage.get(Case);		// �� ������ �ؽ��ʿ� �־ ��ȭȮ���� �̾Ƴ���.
		return percentage;		// �׷��� �� ��ȭȮ���� �����Ѵ�.
	}	
	
	// �޼ҵ� ���� : ������ �����ϴ� �޼ҵ�
	public String returnCase(int random) {
		Case = Vcase.get(random);		// ���ڸ� �޾ƿ��� �׿� �ش��ϴ� ���ΰ��� �����Ѵ�.
		return Case;		// �׿����� �����Ѵ�.
	}
	
	// �޼ҵ� ���� : �̹����� �����ϴ� �޼ҵ�
	public String returnimage(int random) {
		Case = Vcase.get(random);		// �ش� ���ڿ� ���� ������ ������ �Ŀ� 
		image = Hashimage.get(Case);		// �� ������ �̹��� �ؽ��ʿ� �־ �̹����� �˾Ƴ���.
		return image;		// �̹����� �����Ѵ�.
	}
	
	// �޼ҵ� ���� : ������ ������ �����Ѵ�.
	public int OriginalPrice(String name) {
		try {		// ���� ��ü�� ����Ȱ� ������ 0�� �����Ѵ�.
		percentage = HashPercentage.get(name);		// ���۹��� �̸��� ������ ������ ������ ������ ���̴�. 
		return (int)percentage;			// ������ �������̹Ƿ� ���������� �����Ѵ�. 
		}
		catch(NullPointerException e) {
			return 0;
		}
	}
}
 



