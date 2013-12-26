package Controller;

import java.lang.reflect.Method;

/* UIT 개발실 신입사원 박지만
 * 
 * Command LIST
 * 
 * ?> [-Operater] [-Parameter]
 * 
 * Parameter로 넘겨지는 XML file 을 로드 합니다.
 * 
 * LOAD {params} ? data.xml, data2.xml
 * 
 * Parameter로 넘겨지는 학번에 대한 Subject와 Score를 출력합니다. 
 * 
 * PMAX {학번} ? 1111 , 2222 , 3333
 * PMIN {학번} ? 1111 , 2222 , 3333
 * PAVG {학번} ? 1111 , 2222 , 3333
 *
 * Parameter로 넘겨지는 수강 과목에 대한 Id와 Score를 출력합니다.
 * 
 * SMAX {과목} ? Programming, English, History
 * SMIN {과목} ? Programming, English, History
 * SAVG {과목} ? Programming, English, History
 * 
 * Parameter로 넘겨지는 학번을 가진 모든 Subject와 Score를 출력합니다.
 * 
 * PERSON {학번} ? 1111 , 2222 , 3333
 * 
 * Parameter로 넘겨지는 수강 과목을 가진 모든 Id와 Score를 출력합니다.
 * 
 * SUBJECT {과목} ? Programming, English, History
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
