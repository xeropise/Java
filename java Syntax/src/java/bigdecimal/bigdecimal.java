package java.bigdecimal;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class bigdecimal {
	
	
	
	
	public static void main(String[] args) {
		// ���� ���̴� ���� ����� ���� �Ǿ� �ִ�.
		// 0
		BigDecimal zero = BigDecimal.ZERO;
		
		// 1
		BigDecimal one = BigDecimal.ONE;
		
		// 10
		BigDecimal ten = BigDecimal.TEN;
		
		
		// ** BigDecimal �ʱ�ȭ **
		
		// double Ÿ���� �״�� �ʱ�ȭ�ϸ� ��� ���� �ٸ� ���� ������. �̴� double Ÿ���� �������� �ٻ� ���� �����ϰ� �ֱ� ����
		// 0.01000000000000000020816681711721685132943093776702880859375
		new BigDecimal(0.01);
		
		// ���ڿ��� �ʱ�ȭ�ϸ� ���� �ν�
		// 0.01
		new BigDecimal("0.01");
		
		// ���� ������ ���, double#toString�� �̿��ϸ� ���ڿ��� �ʱ�ȭ
		// 0.01
		BigDecimal.valueOf(0.01);
		
/* ################################################################ */
		
		// ** BigDecimal �� ���� **
		
		// BigDecimal�� �⺻ Ÿ���� �ƴ� ������Ʈ�̱⶧����, Ư�� ���� �� ������ �����ؾ� ��.
		// double Ÿ���� ����ϴ� ������� ���ǽ������� == �� ����ϸ�, ����ġ ���� ���� ��� �ʷ�
		
		BigDecimal a = new BigDecimal("2.01");
		BigDecimal b = new BigDecimal("2.010");
		
		// ��ü�� ���۷��� �ּҿ� ���� �� �����ڷ� ���ǽ������� ���� �� ��� ������
		// false
		System.out.println(a == b );
		
		// ���� �񱳸� ���� ���, �Ҽ��� �� ���� 0���� ������ ���� ���� �ؾ� true 
		// false
		a.equals(b);
		
		// ���� �񱳸� ���� ���, �Ҽ��� �� ���� 0�� �����ϰ� ���� �����ϸ� 0, ������ -1, ������ 1�� ��ȯ 
		// 0
		a.compareTo(b);
		
/* ################################################################ */
		
		// ** BigDecimal ��Ģ ���� **
		
		// double Ÿ�Ժ��� ��Ȳ�ϰ� ������ ��
		
		// ���ϱ�
		// 13
		a.add(b);
		
		// ����
		// 7
		a.subtract(b);
		
		// ���ϱ�
		// 30
		a.multiply(b);
		
		// ������
		// 3.3333...
		// java.lang.ArithmeticException: Non-terminating decimal expansion; no exact representable decimal result.
		a.divide(b);
		
		// ������
		// 3.333
		a.divide(b, 3, RoundingMode.HALF_EVEN);
		
		// ������ �� ������
		// ��ü �ڸ����� 34���� ����
		// 1
		a.remainder(b, MathContext.DECIMAL128);
		
		// ���밪
		// 3
		new BigDecimal("-3").abs();
		
		// �� �� �� �ּҰ�
		// 3
		a.min(b);
		
		// �� �� �� �ִ밪
		// 10
		a.max(b);
		
/* ################################################################ */
		
		// ** BigDecimal �Ҽ��� ó�� **
		// RoundingMode.HALF_EVEN�� �ڹ��� �⺻ �ݿø� ��å����, �����ǿ��� ����ϴ�
		// Bankers Rounding�� ������ �˰����� ���, 
		
		// �Ҽ��� ���ϸ� �����Ѵ� 
		// 1
		new BigDecimal("1.1234567890").setScale(0, RoundingMode.FLOOR);
		
		// �Ҽ��� ���ϸ� �����ϰ�, 1�� ������Ų��
		// 2
		new BigDecimal("1.123456789").setScale(0, RoundingMode.CEILING);
		
		// ���������� �Ҽ��� ���ϸ� �����Ѵ�
		// -1
		new BigDecimal("--1.1234567890").setScale(0, RoundingMode.CEILING);
		
		// �Ҽ��� �ڸ������� �������� 0 �κ��� ������ ���� ��ȯ�Ѵ�.
		// 0.999
		new BigDecimal("0.99990").stripTrailingZeros();
		
		// �Ҽ��� �ڸ����� �������Ѵ�.
		// ���� �Ҽ��� �ڸ������� ���� �ڸ����� �Ҽ����� �����ϸ� ���ܰ� �߻��Ѵ�
		// java.lang.ArithmeticException: Rounding necessary
		new BigDecimal("0.1234").setScale(3);
		
		// �ݿø� ��å�� ����ϸ�, ���ܰ� �߻����� �ʴ´�.
		// 0.123
		new BigDecimal("0.1234").setScale(3, RoundingMode.HALF_EVEN);
		
		// �Ҽ����� ������ �ʰ�, �ݿø��Ѵ�.
		// 0
		new BigDecimal("0.1234").setScale(0, RoundingMode.HALF_EVEN);
		
		// 1
		new BigDecimal("0.9876").setScale(0, RoundingMode.HALF_EVEN);
		
/* ################################################################ */
		
		// BigDecimal ������ ó��
		
		BigDecimal b10 = new BigDecimal("10");
		BigDecimal b3 = new BigDecimal("3");
		
		// ������ ����� �������� �������� ���� �߻�
		// java.lang.ArithmeticException: Non-terminating decimal expansion; no exact representable decimal result.
		b10.divide(b3);
		
		// �ݿø� ��å�� ����ϸ� ���ܰ� �߻����� ����
		// 3
		b10.divide(b3, RoundingMode.HALF_EVEN);
		
		// �ݿø� �ڸ����� ��� 
		// 3.333333
		b10.divide(b3, 6, RoundingMode.HALF_EVEN);
		
		// 3.333333333
		b10.divide(b3, 9, RoundingMode.HALF_EVEN);
		
		// ��ü �ڸ����� 7���� �����ϰ�, HALF_EVEN �ݿø��� �����Ѵ�
		// 3.333333
		b10.divide(b3, MathContext.DECIMAL32);
		
		// ��ü �ڸ����� 16���� �����ϰ�, HALF_EVEN �ݿø��� �����Ѵ�.
		// 3.333333333333333
		b10.divide(b3, MathContext.DECIMAL64);
		
		// ��ü �ڸ����� 34���� �����ϰ�, HALF_EVEN �ݿø��� �����Ѵ�.
		// 3.333333333333333333333333333333333
		b10.divide(b3, MathContext.DECIMAL128);
		
		// ��ü �ڸ����� �������� �ʴ´�.
		// ���ܰ� �߻��Ѵ�.
		// java.lang.ArithmeticException: Non-terminating decimal expansion; no exact representable decimal result. 
		b10.divide(b3, MathContext.UNLIMITED);
		
/* ################################################################ */
		
		// BigDecimal ���ڿ� ��ȯ ���
		// .setScale()�� ����Ͽ� �Ҽ��� �ڸ��� �����ϸ�, �Ҽ��� ���� ����� ������, 
		// ���ڿ��� ����ϴ� ���� �����̶�� NumberFormat Ŭ������ ����ϴ� ���� �����ϴ�
		NumberFormat format = NumberFormat.getInstance();
		format.setMaximumFractionDigits(6);
		format.setRoundingMode(RoundingMode.HALF_EVEN);
		// 0.123457
		format.format(new BigDecimal("0.1234567890"));
	}

}
