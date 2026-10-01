package atividade6e12e15;

public class Testes {

    public static void main(String[] args) {

        contaCorrente cc1 = new contaCorrente(101, 1001, "Henrique");
        contaCorrente cc2 = new contaCorrente(101, 1002, "Juliana");
        cc1.depositar(1000.00);
        cc2.depositar(2500.00);

        seguroDeVida seguro1 = new seguroDeVida();
        seguroDeVida seguro2 = new seguroDeVida();

        calculadorImposto calc = new calculadorImposto();
        calc.registra(cc1);
        calc.registra(cc2);
        calc.registra(seguro1);
        calc.registra(seguro2);

        System.out.println("--- Saldos das Contas Correntes ---");
        System.out.println(cc1.consultar());
        System.out.println(cc2.consultar());

        System.out.println("\n--- Seguros de Vida definidos ---");
        System.out.println(String.format("Seguro de Vida 1 - imposto: R$ %.2f", seguro1.getValorImposto()));
        System.out.println(String.format("Seguro de Vida 2 - imposto: R$ %.2f", seguro2.getValorImposto()));

        System.out.println(String.format("\nTotal de impostos arrecadado: R$ %.2f", calc.getTotalImposto()));
    }
}
