package myProject.templates;

import myProject.converters.ArabicConverter;

/**
 * Класс-шаблон, отвечающий за арабские цифры (называемые также индийскими или индо-арабскими)) вида: "0123456789"
 */
public class ArabicTemplate extends Template {

	public ArabicTemplate(String patternString, int minArgValue, int maxArgValue, int minResult, int maxResult){
		super( patternString,  minArgValue,  maxArgValue,  minResult,  maxResult, new ArabicConverter());
	}
}
