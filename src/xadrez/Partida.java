package xadrez;

import tabuleiro.Peca;
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
	
	public PecaXadrez realizaMovimento(PosicaoXadrez posicaoOrigem, PosicaoXadrez posicaoAlvo) {
		Posicao origem = posicaoOrigem.toPosicao();
		Posicao alvo = posicaoAlvo.toPosicao();
		validaPosicaoInicial(origem);
		Peca pecaCapturada = fazMovimento(origem, alvo);
		return (PecaXadrez)pecaCapturada;
	}
	
	private Peca fazMovimento(Posicao origem, Posicao alvo) {
		Peca p = tabuleiro.removePeca(origem);
		Peca pecaCapturada = tabuleiro.removePeca(alvo);
		tabuleiro.colocarPeca(p, alvo);
		return pecaCapturada;
	}
	
	private void validaPosicaoInicial(Posicao posicao) {
		if (!tabuleiro.existePeca(posicao)) {
			throw new XadrezException("Nao ha peca na posicao de origem");
		}
	}
	
	private void colocaNovaPeca(char coluna, int linha, PecaXadrez peca) {
		tabuleiro.colocarPeca(peca, new PosicaoXadrez(coluna, linha).toPosicao());
	}
	
	private void setupInicial() {
		colocaNovaPeca('c', 1, new Torre(tabuleiro, Cor.BRANCAS));
		colocaNovaPeca('c', 2, new Torre(tabuleiro, Cor.BRANCAS));
        colocaNovaPeca('d', 2, new Torre(tabuleiro, Cor.BRANCAS));
        colocaNovaPeca('e', 2, new Torre(tabuleiro, Cor.BRANCAS));
        colocaNovaPeca('e', 1, new Torre(tabuleiro, Cor.BRANCAS));
        colocaNovaPeca('d', 1, new Rei(tabuleiro, Cor.BRANCAS));

        colocaNovaPeca('c', 7, new Torre(tabuleiro, Cor.PRETAS));
        colocaNovaPeca('c', 8, new Torre(tabuleiro, Cor.PRETAS));
        colocaNovaPeca('d', 7, new Torre(tabuleiro, Cor.PRETAS));
        colocaNovaPeca('e', 7, new Torre(tabuleiro, Cor.PRETAS));
        colocaNovaPeca('e', 8, new Torre(tabuleiro, Cor.PRETAS));
        colocaNovaPeca('d', 8, new Rei(tabuleiro, Cor.PRETAS));
	}
	
}
