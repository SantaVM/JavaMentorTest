package myProject.converters;

/**
 * Определяет интерфейс для классов, преобразующих данные из текстового представления числа (представленного в
 * определенной системе счисления) в число типа Integer (в десятичной системе) и обратно
 * (из числа Integer в текстовое представление в опеределенной системе счисления)
 */

public interface Converter {

	/**
	 *
	 * @param s Строка (текстовое представления числа в определенной системе счисления) для преобразования в Integer
	 * @return Целое число Integer в десятичной системе для дальнейших вычислений
	 */
	int convertToInt ( String s);

	/**
	 *
	 * @param i Целое число в десятичном представлении Integer для преобразования в строку
	 * @return текстовое представление числа в определенной системе счисления
	 */
	String convertFromInt( int i);
}
