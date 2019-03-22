import java.util.HashMap;
import java.util.Map;

public class test {

	public static void main(String[] args) {
		Object m =new HashMap<>();
		Map m2  = (Map)m;
		m2.put("a",3);
		m2.put("안녕", 123);
		m2.put(333, 123);

		System.out.println(m);
	}
}
