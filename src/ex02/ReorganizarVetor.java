package ex02;

import java.util.Random;

public class ReorganizarVetor {

    private int[] vetor;

    public ReorganizarVetor(int tamanho) {
        this.vetor = new int[tamanho];
        preencherVetor();
    }

    public void magicReorganizar () {
        imprimir();
        mergeSort(vetor, 0,vetor.length -1);
        imprimir();
    }

    private void mergeSort(int[] array, int low, int high){
        if(low < high){
            int middle = (low + high) / 2;
            mergeSort(array, low, middle);
            mergeSort(array, middle+1, high);
            merge(array, low, middle, high);
        }
    }

    private void merge(int[] array, int low, int middle, int high){
        int[] helper = new int[array.length];
        for (int i = low; i <= high; i++) {
            helper[i] = array[i];
        }

        int helperLeft = low;
        int helperRight = middle+1;
        int current = low;

        while (helperLeft <= middle && helperRight <=high) {
            if(helper[helperLeft] <= helper[helperRight]){
                array[current] = helper[helperLeft];
                helperLeft++;

            }else{
                array[current] = helper[helperRight];
                helperRight++;
            }
            current ++;
        }

        int remaining = middle - helperLeft;
        for (int i = 0; i <= remaining; i++) {
            array[current+i] = helper[helperLeft+ i];
        }
    }

    private void preencherVetor() {
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = gerarCodigo();
        }
    }

    private int gerarCodigo() {
        Random gerador = new Random();
        int numero = 1+gerador.nextInt(20) ;

        if (gerador.nextInt(2) == 1) {
            numero = numero * -1;
        }
        return numero;
    }

    private void imprimir() {
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println("");
    }
}
