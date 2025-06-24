/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho.zamba;

/**
 *
 * @author vitim
 */
import java.util.*;

public class Perceptron {
    private List<Ponto> amostras;
    private List<Integer> saidas;
    private double taxaAprendizado;
    private int geracoes;
    private int limiar;
    private double[] pesos;

    public Perceptron(List<Ponto> amostras, List<Integer> saidas, double taxaAprendizado, int geracoes, int limiar) {
        this.amostras = amostras;
        this.saidas = saidas;
        this.taxaAprendizado = taxaAprendizado;
        this.geracoes = geracoes;
        this.limiar = limiar;
        this.pesos = new double[3]; // limiar + x + y
    }

    private int funcaoAtivacaoSignal(double soma) {
        return soma >= 0 ? 1 : -1;
    }

    public void treinar() {
        for (Ponto ponto : amostras) {
            ponto.limiar = limiar;
        }

        Random rand = new Random();
        pesos[0] = limiar;
        pesos[1] = rand.nextDouble();
        pesos[2] = rand.nextDouble();

        int conta = 0;
        boolean aprendeu;

        while (true) {
            aprendeu = true;

            for (int i = 0; i < amostras.size(); i++) {
                Ponto p = amostras.get(i);
                double soma = p.limiar * pesos[0] + p.x * pesos[1] + p.y * pesos[2];
                int saidaGerada = funcaoAtivacaoSignal(soma);

                if (saidaGerada != saidas.get(i)) {
                    aprendeu = false;
                    double erro = saidas.get(i) - saidaGerada;
                    pesos[0] += taxaAprendizado * erro * p.limiar;
                    pesos[1] += taxaAprendizado * erro * p.x;
                    pesos[2] += taxaAprendizado * erro * p.y;
                }
            }

            conta++;
            if (aprendeu || conta > geracoes) {
                System.out.println("Geracoes de treinamento: " + conta);
                break;
            }
        }
    }

    public void testar(Ponto amostra) {
        amostra.limiar = limiar;
        double soma = amostra.limiar * pesos[0] + amostra.x * pesos[1] + amostra.y * pesos[2];
        int saidaGerada = funcaoAtivacaoSignal(soma);

        if (saidaGerada == 1) {
            System.out.println("Classe: " + saidaGerada + " ou Time Azul");
        } else {
            System.out.println("Classe: " + saidaGerada + " ou Time Vermelho");
        }
    }
}