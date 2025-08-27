# 📘 Compliance & Quality Assurance Tests - CP4

**Disciplina:** Compliance & Quality Assurance Tests  
**Turma:** 2TDSPZ - FIAP 2025  
**Aluno:** Paulo André Carminati - RM: 557881  

---

## 📚 Sobre o Projeto

Este projeto implementa uma aplicação Java com **Testes Unitários** utilizando **JUnit 5** e a abordagem **TDD (Test-Driven Development)**.  
O objetivo foi calcular e validar a métrica **APDEX (Application Performance Index)**, garantindo a correta classificação da experiência do usuário com base nos tempos de resposta.

---

## 📜 Regras do Projeto

- **Entrega individual** via link do repositório no GitHub.  
- O **total de amostras** deve ser **igual ao número de RM** do aluno.  
- As classes `Apdex` (implementação) e `ApdexTest` (testes) devem conter o **nome completo e RM** na **primeira linha de cada classe**.  
- Devem ser utilizadas as annotations **`@BeforeEach`** ou **`@BeforeAll`** de acordo com o contexto dos testes.  
- Os métodos de teste unitário devem **cobrir todas as classificações do APDEX** apresentadas em aula e no material: Excelente, Boa, Razoável, Ruim e Inaceitável.  
- Todos os testes devem ser executados com **sucesso** no **IntelliJ** utilizando **JDK 17**.  

---

## ⚙️ Tecnologias Utilizadas

- Java 17  
- Maven  
- Spring Boot (configuração do projeto)  
- JUnit 5  

---

## 📂 Estrutura do Projeto

```
cp4-teste/
 ├── src
 │   ├── main
 │   │   └── java/br/com/fiap/teste
 │   │        ├── Cp4.java               # Classe principal para cálculo do APDEX
 │   │        └── Cp4TesteApplication.java # Classe gerada pelo Spring Boot (opcional)
 │   └── test
 │       └── java/br/com/fiap/teste
 │            └── Cp4Test.java           # Testes unitários JUnit 5
 ├── pom.xml                             # Configuração do Maven
 └── README.md                           # Documentação do projeto
```

---

## 📊 APDEX - Application Performance Index

### Regras de Cálculo
- **Satisfeito:** tempo ≤ T  
- **Tolerável:** T < tempo ≤ 4T  
- **Frustrado:** tempo > 4T  

**Score:**  
```
(Satisfeitos + 0.5 × Toleráveis) / Total
```

### Classificações
- **Excelente:** 0.94 – 1.00  
- **Boa:** 0.85 – 0.93  
- **Razoável:** 0.70 – 0.84  
- **Ruim:** 0.50 – 0.69  
- **Inaceitável:** < 0.50  

---

## ✅ Resultados dos Testes

A execução do comando:

```bash
mvn test
```

Gerou o seguinte resultado:

```
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running br.com.fiap.teste.Cp4Test
Tests run: 6, Failures: 0, Errors: 0, Skipped: 0
-------------------------------------------------------
BUILD SUCCESS
```

Todos os **6 testes unitários** passaram com sucesso ✅.

---

## 🚀 Como Executar

### Compilar e empacotar:
```bash
mvn clean package
```

### Rodar os testes:
```bash
mvn test
```

### Executar a classe principal (exemplo):
```bash
mvn exec:java -Dexec.mainClass="br.com.fiap.teste.Main"
```

---

## 📝 Observações

- Projeto desenvolvido em **Java 17**.  
- Estruturado com **TDD** e boas práticas de testes.  
- O foco foi garantir a cobertura de todas as classificações do **APDEX**.
