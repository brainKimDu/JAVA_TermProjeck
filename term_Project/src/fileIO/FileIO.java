/*
- ���� (author)
 brainKimDu
- ���� ���� (date to create)
2020�� 5�� 15��
- ���� ���� (date to update)
2020�� 6�� 16��
- ���α׷� ����(purpose of the program)
	���۹� ���� ���α׷����� ����� ��������� �޼ҽ����� ��Ƴ��� Ŭ����
- �Լ�/�޼ҵ� (purpose of method)
	public void delete_File(String text)	: txt ���� ����
	public void File_Input_product(String name, int EA, String image )	 : ��� Ŭ�������� ����ϴ� �÷��̾��� ���� ��� �˷��ش�.
	public void File_Input_Reason(String File, String Reason, String percentage )	: �Թ��� ��忡�� ����ϴ� ������ �߰��ϴ� �޼ҵ�
	public void File_Input_Reason(String File, String Reason, String percentage ,String Location ) : ������ ��忡�� ����ϴ� ���۹��� �߰��ϴ� �޼ҵ� (�����ε�)
	public void player_Infor_Make(String name,int money, int level, int day)	: �÷��̾��� �����Ͱ� ����� txt���� ���� �����´�.
	public void player_Infor_Make(gamer_Information gamer)		// �÷��̾� ��ü�� ���� �����Ѵ�.
*/

/*
 *  ���� Ŭ������ ���� �󼼼���
 *  	�ش� Ŭ���������� ����¿� ���õ� �޼ҵ带 ��Ƴ��Ҵ�.
 */
package fileIO;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import game_Progress.gamer_Information;


// ����Ŭ���� 
public class FileIO {
	FileWriter fout = null;		// ���� ����¿� ����ϴ� ��ü
	FileWriter fw = null;
	int fc;			// ���� ����¿� ����ϴ� ������ ����
	private String all_Infor = null;
	
	// �޼ҵ� ���� : �ؽ�Ʈ ������ �����Ѵ�.
	public void delete_File(String text) {
		File deleteFile = new File(text);	// �ش� ����� ������ ����Ű�� ��ü
		if(deleteFile.exists()) {		// �� ��ü�� ����Ű�°� ������
			deleteFile.delete();		// �����ض�
		}
	}
	
	// �޼ҵ� ���� : ���txt�� �����Ѵ�.
	public void File_Input_product(String name, int EA, String image ) {
		try {
			fout =new FileWriter("���.txt", true);	// ��� txt�� �����.
			fout.write(name + "," + EA + "," +image + "\n");		// �ű⿡ �޾ƿ� ������ �����Ѵ�.
			fout.close();		// �׸��� �ݴ´�.
		}
		catch (IOException IOe) {		// ����� ������ ǥ��
			System.out.println("Error");
		}
	}
	
	// �޼ҵ� ���� : ������ �����ϴ� �޼ҵ�
	public void File_Input_Reason(String File, String Reason, String percentage ) {
		try {
			fout =new FileWriter(File, true);		// �޾ƿ� txt������ �����ϸ�, ������ϸ� �����
			fout.write(Reason + "," + percentage + "\n");	// ���ΰ� Ȯ���� �����Ѵ�.
			fout.close();		// �׸��� �ݴ´�.
		}
		catch (IOException IOe) {	// ����� ������ ǥ��
			System.out.println("Error");
		}
	}
	// �޼ҵ� ���� : ���۹��� �����ϴ� �޼ҵ� 
	public void File_Input_product(String File, String Reason, String percentage ,String Location ) {
		try {
			fout =new FileWriter(File, true);		// ������ ���ٸ� �����
			fout.write(Reason + "," + percentage + "," + Location  +  "\n");	// �̸��� ���� �׸��� �̹�����ġ�� �����Ѵ�.
			fout.close();		// �׸��� �ݴ´�.
		}
		catch (IOException IOe) {	// ����� ������ �߻��ϸ� ǥ��
			System.out.println("Error");
		}
	}
	
	//�޼ҵ� ���� : �÷��̾��� ������ �����ϴ� UserData.txt�� �����.
	public void player_Infor_Make(String name,int money, int level, int day) {
		try {
			File deleteFile = new File("UserData.txt");	// ������ UserData.txt�� ����Ű�� ���ϰ�ü�� ����
			if(deleteFile.exists()) {		// �����Ѵٸ�
				deleteFile.delete();		// �����ϰ�
			}
			fout =new FileWriter("UserData.txt");	// �ٽø�����.
			fout.write(name +"," + money +"," + level + ',' + day );	//�ű⿡ �÷��̾��� ������ ����ִ´�.
			fout.close();		// �׸��� �ݴ´�.
		}
		catch (IOException IOe) {		// ����� ������ �߻��Ѵٸ� 
			System.out.println("Error");		// ǥ���Ѵ�.
		}
	}
	
	// �޼ҵ� ���� : �÷��̾��� ������ ��ü�� �� ���� �޾ƿ� �����ϴ� �޼ҵ�
	public void player_Infor_Make(gamer_Information gamer) {
		try {
			File deleteFile = new File("UserData.txt");		// ������ �����ϰ�
			if(deleteFile.exists()) {
				deleteFile.delete();
			}
			fout =new FileWriter("UserData.txt");		// �ٽ� ����
			fout.write(gamer.gamerName() +"," + gamer.gamerMoney() +"," + gamer.gamerLevel() + ',' + gamer.gamerDay() );
			fout.close();		// �޾ƿ� ��ü�� ������ �����ϰ� �ݾƶ�.
		}
		catch (IOException IOe) {		// ������ �߻��ϸ� ǥ���ض�.
			System.out.println("Error");
		}
	}
	// �����ڸ� �ҷ��� ����ϴ� Ŭ���������� ��ü�� ����� all_Infor���� �����Ѵ�.
	public String player_Infor_Get(String txt) {
		
		try {
				Scanner fscanner = new Scanner(new FileReader(txt));		// �ش� ����� ������ �д� ��ĳ��
				while(fscanner.hasNext()) {		// ���پ� �о
					all_Infor = fscanner.nextLine();		// all _Infor�� �����Ѵ�.
				}
				fscanner.close();		// �����Ѵ�.		
				return all_Infor;
		
		}
		catch(IOException e) {		// ����� ������ �߻��ϴ� ���
			System.out.println("�����б� �����ų� �÷��̾��� ��� ����.");
			return "";
		}
		
	}
	
}




