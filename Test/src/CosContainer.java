import java.lang.reflect.Field;
import java.lang.reflect.Method;

// 스프링 로딩될 때 전체 어노테이션을 스캔하는 역할
// 실행시에 되니까 런타임시에 스캔함 → 메모리에 뭐가 떴는지 분석하는 기술이 "리플렉션"
public class CosContainer {

	// invoke 호출 → 톰캣 시작 시
	public <T> T invokeAnnotation(T instance) {

		Method[] methods = instance.getClass().getDeclaredMethods(); // 이 클래스가 들고있는 모든 메소드 스캔함

		for (Method m : methods) {
			if (m.isAnnotationPresent(NumCheck.class)) {
				Field f[] = instance.getClass().getFields(); // new Money()가 들고있는 모든 필드를 가져와 (num1, num2)

				try {
					int num1 = f[0].getInt(instance); // instance : 실제 메모리 주소
					int num2 = f[1].getInt(instance);

					System.out.println(num1);
					System.out.println(num2);

					if (num1 - num2 < 0) {
						System.out.println("금액이 부족합니다.");
						return null;
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return instance;
	}
}
