public class RuntimeLoad {
	public static void main(String[] args) {
		CosContainer c = new CosContainer();

		Money m = c.invokeAnnotation(new Money()); // m이 null 값 → 남은 금액 안뜸

		try {
			int money = m.minus();
			System.out.println("남은 금액은 : " + money);
		} catch (Exception e) {
			System.out.println("Money 객체가 만들어지지 않았습니다.");
		}
	}
}
