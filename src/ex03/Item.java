package ex03;

import java.util.Random;

public class Item implements Comparable<Item> {

    private int valor;
    private int quilos;
    private boolean jaFoiPego = false;
    private String nome;

    public Item(int quantidadeMaxima) {
        this.valor = 10 + gerarCodigo(quantidadeMaxima);
        this.quilos = 1+gerarCodigo(quantidadeMaxima);
    }

    private int gerarCodigo(int quantidadeMaxima) {
        Random gerador = new Random();
        return gerador.nextInt(quantidadeMaxima);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getQuilos() {
        return quilos;
    }

    public void setQuilos(int quilos) {
        this.quilos = quilos;
    }

    public boolean jaFoiPego() {
        return jaFoiPego;
    }

    public void setJaFoiPego(boolean jaFoiPego) {
        this.jaFoiPego = jaFoiPego;
    }

    public String toString (){
        String peso = String.format("%2s", getQuilos()).replace(' ', '0');
        String valor = String.format("%2s", getValor()).replace(' ', '0');
        return "Peso: " + peso + " Valor: " + valor;
    }

    public int compareTo(Item item) {

        int resultado = 0;

        if (this.getQuilos() < item.getQuilos()) {
            resultado = -1;
        } else if (this.getQuilos() > item.getQuilos()) {
            resultado = 1;
        }

        return resultado;
    }
}
