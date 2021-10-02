package myProject.templates;

import myProject.converters.Converter;

/**
 * Класс-шаблон. Используется не напрямую, а в качестве родительского (parent) для классов-наследников, каждый из которых
 * представляет собой конкретную систему счисления и несет в себе начальные условия и ограничения, характерные для
 * указанной системы счисления.
 * Ограничения могут быть как "органическими", т.е. заложенными в саму систему счисления, так и "искусственными" -
 * заданными в условиях проекта.
 *
 * Специально установлен модификатор abstract, чтобы не использовали напрямую, хотя класс не имеет методов abstract.
 */

public abstract class Template {
	// строка шаблона для использования в Регулярном выражении (regular expression)
	private String patternString;
	// минимальное значение, которое могут иметь аргументы арифметического выражения в конкретной системе счисления
	private int minArgValue;
	// максимальное значение, которое могут иметь аргументы арифметического выражения в конкретной системе счисления
	private int maxArgValue;
	// минимальное значение, которое может принимать результат выполнения арифметического выражения
	private int minResult;
	// максимально значение, которое может принимать результат выполнения арифметического выражения
	private int maxResult;
	// конкретная реализация интерфейса Converter, относящаяся к данной конкретной системе счисления
	private Converter converter;

	public Template( String patternString, int minArgValue, int maxArgValue, int minResult, int maxResult, Converter converter ) {
		this.patternString = patternString;
		this.minArgValue = minArgValue;
		this.maxArgValue = maxArgValue;
		this.minResult = minResult;
		this.maxResult = maxResult;
		this.converter = converter;
	}

	public String getPatternString() {
		return patternString;
	}

	public int getMinArgValue() {
		return minArgValue;
	}

	public int getMaxArgValue() {
		return maxArgValue;
	}

	public int getMinResult() {
		return minResult;
	}

	public int getMaxResult() {
		return maxResult;
	}

	public Converter getConverter() {
		return converter;
	}
}
