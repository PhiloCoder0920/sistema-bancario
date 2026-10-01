package atividade6e12e15;

interface tributavel {
    
    double getValorImposto();
}

abstract class conta {
    private int agencia;
    private int numero;
    private String tipo;
    private String titular;
    
    protected double saldo; 
    
    private static int quantidadeDeContas = 0;

    public conta(int agencia, int numero, String titular, String tipo) {
        this.agencia = agencia;
        this.numero = numero;
        this.titular = titular;
        this.tipo = tipo;
        this.saldo = 0.0;
        quantidadeDeContas++;
    }

    public abstract boolean depositar(double valor);

    public boolean sacar(double valor) {
        if (valor > 0 && this.saldo >= valor) {
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    public boolean transferir(double valor, conta destino) {
        if (this.sacar(valor)) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }

    public String consultar() {
        return "Agência: " + this.agencia + 
               "  Conta: " + this.numero + 
               "  Titular: " + this.titular + 
               "  Tipo: " + this.tipo + 
               "  Saldo Atual: R$ " + String.format("%.2f", this.saldo);
    }

    public static int getQuantidadeDeContas() {
        return quantidadeDeContas;
    }

    public double getSaldo() {
        return saldo;
    }
}

class contaCorrente extends conta implements tributavel {

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

class contaPoupanca extends conta {

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

class seguroDeVida implements tributavel {

    @Override
    public double getValorImposto() {
        return 42.00;
    }
}

class calculadorImposto {
    
    private double totalImposto;

    public void registra(tributavel t) {
        double valor = t.getValorImposto();
        this.totalImposto += valor;
    }

    public double getTotalImposto() {
        return this.totalImposto;
    }
}