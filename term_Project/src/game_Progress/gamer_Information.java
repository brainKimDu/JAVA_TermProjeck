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
	public class gamer_Information		: 플레이어의 정보를 저장하는 클래스
		public String gamerName()		: 이름을 리턴한다.
		public int gamerMoney()			: 돈을 리턴한다.
		public int gamerLevel()			: 레벨을 리턴한다.
		public int gamerDay()			: 현재 날짜를 리턴한다.
		public void setmoney(int setmoney)		: 구매를 할때 플레이어의 돈을 수정한다.
		public void Sellmoney(int setmoney)		: 판매를 할때 플레이어의 돈을 수정한다.
		public void setDay() 		: 다음날로 이동할 때의 메소드
		public void setSunday()		: 재고가 없거나 모두 판매했을 경우 월요일로 이동한다. 
		public void Levelup(int cost) 	: 레벨업을 하는 메소드
		
		
- 변수
	 String name;		플레이어의 이름
	 int money;			플레이어의 돈
	 int Level;			플레이어의 레벨
	 int IntDay;		플레이어의 날짜
	
*/

package game_Progress;

// 플레이어의 정보를 저장하는 클래스이다. 
public class gamer_Information {
	private String name;			// 플레이어의 이름
	private int money;				// 플레이어의 돈
	private int Level;				//플레이어의 레벨
	private int IntDay;				// 플레이어의 현재 날짜
	
	// 	생성자
	public gamer_Information(String All_Data) {
		String[] UserData = new String[4];		// 4개의 문자열을 변수를 생성한다.
		
		String FileInfor = All_Data;		// UserData.txt 한줄을 읽었던 문자열 변수를 가져와서
		String split1[] = FileInfor.split(",");	// 그걸 ,를 기준으로 나눈다.
		for(int i=0; i<split1.length; i++) {		// 총 4번 돌게되고
		UserData[i] = split1[i];		// 각각의 순서대로 UserData에 저장한다.
		}
		this.name = UserData[0];					// 이제 그걸 각각의 변수에 넣어준다.
		this.money = Integer.parseInt(UserData[1]);
		this.Level = Integer.parseInt(UserData[2]);
		this.IntDay = Integer.parseInt(UserData[3]);
	}
	
	
	//메소드 제목: 플레이어의 이름을 리턴한다.
	public String gamerName() {
		return name;
	}
	
	//메소드 제목: 플레이어의 돈을 리턴한다. 
	public int gamerMoney() {
		return money;
	}
	
	//메소드 제목: 플레이어의 레벨을 리턴한다.
	public int gamerLevel() {
		return Level;
	}
	
	//메소드 제목: 플레이어의 현재 날짜를 리턴한다. (정수형 플레이어 날짜)
	public int gamerDay() {
		return IntDay;
	}
	
	//메소드 제목: 플레이어가 물건을 구매하는 경우 돈을 조절한다.
	public void setmoney(int setmoney) {
		this.money -=  setmoney;
	}
	//메소드 제목: 플레이어가 판매를 하는 경우 돈을 조절한다.
	public void Sellmoney(int setmoney) {
		this.money +=  setmoney;
	}
	
	//메소드 제목: 플레이어가 다음날로 이동하는 경우
	public void setDay() {
		if(this.IntDay < 7) {
		this.IntDay += 1;
		}
		else {
			this.IntDay = 1;
		}
		
	}
	
	//메소드 제목: 플레이어가 재고를 모두 판매하는 경우 일요일로 이동한다.
	public void setSunday() {
		this.IntDay = 1;
		
	}
	
	//메소드 제목: 레벨업에 관한 메소드 일정 돈을 지불해야한다.
	public void Levelup(int cost) {
		this.money = money - cost;
		this.Level++;
	}
}
