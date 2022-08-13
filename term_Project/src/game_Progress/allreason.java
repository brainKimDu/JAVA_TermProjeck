/*
- 저자 (author)
 brainKimDu
- 만든 일자 (date to create)
2020년 5월 15일
- 수정 일자 (date to update)
2020년 6월 16일
- 프로그램 내용(purpose of the program)
	>> txt파일에서 원인과 변화확률을 읽어들어와서 저장한다. 
	>> txt파일에서 농작물의 이름과 가격 그리고 이미지도 가져온다. 
	
- 함수/메소드 (purpose of method)
	public abstract class allreason		: 후에 추가적으로 다른 가격변화의 원인을 추가할 경우에 참고해야할 가이드라인을 제시
	
	class ChangeReason extends allreason	: 	추상 메소드를 구현한 모든 원인들의 상위 클래스
			public ChangeReason()			: 	생성자
			public ChangeReason(String txt)		: 공급 수요 물류의 가격변화에 대한 생성자
			public ChangeReason(String txt, int x)	: 농작물에 가격변화에 대한 생성자
			public int returnVectorSize()		: 현재의 벡터 크기를 리턴한다.
			public double changePercentage(int random) 	: 변화 확률 혹은 가격을 리턴한다.
			public String returnCase(int random) 		: 원인을 리턴한다.
			public String returnimage(int random) 		: 이미지를 리턴한다.
			public int OriginalPrice(String name) 		: 상품의 원래 가격을 리턴한다.
			
	class PurchaseChangeReason extends  ChangeReason	:구매가격변화원인을 가지는 클래스 객체 생성
	
	class SellChangeReason extends ChangeReason		: 판매가격변화원인에 대한 클래스	객체 생성

	class MoveChangeReason extends ChangeReason		: 물류가격변화원인에 대한 클래스	객체 생성
	
	

-  변수의 설명
	Vector<String> Vcase			: 원인을 가지고 있는 벡터변수이다.
	HashMap<String, Double> HashPercentage	: 원인을 키로하고 확률을 value로  가지고 있는 해쉬맵이다.
			-> 어떻게 작동하는가? 
				원인을 넣으면 그거에 맞는 확률을 리턴한다.
	
	HashMap<String, String> Hashimage  : 마찬가지로 농작물의 이름을 키로가지고, 농작물의 이미지 경로를 value로 가진다.
	String Case;	: 원인을 가지는 문자열 변수
	double percentage = 0;	: 확률을 가지는 실수형 변수
	String image;		:  이미지 경로를 가지는 문자열 변수
	
*/


package game_Progress;

import java.io.*;
import java.util.*;

// 만들기전 어던 함수와 메소드가 필요할 것인가 고려하기 위함. 가이드라인을 제시한다.
// 후에 추가적인 원인을 추가할 경우 어떤방식으로 구현해야하는지 방향을 제시
public abstract class allreason {
	private Vector<String> Vcase;
	// (원인을 가지는 벡터이다.)
	private HashMap<String, Double> HashPercentage;
	// (원인을 키값으로 가지고, value는 변화확률을 가진다.)  / 즉 벡터의 내용을 키로 넣으면 변화확률을 리턴한다.
	public abstract double changePercentage(int random);
		//	변화확률을 리턴하는 메소드
	public abstract String returnCase(int random);
		// 원인을 리턴하는 메소드
}



// 추상클래스를 구현한 가격의 원인과 확률을 반환하는 클래스 구현
class ChangeReason extends allreason{
	private Vector<String> Vcase = new Vector<String>();		
	// 원인를 가지는 벡터변수 
	private HashMap<String, Double> HashPercentage = new HashMap<String, Double>();
	// 원인을 키값으로 가지고, value는 변화확률을 가진다. 
	// 원인를 입력하면  변화확률이 나온다.
	private HashMap<String, String> Hashimage = new HashMap<String, String>();
	// 농작물에서 사용하며, 농작물 이름을 입력하면 해당하는 이미지가 나온다.
	private String Case;		//원인을 저장하는 문자형 변수
	private double percentage = 0;		// 변화확률을 저장하는 실수형 변수
	private String image;		// 이미지의 경로명을 저장하는 문자형 변수
	
	
	// 생성자
	public ChangeReason() {
	
	}
	
	//공급 수요 물류의 가격변화에 대한 생성자
	public ChangeReason(String txt) {
		try {
			Scanner fscanner = new Scanner(new FileReader(txt));		//한줄씩 읽기 위해 파일 스캐너 사용
	
			while(fscanner.hasNext()) {		// 한줄씩 계속읽는다. 
				String a = fscanner.nextLine();		// 한 줄을 가지는 문자형 변수 a
				String line = a.replace("\n", "");	// a의 \n을 ""으로 대체 한후 다시 line에 저장한다.
				String split[] = line.split(",");	// 콤마를 기준으로 나눈다.
				for(int i=0; i<(split.length/2); i++) {	// 줄의 갯수 만큼 반복한다.
				Vcase.add(split[0]);		// 원인은 벡터에 저장하고
				HashPercentage.put(split[0], Double.parseDouble(split[1]));		// 변화확률은 해쉬맵에 원인과 함께 저장한다.
				}
			}
		}
		catch (IOException IOe) {		// 입출력 오류가 발생하는 경우
			System.out.println("Error");		// 에러를 표시한다.
		}
		
		
	}
	
	//농작물에 가격변화에 대한 생성자
	public ChangeReason(String txt, int x) {
		try {
			Scanner fscanner = new Scanner(new FileReader(txt));		//한줄씩 읽기 위해 파일 스캐너 사용
	
			while(fscanner.hasNext()) {
				String a = fscanner.nextLine();
				String line = a.replace("\n", "");
				String split[] = line.split(",");
				for(int i=0; i<(split.length/2); i++) {			// 위의 과정과 동일하나 
				Vcase.add(split[0]);		//원인을 저장하고
				HashPercentage.put(split[0], Double.parseDouble(split[1]));	//원인과 변화확률을 저정한다.
				Hashimage.put(split[0], split[2]);		// 원인과 이미지저장경로를 해쉬맵에 저장한다.
				}
			}
		}
		catch (IOException IOe) {		// 입출력 오류가 발생하는 경우
			System.out.println("Error");		// 에러를 표시
		}
		
		
	}
	// 메소드 제목 : 벡터의 크기 리턴
	public int returnVectorSize() {
		return Vcase.size();		// 벡터의 크기 리턴한다.
	}
	
	// 메소드 제목 : 가격변화 확률 리턴, 랜덤한 숫자를 받아와서 랜덤한 수의 변화확률을 리턴한다.
	public double changePercentage(int random) {
		Case = Vcase.get(random);		// 벡터에 랜덤숫자를 넣어서 원인을 알아내고
		percentage = HashPercentage.get(Case);		// 그 원인을 해쉬맵에 넣어서 변화확률을 뽑아낸다.
		return percentage;		// 그래서 그 변화확률을 리턴한다.
	}	
	
	// 메소드 제목 : 원인을 리턴하는 메소드
	public String returnCase(int random) {
		Case = Vcase.get(random);		// 숫자를 받아오면 그에 해당하는 원인값을 리턴한다.
		return Case;		// 그원인을 리턴한다.
	}
	
	// 메소드 제목 : 이미지를 리턴하는 메소드
	public String returnimage(int random) {
		Case = Vcase.get(random);		// 해당 숫자에 대한 원인을 저장한 후에 
		image = Hashimage.get(Case);		// 그 원인을 이미지 해쉬맵에 넣어서 이미지를 알아낸다.
		return image;		// 이미지를 리턴한다.
	}
	
	// 메소드 제목 : 원래의 가격을 리턴한다.
	public int OriginalPrice(String name) {
		try {		// 만약 객체에 저장된게 없으면 0을 리턴한다.
		percentage = HashPercentage.get(name);		// 농작물의 이름을 넣으면 원래의 가격을 리턴할 것이다. 
		return (int)percentage;			// 가격은 정수형이므로 정수형으로 리턴한다. 
		}
		catch(NullPointerException e) {
			return 0;
		}
	}
}
 



