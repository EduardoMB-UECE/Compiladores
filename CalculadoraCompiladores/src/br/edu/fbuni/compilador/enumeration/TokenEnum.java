package br.edu.fbuni.compilador.enumeration;

public enum TokenEnum {

	NUMERO(TipoTokenEnum.NUMERO), SOMA(TipoTokenEnum.OPERADOR), SUBTRACAO(TipoTokenEnum.OPERADOR),
	DIVISAO(TipoTokenEnum.OPERADOR), MULTIPLICACAO(TipoTokenEnum.OPERADOR),
	EXPONENCIAL(TipoTokenEnum.OPERADOR), PARENTESE_ESQ(TipoTokenEnum.PONTUACAO),
	PARENTESE_DIR(TipoTokenEnum.PONTUACAO);

	private TipoTokenEnum tipo;

	private TokenEnum() {
		tipo = null;
	}

	TokenEnum(TipoTokenEnum tipo) {
		this.tipo = tipo;
	}

	public TipoTokenEnum getTipo() {
		return this.tipo;
	}

}
