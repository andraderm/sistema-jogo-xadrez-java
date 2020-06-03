package xadrez;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.peca.Rei;
import xadrez.peca.Torre;

public class Partida {
	
	private Tabuleiro tabuleiro;
	
	public Partida() {
		tabuleiro = new Tabuleiro(8, 8);
		setupInicial();
	}
	
	public PecaXadrez[][] getPecas(){
		PecaXadrez[][] mat = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		for (int i = 0; i < tabuleiro.getLinhas(); i++) {
			for (int j = 0; j < tabuleiro.getColunas(); j++) {
				mat[i][j] = (PecaXadrez) tabuleiro.peca(i, j);
			}
		}
		return mat;
	}
	
	private void setupInicial() {
		tabuleiro.colocarPeca(new Torre(tabuleiro, Cor.BRANCAS), new Posicao(2, 1));
		tabuleiro.colocarPeca(new Rei(tabuleiro, Cor.PRETAS), new Posicao(0, 4));
		tabuleiro.colocarPeca(new Rei(tabuleiro, Cor.BRANCAS), new Posicao(7, 4));
	}
	
}
