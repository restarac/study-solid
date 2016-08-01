package fredojo;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {

		double[] cedulas = { 100, 50, 10, 5, 1, 0.50, 0.25, 0.10, 0.05, 0.01 };
		int[] qtdeEmCaixa = { 10, 50, 20, 2, 15, 2, 0, 20, 10, 10 };
		Scanner scanner = new Scanner(System.in);

		while (true) {

			double dinheiroRecebido = scanner.nextDouble();
			double totalEfetivamente = scanner.nextDouble();

			double troco = dinheiroRecebido - totalEfetivamente;

			int[] qtdCedulas = new int[cedulas.length];

			System.out.printf("Troco: R$ %.2f\n", troco);

			troco = contaTudo(cedulas, qtdeEmCaixa, troco, qtdCedulas);

			for (int i = 0; i < qtdCedulas.length; i++) {
				if (qtdCedulas[i] > 0) {
					System.out.println(qtdCedulas[i] + ((cedulas[i] < 1) ? " moeda(s)" : " cédula(s)") + " de " + cedulas[i]);
				}
			}

			if (troco != 0) {
				System.out.printf("Troco (R$ %.2f) em balinhas?", troco);
			}
			System.out.println("\n |");
			System.out.println(" V Valor em caixa");
			for (int i = 0; i < qtdeEmCaixa.length; i++) {
				if (qtdeEmCaixa[i] > 0) {
					System.out.println(qtdeEmCaixa[i] + ((cedulas[i] < 1) ? " moeda(s)" : " cédula(s)") + " de " + cedulas[i]);
				}
			}
		}
	}

	private static double contaTudo(double[] cedulas, int[] qtdeEmCaixa, double troco, int[] qtdCedulas) {
		for (int i = 0; i < cedulas.length; i++) {
			double valorCedula = cedulas[i];
			qtdCedulas[i] = (int) (troco / valorCedula);

			if (qtdCedulas[i] > qtdeEmCaixa[i]) {
				qtdCedulas[i] = qtdeEmCaixa[i];
				qtdeEmCaixa[i] = 0;
			} else {
				qtdeEmCaixa[i] -= qtdCedulas[i];
			}

			troco = troco - valorCedula * qtdCedulas[i];

		}
		return troco;
	}
}
