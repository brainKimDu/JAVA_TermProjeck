/*
- 저자 (author)
 brainKimDu
- 만든 일자 (date to create)
2020년 5월 15일
- 수정 일자 (date to update)
2020년 6월 16일
- 프로그램 내용(purpose of the program)
	농작물 관리 프로그램에서 사용할 파일입출력 메소스들을 모아놓은 클래스
- 함수/메소드 (purpose of method)
	public void delete_File(String text)	: txt 파일 삭제
	public void File_Input_product(String name, int EA, String image )	 : 재고 클래스에서 사용하는 플레이어의 현재 재고를 알려준다.
	public void File_Input_Reason(String File, String Reason, String percentage )	: 게발자 모드에서 사용하는 원인을 추가하는 메소드
	public void File_Input_Reason(String File, String Reason, String percentage ,String Location ) : 개발자 모드에서 사용하는 농작물을 추가하는 메소드 (오버로딩)
	public void player_Infor_Make(String name,int money, int level, int day)	: 플레이어의 데이터가 저장된 txt에서 값을 가져온다.
	public void player_Infor_Make(gamer_Information gamer)		// 플레이어 객체의 값을 저장한다.
*/

/*
 *  현재 클래스의 동작 상세설명
 *  	해당 클래스에서는 입출력에 관련된 메소드를 모아놓았다.
 */
package fileIO;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import game_Progress.gamer_Information;


// 메인클래스 
public class FileIO {
	FileWriter fout = null;		// 파일 입출력에 사용하는 객체
	FileWriter fw = null;
	int fc;			// 파일 입출력에 사용하는 정수형 변수
	private String all_Infor = null;
	
	// 메소드 제목 : 텍스트 파일을 삭제한다.
	public void delete_File(String text) {
		File deleteFile = new File(text);	// 해당 경로의 파일을 가리키는 객체
		if(deleteFile.exists()) {		// 그 객체가 가리키는게 있으면
			deleteFile.delete();		// 삭제해라
		}
	}
	
	// 메소드 제목 : 재고txt를 생성한다.
	public void File_Input_product(String name, int EA, String image ) {
		try {
			fout =new FileWriter("재고.txt", true);	// 재고 txt을 만든다.
			fout.write(name + "," + EA + "," +image + "\n");		// 거기에 받아온 값들을 저장한다.
			fout.close();		// 그리고 닫는다.
		}
		catch (IOException IOe) {		// 입출력 오류시 표시
			System.out.println("Error");
		}
	}
	
	// 메소드 제목 : 원인을 저장하는 메소드
	public void File_Input_Reason(String File, String Reason, String percentage ) {
		try {
			fout =new FileWriter(File, true);		// 받아온 txt파일이 존재하면, 존재안하면 만들고
			fout.write(Reason + "," + percentage + "\n");	// 원인과 확률을 저장한다.
			fout.close();		// 그리도 닫는다.
		}
		catch (IOException IOe) {	// 입출력 오류시 표시
			System.out.println("Error");
		}
	}
	// 메소드 제목 : 농작물을 저장하는 메소드 
	public void File_Input_product(String File, String Reason, String percentage ,String Location ) {
		try {
			fout =new FileWriter(File, true);		// 파일이 없다면 만들고
			fout.write(Reason + "," + percentage + "," + Location  +  "\n");	// 이름과 가격 그리고 이미지위치를 저장한다.
			fout.close();		// 그리고 닫는다.
		}
		catch (IOException IOe) {	// 입출력 오류가 발생하면 표시
			System.out.println("Error");
		}
	}
	
	//메소드 제목 : 플레이어의 정보를 저장하는 UserData.txt를 만든다.
	public void player_Infor_Make(String name,int money, int level, int day) {
		try {
			File deleteFile = new File("UserData.txt");	// 현재의 UserData.txt를 가리키는 파일객체를 생성
			if(deleteFile.exists()) {		// 존재한다면
				deleteFile.delete();		// 삭제하고
			}
			fout =new FileWriter("UserData.txt");	// 다시만들어라.
			fout.write(name +"," + money +"," + level + ',' + day );	//거기에 플레이어의 정보를 집어넣는다.
			fout.close();		// 그리고 닫는다.
		}
		catch (IOException IOe) {		// 입출력 오류가 발생한다면 
			System.out.println("Error");		// 표시한다.
		}
	}
	
	// 메소드 제목 : 플레이어의 정보를 객체로 한 번에 받아와 저장하는 메소드
	public void player_Infor_Make(gamer_Information gamer) {
		try {
			File deleteFile = new File("UserData.txt");		// 있으면 삭제하고
			if(deleteFile.exists()) {
				deleteFile.delete();
			}
			fout =new FileWriter("UserData.txt");		// 다시 만들어서
			fout.write(gamer.gamerName() +"," + gamer.gamerMoney() +"," + gamer.gamerLevel() + ',' + gamer.gamerDay() );
			fout.close();		// 받아온 객체의 값들을 저장하고 닫아라.
		}
		catch (IOException IOe) {		// 오류가 발생하면 표시해라.
			System.out.println("Error");
		}
	}
	// 생성자를 불러와 사용하는 클래스에서는 객체를 만들어 all_Infor값을 추출한다.
	public String player_Infor_Get(String txt) {
		
		try {
				Scanner fscanner = new Scanner(new FileReader(txt));		// 해당 경로의 파일을 읽는 스캐너
				while(fscanner.hasNext()) {		// 한줄씩 읽어서
					all_Infor = fscanner.nextLine();		// all _Infor에 저장한다.
				}
				fscanner.close();		// 종료한다.		
				return all_Infor;
		
		}
		catch(IOException e) {		// 입출력 오류가 발생하는 경우
			System.out.println("파일읽기 오류거나 플레이어의 재고가 없음.");
			return "";
		}
		
	}
	
}




