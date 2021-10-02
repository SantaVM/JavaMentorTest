package myProject.converters;

/**
 * Класс, реализующий конвертацию из текстового представления числа в десятичной системе арабскими цифрами
 * в число типа Integer и обратно
 */

public class ArabicConverter implements Converter {

	/**
	 *
	 * @param s Строка (содержащая арабские цифры (называемые также индийскими или индо-арабскими)) вида: "1234"
	 *          без пробелов и других символов между знаками
	 * @return целое число типа Integer
	 */
	@Override
	public int convertToInt( String s ) {
		return Integer.parseInt( s );
	}

	/**
	 *
	 * @param i Целое число в десятичном представлении Integer
	 * @return строка типа String
	 */
	@Override
	public String convertFromInt( int i ) {
		return Integer.toString( i );
	}

}
