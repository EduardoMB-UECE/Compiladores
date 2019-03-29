package br.edu.fbuni.compilador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import br.edu.fbuni.compilador.entidade.TokenCalculadora;
import br.edu.fbuni.compilador.exception.AnalisadorLexicoException;

public class Main {

	private static String expressao = "";
	private static final File arquivoEntrada = new File("analizador.txt");

	public static void main(String[] args) {
		criarArquivoEntrada();
		carregarArquivoLinhaALinha();

		@SuppressWarnings("unused")
		List<TokenCalculadora<Object>> resultado = null;
		try {
			String[] split = expressao.split("\n");
			for (String linha : split) {
				resultado = AnalizadorLexicoCalculadora.analisarExpressao(linha);
			}
		} catch (AnalisadorLexicoException e) {
			System.out.println(e.getMessage());
			System.out.println("################");
		}

		System.out.println("Programa finalizado =====================");
	}

	/**
	 * L� todos os caracteres do arquivo linha a linha.
	 */
	private static void carregarArquivoLinhaALinha() {
		String linha = "";
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(arquivoEntrada));

			linha = reader.readLine();
			while (linha != null) {
				expressao = expressao.concat(linha + "\n");
				linha = reader.readLine();
			}

			reader.close();
		} catch (IOException e) {
			System.out.println("Erro ao remover espacos em branco!");
			e.printStackTrace();
			return;
		}

	}

	/**
	 * Cria arquivo para a entrada das expressoes da calculadora, caso nao exista.
	 */
	private static void criarArquivoEntrada() {
		if (!arquivoEntrada.exists()) {
			try {
				arquivoEntrada.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
