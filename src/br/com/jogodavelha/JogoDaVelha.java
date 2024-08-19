package br.com.jogodavelha;

public class JogoDaVelha {

	private char[][] board;
    private char jogadorAtual;

    public JogoDaVelha() {
        board = new char[3][3];
        jogadorAtual = 'X';
        inicializarJogo();
    }

    public void inicializarJogo() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean conferirGanhador() {
        return (conferirLinhas() || conferirColunas() || conferirDiagonais());
    }

    private boolean conferirLinhas() {
        for (int i = 0; i < 3; i++) {
            if (conferirLinha(board[i][0], board[i][1], board[i][2])) {
                return true;
            }
        }
        return false;
    }

    private boolean conferirColunas() {
        for (int i = 0; i < 3; i++) {
            if (conferirLinha(board[0][i], board[1][i], board[2][i])) {
                return true;
            }
        }
        return false;
    }

    private boolean conferirDiagonais() {
        return ((conferirLinha(board[0][0], board[1][1], board[2][2])) || (conferirLinha(board[0][2], board[1][1], board[2][0])));
    }

    private boolean conferirLinha(char c1, char c2, char c3) {
        return (c1 != '-' && c1 == c2 && c2 == c3);
    }

    public void mudarJogador() {
        jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
    }

    public boolean escolherPosicao(int linha, int col) {
        if (linha >= 0 && col >= 0 && linha < 3 && col < 3 && board[linha][col] == '-') {
            board[linha][col] = jogadorAtual;
            return true;
        }
        return false;
    }

    public char getJogadoAtual() {
        return jogadorAtual;
    }
	
}
