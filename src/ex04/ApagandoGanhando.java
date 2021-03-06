package ex04;

import java.util.Random;

// Metodo Guloso
public class ApagandoGanhando {

    private int[] numeros;
    private int escolhas;

    public ApagandoGanhando(int numeros, int escolhas) {
        this.numeros = new int[numeros];
        this.escolhas = escolhas;
        preencherVetor();
    }

    public void magicApagarGuloso () {
        System.out.println("Exercicio 4 - Apagando e Ganhando");
        int j = 0;
        // Imprime digitos que serão apagados
        System.out.println("Numeros escolhidos:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(this.numeros[i] + " ");
        }
        System.out.println("");
        System.out.println("Digitos a serem apagados");
        // Seleciona os numeros
        while (j < escolhas) {
            int indexMenor = 0;
            for (int i = 0; i < numeros.length; i++) {
                if (numeros[i] < numeros[indexMenor] && numeros[i] != -1) {
                    indexMenor = i;
                }
            }
            numeros[indexMenor] = -1;
            j++;
        }

        // imprime o total a ser levado
        System.out.println("Total a ser levado para casa:");
        for (int i = 0; i < numeros.length; i++) {
            if (this.numeros[i] != -1)
            System.out.print(this.numeros[i]);
        }

    }

    private void preencherVetor () {
        for (int i = 0; i < numeros.length; i++) {
            this.numeros[i] = gerarCodigo();
        }
    }

    private int gerarCodigo() {
        Random gerador = new Random();
        return 1+gerador.nextInt(8);
    }
}
