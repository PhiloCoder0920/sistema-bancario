package atividade6e12e15;

public class testeParte3 {

    public static void main(String[] args) {

        System.out.println("===== Projeto Sistema Bancário - Parte 3 =====\n");

        // ---------- Criação das contas (construtores de conta, contaCorrente e contaPoupanca) ----------
        contaCorrente cc1 = new contaCorrente(101, 1001, "Henrique");
        contaCorrente cc2 = new contaCorrente(101, 1002, "Juliana");
        contaPoupanca cp1 = new contaPoupanca(101, 2001, "Mariana");

        // conta.getQuantidadeDeContas() (método estático)
        System.out.println("Contas abertas: " + conta.getQuantidadeDeContas() + "\n");

        // ---------- depositar() - sobrescrito em contaCorrente e contaPoupanca ----------
        System.out.println("--- Depósitos ---");
        System.out.println("Depósito de 1000 na CC do Henrique: " + cc1.depositar(1000.00));
        System.out.println("Depósito de 2500 na CC da Juliana: " + cc2.depositar(2500.00));
        System.out.println("Depósito de 500 na Poupança da Mariana: " + cp1.depositar(500.00));
        System.out.println("Depósito inválido de -50 na CC (deve ser false): " + cc1.depositar(-50.00));
        System.out.println("Depósito inválido de 0 na Poupança (deve ser false): " + cp1.depositar(0));

        // consultar()
        System.out.println(cc1.consultar());
        System.out.println(cc2.consultar());
        System.out.println(cp1.consultar() + "\n");

        // ---------- sacar() - conta (sem taxa) x contaCorrente (com taxa de 0,20) ----------
        System.out.println("--- Saques ---");
        System.out.println("Saque de 100 na Poupança, sem taxa: " + cp1.sacar(100.00));
        System.out.println(cp1.consultar());
        System.out.println("Saque de 100 na CC do Henrique, taxa de 0,20: " + cc1.sacar(100.00));
        System.out.println(cc1.consultar());
        System.out.println("Saque acima do saldo na Poupança (deve ser false): " + cp1.sacar(10000.00));
        System.out.println("Saque acima do saldo na CC (deve ser false): " + cc2.sacar(10000.00));
        System.out.println("Saque de valor negativo na Poupança (deve ser false): " + cp1.sacar(-10.00) + "\n");

        // ---------- transferir() ----------
        System.out.println("--- Transferências ---");
        System.out.println("Transferência de 100 da CC do Henrique para a Poupança da Mariana: "
                + cc1.transferir(100.00, cp1));
        System.out.println("Transferência de 200 da Poupança da Mariana para a CC da Juliana: "
                + cp1.transferir(200.00, cc2));
        System.out.println("Transferência acima do saldo (deve ser false): " + cp1.transferir(10000.00, cc1));
        System.out.println(cc1.consultar());
        System.out.println(cc2.consultar());
        System.out.println(cp1.consultar() + "\n");

        // ---------- Polimorfismo com a classe abstrata conta ----------
        System.out.println("--- Polimorfismo (vetor de conta) ---");
        conta[] contas = { cc1, cc2, cp1 };
        for (conta c : contas) {
            System.out.println(c.consultar());
        }
        System.out.println();

        // ---------- Saldos das contas correntes (getSaldo) ----------
        System.out.println("--- Saldos das Contas Correntes ---");
        System.out.println(String.format("Saldo CC Henrique: R$ %.2f", cc1.getSaldo()));
        System.out.println(String.format("Saldo CC Juliana:  R$ %.2f", cc2.getSaldo()));
        System.out.println(String.format("Saldo Poupança Mariana (não tributável): R$ %.2f\n", cp1.getSaldo()));

        // ---------- Seguros de vida (seguroDeVida.getValorImposto) ----------
        seguroDeVida seguro1 = new seguroDeVida();
        seguroDeVida seguro2 = new seguroDeVida();
        System.out.println("--- Seguros de Vida definidos ---");
        System.out.println(String.format("Seguro de Vida 1 - imposto: R$ %.2f", seguro1.getValorImposto()));
        System.out.println(String.format("Seguro de Vida 2 - imposto: R$ %.2f\n", seguro2.getValorImposto()));

        // ---------- Impostos (contaCorrente.getValorImposto = 1% do saldo) ----------
        System.out.println("--- Impostos individuais ---");
        System.out.println(String.format("Imposto CC Henrique (1%% do saldo): R$ %.2f", cc1.getValorImposto()));
        System.out.println(String.format("Imposto CC Juliana  (1%% do saldo): R$ %.2f\n", cc2.getValorImposto()));

        // ---------- calculadorImposto: registra() e getTotalImposto() via interface tributavel ----------
        calculadorImposto calc = new calculadorImposto();
        System.out.println("--- Calculador de Imposto ---");
        System.out.println(String.format("Total antes de registrar: R$ %.2f", calc.getTotalImposto()));

        tributavel[] tributaveis = { cc1, cc2, seguro1, seguro2 };
        for (tributavel t : tributaveis) {
            calc.registra(t);
            System.out.println(String.format("Registrado %s -> imposto R$ %.2f | total parcial R$ %.2f",
                    t.getClass().getSimpleName(), t.getValorImposto(), calc.getTotalImposto()));
        }
        // contaPoupanca não implementa tributavel, então não pode ser registrada:
        // calc.registra(cp1);  -> erro de compilação

        System.out.println(String.format("\nTOTAL DE IMPOSTOS ARRECADADO: R$ %.2f", calc.getTotalImposto()));
    }
}
