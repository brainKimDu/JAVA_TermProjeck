/*
- ���� (author)
brainKimDu
- ���� ���� (date to create)
2020�� 5�� 15��
- ���� ���� (date to update)
2020�� 6�� 16��
- ���α׷� ����(purpose of the program)
	�÷��̾��� ������ �����ϴ� Ŭ����
- �Լ�/�޼ҵ� (purpose of method)
	public class gamer_Information		: �÷��̾��� ������ �����ϴ� Ŭ����
		public String gamerName()		: �̸��� �����Ѵ�.
		public int gamerMoney()			: ���� �����Ѵ�.
		public int gamerLevel()			: ������ �����Ѵ�.
		public int gamerDay()			: ���� ��¥�� �����Ѵ�.
		public void setmoney(int setmoney)		: ���Ÿ� �Ҷ� �÷��̾��� ���� �����Ѵ�.
		public void Sellmoney(int setmoney)		: �ǸŸ� �Ҷ� �÷��̾��� ���� �����Ѵ�.
		public void setDay() 		: �������� �̵��� ���� �޼ҵ�
		public void setSunday()		: ��� ���ų� ��� �Ǹ����� ��� �����Ϸ� �̵��Ѵ�. 
		public void Levelup(int cost) 	: �������� �ϴ� �޼ҵ�
		
		
- ����
	 String name;		�÷��̾��� �̸�
	 int money;			�÷��̾��� ��
	 int Level;			�÷��̾��� ����
	 int IntDay;		�÷��̾��� ��¥
	
*/

package game_Progress;

// �÷��̾��� ������ �����ϴ� Ŭ�����̴�. 
public class gamer_Information {
	private String name;			// �÷��̾��� �̸�
	private int money;				// �÷��̾��� ��
	private int Level;				//�÷��̾��� ����
	private int IntDay;				// �÷��̾��� ���� ��¥
	
	// 	������
	public gamer_Information(String All_Data) {
		String[] UserData = new String[4];		// 4���� ���ڿ��� ������ �����Ѵ�.
		
		String FileInfor = All_Data;		// UserData.txt ������ �о��� ���ڿ� ������ �����ͼ�
		String split1[] = FileInfor.split(",");	// �װ� ,�� �������� ������.
		for(int i=0; i<split1.length; i++) {		// �� 4�� ���Եǰ�
		UserData[i] = split1[i];		// ������ ������� UserData�� �����Ѵ�.
		}
		this.name = UserData[0];					// ���� �װ� ������ ������ �־��ش�.
		this.money = Integer.parseInt(UserData[1]);
		this.Level = Integer.parseInt(UserData[2]);
		this.IntDay = Integer.parseInt(UserData[3]);
	}
	
	
	//�޼ҵ� ����: �÷��̾��� �̸��� �����Ѵ�.
	public String gamerName() {
		return name;
	}
	
	//�޼ҵ� ����: �÷��̾��� ���� �����Ѵ�. 
	public int gamerMoney() {
		return money;
	}
	
	//�޼ҵ� ����: �÷��̾��� ������ �����Ѵ�.
	public int gamerLevel() {
		return Level;
	}
	
	//�޼ҵ� ����: �÷��̾��� ���� ��¥�� �����Ѵ�. (������ �÷��̾� ��¥)
	public int gamerDay() {
		return IntDay;
	}
	
	//�޼ҵ� ����: �÷��̾ ������ �����ϴ� ��� ���� �����Ѵ�.
	public void setmoney(int setmoney) {
		this.money -=  setmoney;
	}
	//�޼ҵ� ����: �÷��̾ �ǸŸ� �ϴ� ��� ���� �����Ѵ�.
	public void Sellmoney(int setmoney) {
		this.money +=  setmoney;
	}
	
	//�޼ҵ� ����: �÷��̾ �������� �̵��ϴ� ���
	public void setDay() {
		if(this.IntDay < 7) {
		this.IntDay += 1;
		}
		else {
			this.IntDay = 1;
		}
		
	}
	
	//�޼ҵ� ����: �÷��̾ ��� ��� �Ǹ��ϴ� ��� �Ͽ��Ϸ� �̵��Ѵ�.
	public void setSunday() {
		this.IntDay = 1;
		
	}
	
	//�޼ҵ� ����: �������� ���� �޼ҵ� ���� ���� �����ؾ��Ѵ�.
	public void Levelup(int cost) {
		this.money = money - cost;
		this.Level++;
	}
}
