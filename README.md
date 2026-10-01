# Sistema Bancário

Projeto Sistema Bancário – Parte 3: Conta Corrente e Poupança.

Conceitos trabalhados: Polimorfismo, Override, Classes Abstratas e Interfaces.

## Estrutura

Pacote `atividade6e12e15` (em `src/atividade6e12e15/`):

- `conta` (abstrata) – classe mãe das contas: `depositar` (abstrato), `sacar`, `transferir`, `consultar`, `getSaldo`, `getQuantidadeDeContas`
- `contaCorrente` – herda `conta` e implementa `tributavel` (saque com taxa de R$ 0,20; imposto de 1% do saldo)
- `contaPoupanca` – herda `conta` (não é tributável)
- `seguroDeVida` – implementa `tributavel` (imposto fixo de R$ 42,00)
- `tributavel` (interface) – `getValorImposto() : double`
- `calculadorImposto` – `registra(tributavel)` soma os impostos; `getTotalImposto()` retorna o total arrecadado
- `TesteBanco` – teste da Parte 2
- `testeParte3` – teste da Parte 3: exercita todas as classes e todos os métodos, imprime os saldos das contas correntes, os seguros de vida e o total de impostos arrecadado

## Como executar

```bash
javac -encoding UTF-8 -d out src/atividade6e12e15/*.java
java -cp out atividade6e12e15.testeParte3
```

Prazo de entrega: 30/09/2026.
