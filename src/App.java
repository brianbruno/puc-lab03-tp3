import ex01.JogoVelha;
import ex02.ReorganizarVetor;
import ex03.ProblemaLadrao;
import ex04.ApagandoGanhando;
import ex05.ProblemaRainhas;

public class App {

    public static void main(String[] args) {
        System.out.println("Atividade 3");

        // Exercicio 1
        JogoVelha jv = new JogoVelha();
        //jv.magicJogoVelha();

        // Exercicio 2
        ReorganizarVetor rv = new ReorganizarVetor(10);
        //rv.magicReorganizar();

        // Exercicio 3
        ProblemaLadrao pl = new ProblemaLadrao(35);
        pl.magicRoubarGuloso();

        // Exercicio 4
        ApagandoGanhando ag = new ApagandoGanhando(7, 3);
        //ag.magicApagarGuloso();

        // Exercicio 5
        ProblemaRainhas pr = new ProblemaRainhas(8);
        //pr.magicProblemaRainhas();
    }
}
