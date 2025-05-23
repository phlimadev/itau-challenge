# Desafio Backend Itaú – Estatísticas de Transações

## Descrição

Este projeto é a solução para o desafio backend do Itaú, que consiste em desenvolver uma API REST capaz de receber transações financeiras e calcular estatísticas em tempo real. As estatísticas incluem soma, média, valor máximo, valor mínimo e total de transações ocorridas nos últimos N segundos, onde esse intervalo é personalizado pelo usuário via parâmetro na requisição, com valor padrão de 60 segundos.

O principal desafio do projeto foi implementar a persistência **sem o uso de banco de dados**, armazenando as transações apenas em memória, garantindo que as estatísticas reflitam corretamente o estado atual das transações válidas dentro da janela de tempo definida.

A aplicação foi desenvolvida em Java usando Spring Boot, com foco em desempenho, validação de dados e tratamento de erros.

---

## Funcionalidades

- Receber transações via endpoint HTTP POST.
- Calcular estatísticas (soma, média, máximo, mínimo, total) considerando apenas as transações dos últimos N segundos, onde N é informado pelo usuário como `requestParam` (padrão: 60 segundos).
- Armazenamento em memória das transações, sem uso de banco de dados.
- Validação das transações para garantir que somente dados válidos e atuais sejam considerados.
- Tratamento adequado de erros e respostas HTTP apropriadas.

---

## Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Web
- Maven para gerenciamento de dependências

---

## Como Executar

1. Clone o repositório:
   ```
   git clone https://github.com/phlimadev/itau-challenge.git
   ```

2. Entre na pasta do projeto:
   ```
   cd itau-challenge
   ```

3. Execute a aplicação:
   ```
   ./mvnw spring-boot:run
   ```
   ou
   ```
   mvn spring-boot:run
   ```

4. A API estará disponível em `http://localhost:8080`.

---

## Endpoints

- **POST /transacao**

  Recebe uma transação com os seguintes dados:
  ```json
  {
    "valor": 123.45,
    "dataHora": "2020-08-07T12:34:56.789-03:00"
  }
  ```
  
- **DELETE /transacao**

  Apaga todas as transações.

- **GET /estatistica?seconds=N**

  Retorna as estatísticas das transações ocorridas nos últimos N segundos. O parâmetro `seconds` é opcional e, se não informado, considera o padrão de 60 segundos.

  Exemplo de resposta:
  ```json
  {
    "sum": 100.0,
    "avg": 50.0,
    "max": 70.0,
    "min": 30.0,
    "count": 2
  }
  ```

---

## Considerações Finais

Este projeto destaca a capacidade de gerenciar dados em memória, realizando cálculos de estatísticas em tempo real com alta performance, além de demonstrar boas práticas em desenvolvimento backend, validação e tratamento de dados sem o suporte tradicional de um banco de dados.
