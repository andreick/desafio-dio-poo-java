# Desafio de Projeto Java

Projeto realizado durante o desafio Abstraindo um Bootcamp Usando Orientação a Objetos em Java demonstrado no repositório [cami-la/desafio-poo-dio](https://github.com/cami-la/desafio-poo-dio).  
O objetivo é abstrair o domínio de aplicação de um Bootcamp. Cada Bootcamp possui um conjunto de cursos e mentorias e os Devs poderão se matricular nos bootcamps, progredir e ganhar xp.

## O que foi feito

Em relação ao projeto de demonstração do desafio, este projeto faz uma separação mais clara das regras de nogócio encapsulando as classes de acesso aos dados, a classe [DevService](src/main/java/com/andreick/poo/service/DevService.java) contém as regras de negócio relativas ao Dev.  
Também foi criada a classe [DevServiceTest](src/test/java/com/andreick/poo/service/DevServiceTest.java) para testar os comportamentos esperados.

## O que foi utilizado

- [Java 11](https://www.oracle.com/java/technologies/downloads/#java11)
- [JUnit 5](https://junit.org/junit5)
- [IntelliJ IDEA](https://www.jetbrains.com/idea)
