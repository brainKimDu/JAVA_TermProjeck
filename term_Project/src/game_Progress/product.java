/*
- ���� (author)
 ��ο�
- ���� ���� (date to create)
2020�� 5�� 15��
- ���� ���� (date to update)
2020�� 6�� 16��
- ���α׷� ����(purpose of the program)
	���۹��� ���� Ŭ����
- �Լ�/�޼ҵ� (purpose of method)
		public class product 				// ���۹��� ���� Ŭ����
			public product(String pro_Name, int pro_EarlyPrice, String image) 		// ���۹��� �̸�, ����, �̹����� �����ͼ� ��üȭ�Ѵ�.
			public void changePrice(double changer) 		// ���ݺ�ȭ���ο� ���� ������ ��ȭ��Ų��.
			public String getName() 			// ���۹��� �̸��� ����
			public int getproductPrice() 		// ���۹��� ������ ����
			public String getImage()			// ���۹��� �̹����� ����
		class selectProduct extends ChangeReason 		// �ڵ��� �ߺ��ۼ��� ���ϱ� ���� ChangeReason�� ��ӹ޾� �����Ѵ�.
														������ ���۹��� �̸��� �ǰ�, ��ȭȮ���� ������ �ȴ�.
			public selectProduct() 			// �����ڷ� ���۹����� ����Ʈ�� ������ ��ü�� �����Ѵ�.
			
		class makeproduct 	extends product		// ���۹����� ����Ʈ�� �߿��� ���۹� �ϳ��� �����ϴ� Ŭ����
			public makeproduct() 		// �����ڷ� ���۹� �ϳ��� �����ؼ� ��üȭ�Ѵ�.
}

- ����
	private String pro_Name 		�̸�
	private int pro_EarlyPrice;		����
	private String image;			�̹���
*/
package game_Progress;


// ���۹� Ŭ���� 
public class product {
	private String pro_Name = null;		// ���۹��� �̸�
	private int pro_EarlyPrice;			// ���۹��� ����
	private String image;				// ���۹��� �̹���
	
	public product() {
		
	}
	
	// �����ڷ� ������ ������ �޾ƿͼ� �����Ѵ�.
	public product(String pro_Name, int pro_EarlyPrice, String image) {
		this.pro_Name = pro_Name;
		this.pro_EarlyPrice = pro_EarlyPrice;
		this.image = image;
	}
	
	// ���� ���� Ȯ���� ���� ������ ��ȭ�ϴ� �޼ҵ�
	public void changePrice(double changer) {
		this.pro_EarlyPrice *= changer;		// Ȯ���� ���Ѵ�.
	}
	
	// ���۹��� �̸��� �����ϴ� �޼ҵ�
	public String getName() {
		return pro_Name;
	}
	
	// ���۹��� ������ �����ϴ� �޼ҵ�
	public int getproductPrice() {
		return pro_EarlyPrice;
	}
	
	// ���۹��� �̹����� �����ϴ� �޼ҵ�
	public String getImage() {
		return image;
	}
	
}

// ���۹��� ����Ʈ�� �̾ƿ��� Ŭ���� ����� Ŭ����
class selectProduct extends ChangeReason {
	// ���۹�.txt�� �ִ� ��� ���۹��� �����Ѵ�.
	public selectProduct() {
		super("���۹�.txt", 1);
	}
}

// ���۹��� ����Ʈ���� �ϳ��� �̴� Ŭ����
class makeproduct extends product {
	product product;		// ��깰 ��ü
	int size;		// ���� ũ��
	int random;		// ����
	
	// ������
	public makeproduct() {
		selectProduct productList = new selectProduct();		// ���۹� ����Ʈ ��ü
		size = productList.returnVectorSize();		// ����ũ��
		random = (int)(Math.random() * size);		// ������ ����		
		this.product= new product(productList.returnCase(random), 
				(int)productList.changePercentage(random), productList.returnimage(random));
				// ����Ʈ���� ������ ���� ���� ��깰 ��ü�� �����Ѵ�.
	}
}