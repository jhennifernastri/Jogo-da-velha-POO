package br.com.jogodavelha;

import java.util.Scanner;

public class Jogo {

	
	public static void main(String [] args) {
		
		
		Scanner scan = new Scanner(System.in);
        JogoDaVelha jogo = new JogoDaVelha();
        jogo.inicializarJogo();
        System.out.println("Jogo da Velha!");
        
        boolean querJogar = true;
        while (querJogar) {
            jogo.printBoard();
            int linha, col;
            do {
                System.out.println("Jogador " + jogo.getJogadoAtual() + ", entre com uma linha (0-2) e coluna (0-2): ");
                linha = scan.nextInt();
                col = scan.nextInt();
            } while (!jogo.escolherPosicao(linha, col));
            
            jogo.mudarJogador();
            if (jogo.conferirGanhador()) {
                System.out.println("Jogador " + jogo.getJogadoAtual() + " ganhou!");
                jogo.printBoard();
                querJogar = false;
            } else if (jogo.isBoardFull()) {
                System.out.println("Empate!");
                jogo.printBoard();
                querJogar = false;
            }
        }
        
        scan.close();
	}
}
