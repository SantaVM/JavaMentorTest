package myProject.templates;

import myProject.converters.RomanConverter;

/**
 * Класс-шаблон, отвечающий за систему счисления в римских цифрах.
 * Используется наиболее широко принятый формат римских чисел:
 *   - допустимые символы: IVXLCDM
 *   - не более 3 одинаковых знаков подряд;
 *   - меньшая цифра может быть записана и слева от большей, тогда её следует вычесть из большей.
 *     При этом вычитаться могут только цифры, обозначающие 1 или степени 10, а в качестве уменьшаемого выступать
 *     только ближайшие в числовом ряду к вычитаемой цифре (то есть вычитаемое, умноженное на 5 или 10).
 *   - отсутствуют обозначения для ноля, отрицательных чисел и дробей.
 *   - максимальное целое число в указанном формате соответствует 3999.
 */
public class RomanTemplate extends Template {
	public RomanTemplate (String patternString, int minArgValue, int maxArgValue, int minResult, int maxResult){
		super( patternString,  minArgValue,  maxArgValue,  minResult,  maxResult, new RomanConverter());
	}
}
