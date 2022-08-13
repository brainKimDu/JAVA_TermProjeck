/*
- 저자 (author)
 brainKimDu
- 만든 일자 (date to create)
2020년 5월 15일
- 수정 일자 (date to update)
2020년 6월 16일
- 프로그램 내용(purpose of the program)
	플레이어의 정보를 저장하는 클래스
- 함수/메소드 (purpose of method)
	class Purchase extends ChangeReason	: ChangeReason 클래스를 상속을 통해 구매클래스 구현
	class Sell extends ChangeReason		: ChangeReason 클래스를 상속을 통해 판매클래스 구현
	class Move extends ChangeReason		: ChangeReason 클래스를 상속을 통해 물류클래스 구현
		public int returnMovePrice()	: 추가로 작성 총 물류비용을 리턴한다.
	
- 변수
	ChangeReason Purchase, Sell , Move : 원인 객체 리스트를 생성한다.
	 
	private int random = 0;		랜덤한 숫자
	private int Vectorsize; 	벡터의 크기
	private String cause;		원인
	private Double percentage;		확률
	
	
*/
package game_Progress;



//ChangeReason 클래스를 상속을 통해 구매클래스 구현  (즉 상속을 통해 구매원인 리스트를 가지는 객체를 만들고, 거기서 한가지를 랜덤하게 뽑는 과정이다. )
class Purchase extends ChangeReason {
	ChangeReason Purchase;	// 구매원인 객체 리스트를 생성한다.
	private int random = 0;			// 랜덤한 수
	private int size;		// 벡터의 사이즈를 가진다.
		
	// 생성자
	public Purchase() {
		ChangeReason Purchase = new ChangeReason("공급가격변화원인.txt");	//공급가격변화원인 txt를 통해 리스트 변화원인과 확률 리스트를 가져온다.
		size = Purchase.returnVectorSize();			//
		random = (int)(Math.random() * size);		// 랜덤한 숫자를 뽑아서
		this.Purchase = Purchase;		// 구매원인 객체 리스트가 생성자를 통해 생성한 구매원인 객체 리스트를 가리키게한다.
		}
	
	// 랜덤한 수를 넣어서 원인을 리턴한다.
	public String returnCase() {
		return Purchase.returnCase(random);
	}
	// 랜덤한 수를 넣어서변화확률을 리턴한다.
	public double returnPercentage() {
		return Purchase.changePercentage(random);
	}
}

//ChangeReason 클래스를 상속을 통해 판매클래스 구현  (즉 상속을 통해 판매원인 리스트를 가지는 객체를 만들고, 거기서 한가지를 랜덤하게 뽑는 과정이다. )
class Sell extends ChangeReason{
	ChangeReason Sell;
	private int random = 0;
	private int size;
	
	public Sell() {
		ChangeReason Sell = new ChangeReason("수요가격변화원인.txt");
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

//ChangeReason 클래스를 상속을 통해 물류클래스 구현  (즉 상속을 통해 물류원인 리스트를 가지는 객체를 만들고, 거기서 한가지를 랜덤하게 뽑는 과정이다. )
class Move extends ChangeReason{
	ChangeReason Move; // 물류원인객체를 만든다. 위와 같으며 마지막에 메소드하나 추가되었다.
	private int random = 0;
	private int size;
	private int money;
	
	public Move() {
		ChangeReason Move = new ChangeReason("물류가격변화원인.txt");// 물류원인객체를 만든다. 위와 같으며 마지막에 메소드하나 추가되었다.
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
	
	public int returnMovePrice() {			// 상속후에 추가적으로 작성
		this.money =(int)(1000 * Move.changePercentage(random));
		return this.money;
	}
	
}
