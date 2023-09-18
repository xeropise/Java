package base.bigdecimal;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class bigdecimal {

	public static void main(String[] args) {
		// 흔히 쓰이는 값은 상수로 정의 되어 있다.
		// 0
		BigDecimal zero = BigDecimal.ZERO;

		// 1
		BigDecimal one = BigDecimal.ONE;

		// 10
		BigDecimal ten = BigDecimal.TEN;


		// ** BigDecimal 초기화 **

		// double 타입을 그대로 초기화하면 기대 값과 다른 값을 가진다. 이는 double 타입의 이진수의 근사 값을 저장하고 있기 때문
		// 0.01000000000000000020816681711721685132943093776702880859375
		new BigDecimal(0.01);

		// 문자열로 초기화하면 정상 인식
		// 0.01
		new BigDecimal("0.01");

		// 위와 동일한 결과, double#toString을 이용하면 문자열로 초기화
		// 0.01
		BigDecimal.valueOf(0.01);

		/* ################################################################ */

		// ** BigDecimal 비교 연산 **

		// BigDecimal은 기본 타입이 아닌 오브젝트이기때문에, 특히 동등 비교 연산을 유의해야 함.
		// double 타입을 사용하던 습관대로 무의식적으로 == 을 사용하면, 예기치 않은 연산 결과 초래

		BigDecimal a = new BigDecimal("2.01");
		BigDecimal b = new BigDecimal("2.010");

		// 객체의 레퍼런스 주소에 대한 비교 연산자로 무의식적으로 값비교 할 경우 오동작
		// false
		System.out.println(a == b );

		// 값의 비교를 위해 사용, 소수점 맨 끝의 0까지 완전히 값이 동일 해야 true
		// false
		a.equals(b);

		// 값의 비교를 위해 사용, 소수점 맨 끝의 0을 무시하고 값이 동일하면 0, 적으면 -1, 많으면 1을 반환
		// 0
		a.compareTo(b);

		/* ################################################################ */

		// ** BigDecimal 사칙 연산 **

		// double 타입보다 장황하고 귀찮은 편

		// 더하기
		// 13
		a.add(b);

		// 빼기
		// 7
		a.subtract(b);

		// 곱하기
		// 30
		a.multiply(b);

		// 나누기
		// 3.3333...
		// java.lang.ArithmeticException: Non-terminating decimal expansion; no exact representable decimal result.
		a.divide(b);

		// 나누기
		// 3.333
		a.divide(b, 3, RoundingMode.HALF_EVEN);

		// 나누기 후 나머지
		// 전체 자리수를 34개로 제한
		// 1
		a.remainder(b, MathContext.DECIMAL128);

		// 절대값
		// 3
		new BigDecimal("-3").abs();

		// 두 수 중 최소값
		// 3
		a.min(b);

		// 두 수 중 최대값
		// 10
		a.max(b);

		/* ################################################################ */

		// ** BigDecimal 소수점 처리 **
		// RoundingMode.HALF_EVEN은 자바의 기본 반올림 정책으로, 금융권에서 사용하는
		// Bankers Rounding과 동일한 알고리즘을 사용,

		// 소수점 이하를 절사한다
		// 1
		new BigDecimal("1.1234567890").setScale(0, RoundingMode.FLOOR);

		// 소수점 이하를 절사하고, 1을 증가시킨다
		// 2
		new BigDecimal("1.123456789").setScale(0, RoundingMode.CEILING);

		// 음수에서는 소수점 이하만 절사한다
		// -1
		new BigDecimal("--1.1234567890").setScale(0, RoundingMode.CEILING);

		// 소수점 자리수에서 오른쪽의 0 부분을 제거한 값을 반환한다.
		// 0.999
		new BigDecimal("0.99990").stripTrailingZeros();

		// 소수점 자리수를 재정의한다.
		// 원래 소수점 자리수보다 작은 자리수의 소수점을 설정하면 예외가 발생한다
		// java.lang.ArithmeticException: Rounding necessary
		new BigDecimal("0.1234").setScale(3);

		// 반올림 정책을 명시하면, 예외가 발생하지 않는다.
		// 0.123
		new BigDecimal("0.1234").setScale(3, RoundingMode.HALF_EVEN);

		// 소수점을 남기지 않고, 반올림한다.
		// 0
		new BigDecimal("0.1234").setScale(0, RoundingMode.HALF_EVEN);

		// 1
		new BigDecimal("0.9876").setScale(0, RoundingMode.HALF_EVEN);

		/* ################################################################ */

		// BigDecimal 나누기 처리

		BigDecimal b10 = new BigDecimal("10");
		BigDecimal b3 = new BigDecimal("3");

		// 나누기 결과가 무한으로 떨어지면 예외 발생
		// java.lang.ArithmeticException: Non-terminating decimal expansion; no exact representable decimal result.
		b10.divide(b3);

		// 반올림 정책을 명시하면 예외가 발생하지 않음
		// 3
		b10.divide(b3, RoundingMode.HALF_EVEN);

		// 반올림 자리값을 명시
		// 3.333333
		b10.divide(b3, 6, RoundingMode.HALF_EVEN);

		// 3.333333333
		b10.divide(b3, 9, RoundingMode.HALF_EVEN);

		// 전체 자리수를 7개로 제한하고, HALF_EVEN 반올림을 적용한다
		// 3.333333
		b10.divide(b3, MathContext.DECIMAL32);

		// 전체 자리수를 16개로 제한하고, HALF_EVEN 반올림을 적용한다.
		// 3.333333333333333
		b10.divide(b3, MathContext.DECIMAL64);

		// 전체 자리수를 34개로 제한하고, HALF_EVEN 반올림을 적용한다.
		// 3.333333333333333333333333333333333
		b10.divide(b3, MathContext.DECIMAL128);

		// 전체 자리수를 제한하지 않는다.
		// 예외가 발생한다.
		// java.lang.ArithmeticException: Non-terminating decimal expansion; no exact representable decimal result.
		b10.divide(b3, MathContext.UNLIMITED);

		/* ################################################################ */

		// BigDecimal 문자열 변환 출력
		// .setScale()을 사용하여 소수점 자리를 제한하면, 소수점 값은 상실해 버린다,
		// 문자열로 출력하는 것이 목적이라면 NumberFormat 클래스를 사용하는 것이 적합하다
		NumberFormat format = NumberFormat.getInstance();
		format.setMaximumFractionDigits(6);
		format.setRoundingMode(RoundingMode.HALF_EVEN);
		// 0.123457
		format.format(new BigDecimal("0.1234567890"));
	}

}
