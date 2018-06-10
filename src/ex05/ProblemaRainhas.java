package ex05;

import java.util.Random;

public class ProblemaRainhas {

    private int[][] tabuleiro;
    private int rainhas;

    public ProblemaRainhas(int rainhas) {
        this.rainhas = rainhas;
        this.tabuleiro = new int[rainhas][rainhas];

        for (int i = 0; i < rainhas-1; i++) {
            for (int j = 0; j < rainhas-1; j++) {
                tabuleiro[i][j] = 0;
            }
        }

    }

    public void magicProblemaRainhas() {
        mergulhar(0,0);
        imprimirTabuleiro();
    }

    private boolean mergulhar(int i, int j) {
        boolean linha = true;
        boolean coluna = true;
        boolean diagonal = true;
        int a = 0;

        if (i >= rainhas || j >= rainhas) {
            linha = coluna = false;
        }

        while (a < rainhas-1 && (linha && coluna)) {
            if(tabuleiro[i][a] != 0){
               linha = false;
            }
            if (tabuleiro[a][j] != 0) {
                coluna = false;
            }
            /*int aux1 = a;
            int aux2 = i;
            while (aux1+1 < rainhas && aux2+1 < rainhas) {
                if (tabuleiro[aux1++][aux2++] != 0) {
                    diagonal = false;
                }
            }
            aux1 = a;
            aux2 = i;
            while (aux1+1 < rainhas && aux2+1 < rainhas) {
                if (tabuleiro[aux1++][aux2++] != 0) {
                    diagonal = false;
                }
            }*/
            a++;
        }

        int aux1 = -1;
        int aux2 = j;

        while (aux1+1 < rainhas && aux2+1 < rainhas) {
            if (tabuleiro[++aux1][++aux2] != 0) {
                diagonal = false;
            }
        }

        if (linha && coluna && diagonal){
            tabuleiro[i][j] = 1;
            mergulhar(i + 1, j+1);
        }

        return linha && coluna && diagonal;
    }

    private void imprimirTabuleiro () {
        for (int i = 0; i < rainhas; i++) {
            for (int j = 0; j < rainhas; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println("");
        }
    }

    private int gerarCodigo() {
        Random gerador = new Random();
        return gerador.nextInt(rainhas);
    }
}
