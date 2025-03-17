# **BackendSaas**

Este projeto é o **backend** do sistema **Gestão de Clientes**, desenvolvido para gerenciar informações de clientes e serviços. Ele fornece uma **API REST** robusta construída em **Java** com **Spring Boot**, integrada com **MongoDB** e outras tecnologias para garantir alta escalabilidade e segurança.

## **🛠 Tecnologias Utilizadas**

- **Java 21*
- **Spring Boot 3.x**
- **MongoDB** *(Banco de dados NoSQL)*
- **Spring Security** *(Autenticação e autorização)*
- **Swagger UI** *(Documentação da API)*
- **Lombok** *(Para redução de código boilerplate)*
- **Docker** *(Para conteinerização do ambiente)*

---

## **📌 Funcionalidades Principais**

✔ **Gerenciamento de clientes e serviços**✔ **Autenticação e autorização de usuários** *(JWT e Spring Security)*✔ **Criação e edição de propostas e contratos**✔ **Persistência de dados via MongoDB**✔ **Integração com o Frontend via API REST**✔ **Geração de relatórios e notificações**

---

## **📚 Estrutura do Projeto**

```
📂 backend/
 ├── 📂 src/main/java/com/gh/backend/
 │    ├── 📂 controller/    # Camada de controle (Endpoints da API)
 │    ├── 📂 service/       # Camada de serviço (Regras de negócio)
 │    ├── 📂 repository/    # Camada de persistência (Acesso ao banco)
 │    ├── 📂 model/         # Modelos de entidades
 │    ├── 📂 security/      # Configurações de autenticação e autorização
 │    ├── 📂 dto/           # Data Transfer Objects (DTOs)
 │    ├── 📜 Application.java  # Ponto de entrada do Spring Boot
 ├── 📂 src/main/resources/
 │    ├── 📜 application.properties # Configurações do Spring Boot
 ├── 📜 pom.xml    # Dependências do projeto
```

---

## **🚀 Como Executar o Projeto**

### **🔹 Ambiente de Desenvolvimento**

1️⃣ **Clone o repositório**

```bash
git clone https://github.com/LeonardoPereirajr/backend-saas.git
```

2️⃣ **Configure o MongoDB**Certifique-se de que o serviço do **MongoDB** está em execução na porta padrão `27017`. 

3️⃣ **Configure as variáveis de ambiente**Crie um arquivo `application.properties` dentro de `src/main/resources/` com os seguintes parâmetros:

```
spring.data.mongodb.uri=mongodb://localhost:27017/backend_saas
server.port=8080
spring.profiles.active=dev
```

4️⃣ **Instale as dependências**

```bash
mvn clean install
```

5️⃣ **Execute a aplicação**

```bash
mvn spring-boot:run
```

A API estará disponível em: [http://localhost:8080](http://localhost:8080)

---

## **🛠 Endpoints Disponíveis**

### **ClienteController**

📌 `GET /clientes` → Listar todos os clientes
📌 `GET /clientes/{id}` → Buscar cliente por ID
📌 `POST /clientes` → Criar um novo cliente
📌 `PUT /clientes/{id}` → Atualizar cliente
📌 `DELETE /clientes/{id}` → Remover cliente

### **ServicoController**

📌 `GET /servicos` → Listar todos os serviços
📌 `POST /servicos` → Criar um novo serviço
📌 `PUT /servicos/{id}` → Atualizar serviço
📌 `DELETE /servicos/{id}` → Remover serviço

Para acessar a documentação da API via **Swagger UI**, vá para:  
📌 [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## **🤖 Testes**

### **🔹 Testes Unitários**

```bash
mvn test
```

Executa os testes unitários usando **JUnit** e **Mockito**.

### **🔹 Testes de Integração**

```bash
mvn verify
```

Executa os testes de integração do projeto.

---

## **📦 Docker - Deploy Simplificado**

Para rodar o backend dentro de um container Docker:

1️⃣ **Crie a imagem Docker**

```bash
docker build -t backend-saas .
```

2️⃣ **Rode o container**

```bash
docker run -p 8080:8080 backend-saas
```

O backend estará acessível na porta `8080`.

---

## **📚 Documentação e Ajuda**

Para mais informações sobre **Spring Boot**, consulte a [documentação oficial](https://spring.io/projects/spring-boot).

Caso precise de suporte ou queira contribuir com o projeto, entre em contato! 🚀

---

### **📢 Status do Projeto**

💡 **Em desenvolvimento** 



![DALL·E](https://github.com/user-attachments/assets/635b8c33-d370-4f9b-a32b-2ced808b1221)
![output](https://github.com/user-attachments/assets/6fea9012-cd7e-49f3-a65f-d006f4893b63)
