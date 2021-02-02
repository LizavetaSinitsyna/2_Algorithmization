package by.epam.module2.part3;

public class Fraction {
	private long numerator;
	private long denominator;

	public Fraction(long numerator, long denominator) {
		this.numerator = numerator;
		if (denominator == 0) {
			System.out.println("Denominator can't be equal to 0! The denominator is assigned the default value = 1.");
			denominator = 1;
		} else {
			this.denominator = denominator;
		}
	}
	
	public Fraction() {
		numerator = 1;
		denominator = 1;
	}
	
	public long getNumerator() {
		return numerator;
	}

	public void setNumerator(long numerator) {
		this.numerator = numerator;
	}

	public long getDenominator() {
		return denominator;
	}

	public void setDenominator(long denominator) {
		this.denominator = denominator;
	}

	@Override
	public String toString() {
		return numerator + "/" + denominator;
	}

}
