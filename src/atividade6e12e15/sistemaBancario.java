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

    public static final double LIMITE_SAQUE = 300.00;
    public static final double VALOR_CEDULA = 20.00;

    public conta(int agencia, int numero, String titular, String tipo) {
        this.agencia = agencia;
        this.numero = numero;
        this.titular = titular;
        this.tipo = tipo;
        this.saldo = 0.0;
        quantidadeDeContas++;
    }

    public abstract boolean depositar(double valor);

    protected double getTaxaSaque() {
        return 0.0;
    }

    public void sacar(double valor)
            throws saldoInsuficienteException, limiteDeSaqueExcedidoException, valorNaoMultiploDe20Exception {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor do saque deve ser maior que zero");
        }
        if (valor > LIMITE_SAQUE) {
            throw new limiteDeSaqueExcedidoException(valor, LIMITE_SAQUE);
        }
        if (valor % VALOR_CEDULA != 0) {
            throw new valorNaoMultiploDe20Exception(valor);
        }
        double valorTotal = valor + this.getTaxaSaque();
        if (this.saldo < valorTotal) {
            throw new saldoInsuficienteException(this.saldo, valorTotal);
        }
        this.saldo -= valorTotal;
    }

    public void transferir(double valor, conta destino)
            throws saldoInsuficienteException, limiteDeSaqueExcedidoException, valorNaoMultiploDe20Exception {
        this.sacar(valor);
        destino.depositar(valor);
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

    public String getTipo() {
        return tipo;
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
    protected double getTaxaSaque() {
        return 0.20;
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

class saldoInsuficienteException extends Exception {

    private static final long serialVersionUID = 1L;

    public saldoInsuficienteException(double saldo, double valorNecessario) {
        super(String.format("Saldo insuficiente: saldo de R$ %.2f, necessário R$ %.2f", saldo, valorNecessario));
    }
}

class limiteDeSaqueExcedidoException extends Exception {

    private static final long serialVersionUID = 1L;

    public limiteDeSaqueExcedidoException(double valor, double limite) {
        super(String.format("Valor de saque (R$ %.2f) superior ao limite máximo de R$ %.2f", valor, limite));
    }
}

class valorNaoMultiploDe20Exception extends Exception {

    private static final long serialVersionUID = 1L;

    public valorNaoMultiploDe20Exception(double valor) {
        super(String.format("Valor do saque (R$ %.2f) não pode ser composto por cédulas de R$ 20,00", valor));
    }
}