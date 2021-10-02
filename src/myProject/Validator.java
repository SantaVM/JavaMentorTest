package myProject;

import myProject.templates.Template;

/**
 * Класс, отвечающий за валидацию ограничений на значение аргументов и результатов выполнения арифметических выражений.
 * Ограничения могут быть как "органическими", т.е. заложенными в саму систему счисления, так и "искусственными" -
 * заданными в условиях проекта.
 */

public class Validator {

	/**
	 * Метод проверяет соответствие аргуметов арифметического выражения органичениям, установленным в проекте,
	 * и описанным в полях класса xxxTemplate.
	 * @param firstArg Значение первого аргумента
	 * @param secondArg Значение второго аргумента
	 * @param template Конкретный класс, расширяющий общий класс-шаблон {@code Template}, и содержащий ограничения
	 *                для конкретной системы счисления.
	 * @return true - если проверка пройдена успешно и false - если проверка обнаружила нарушения
	 */
	public static boolean validateArgs( int firstArg, int secondArg, Template template ) {
		return ( template.getMinArgValue() <= firstArg && firstArg <= template.getMaxArgValue() &&
				template.getMinArgValue() <= secondArg && secondArg <= template.getMaxArgValue() );
	}

	/**
	 * Метод проверяет соответствие результата выполнения арифметического выражения органичениям, установленным в проекте,
	 * и описанным в полях класса xxxTemplate.
	 * @param result Значение результата
	 * @param template - Конкретный класс, расширяющий общий класс-шаблон {@code Template}, и содержащий ограничения
	 * 	                  для конкретной системы счисления.
	 * @return true - если проверка пройдена успешно и false - если проверка обнаружила нарушения
	 */
	public static boolean validateResult( int result, Template template) {
		return ( template.getMinResult() <= result && result <= template.getMaxResult() );
	}
}
