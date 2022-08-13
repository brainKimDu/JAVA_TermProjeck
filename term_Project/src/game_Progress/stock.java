/*
- 저자 (author)
 brainKimDu
- 만든 일자 (date to create)
2020년 5월 15일
- 수정 일자 (date to update)
2020년 6월 16일
- 프로그램 내용(purpose of the program)
	플레이어의 재고를 저장하거나 불러오는 클래스
- 함수/메소드 (purpose of method)
	public class stock		: 플레이어가 가지고 있는 재고에 관한 클래스
		public stock()		: 재고.txt에서 파일을 읽어와서 저장해서 객체를 생성한다. 
		public String returnproductname() 	: 플레이어의 재고의 이름을 리턴한다.
		public int returnEA() 			: 플레이어가 가지고 있는 재고의 개수를 리턴한다.
		public String returnimage() 	: 플레이어가 가지고 있는 재고의 이미지를 리턴한다.
		public void Allsell() 			: 재고를 모두 비운다. (해당 경우는 일요일이 될 경우 발생한다.)
		public void sell(int EA) 		: 판매에 관한 메소드 
		
		
- 변수
	String productname 			: 재고 이름 (농작물 이름)
	int EA 						: 제고 개수
	String image;				: 농작물의 이미지
	
*/

package game_Progress;

import fileIO.*;

// 재고 클래스 
public class stock {
	private String productname = "";		// 현재 플레이어가 가지고 있는 재고의 농작물 이름
	private int EA = 0;					// 재고의 개수
	private String image;				// 농작물 재고의 이미지
	FileIO File = new FileIO();
	
		// 생성자
		public stock(){
			try {
			String stockpro = File.player_Infor_Get("재고.txt");		// 재고.txt 에서 한줄을 읽어오는 메소드 
			
			String FileInfor = stockpro;		// 읽어온 문자열 리턴해서 문자열 변수로 저장하고
			String split1[] = FileInfor.split(",");			// 	,로 나눈다.
			for(int i=0; i<split1.length; i++) {		// 분할된 개수만큼 돈다.
				if(i%3 == 0)
						this.productname = split1[i];		// 나머지 0이라는 것은 맨 왼쪽  , 이름을 저장한다.
				if(i%3 == 1)
						this.EA = Integer.parseInt(split1[i]);	// 중간 , 개수를 저장한다.
				if(i%3 == 2)
						this.image = split1[i];		// 오른쪽	, 이미지를 저장한다.
			}
			
			}
			
			catch(NullPointerException e){		// 만약 재고.txt에 문제가 있을 경우
				productname = "";		// 초기상태로 돌린다.
				EA = 0;
				image = "";
			}
		}
		
		// 현재가지고 있는 재고의 이름을 리턴한다.
		public String returnproductname() {
			return productname;	// 
		}
		
		// 현재 재고의 개수를 리턴한다.
		public int returnEA() {
			return EA;
		}
		
		// 현재 재고의 이미지를 리턴한다.
		public String returnimage() {
			return image;
		}
		
		// 재고를 0으로 만든다.
		public void Allsell() {
			this.EA  = 0;
		}
		
		// 재고가 판매될 경우 -한다.
		public void sell(int EA) {
			this.EA -= EA;
		}
}
