# Sistema Bancário

Projeto Sistema Bancário – Parte 4: Exceções em Java.

Conceitos trabalhados: Polimorfismo, Override, Classes Abstratas, Interfaces e Exceções.

A versão da Parte 3 está guardada na branch `parte3`.

## Estrutura

Pacote `atividade6e12e15` (em `src/atividade6e12e15/`).

O arquivo `sistemaBancario.java` reúne todas as classes do sistema (sem `public` na declaração, pois um arquivo Java só pode ter uma classe pública):

- `conta` (abstrata) – classe mãe das contas: `depositar` (abstrato), `sacar`, `transferir`, `consultar`, `getSaldo`, `getTipo`, `getQuantidadeDeContas`
- `contaCorrente` – herda `conta` e implementa `tributavel` (taxa de R$ 0,20 por saque; imposto de 1% do saldo)
- `contaPoupanca` – herda `conta` (não é tributável, saque sem taxa)
- `seguroDeVida` – implementa `tributavel` (imposto fixo de R$ 42,00)
- `tributavel` (interface) – `getValorImposto() : double`
- `calculadorImposto` – `registra(tributavel)` soma os impostos; `getTotalImposto()` retorna o total arrecadado
- `saldoInsuficienteException` – saldo menor que o valor do saque (mais a taxa, na conta corrente)
- `limiteDeSaqueExcedidoException` – saque acima do limite máximo de R$ 300,00
- `valorNaoMultiploDe20Exception` – valor que não pode ser composto por cédulas de R$ 20,00

Classe de teste:

- `TesteConta` – testa saques e transferências com sucesso e cada uma das exceções

## Regras do saque

1. O valor deve ser maior que zero.
2. O valor não pode passar do limite de R$ 300,00.
3. O valor deve ser múltiplo de R$ 20,00.
4. O saldo deve cobrir o valor mais a taxa (R$ 0,20 na conta corrente).

A transferência usa o saque, então segue as mesmas regras.

## Como executar

```bash
javac -encoding UTF-8 -d out src/atividade6e12e15/*.java
java -cp out atividade6e12e15.TesteConta
```

Prazo de entrega: 11/11/2026.
