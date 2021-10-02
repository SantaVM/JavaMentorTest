package myProject;

import myProject.templates.ArabicTemplate;
import myProject.templates.RomanTemplate;
import myProject.templates.Template;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Основной класс проекта.
 */
public class Main {

	/**	Строка шаблона регулярного выражения для проверки соответствия операции арабской системе счисления.
	 * Позволяет выделить три группы: первый аргумент операции, знак операции и второй аргумент операции.
	 * Игнорирует пробелы перед/после аргументами.
	 * Допустимые знаки операции: +, -, *, /
	 */
	private static final String ARABIC_PATTERN_STRING = "\\A\\s*(\\d+)\\s*([-+*/])\\s*(\\d+)\\s*\\z";

	/**Строка шаблона регулярного выражения для проверки соответствия операции римской системе счисления.
	 * Позволяет выделить три группы: первый аргумент операции, знак операции и второй аргумент операции.
	 * Игнорирует пробелы перед/после аргументами.
	 * Римские цифры могут быть в любом регистре, т.е. можно передавать "i" или "I"
	 * Допустимые знаки операции: +, -, *, /
	 */
	private static final String ROMAN_PATTERN_STRING = "\\A\\s*([iIvVxXlLcCdDmM]+)\\s*([-+*/])\\s*([iIvVxXlLcCdDmM]+)\\s*\\z";

	/**
	 * Список для всех поддерживаемых проектом систем счисления
	 */
	public static ArrayList< Template > templates = new ArrayList<>();

	static {
		templates.add( new ArabicTemplate( ARABIC_PATTERN_STRING, 1, 10, Integer.MIN_VALUE, Integer.MAX_VALUE ) );
		templates.add( new RomanTemplate( ROMAN_PATTERN_STRING, 1, 10, 1, 3999 ) );
	}

	public static void main( String[] args ) {

		System.out.println("Input:");
		Scanner scanner = new Scanner( System.in );
		String expression = scanner.nextLine();
		scanner.close();

		boolean solved = false;
		for ( Template t :  templates  ) {
			if ( solved ) break;
			Pattern pattern = Pattern.compile( t.getPatternString(), Pattern.UNICODE_CHARACTER_CLASS );
			Matcher matcher = pattern.matcher( expression );
			if ( matcher.find() ) {
				solved = true;
				String first = matcher.group( 1 );
				String operator = matcher.group( 2 );
				String second = matcher.group( 3 );
				int firstArg = t.getConverter().convertToInt( first );
				int secondArg = t.getConverter().convertToInt( second );
				if ( Validator.validateArgs( firstArg, secondArg, t ) ) {
					int result = Calculator.calculate( firstArg, operator, secondArg );
					if ( Validator.validateResult( result, t )){
						System.out.println( "Output:" );
						System.out.println( t.getConverter().convertFromInt( result ) );
					} else {
						throw new IllegalArgumentException("The result of the calculation goes beyond the permissible limits");
					}
				} else {
					throw new IllegalArgumentException("Arguments are out of bounds");
				}
			}
		}

		if( !solved ){
			throw new IllegalArgumentException("Wrong expression entered");
		}
	}

	public static void addTemplate(Template template){
		templates.add( template );
	}
}
