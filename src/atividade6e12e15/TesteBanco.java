package atividade6e12e15;

public class TesteBanco {

    public static void main(String[] args) {
    	
        contaCorrente cc = new contaCorrente(101, 1001, "Henrique");
        contaPoupanca cp = new contaPoupanca(101, 2001, "Mariana");

        System.out.println("Contas abertas: " + conta.getQuantidadeDeContas() + "\n");

        System.out.println("Depositando 500");
        cc.depositar(500.00);
        cp.depositar(500.00);
        System.out.println(cc.consultar());
        System.out.println(cp.consultar());

        System.out.println(" \nSaque de 100 na Conta Poupança:");
        if (cp.sacar(100.00)) {
            System.out.println("Sucesso sem cobrança de taxa");
        }
        System.out.println(cp.consultar() + "\n");

        System.out.println("Saque de 100 na Conta Corrente:");
        if (cc.sacar(100.00)) {
            System.out.println("Sucesso taxa de 0,20");
        }
        System.out.println(cc.consultar() + "\n");

        System.out.println("Transferência de 100 da Conta Corrente para a Conta Poupança:");
        if (cc.transferir(100.00, cp)) {
            System.out.println("Sucesso cobrando a taxa");
        }

        System.out.println("\nConsultas");
        System.out.println(cc.consultar());
        System.out.println(cp.consultar());
    }
}