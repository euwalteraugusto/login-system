# Sistema de Login em Java

Projeto acadêmico desenvolvido para a disciplina de Linguagem de Programação II.

O sistema realiza autenticação de usuários utilizando Java integrado ao banco de dados SQLite, com interface gráfica desenvolvida em Swing.

---

# Objetivo do Projeto

O objetivo do projeto é demonstrar conceitos fundamentais de:

- Programação Orientada a Objetos (POO)
- Integração com banco de dados
- JDBC
- Interface gráfica com Swing
- Estruturação de projetos Java
- Tratamento de erros
- Organização em camadas

---

# Tecnologias Utilizadas

- Java
- Swing
- JDBC
- SQLite
- VS Code

---

# Funcionalidades

- Tela de login
- Validação de usuário e senha
- Integração com banco de dados SQLite
- Consulta SQL utilizando `PreparedStatement`
- Mensagens de sucesso e erro
- Tratamento de exceções

---

# Tratamento de Erros

O sistema possui tratamento para:

- Campos vazios
- Usuário inexistente
- Senha incorreta
- Falha de conexão com banco de dados

---

# Estrutura do Projeto

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

# Usuários de Teste

| Usuário | Senha |
|---|---|
| admin | 123456 |
| walter | walter123 |
| luana | luana123 |

---

# Como Executar

## 1. Abrir o projeto no VS Code

Abra a pasta:

```text
login-system
```

---

## 2. Adicionar o Driver JDBC

Adicionar o arquivo:

```text
lib/sqlite-jdbc-3.53.1.0.jar
```

em:

```text
JAVA PROJECTS → Referenced Libraries
```

---

## 3. Executar o Projeto

Abrir o arquivo:

```text
src/app/Main.java
```

Clique em:

```text
Run
```

---

# Banco de Dados

O sistema utiliza SQLite como banco de dados local.

O arquivo:

```text
users.db
```

precisa permanecer na raiz do projeto para evitar problemas de caminho durante a execução.

---

# Exemplo de Consulta SQL

```sql
SELECT * FROM users WHERE username = ?
```

---

# Interface do Sistema

O sistema possui:

- Campo de usuário
- Campo de senha
- Botão de login
- Mensagens de erro e sucesso
- Validação de autenticação

---

# Observações

Projeto desenvolvido para fins acadêmicos e demonstração prática dos conceitos estudados na disciplina de Linguagem de Programação II

# Autores

- Walter Fonseca  
- Luana Monteiro  
- Gabriel Champin  
- Pedro Genaro
