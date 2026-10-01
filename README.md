# Sistema Bancário

Projeto Sistema Bancário – Parte 3: Conta Corrente e Poupança.

Conceitos trabalhados: Polimorfismo, Override, Classes Abstratas e Interfaces.

## Estrutura prevista

- `Conta` (abstrata) – classe mãe das contas
- `ContaCorrente` – herda `Conta` e implementa `Tributavel` (imposto de 1% do saldo)
- `ContaPoupanca` – herda `Conta` (não é tributável)
- `SeguroDeVida` – implementa `Tributavel` (imposto fixo de R$ 42,00)
- `Tributavel` (interface) – `getValorImposto() : double`
- `CalculadorImposto` – soma os impostos de objetos `Tributavel`
- Classe de testes – exercita todas as classes e métodos

Prazo de entrega: 30/09/2026.
