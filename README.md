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
- Credenciais inválidas (usuário inexistente ou senha incorreta, com a mesma mensagem)
- Falha de conexão com banco de dados

---

# Estrutura do Projeto

```text
login-system/
│
├── users.db            (gerado localmente, não versionado)
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
│   ├── security/
│   └── ui/
│
├── scripts/            (criar-banco.sh / criar-banco.bat)
├── tools/              (CriarBanco, GerarHash)
├── test/               (PasswordHasherTest)
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

O sistema utiliza SQLite como banco de dados local. O arquivo `users.db` **não é versionado** (`*.db` está no `.gitignore`); ele é gerado a partir de `database/database.sql` e precisa ficar na raiz do projeto.

Para gerar o banco (requer `javac`/`java` no PATH), na raiz do projeto:

```bash
sh scripts/criar-banco.sh            # Linux/macOS/Git Bash
scripts\criar-banco.bat              # Windows
# use --recriar para apagar e recriar um users.db existente
```

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

# Segurança

- **Hash de senha:** as senhas nunca são guardadas em texto puro. Usa-se PBKDF2WithHmacSHA256 (JDK, sem bibliotecas extras), 600.000 iterações, salt aleatório de 16 bytes por senha. Formato salvo na coluna `password`: `iteracoes$salt$hash` (Base64). Veja `src/security/PasswordHasher.java`.
- **Verificação:** `AuthService` usa `PasswordHasher.verify`, que compara em tempo constante (`MessageDigest.isEqual`).
- **Sem enumeração de usuários:** usuário inexistente e senha incorreta retornam a mesma mensagem ("Usuário ou senha inválidos"); para usuário inexistente também é feita uma verificação de hash fictícia para equalizar o tempo de resposta.
- **SQL Injection:** o `UserDAO` usa apenas `PreparedStatement` com parâmetros.
- **Banco fora do Git:** `users.db` não é rastreado; o seed em `database/database.sql` contém apenas hashes. As senhas de teste da tabela acima servem só para desenvolvimento.
- **Novo hash para o seed:** `java -cp out GerarHash <senha>` (após compilar, veja `scripts/criar-banco.sh`).
- **Teste do hash:**

```bash
mkdir -p out && javac -d out src/security/PasswordHasher.java test/PasswordHasherTest.java && java -cp out PasswordHasherTest
```

Limitações (projeto acadêmico): não há bloqueio por tentativas excessivas (rate limiting) nem comunicação cifrada, por ser aplicação desktop local.

---

# Observações

Projeto desenvolvido para fins acadêmicos e demonstração prática dos conceitos estudados na disciplina de Linguagem de Programação II

# Autores

- Walter Fonseca  
- Luana Monteiro  
- Gabriel Champin  
- Pedro Genaro
