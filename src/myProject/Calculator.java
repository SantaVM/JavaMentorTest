package myProject;

/**
 * Класс, отвечающий за проведение вычислений арифметических выражений (операций). Операции выражаются с помощью строк,
 * содержащих знаки операций. Допустимые знаки операций:
 * "-" - (минус) вычитание,
 * "+" - (плюс) сложение,
 * "*" - (звездочка) умножение,
 * "/" - (наклонная черта) деление.
 */
public class Calculator {

	/**
	 * Возвращает результат выполнения арифметичекого выражения в виде числа типа Integer
	 *
	 * @param firstArg Первый аргумент операции (уменьшаемое, слагаемое, множитель или делимое)
	 * @param operator строка, содержащая знак операции
	 * @param secondArg Второй аргумент операции (вычитаемое, второе слагаемое, второй множитель или делитель)
	 * @throws UnsupportedOperationException если переданная в operator строка не допустима
	 */
	public static int calculate(int firstArg, String operator, int secondArg){
		switch ( operator ) {
			case "-": return firstArg - secondArg;
			case "+": return firstArg + secondArg;
			case "*": return firstArg * secondArg;
			case "/": return firstArg / secondArg;
			default: throw new UnsupportedOperationException("Operator '" + operator + "' is not supported by Calculator");
		}
	}
}
