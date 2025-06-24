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

public class Program {
    public static void main(String[] args) {
        System.out.println("Exemplo de RNA Perceptron para classificacao de equipes");

        List<Ponto> amostras = Arrays.asList(
            new Ponto(0.72, 0.82), new Ponto(0.91, -0.69), new Ponto(0.46, 0.80),
            new Ponto(0.03, 0.93), new Ponto(0.12, 0.25), new Ponto(0.96, 0.47),
            new Ponto(0.8, -0.75), new Ponto(0.46, 0.98), new Ponto(0.66, 0.24),
            new Ponto(0.72, -0.15), new Ponto(0.35, 0.01), new Ponto(-0.16, 0.84),
            new Ponto(-0.04, 0.68), new Ponto(-0.11, 0.1), new Ponto(0.31, -0.96),
            new Ponto(0.0, -0.26), new Ponto(-0.43, -0.65), new Ponto(0.57, -0.97),
            new Ponto(-0.47, -0.03), new Ponto(-0.72, -0.64), new Ponto(-0.57, 0.15),
            new Ponto(-0.25, -0.43), new Ponto(0.47, -0.88), new Ponto(-0.12, -0.9),
            new Ponto(-0.58, 0.62), new Ponto(-0.48, 0.05), new Ponto(-0.79, -0.92),
            new Ponto(-0.42, -0.09), new Ponto(-0.76, 0.65), new Ponto(-0.77, -0.76)
        );

        List<Integer> saidas = Arrays.asList(
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1
        );

        Perceptron p = new Perceptron(amostras, saidas, 0.1, 1000, 1);
        p.treinar();

        Scanner scanner = new Scanner(System.in);
        String op;

        do {
            System.out.print("\n\nInforme valor para x (-1 a 1): ");
            double x = Double.parseDouble(scanner.nextLine());
            System.out.print("Informe valor para y (-1 a 1): ");
            double y = Double.parseDouble(scanner.nextLine());

            p.testar(new Ponto(x, y));

            System.out.print("Digite 1 para encerrar ou 0 para classificar uma nova equipe: ");
            op = scanner.nextLine();
        } while (!op.equals("1"));

        scanner.close();
    }
}