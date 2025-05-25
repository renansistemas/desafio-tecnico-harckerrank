# desafio-tecnico-harckerrank

## Descrição do Desafio

O objetivo deste desafio é criar um sistema para registrar partidas de vôlei entre diferentes times, acumulando a pontuação de cada equipe e, ao final, identificar qual time obteve a maior pontuação total.

O sistema é interativo: solicita ao usuário os nomes dos times participantes, registra os resultados das partidas (com os pontos de cada time) e, por fim, informa qual time teve o maior desempenho em termos de pontos acumulados.

## Estruturas de Dados Utilizadas

- **Map<String, Integer> teamScores**  
  Utilizado na classe [`VolleyballGameTracker`](volley-tracker/src/main/java/org/renan/VolleyballGameTracker.java) para armazenar o nome de cada time como chave e sua pontuação acumulada como valor.  
  Exemplo: `{ "TimeA": 50, "TimeB": 42 }`

- **String[] teamNames**  
  Array simples para armazenar os nomes dos times informados pelo usuário.

## Regras de Negócio

1. **Cadastro dos Times:**  
   O usuário informa a quantidade de times e, em seguida, digita o nome de cada um deles. Todos os times começam com pontuação zero.

2. **Registro das Partidas:**  
   O usuário informa a quantidade de partidas e, para cada partida, digita uma linha no formato:  
   `nomeTime1 nomeTime2 placar`  
   Exemplo: `TimeA TimeB 25:10`  
   O sistema interpreta que o `TimeA` fez 25 pontos e o `TimeB` fez 10 pontos nesta partida.

3. **Acúmulo de Pontuação:**  
   A cada partida registrada, os pontos de cada time são somados ao total já existente no mapa `teamScores`.

4. **Determinação do Vencedor:**  
   Após o registro de todas as partidas, o sistema percorre o mapa de pontuações e identifica o time com o maior valor acumulado, exibindo seu nome como o vencedor.

## Explicação das Classes

- [`Solution`](volley-tracker/src/main/java/org/renan/Solution.java):  
  Classe principal que executa a lógica de interação com o usuário, coleta os dados e utiliza o tracker para registrar partidas e determinar o vencedor.

- [`VolleyballGameTracker`](volley-tracker/src/main/java/org/renan/VolleyballGameTracker.java):  
  Implementa a interface `GameTracker` e é responsável por armazenar e atualizar as pontuações dos times, além de identificar o time com maior pontuação.

- **Interface `GameTracker`:**  
  Define os métodos essenciais para qualquer tracker de partidas: adicionar uma partida (`addMatch`) e encontrar o time com maior pontuação (`findFirst`).

## Exemplo de Execução

```
Enter the number of teams:
3
Enter team name 1:
TimeA
Enter team name 2:
TimeB
Enter team name 3:
TimeC
Enter the number of matches:
2
Enter match info (team1 team2 score) like 'team1 team2 score'25:10
TimeA TimeB 25:10
Enter match info (team1 team2 score) like 'team1 team2 score'25:10
TimeB TimeC 20:25
The team with the highest score is:
TimeA
```

Neste exemplo, `TimeA` termina com 25 pontos, `TimeB` com 30 (10 + 20), e `TimeC` com 25. O sistema retorna o primeiro time com a maior pontuação.

---
