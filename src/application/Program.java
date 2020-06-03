package application;

import xadrez.Partida;

public class Program {

	public static void main(String[] args) {
		 
		Partida p = new Partida();
		UI.printTabuleiro(p.getPecas());
		
	}

}
