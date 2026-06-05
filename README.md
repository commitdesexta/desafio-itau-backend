# Desafio Itaú - API de Transações e Estatísticas

Este repositório contém a resolução do desafio técnico de backend do Itaú, focado na criação de uma API para recebimento de transações e cálculo de estatísticas em tempo real dos últimos 60 segundos.

O projeto foi construído utilizando os conceitos de **Arquitetura Hexagonal (Ports and Adapters)**, **Modelos Ricos** e estruturas de dados seguras para concorrência.

---

## Stack Tecnológica

- **Java 21** (Eclipse Temurin)
- **Spring Boot 3.x** (Utilizado puramente como adaptador de infraestrutura)
- **Spring Boot Actuator** (Monitoramento e Healthcheck)
- **JUnit 5 & Mockito** (Testes Unitários)
- **Docker & Docker Compose**

---

## Arquitetura do Projeto (Ports & Adapters)

A arquitetura do sistema foi desenhada para seguir rigorosamente o princípio de inversão de dependência e isolamento do Core de negócio.

- **Domain/Core:** Contém os modelos ricos (`Transacao`, `Estatistica`) e as regras puras de negócio. **Não possui nenhuma anotação do Spring Boot ou de qualquer outro framework.**
- **Application/UseCases:** Orquestra os fluxos do sistema através de Portas de Entrada (`Input Ports`).
- **Infrastructure:** Camada externa onde o Spring Boot atua apenas como um provedor de servidores HTTP (Controllers), manipulador global de erros (`@RestControllerAdvice`), persistência em memória e Healthcheck.

Toda a fiação e injeção de dependências é centralizada em uma classe de fábrica (`BeanConfiguration`), garantindo que se o framework precisar ser trocado amanhã (ex: para Quarkus ou Micronaut), o Core de negócio permanecerá 100% intacto.

---

## Como Executar o Projeto com Docker Compose

O projeto está totalmente containerizado utilizando **Multi-Stage Builds** para garantir uma imagem final ultra-leve baseada em Alpine JRE.

Certifique-se de ter o Docker instalado e execute na raiz do projeto:

```bash
# Compilar e subir a aplicação em segundo plano
docker compose up -d --build
