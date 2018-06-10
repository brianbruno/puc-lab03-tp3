import ex01.JogoVelha;
import ex02.ReorganizarVetor;
import ex04.ApagandoGanhando;
import ex05.ProblemaRainhas;

public class App {

    public static void main(String[] args) {
        System.out.println("Atividade 3");

        // Exercicio 4
        ApagandoGanhando ag = new ApagandoGanhando(7, 3);
        //ag.magicGuloso();

        JogoVelha jv = new JogoVelha();
        //jv.magicJogoVelha();

        ReorganizarVetor rv = new ReorganizarVetor(10);
        //rv.magicReorganizar();

        ProblemaRainhas pr = new ProblemaRainhas(8);
        pr.magicProblemaRainhas();
    }
}
