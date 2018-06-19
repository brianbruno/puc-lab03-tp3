package ex01;

import java.util.ArrayList;

public class No {

    ArrayList<No> filhos;
    private Tabuleiro tabuleiro;
    private int valorHeuristica;

    public No() {
        this.filhos = null;
    }

    public int getValorHeuristica() {
        return valorHeuristica;
    }

    public void setValorHeuristica(int valorHeuristica) {
        this.valorHeuristica = valorHeuristica;
    }

    public ArrayList<No> getFilhos() {
        return filhos;
    }

    public void setFilhos(ArrayList<No> filhos) {
        this.filhos = filhos;
    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }
}
