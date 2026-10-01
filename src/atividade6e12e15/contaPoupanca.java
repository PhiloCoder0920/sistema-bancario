package atividade6e12e15;

public class contaPoupanca extends conta {

    public contaPoupanca(int agencia, int numero, String titular) {
        super(agencia, numero, titular, "Conta Poupança");
    }

    @Override
    public boolean depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            return true;
        }
        return false;
    }
}