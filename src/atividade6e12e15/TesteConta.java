package atividade6e12e15;

public class TesteConta {

    public static void main(String[] args) {

        contaCorrente cc1 = new contaCorrente(111, 222, "Henrique");
        contaPoupanca cp1 = new contaPoupanca(222, 333, "Mariana");
        cc1.depositar(500.00);
        cp1.depositar(200.00);

        System.out.println("===== Projeto Sistema Bancário - Parte 4 - Exceções =====\n");
        System.out.println("Contas abertas: " + conta.getQuantidadeDeContas());
        System.out.println(cc1.consultar());
        System.out.println(cp1.consultar());

        System.out.println("\n===== SAQUES =====");
        sacar(cp1, 100.00);
        sacar(cc1, 100.00);
        sacar(cc1, 320.00);
        sacar(cc1, 50.00);
        sacar(cp1, 120.00);
        sacar(cc1, -20.00);

        System.out.println("\n===== TRANSFERÊNCIAS =====");
        transferir(cc1, cp1, 200.00);
        transferir(cc1, cp1, 340.00);
        transferir(cc1, cp1, 15.00);
        transferir(cc1, cp1, 200.00);

        System.out.println("\n===== SALDOS FINAIS =====");
        System.out.println(cc1.consultar());
        System.out.println(cp1.consultar());
    }

    private static void sacar(conta c, double valor) {
        System.out.println(String.format("\nSaque de R$ %.2f na %s:", valor, c.getTipo()));
        try {
            c.sacar(valor);
            System.out.println("Sucesso no saque!");
        } catch (saldoInsuficienteException e) {
            System.out.println("Saque negado - " + e.getMessage());
        } catch (limiteDeSaqueExcedidoException e) {
            System.out.println("Saque negado - " + e.getMessage());
        } catch (valorNaoMultiploDe20Exception e) {
            System.out.println("Saque negado - " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Saque negado - " + e.getMessage());
        } finally {
            System.out.println(c.consultar());
        }
    }

    private static void transferir(conta origem, conta destino, double valor) {
        System.out.println(String.format("\nTransferência de R$ %.2f:", valor));
        try {
            origem.transferir(valor, destino);
            System.out.println("Sucesso na transferência!");
        } catch (saldoInsuficienteException e) {
            System.out.println("Transferência negada - " + e.getMessage());
        } catch (limiteDeSaqueExcedidoException e) {
            System.out.println("Transferência negada - " + e.getMessage());
        } catch (valorNaoMultiploDe20Exception e) {
            System.out.println("Transferência negada - " + e.getMessage());
        } finally {
            System.out.println("Origem:  " + origem.consultar());
            System.out.println("Destino: " + destino.consultar());
        }
    }
}
