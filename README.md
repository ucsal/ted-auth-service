# TED Auth Service

Serviço de autenticação e autorização do sistema TED. Responsável por gerenciar usuários, validar credenciais e emitir tokens JWT utilizados pelos demais serviços.

## Sobre

O Auth Service implementa o Spring Security com banco de dados PostgreSQL — nenhuma credencial é armazenada em memória. Ao fazer login, o usuário recebe um token JWT contendo seu email e role. Esse token é validado pelo API Gateway a cada requisição, garantindo que apenas usuários autenticados acessem os recursos do sistema.

## Tecnologias

- Java 21
- Spring Boot 3.4.1
- Spring Security 6
- Spring Cloud Netflix Eureka Client 2024.0.1
- JJWT 0.12.6
- PostgreSQL
- Lombok

## Configuração

| Propriedade | Valor |
|---|---|
| Porta | 8081 |
| Banco | auth_db (PostgreSQL) |
| Eureka | http://localhost:8761/eureka |

## Roles disponíveis

| Role | Descrição |
|---|---|
| ADMIN | Gerencia professores, alunos, projetos e grupos |
| PROFESSOR | Solicita projetos e acompanha status |
| ALUNO | Visualiza informações do grupo |

## Endpoints

| Método | Rota | Descrição | Auth |
|---|---|---|---|
| POST | /api/auth/register | Cadastra novo usuário | Público |
| POST | /api/auth/login | Realiza login e retorna JWT | Público |

## Exemplos

**Register:**
```json
{
  "nome": "João Silva",
  "email": "joao@ucsal.edu.br",
  "senha": "senha123",
  "role": "PROFESSOR"
}
```

**Login:**
```json
{
  "email": "joao@ucsal.edu.br",
  "senha": "senha123"
}
```

**Resposta:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```

## Como executar

```bash
mvn clean package -DskipTests
java -jar target/ted-auth-service-0.0.1-SNAPSHOT.jar
```