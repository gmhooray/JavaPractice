
import java.lang.reflect.Method;

public class Main {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		try {
			Class Query = Class.forName("Query");
			Object queryInstance = Query.newInstance();
			Method method = Query.getMethod("execute", String.class);
			method.invoke(queryInstance, "LOAD data.xml");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
}