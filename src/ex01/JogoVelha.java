// Tecnica minimax

package ex01;

import java.util.ArrayList;
import java.util.Random;

public class JogoVelha {

    private String[][] tabuleiro;

    public JogoVelha() {
        tabuleiro = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = "#";
            }
        }
    }

    public void magicJogoVelha() {
        System.out.println("Exercicio 1 - Jogo da Velha");
        imprimirTabuleiro();

        if (proximaJogada()) {
            imprimirTabuleiro();
        }

        System.out.println("Fim do jogo.");

    }

    private boolean proximaJogada () {
        Random gerador = new Random();
        int posicao1 = gerador.nextInt(2);
        int posicao2 = gerador.nextInt(2);
        int tentativas = 0;
        boolean preenchido = false;
        ArrayList<String> combinacoesTentadas = new ArrayList<>();
        combinacoesTentadas.add(posicao1 + "_" + posicao2);

        while (tentativas < 9 && !preenchido) {
            if (this.tabuleiro[posicao1][posicao2].equals("#")) {
                this.tabuleiro[posicao1][posicao2] = "X";
                preenchido = true;
            } else {
                boolean combinar = true;
                posicao1 = gerador.nextInt(2);
                posicao2 = gerador.nextInt(2);

                while (combinar) {
                    if (!combinacoesTentadas.contains(posicao1 + "_" + posicao2)) {
                        combinar = false;
                        combinacoesTentadas.add(posicao1 + "_" + posicao2);
                    }
                }
            }
            tentativas++;
        }

        return preenchido;
    }

    private void imprimirTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
