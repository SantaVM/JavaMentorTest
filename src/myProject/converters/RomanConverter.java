package myProject.converters;

import java.util.TreeMap;

/**
 * Класс, реализующий конвертацию из строки римской системы счисления в числа типа Integer
 * и обратно: из числа типа Integer в строку римских цифр.
 *
 * При конвертации проверяется соответсвие строки наиболее широко принятому формату римских чисел:
 * - допустимые символы: IVXLCDM
 * - не более 3 одинаковых знаков подряд;
 * - меньшая цифра может быть записана и слева от большей, тогда её следует вычесть из большей.
 *   При этом вычитаться могут только цифры, обозначающие 1 или степени 10, а в качестве уменьшаемого выступать
 *   только ближайшие в числовом ряду к вычитаемой цифре (то есть вычитаемое, умноженное на 5 или 10).
 * - отсутствуют обозначения для ноля, отрицательных чисел и дробей.
 * - максимальное целое число в указанном формате соответствует 3999.
 *
 * Таким образом, строки "IIII",  "IVI" и "IM" - не являются корректным написанием числа в римской системе.
 */

public class RomanConverter implements Converter {

	private final static TreeMap<Integer, String> map = new TreeMap<>();
	private final static TreeMap<Integer, Integer> mapSequence = new TreeMap<>();

	static {
		map.put(1000, "M");
		map.put(900, "CM");
		map.put(500, "D");
		map.put(400, "CD");
		map.put(100, "C");
		map.put(90, "XC");
		map.put(50, "L");
		map.put(40, "XL");
		map.put(10, "X");
		map.put(9, "IX");
		map.put(5, "V");
		map.put(4, "IV");
		map.put(1, "I");

		mapSequence.put(1000, 1000);
		mapSequence.put(900, 90);
		mapSequence.put(500, 100);
		mapSequence.put(400, 90);
		mapSequence.put(100, 100);
		mapSequence.put(90, 9);
		mapSequence.put(50, 10);
		mapSequence.put(40, 9);
		mapSequence.put(10, 10);
		mapSequence.put(9, null);
		mapSequence.put(5, 1);
		mapSequence.put(4, null);
		mapSequence.put(1, 1);
	}

	/**
	 *
	 * @param s Строка (текстовое представления числа в римской системе счисления) без пробелов между символами
	 *          в любом регистре, т.е. можно передавать "i" или "I"
	 * @return целое число Integer
	 * @throws IllegalArgumentException если переданная строка нарушает правила римской системы счисления
	 */
	@Override
	public int convertToInt( String s ) {
		String romanNumeral = s.toUpperCase();
		int result = 0;
		int i = 0;
		Integer key = map.lastKey();
		while ( ( romanNumeral.length() > 0 ) && ( key != null ) )  {
			String symbol = map.get( key );
			if ( romanNumeral.startsWith( symbol ) && i < 3 ) {
				result += key;
				romanNumeral = romanNumeral.substring( symbol.length() );
				if( key.equals( mapSequence.get( key ) ) )
					i++;
				key = mapSequence.get( key );
			} else {
				i = 0;
				key = map.lowerKey( key );
			}
		}

		if (romanNumeral.length() > 0) {
			throw new IllegalArgumentException("'" + s + "'" + " cannot be converted to a Roman Numeral");
		}

		return result;
	}

	/**
	 *
	 * @param i Целое число в десятичном представлении Integer
	 * @return строка в римской системе счисления
	 */
	@Override
	public String convertFromInt( int i ) {
		int key =  map.floorKey( i );
		if ( i == key ) {
			return map.get( i );
		}
		return map.get( key ) + convertFromInt(i - key );
	}
}
