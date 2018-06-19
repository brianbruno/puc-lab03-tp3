// Tecnica minimax

package ex01;

import java.util.ArrayList;

public class JogoVelha {

    private Tabuleiro tabuleiro;
    private ArrayList<Tabuleiro> filhos;

    public JogoVelha() {
        this.tabuleiro = new Tabuleiro();
    }

    public void magicJogoVelha() {
        System.out.println("Exercicio 1 - Jogo da Velha");
        this.tabuleiro.imprimirTabuleiro();


        System.out.println("");
        System.out.println("Fim do jogo.");

    }

    /*
    ROTINA minimax(nó, profundidade)
        SE nó é um nó terminal OU profundidade = 0 ENTÃO
            RETORNE o valor da heurística do nó
        SENÃO SE o nó representa a jogada de algum adversário ENTÃO
            α ← +∞
            PARA CADA filho DE nó
                α ← min(α, minimax(filho, profundidade-1))
            FIM PARA
            RETORNE α
        SENÃO
            α ← -∞
            PARA CADA filho DE nó
                α ← max(α, minimax (filho, profundidade-1))
            FIM PARA
            RETORNE α
        FIM SE
    FIM ROTINA
     */
}
