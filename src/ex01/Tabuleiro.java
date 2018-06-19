package ex01;

import javafx.scene.control.Tab;

import java.util.ArrayList;

public class Tabuleiro {

    private String[][] tabuleiro = new String[3][3];
    private ArrayList<Tabuleiro> filhos = new ArrayList<>();
    private int possibilidades = 0;
    private static final String X = "x";
    private static final String O = "o";

    public Tabuleiro() {
        preencherVazio();
        gerarArvore();
    }

    public Tabuleiro(int linha, int coluna, String simbolo) {
        preencherVazio();
        gerarArvore();
        preencherPosicao(linha, coluna, simbolo);
    }

    public Tabuleiro(String[][] tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    private void preencherVazio() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.tabuleiro[i][j] = " ";
            }
        }
    }

    public boolean preencherPosicao(int linha, int coluna, String simbolo)  {
        boolean resultado = false;
        if (this.tabuleiro[linha][coluna].equals(" ")) {
            this.tabuleiro[linha][coluna] = simbolo;
            resultado = true;
        }
        return resultado;
    }

    public int posicoesDisponiveis() {
        int pos = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.tabuleiro[i][j].equals(" ")) {
                    pos++;
                }
            }
        }
        return pos;
    }

    public void imprimirTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(this.tabuleiro[i][j]);
                if (j == 0 || j == 1 )
                    System.out.print(" | ");
            }
            if (i < 2) {
                System.out.println("");
                System.out.println("---------");
            }
        }
    }



    public int possibilidades() {

        if(posicoesDisponiveis() == 9)
            possibilidades = 91;

        if (this.filhos !=  null) {
            this.filhos.forEach((filho) -> {
                possibilidades += filho.possibilidades();
            });
        } else  {
            if (verificarVitoria())
                possibilidades = 1;
        }

        return possibilidades;

    }

    public boolean verificarVitoria() {
        boolean resultado = false;
        if (posicoesDisponiveis() == 0)  {
            boolean horizontal = verificarVitoriaHorizontal();
            boolean vertical = verificarVitoriaVertical();
            boolean diagonal = verificarVitoriaDiagonal();
            resultado = horizontal || vertical || diagonal;
        }
        return resultado;
    }

    public boolean verificarVitoriaDiagonal() {
        boolean vitoria = false;
        if ((this.tabuleiro[0][0].equals(X) &&
             this.tabuleiro[1][1].equals(X) &&
             this.tabuleiro[2][2].equals(X)) ||
            (this.tabuleiro[0][0].equals(X) &&
             this.tabuleiro[1][1].equals(X) &&
             this.tabuleiro[2][2].equals(X))) {
            vitoria = true;
        }
        return vitoria;
    }

    public boolean verificarVitoriaVertical() {
        boolean vitoria = true;
        for (int coluna = 0; coluna < 3; coluna++) {
            vitoria = true;
            for (int linha = 0; linha < 3; linha++) {
                if (!this.tabuleiro[linha][coluna].equals(X)) {
                    vitoria = false;
                    break;
                }
            }
            if (vitoria) {
                break;
            }
        }
        return vitoria;
    }

    public boolean verificarVitoriaHorizontal() {
        boolean vitoria = true;
        for (int i = 0; i < 3; i++) {
            vitoria = true;
            for (int j = 0; j < 3; j++) {
                if (!this.tabuleiro[i][j].equals(X)) {
                    vitoria = false;
                    break;
                }
            }
            if (vitoria)
                break;
        }
        return vitoria;
    }

    public ArrayList<Tabuleiro> getFilhos() {
        return filhos;
    }

    public void setFilhos(ArrayList<Tabuleiro> filhos) {
        this.filhos = filhos;
    }

    private int[] getPosicaoDisponivel() {
        int[] pos = new int[2];
        pos[0] = -1;
        pos[1] = -1;
        if (posicoesDisponiveis() > 0) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (this.tabuleiro[i][j].equals(" ")) {
                        pos[0] = i;
                        pos[0] = j;
                    }
                }
            }
        }
        return pos;
    }

    private void gerarArvore() {
        if (posicoesDisponiveis() > 0) {
            ArrayList<Tabuleiro> tabAux = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (this.tabuleiro[i][j].equals(" ")) {
                        Tabuleiro tab = new Tabuleiro(this.tabuleiro);
                        // Joga o jogo do X
                        tab.preencherPosicao(i,j, X);

                        // Joga o jogo do Y
                        Tabuleiro tab2 = new Tabuleiro(tab.getTabuleiro());

                        int posicoes = tab.posicoesDisponiveis();
                        int add = 0;
                        while (add <  posicoes) {

                        }

                    }
                }
            }
            this.setFilhos(tabAux);
        }
    }

    public String[][] getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(String[][] tabuleiro) {
        this.tabuleiro = tabuleiro;
    }
}
