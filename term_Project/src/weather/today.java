/*
- ���� (author)
 brainKimDu
- ���� ���� (date to create)
2020�� 5�� 15��
- ���� ���� (date to update)
2020�� 6�� 16��
- ���α׷� ����(purpose of the program)
	������ �޾ƿ� ��¥ �����͸� ������ ȭ���� �̷������� ��ȯ�Ͽ� �����ִ� Ŭ����
- �Լ�/�޼ҵ� (purpose of method)
	public String getToday(int dayOfWeek) : ������ �޾ƿ� ��¥ �����͸� ������ ȭ���� �̷������� ��ȯ�Ͽ� �����ִ� Ŭ����
*/
package weather;

import java.util.Calendar;

// ����Ŭ����
public class today {
	String today = null;		// ������ ������ �˷��ִ� ���ڿ� ����
	
	// ������
	public today() {
		
	}
	
	// �޼ҵ� ���� : ������ �޾ƿ� ��¥ �����͸� ������ ȭ���� �̷������� ��ȯ�Ͽ� �����ִ� Ŭ����
	public String getToday(int dayOfWeek) {
		switch(dayOfWeek) {
        case Calendar.SUNDAY : this.today = "�Ͽ���"; break;		// 1�̸� �Ͽ��� ~
        case Calendar.MONDAY :  this.today ="������"; break; 
        case Calendar.TUESDAY :  this.today ="ȭ����"; break;
        case Calendar.WEDNESDAY :  this.today ="������"; break;
        case Calendar.THURSDAY :  this.today ="�����"; break;
        case Calendar.FRIDAY:  this.today ="�ݿ���"; break;
        case Calendar.SATURDAY :  this.today ="�����"; break;	// 7�̸� �����
		}
		return today;	// ���ڷ� ��ȯ�� ���� �����Ѵ�.
	}
}
