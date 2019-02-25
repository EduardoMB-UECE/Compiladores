package br.edu.fbuni.compilador.util;

public interface RegexUtil {
	public static final String REGEX_IDENTIFICADOR_DE_NUMERO = "\\d+(\\.\\d+)?";
	public static final String REGEX_IDENTIFICADOR_DE_ESPACO_BRANCO = "\\s+";
	public static final String REGEX_IDENTIFICADOR_DE_TOKENS = "\\d+(\\.\\d+)?|\\*\\*|[\\/\\*\\+\\-\\(\\)]|[^\\s+]";

}
