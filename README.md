# 🏥 SGHSS - Sistema de Gestão Hospitalar e de Serviços de Saúde

Projeto desenvolvido por **Yngridy Pereira Santos Silva**, matrícula **4424216**, como requisito acadêmico do curso de Análise e Desenvolvimento de Sistemas.

---

## 📌 Sobre o Projeto

Este projeto é um sistema web backend RESTful para gerenciamento de uma clínica ou consultório médico. Ele permite gerenciar usuários, pacientes, profissionais de saúde, consultas, exames e prescrições médicas.

---

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.4.3**
- **Spring Security + JWT**
- **Banco de Dados H2 (em memória)**
- **JPA (Hibernate)**
- **Maven**
- **Lombok**
- **Spring DevTools**
- **Postman (para testes de API)**

---

## ⚙️ Como Executar Localmente

1. **Clone o projeto:**
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   cd seu-repositorio

2. **Importe no IntelliJ, VS Code ou Eclipse como projeto Maven.**

3. **Execute a aplicação:**

    - **Via terminal:**
        bash
    ./mvnw spring-boot:run

    - **Ou diretamente pela IDE (rodando a classe FinalProjectApplication)**

4. **Acesse o console H2 (opcional para debug):**

    http://localhost:8080/h2-console

    - **JDBC URL: jdbc:h2:mem:testdb**
    - **Usuário: sa | Senha: (em branco)**

## 🔐 Autenticação

O sistema usa autenticação baseada em JWT:

## 📌 Cadastro e Login

**Registrar usuário**
    POST /api/auth/register

**Exemplo:**
{
  "nome": "Admin Yngridy",
  "email": "yngridy.silva18@gmail.com",
  "senha": "123456",
  "role": "ADMIN"
}

**Login**
    POST /api/auth/login

**Exemplo:**
{
  "email": "yngridy.silva18@gmail.com",
  "senha": "123456"
}

**Resposta:**
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}

## ⚠️ Use o token retornado em todas as requisições protegidas no cabeçalho:

    Authorization: Bearer SEU_TOKEN_AQUI

# 📁 Endpoints da API

| Entidade          | Método | Endpoint                  | Descrição              |
| ----------------- | ------ | ------------------------- | ---------------------- |
| **Usuários**      | POST   | `/api/auth/register`      | Registrar Usuário      |
|                   | POST   | `/api/auth/login`         | Login do Usuário       |
| **Profissionais** | GET    | `/api/profissionais`      | Listar Profissionais   |
|                   | POST   | `/api/profissionais`      | Criar Profissional     |
|                   | PUT    | `/api/profissionais/{id}` | Atualizar Profissional |
|                   | DELETE | `/api/profissionais/{id}` | Excluir Profissional   |
| **Pacientes**     | GET    | `/api/pacientes`          | Listar Pacientes       |
|                   | POST   | `/api/pacientes`          | Criar Paciente         |
|                   | PUT    | `/api/pacientes/{id}`     | Atualizar Paciente     |
|                   | DELETE | `/api/pacientes/{id}`     | Excluir Paciente       |
| **Consultas**     | GET    | `/api/consultas`          | Listar Consultas       |
|                   | POST   | `/api/consultas`          | Criar Consulta         |
|                   | PUT    | `/api/consultas/{id}`     | Atualizar Consulta     |
|                   | DELETE | `/api/consultas/{id}`     | Excluir Consulta       |
| **Exames**        | GET    | `/api/exames`             | Listar Exames          |
|                   | POST   | `/api/exames`             | Criar Exame            |
|                   | PUT    | `/api/exames/{id}`        | Atualizar Exame        |
|                   | DELETE | `/api/exames/{id}`        | Excluir Exame          |
| **Prescrições**   | GET    | `/api/prescricoes`        | Listar Prescrições     |
|                   | POST   | `/api/prescricoes`        | Criar Prescrição       |
|                   | PUT    | `/api/prescricoes/{id}`   | Atualizar Prescrição   |
|                   | DELETE | `/api/prescricoes/{id}`   | Excluir Prescrição     |

## 📸 Evidências de Testes

- **Testes realizados via Postman com requisições HTTP (GET, POST, PUT, DELETE)*
- **Todas as respostas foram validadas com códigos HTTP 200 OK, 201 Created e 204 No Content.*

# ✅ Conclusão

Este projeto proporcionou uma sólida experiência prática com desenvolvimento de APIs REST com Spring Boot, implementação de autenticação JWT, manipulação de dados via JPA e testes com Postman. Foi possível aplicar boas práticas de segurança, modelagem de dados e estruturação de código limpo, o que refletiu no amadurecimento técnico ao longo do semestre.

# 📬 Contato

Yngridy Silva – yngridy.silva18@gmail.com
Matrícula: 4424216