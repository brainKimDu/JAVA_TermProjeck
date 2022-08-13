/*
- ���� (author)
 brainKimDu
- ���� ���� (date to create)
2020�� 5�� 15��
- ���� ���� (date to update)
2020�� 6�� 16��
- ���α׷� ����(purpose of the program)
	�÷��̾��� ��� �����ϰų� �ҷ����� Ŭ����
- �Լ�/�޼ҵ� (purpose of method)
	public class stock		: �÷��̾ ������ �ִ� ��� ���� Ŭ����
		public stock()		: ���.txt���� ������ �о�ͼ� �����ؼ� ��ü�� �����Ѵ�. 
		public String returnproductname() 	: �÷��̾��� ����� �̸��� �����Ѵ�.
		public int returnEA() 			: �÷��̾ ������ �ִ� ����� ������ �����Ѵ�.
		public String returnimage() 	: �÷��̾ ������ �ִ� ����� �̹����� �����Ѵ�.
		public void Allsell() 			: ��� ��� ����. (�ش� ���� �Ͽ����� �� ��� �߻��Ѵ�.)
		public void sell(int EA) 		: �Ǹſ� ���� �޼ҵ� 
		
		
- ����
	String productname 			: ��� �̸� (���۹� �̸�)
	int EA 						: ���� ����
	String image;				: ���۹��� �̹���
	
*/

package game_Progress;

import fileIO.*;

// ��� Ŭ���� 
public class stock {
	private String productname = "";		// ���� �÷��̾ ������ �ִ� ����� ���۹� �̸�
	private int EA = 0;					// ����� ����
	private String image;				// ���۹� ����� �̹���
	FileIO File = new FileIO();
	
		// ������
		public stock(){
			try {
			String stockpro = File.player_Infor_Get("���.txt");		// ���.txt ���� ������ �о���� �޼ҵ� 
			
			String FileInfor = stockpro;		// �о�� ���ڿ� �����ؼ� ���ڿ� ������ �����ϰ�
			String split1[] = FileInfor.split(",");			// 	,�� ������.
			for(int i=0; i<split1.length; i++) {		// ���ҵ� ������ŭ ����.
				if(i%3 == 0)
						this.productname = split1[i];		// ������ 0�̶�� ���� �� ����  , �̸��� �����Ѵ�.
				if(i%3 == 1)
						this.EA = Integer.parseInt(split1[i]);	// �߰� , ������ �����Ѵ�.
				if(i%3 == 2)
						this.image = split1[i];		// ������	, �̹����� �����Ѵ�.
			}
			
			}
			
			catch(NullPointerException e){		// ���� ���.txt�� ������ ���� ���
				productname = "";		// �ʱ���·� ������.
				EA = 0;
				image = "";
			}
		}
		
		// ���簡���� �ִ� ����� �̸��� �����Ѵ�.
		public String returnproductname() {
			return productname;	// 
		}
		
		// ���� ����� ������ �����Ѵ�.
		public int returnEA() {
			return EA;
		}
		
		// ���� ����� �̹����� �����Ѵ�.
		public String returnimage() {
			return image;
		}
		
		// ��� 0���� �����.
		public void Allsell() {
			this.EA  = 0;
		}
		
		// ��� �Ǹŵ� ��� -�Ѵ�.
		public void sell(int EA) {
			this.EA -= EA;
		}
}
