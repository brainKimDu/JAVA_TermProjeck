/*
- 저자 (author)
 김두엽
- 만든 일자 (date to create)
2020년 5월 15일
- 수정 일자 (date to update)
2020년 6월 16일
- 프로그램 내용(purpose of the program)
	농작물에 대한 클래스
- 함수/메소드 (purpose of method)
		public class product 				// 농작물에 관한 클래스
			public product(String pro_Name, int pro_EarlyPrice, String image) 		// 농작물의 이름, 가격, 이미지를 가져와서 객체화한다.
			public void changePrice(double changer) 		// 가격변화원인에 따라 가격을 변화시킨다.
			public String getName() 			// 농작물의 이름을 리턴
			public int getproductPrice() 		// 농작물의 가격을 리턴
			public String getImage()			// 농작물의 이미지를 리턴
		class selectProduct extends ChangeReason 		// 코드의 중복작성를 피하기 위해 ChangeReason을 상속받아 진행한다.
														원인은 농작물의 이름이 되고, 변화확률은 가격이 된다.
			public selectProduct() 			// 생성자로 농작물들의 리스트를 가지는 객체를 생성한다.
			
		class makeproduct 	extends product		// 농작물들의 리스트를 중에서 농작물 하나를 선택하는 클래스
			public makeproduct() 		// 생성자로 농작물 하나를 선택해서 객체화한다.
}

- 변수
	private String pro_Name 		이름
	private int pro_EarlyPrice;		가격
	private String image;			이미지
*/
package game_Progress;


// 농작물 클래스 
public class product {
	private String pro_Name = null;		// 농작물의 이름
	private int pro_EarlyPrice;			// 농작물의 가격
	private String image;				// 농작물의 이미지
	
	public product() {
		
	}
	
	// 생성자로 각각의 값들을 받아와서 저장한다.
	public product(String pro_Name, int pro_EarlyPrice, String image) {
		this.pro_Name = pro_Name;
		this.pro_EarlyPrice = pro_EarlyPrice;
		this.image = image;
	}
	
	// 가격 변동 확률에 따라 가격을 변화하는 메소드
	public void changePrice(double changer) {
		this.pro_EarlyPrice *= changer;		// 확률을 곱한다.
	}
	
	// 농작물의 이름을 리턴하는 메소드
	public String getName() {
		return pro_Name;
	}
	
	// 농작물의 가격을 리턴하는 메소드
	public int getproductPrice() {
		return pro_EarlyPrice;
	}
	
	// 농작물의 이미지를 리턴하는 메소드
	public String getImage() {
		return image;
	}
	
}

// 농작물의 리스트를 뽑아오는 클래스 만드는 클래스
class selectProduct extends ChangeReason {
	// 농작물.txt에 있는 모든 농작물을 저장한다.
	public selectProduct() {
		super("농작물.txt", 1);
	}
}

// 농작물의 리스트에서 하나를 뽑는 클래스
class makeproduct extends product {
	product product;		// 농산물 객체
	int size;		// 벡터 크기
	int random;		// 숫자
	
	// 생성자
	public makeproduct() {
		selectProduct productList = new selectProduct();		// 농작물 리스트 객체
		size = productList.returnVectorSize();		// 벡터크기
		random = (int)(Math.random() * size);		// 랜덤한 숫자		
		this.product= new product(productList.returnCase(random), 
				(int)productList.changePercentage(random), productList.returnimage(random));
				// 리스트에서 가져온 값을 통해 농산물 객체를 생성한다.
	}
}