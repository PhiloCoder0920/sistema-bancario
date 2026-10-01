package atividade6e12e15;

public class contaCorrente extends conta implements tributavel {

    public contaCorrente(int agencia, int numero, String titular) {
        super(agencia, numero, titular, "Conta Corrente");
    }

    @Override
    public boolean depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            return true;
        }
        return false;
    }

    @Override
    public boolean sacar(double valor) {
        double valorComTaxa = valor + 0.20;
        return super.sacar(valorComTaxa);
    }

    @Override
    public double getValorImposto() {
        return this.saldo * 0.01;
    }
}