package ex05;

public class ProblemaRainhas {

    private int[][] tabuleiro;
    private int rainhas;
    private int linhas;
    private int colunas;
    public static int solucao = 0;

    public ProblemaRainhas(int rainhas) {
        this.rainhas = rainhas;
        this.tabuleiro = new int[rainhas][rainhas];

        for (int i = 0; i < rainhas-1; i++) {
            for (int j = 0; j < rainhas-1; j++) {
                tabuleiro[i][j] = 0;
            }
        }

    }

    public ProblemaRainhas(int rainhas, int linhas, int colunas) {
        this.rainhas = rainhas;
        this.linhas = linhas;
        this.colunas = colunas;
        this.tabuleiro = new int[linhas][colunas];
    }

    // funcao aposentada rs
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

    public void magicProblemaRainhas(){
        mergulhar(this.tabuleiro, rainhas, 0);
    }

    //Função que resolve o problema, retorna true se conseguiu resolver e false caso contrário
    public static void mergulhar(int[][] tab, int rainhas, int colunas){
        if(colunas == rainhas){
            System.out.println("*-------------------------------------------------------------------------*");
            System.out.print("SOLUÇÃO [" + (solucao+1) + "]");
            System.out.print(":\n\n");
            imprimirTabuleiro(tab, rainhas);
            solucao++;
            return;
        }

        for(int i=0; i<rainhas; i++){
            // verifica se é seguro colocar a rainha naquela coluna
            if(seguro(tab, rainhas, i, colunas)){
                // insere a rainha marcando com 1
                tab[i][colunas] = 1;
                // realiza uma chamada recursiva
                mergulhar(tab, rainhas, colunas+1);
                // remove a rainha (BACKTRAKING)
                tab[i][colunas] = 0;
            }
        }
    }

    // função para mostrar o tabuleiro
    public static void imprimirTabuleiro(int[][] tab, int rainhas){
        for(int i=0; i<rainhas; i++){
            for(int j=0; j<rainhas; j++){
                if(tab[i][j] == 1){
                    System.out.print("[R]\t");
                }else{
                    System.out.print("[-]\t");
                }
            }
            System.out.print("\n\n");
        }
        System.out.print("\n");
    }

    // verifica se é seguro colocar a rainha numa determinada coluna
    public static boolean seguro(int[][] tab, int rainhas, int linhas, int colunas){
        int i;
        int j;

        // verifica se ocorre ataque na linha
        for(i=0; i<rainhas; i++){
            if(tab[linhas][i] == 1){
                return false;
            }
        }

        // verifica se ocorre ataque na coluna
        for(i=0; i<rainhas; i++){
            if(tab[i][colunas] == 1){
                return false;
            }
        }

        // verifica se ocorre ataque na diagonal principal (ACIMA E ABAIXO)
        for(i=linhas, j=colunas; i>=0 && j>=0; i--, j--){
            if(tab[i][j] == 1){
                return false;
            }
        }
        for(i=linhas, j=colunas; i<rainhas && j<rainhas; i++, j++){
            if(tab[i][j] == 1){
                return false;
            }
        }

        // verifica se ocorre ataque na diagonal secundária (ACIMA E ABAIXO)
        for(i=linhas, j=colunas; i>=0 && j<rainhas; i--, j++){
            if(tab[i][j] == 1){
                return false;
            }
        }
        for(i=linhas, j=colunas; i<rainhas && j>=0; i++, j--){
            if(tab[i][j] == 1){
                return false;
            }
        }

        // se chegou até aqui está seguro
        return true;
    }
}
