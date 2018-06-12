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
    }

    public void dinamica() {

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
