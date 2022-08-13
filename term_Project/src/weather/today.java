/*
- 저자 (author)
 brainKimDu
- 만든 일자 (date to create)
2020년 5월 15일
- 수정 일자 (date to update)
2020년 6월 16일
- 프로그램 내용(purpose of the program)
	정수로 받아온 날짜 데이터를 월요일 화요일 이런식으로 변환하여 돌려주는 클래스
- 함수/메소드 (purpose of method)
	public String getToday(int dayOfWeek) : 정수로 받아온 날짜 데이터를 월요일 화요일 이런식으로 변환하여 돌려주는 클래스
*/
package weather;

import java.util.Calendar;

// 메인클래스
public class today {
	String today = null;		// 돌려줄 요일을 알려주는 문자열 변수
	
	// 생성자
	public today() {
		
	}
	
	// 메소드 제목 : 정수로 받아온 날짜 데이터를 월요일 화요일 이런식으로 변환하여 돌려주는 클래스
	public String getToday(int dayOfWeek) {
		switch(dayOfWeek) {
        case Calendar.SUNDAY : this.today = "일요일"; break;		// 1이면 일요일 ~
        case Calendar.MONDAY :  this.today ="월요일"; break; 
        case Calendar.TUESDAY :  this.today ="화요일"; break;
        case Calendar.WEDNESDAY :  this.today ="수요일"; break;
        case Calendar.THURSDAY :  this.today ="목요일"; break;
        case Calendar.FRIDAY:  this.today ="금요일"; break;
        case Calendar.SATURDAY :  this.today ="토요일"; break;	// 7이면 토요일
		}
		return today;	// 숫자로 변환한 값을 리턴한다.
	}
}
