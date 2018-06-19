package ex03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ProblemaLadrao {

    private int quantidadeMaxima;
    private ArrayList<Item> itens;
    private ArrayList<Item> mochila;

    public ProblemaLadrao(int quantidadeMaxima) {
        this.quantidadeMaxima = quantidadeMaxima;
        this.itens = new ArrayList<>();
        this.mochila = new ArrayList<>();

        for (int i = 0; i<quantidadeMaxima*0.5; i++) {
            this.itens.add(new Item(quantidadeMaxima));
        }
    }

    public void magicRoubarGuloso() {

        System.out.println("Exercicio 3 - Ladrão e Mochila");
        System.out.println("Metodo Guloso");

        // Ordena para pegar sempre o objeto mais leve
        Collections.sort(itens);
        imprimirItens();
        Item proxItem = itens.remove(0);

        while (proxItem.getQuilos() <= getPesoDisponivel()) {
            mochila.add(proxItem);
            proxItem.setJaFoiPego(true);
            proxItem = itens.remove(0);
        }

        imprimirMochila();
    }

    public void magicRoubarDinamico() {
        System.out.println("Exercicio 3 - Ladrão e Mochila");
        System.out.println("Metodo Programação Dinâmica");

        Item[] itens = new Item[this.itens.size()];

        int i = 0;
        for (Item item : itens) {
            itens[i] = item;
            i++;
        }
        int N = itens.length-1; // number of items
        int W = quantidadeMaxima; // maximum weight


        // opt[n][w] = max profit of packing items 1..n with weight limit w // sol[n][w]
        // = does opt solution to pack items 1..n with weight limit w include item n?
        int[][] opt = new int[N + 1][W + 1];
        boolean[][] sol = new boolean[N + 1][W + 1];
        for (int n = 1; n <= N; n++) {
            for (int w = 1; w <= W; w++) {
                // don't take item n
                int option1 = opt[n - 1][w];
                // take item n
                int option2 = Integer.MIN_VALUE;
                if (itens[n].getQuilos() <= w) {
                    option2 = itens[n].getValor() + opt[n - 1][w - itens[n].getQuilos()];
                }
                // select better of two options
                opt[n][w] = Math.max(option1, option2);
                sol[n][w] = option2 > option1;
            }
        }
        // determine which items to take
        boolean[] take = new boolean[N + 1];
        for (int n = N, w = W; n > 0; n--) {
            if (sol[n][w]) {
                take[n] = true;
                w = w - itens[n].getQuilos();
            } else {
                take[n] = false;
            }
        }
        // print results
        System.out.println("Item" + "\t" + "Valor" + "\t" + "Peso" + "\t" + "Pegar");
        for (int n = 1; n <= N; n++) {
            System.out.println(itens[n].getNome() + "\t" + itens[n].getValor() + "\t" + itens[n].getQuilos() + "\t" + take[n]);
        }
        System.out.println();

    }

    private int valorMochila() {
        int valor = 0;
        for (Item itemMochila : mochila) {
            valor += itemMochila.getValor();
        }
        return valor;
    }

    private int pesoMochila() {
        int peso = 0;
        for (Item itemMochila : mochila) {
            peso += itemMochila.getQuilos();
        }
        return peso;
    }

    private int getPesoDisponivel() {
        return quantidadeMaxima-pesoMochila();
    }

    private void imprimirMochila() {
        System.out.println("Mochila: ");
        mochila.forEach((item)->{
            System.out.println("Peso: " + item.getQuilos() + " - Valor: " + item.getValor());
        });
        System.out.print("Peso total: " + pesoMochila());
        System.out.print(" | Peso maximo: " + quantidadeMaxima);
        System.out.println(" | Valor: " + valorMochila());
        System.out.println("---------------------------------");
    }

    private void imprimirItens() {
        System.out.println("Itens:");
        int i = 0;

        while (i < this.itens.size()) {
            String stringImpressao = this.itens.get(i).toString();
            i++;
            if (i < this.itens.size()) {
                stringImpressao += " | " + this.itens.get(i);
                i++;
            }
            if (i < this.itens.size()) {
                stringImpressao += " | " + this.itens.get(i);
                i++;
            }
            System.out.println(stringImpressao);
        }
        System.out.println("Total de itens: " + this.itens.size());
        System.out.println("---------------------------------");
    }


}
