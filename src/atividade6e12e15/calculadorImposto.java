package atividade6e12e15;

public class calculadorImposto {
    
    private double totalImposto;

    public void registra(tributavel t) {
        double valor = t.getValorImposto();
        this.totalImposto += valor;
    }

    public double getTotalImposto() {
        return this.totalImposto;
    }
}