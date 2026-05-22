````markdown
# Sistema de Login em Java

Projeto acadêmico desenvolvido para a disciplina de Linguagem de Programação II, com o objetivo de demonstrar autenticação de usuários utilizando Java integrado ao banco de dados SQLite.

---

## Descrição

O sistema realiza autenticação de usuários através de uma interface gráfica desenvolvida com Swing, utilizando JDBC para conexão com banco de dados SQLite.

O projeto foi estruturado em camadas para facilitar organização, manutenção e entendimento do código.

---

## Tecnologias Utilizadas

- Java
- Swing
- JDBC
- SQLite
- VS Code

---

## Funcionalidades

- Tela de login
- Validação de usuário e senha
- Integração com banco de dados SQLite
- Consulta SQL utilizando PreparedStatement
- Mensagens de sucesso e erro
- Tratamento básico de exceções

---

## Tratamento de Erros

O sistema possui tratamento para:

- Campos vazios
- Usuário inexistente
- Senha incorreta
- Falha de conexão com banco de dados

---

## Estrutura do Projeto

```text
login-system/
│
├── users.db
│
├── lib/
│   └── sqlite-jdbc-3.53.1.0.jar
│
├── database/
│   └── database.sql
│
├── src/
│   ├── app/
│   ├── connection/
│   ├── dao/
│   ├── model/
│   ├── service/
│   └── ui/
```

---

## Usuários de Teste

| Usuário | Senha |
|---|---|
| admin | 123456 |
| walter | walter123 |
| luana | luana123 |
| pedro | pedro123 |
| gabriel | gabriel123 

---

## Como Executar

### 1. Abrir o projeto no VS Code

Abra a pasta:

```text
login-system
```

---

### 2. Adicionar o driver SQLite JDBC

Adicionar o arquivo `.jar` localizado em:

```text
lib/sqlite-jdbc-3.53.1.0.jar
```

em:

```text
JAVA PROJECTS → Referenced Libraries
```

---

### 3. Executar o projeto

Abrir o arquivo:

```text
src/app/Main.java
```

e clicar em:

```text
Run
```

---

## Objetivo Acadêmico

O projeto tem como finalidade aplicar conceitos fundamentais de:

- Programação Orientada a Objetos
- Integração com banco de dados
- JDBC
- Estruturação de projetos Java
- Organização em camadas
- Tratamento de erros
- Interface gráfica com Swing

---

## Observações

O banco de dados SQLite (`users.db`) deve permanecer na raiz do projeto para evitar problemas de caminho durante a execução.
````
