package br.edu.fbuni.compilador.entidade;

import br.edu.fbuni.compilador.enumeration.TokenEnum;

public class TokenCalculadora<T> {

	private TokenEnum token;
	private T valor;
	private int numeroToken;
	private int inicioToken;
	private int fimToken;

	public TokenCalculadora() {
		token = null;
		valor = null;
		numeroToken = 0;
		inicioToken = 0;
		fimToken = 0;
	}

	public TokenCalculadora(int numeroToken, int inicioToken, int fimToken) {
		super();
		this.numeroToken = numeroToken;
		this.inicioToken = inicioToken;
		this.fimToken = fimToken;
	}

	public TokenCalculadora(TokenEnum token, int numeroToken, int inicioToken, int fimToken) {
		super();
		this.token = token;
		this.numeroToken = numeroToken;
		this.inicioToken = inicioToken;
		this.fimToken = fimToken;
	}

	public TokenCalculadora(T valor, int numeroToken, int inicioToken, int fimToken) {
		super();
		this.valor = valor;
		this.numeroToken = numeroToken;
		this.inicioToken = inicioToken;
		this.fimToken = fimToken;
	}

	public TokenCalculadora(TokenEnum token, T valor, int numeroToken, int inicioToken, int fimToken) {
		super();
		this.token = token;
		this.valor = valor;
		this.numeroToken = numeroToken;
		this.inicioToken = inicioToken;
		this.fimToken = fimToken;
	}

	public int getInicioToken() {
		return inicioToken;
	}

	public void setInicioToken(int inicioToken) {
		this.inicioToken = inicioToken;
	}

	public int getFimToken() {
		return fimToken;
	}

	public void setFimToken(int fimToken) {
		this.fimToken = fimToken;
	}

	public int getNumemroToken() {
		return numeroToken;
	}

	public void setNumemroToken(int numemroToken) {
		this.numeroToken = numemroToken;
	}

	public TokenCalculadora(TokenEnum token, int numeroToken) {
		this.token = token;
		this.numeroToken = numeroToken;
	}

	public T getValor() {
		return valor;
	}

	public void setValor(T valor) {
		this.valor = valor;
	}

	public TokenEnum getToken() {
		return token;
	}

	public void setToken(TokenEnum token) {
		this.token = token;
	}

	public int getNumeroToken() {
		return numeroToken;
	}

	public void setNumeroToken(int numeroToken) {
		this.numeroToken = numeroToken;
	}
}
