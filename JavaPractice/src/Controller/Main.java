package Controller;

import java.lang.reflect.Method;

/* UIT ���߽� ���Ի�� ������
 * 
 * Command LIST
 * 
 * ?> [-Operater] [-Parameter]
 * 
 * Parameter�� �Ѱ����� XML file �� �ε� �մϴ�.
 * 
 * LOAD {params} ? data.xml, data2.xml
 * 
 * Parameter�� �Ѱ����� �й��� ���� Subject�� Score�� ����մϴ�. 
 * 
 * PMAX {�й�} ? 1111 , 2222 , 3333
 * PMIN {�й�} ? 1111 , 2222 , 3333
 * PAVG {�й�} ? 1111 , 2222 , 3333
 *
 * Parameter�� �Ѱ����� ���� ���� ���� Id�� Score�� ����մϴ�.
 * 
 * SMAX {����} ? Programming, English, History
 * SMIN {����} ? Programming, English, History
 * SAVG {����} ? Programming, English, History
 * 
 * Parameter�� �Ѱ����� �й��� ���� ��� Subject�� Score�� ����մϴ�.
 * 
 * PERSON {�й�} ? 1111 , 2222 , 3333
 * 
 * Parameter�� �Ѱ����� ���� ������ ���� ��� Id�� Score�� ����մϴ�.
 * 
 * SUBJECT {����} ? Programming, English, History
 * 
 */

public class Main {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		try {
			
			Class Query = Class.forName("Controller.Query");
			Object queryInstance = Query.newInstance();
			Method method = Query.getMethod("execute", String.class);
			method.invoke(queryInstance, "LOAD data.xml");
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
}
