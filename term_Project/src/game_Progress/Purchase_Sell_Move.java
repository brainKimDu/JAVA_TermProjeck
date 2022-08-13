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
	class Purchase extends ChangeReason	: ChangeReason Ŭ������ ����� ���� ����Ŭ���� ����
	class Sell extends ChangeReason		: ChangeReason Ŭ������ ����� ���� �Ǹ�Ŭ���� ����
	class Move extends ChangeReason		: ChangeReason Ŭ������ ����� ���� ����Ŭ���� ����
		public int returnMovePrice()	: �߰��� �ۼ� �� ��������� �����Ѵ�.
	
- ����
	ChangeReason Purchase, Sell , Move : ���� ��ü ����Ʈ�� �����Ѵ�.
	 
	private int random = 0;		������ ����
	private int Vectorsize; 	������ ũ��
	private String cause;		����
	private Double percentage;		Ȯ��
	
	
*/
package game_Progress;



//ChangeReason Ŭ������ ����� ���� ����Ŭ���� ����  (�� ����� ���� ���ſ��� ����Ʈ�� ������ ��ü�� �����, �ű⼭ �Ѱ����� �����ϰ� �̴� �����̴�. )
class Purchase extends ChangeReason {
	ChangeReason Purchase;	// ���ſ��� ��ü ����Ʈ�� �����Ѵ�.
	private int random = 0;			// ������ ��
	private int size;		// ������ ����� ������.
		
	// ������
	public Purchase() {
		ChangeReason Purchase = new ChangeReason("���ް��ݺ�ȭ����.txt");	//���ް��ݺ�ȭ���� txt�� ���� ����Ʈ ��ȭ���ΰ� Ȯ�� ����Ʈ�� �����´�.
		size = Purchase.returnVectorSize();			//
		random = (int)(Math.random() * size);		// ������ ���ڸ� �̾Ƽ�
		this.Purchase = Purchase;		// ���ſ��� ��ü ����Ʈ�� �����ڸ� ���� ������ ���ſ��� ��ü ����Ʈ�� ����Ű���Ѵ�.
		}
	
	// ������ ���� �־ ������ �����Ѵ�.
	public String returnCase() {
		return Purchase.returnCase(random);
	}
	// ������ ���� �־��ȭȮ���� �����Ѵ�.
	public double returnPercentage() {
		return Purchase.changePercentage(random);
	}
}

//ChangeReason Ŭ������ ����� ���� �Ǹ�Ŭ���� ����  (�� ����� ���� �Ǹſ��� ����Ʈ�� ������ ��ü�� �����, �ű⼭ �Ѱ����� �����ϰ� �̴� �����̴�. )
class Sell extends ChangeReason{
	ChangeReason Sell;
	private int random = 0;
	private int size;
	
	public Sell() {
		ChangeReason Sell = new ChangeReason("���䰡�ݺ�ȭ����.txt");
		size = Sell.returnVectorSize();
		random = (int)(Math.random() * size);
		this.Sell = Sell;
		}
	
	public String returnCase() {
		return Sell.returnCase(random);
	}
	public double returnPercentage() {
		return Sell.changePercentage(random);
	}
	
	
}

//ChangeReason Ŭ������ ����� ���� ����Ŭ���� ����  (�� ����� ���� �������� ����Ʈ�� ������ ��ü�� �����, �ű⼭ �Ѱ����� �����ϰ� �̴� �����̴�. )
class Move extends ChangeReason{
	ChangeReason Move; // �������ΰ�ü�� �����. ���� ������ �������� �޼ҵ��ϳ� �߰��Ǿ���.
	private int random = 0;
	private int size;
	private int money;
	
	public Move() {
		ChangeReason Move = new ChangeReason("�������ݺ�ȭ����.txt");// �������ΰ�ü�� �����. ���� ������ �������� �޼ҵ��ϳ� �߰��Ǿ���.
		size = Move.returnVectorSize();
		random = (int)(Math.random() * size);
		this.Move = Move;
		}
	
	public String returnCase() {
		return Move.returnCase(random);
	}
	public double returnPercentage() {
		return Move.changePercentage(random);
	}
	
	public int returnMovePrice() {			// ����Ŀ� �߰������� �ۼ�
		this.money =(int)(1000 * Move.changePercentage(random));
		return this.money;
	}
	
}
