package application;

import java.util.Scanner;

import xadrez.Partida;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;

public class Program {

	public static void main(String[] args) {
		 
		Scanner sc = new Scanner(System.in);
		Partida partida = new Partida();
		
		while (true) {
			UI.printTabuleiro(partida.getPecas());
			System.out.println();
			System.out.print("Origem: ");
			PosicaoXadrez origem = UI.lerPosicaoXadrez(sc);
			
			System.out.println();
			System.out.print("Alvo: ");
			PosicaoXadrez alvo = UI.lerPosicaoXadrez(sc);
			
			PecaXadrez pecaCapturada = partida.realizaMovimento(origem, alvo);
		}
		
	}

}
