package br.edu.fbuni.compilador;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.edu.fbuni.compilador.entidade.TokenCalculadora;
import br.edu.fbuni.compilador.enumeration.TokenEnum;
import br.edu.fbuni.compilador.exception.AnalisadorLexicoException;
import br.edu.fbuni.compilador.util.RegexUtil;

public class AnalizadorLexicoCalculadora {

	private static final boolean DEBUG = true;
	private static final int ERRO_GERAL = 0;
	private static final int MSG_INICIANDO_OPERADOR_ERRADO = 1;
	private static final int MSG_INICIANDO_SIMBOLO_ERRADO = 2;
	private static final int MSG_DOIS_OPERADORES_SEGUIDOS = 3;

	public static List<TokenCalculadora<Object>> analisarExpressao(String expressao) throws AnalisadorLexicoException {
		Pattern pattern = Pattern.compile(RegexUtil.REGEX_IDENTIFICADOR_DE_TOKENS);
		Matcher matcher = pattern.matcher(expressao);

		List<TokenCalculadora<Object>> tokens = new ArrayList<>();

		int numToken = 0;
		while (matcher.find()) {

			TokenCalculadora<Object> token = criarTokenValido(matcher, numToken);

			// TESTA SE INICIA COM OPERADOR INVALIDO
			if (numToken == 0 && (TokenEnum.MULTIPLICACAO.equals(token.getToken())
					|| TokenEnum.DIVISAO.equals(token.getToken()) || TokenEnum.EXPONENCIAL.equals(token.getToken())
					|| TokenEnum.PARENTESE_DIR.equals(token.getToken()))) {
				throw new AnalisadorLexicoException(
						mensagemErroTokenInvalido(token.getValor(), MSG_INICIANDO_OPERADOR_ERRADO));
			}

			// SE TOKEN FOR NULO NAO FAZ PARTE DA LINGUAGEM
			if (token.getToken() == null) {
				throw new AnalisadorLexicoException(mensagemErroTokenInvalido(token.getValor(), ERRO_GERAL));
			}

			tokens.add(token);
			debuggarToken(token);
			numToken++;
		}

		return tokens;
	}

	private static TokenCalculadora<Object> criarTokenValido(Matcher matcher, int numToken) {
		String valorToken = matcher.group();
		TokenCalculadora<Object> novoToken = new TokenCalculadora<Object>(valorToken, numToken, matcher.start(),
				matcher.end());

		if (valorToken.matches(RegexUtil.REGEX_IDENTIFICADOR_DE_NUMERO)) {
			// TRANSFORMA O VALOR DO TOKEN DO TIPO NUMERICO
			novoToken.setToken(TokenEnum.NUMERO);
			novoToken.setValor(Float.valueOf(valorToken));
		} else
			switch (valorToken) {
			case "+":
				novoToken.setToken(TokenEnum.SOMA);
				break;
			case "-":
				novoToken.setToken(TokenEnum.SUBTRACAO);
				break;
			case "/":
				novoToken.setToken(TokenEnum.DIVISAO);
				break;
			case "*":
				novoToken.setToken(TokenEnum.MULTIPLICACAO);
				break;
			case "**":
				novoToken.setToken(TokenEnum.EXPONENCIAL);
				break;
			case "(":
				novoToken.setToken(TokenEnum.PARENTESE_ESQ);
				break;
			case ")":
				novoToken.setToken(TokenEnum.PARENTESE_DIR);
				break;
			default:
				break;
			}

		return novoToken;
	}

	private static String mensagemErroTokenInvalido(Object valor, int tipo) {

		if (tipo == ERRO_GERAL) {
			return "Token \"" + valor + "\" não reconhecido.";
		} else if (tipo == MSG_INICIANDO_SIMBOLO_ERRADO) {
			return "Iniciando com simbolo \"" + valor + "\". Não é válido.";
		} else if (tipo == MSG_DOIS_OPERADORES_SEGUIDOS) {
			return "Dois operadores seguidos. Operador indetificado\"" + valor + "\".";
		}
		return "Erro nao esperado";
	}

	/**
	 * Metodo simples para debug.
	 * 
	 * @param tokenCalculadora Token a ser debugado
	 */
	private static void debuggarToken(TokenCalculadora<Object> tokenCalculadora) {
		if (DEBUG)
			System.out.println("Token #" + tokenCalculadora.getNumemroToken() + " " + tokenCalculadora.getValor()
					+ " index: " + tokenCalculadora.getInicioToken() + ", " + tokenCalculadora.getFimToken());
	}

}