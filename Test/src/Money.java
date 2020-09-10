
public class Money {
	public int num1 = 30000;
	public int num2 = 50000;

	@NumCheck // 이 어노테이션 붙이는 순간, 음수 값이 나오면 값을 제어하는 역할하게 만들 것임
	public int minus() {
		return num1 - num2;
	}
}
