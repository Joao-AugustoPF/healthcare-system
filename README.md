
# Healthcare System

Um sistema de gerenciamento de **Pacientes**, **Medicamentos**, e **Atendimentos Médicos** desenvolvido com **Spring Boot**, utilizando **MySQL** como banco de dados.

---

## **Recursos**

- **Gerenciamento de Pacientes**: Cadastro, consulta, atualização e exclusão de pacientes.
- **Controle de Medicamentos**: Vinculação de medicamentos a pacientes, incluindo dosagem e frequência.
- **Atendimentos Médicos**: Registro de atendimentos, com informações do médico e diagnóstico.
- **Persistência de Dados**: Utiliza MySQL como banco de dados para armazenamento confiável.

---

## **Tecnologias Utilizadas**

- **Java 17**
- **Spring Boot 3**
- **MySQL 8**
- **Lombok**
- **Maven**

---

## **Pré-requisitos**

1. **Java 17+**
2. **Maven 3.8+**
3. Editor de código (opcional, ex.: IntelliJ IDEA ou Eclipse)

---

## **Configuração do Projeto**

### **Banco de Dados**
O banco de dados é configurado no arquivo `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/healthcare_system
spring.datasource.username=root
spring.datasource.password=your_password
```

### **Build Local**
1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/healthcare-system.git
   cd healthcare-system
   ```

2. Compile o projeto com Maven:
   ```bash
   mvn clean package
   ```

3. Execute o projeto:
   ```bash
   java -jar target/healthcare-system-0.0.1-SNAPSHOT.jar
   ```
   
---

## **Endpoints Disponíveis**

### **Pacientes**
- `GET /api/patients`: Lista todos os pacientes.
- `GET /api/patients/{id}`: Retorna um paciente específico.
- `POST /api/patients`: Adiciona um novo paciente.
- `PUT /api/patients/{id}`: Atualiza um paciente existente.
- `DELETE /api/patients/{id}`: Remove um paciente.

### **Medicamentos**
- `GET /api/medications`: Lista todos os medicamentos.
- `GET /api/medications/{id}`: Retorna um medicamento específico.
- `POST /api/medications`: Adiciona um novo medicamento.
- `PUT /api/medications/{id}`: Atualiza um medicamento existente.
- `DELETE /api/medications/{id}`: Remove um medicamento.

### **Atendimentos Médicos**
- `GET /api/appointments`: Lista todos os atendimentos médicos.
- `GET /api/appointments/{id}`: Retorna um atendimento médico específico.
- `POST /api/appointments`: Adiciona um novo atendimento médico.
- `PUT /api/appointments/{id}`: Atualiza um atendimento existente.
- `DELETE /api/appointments/{id}`: Remove um atendimento médico.

---

## **Estrutura do Projeto**

```
healthcare-system/
├── src/
│   ├── main/
│   │   ├── java/com/example/healthcare_system/
│   │   │   ├── controllers/        # Controladores REST
│   │   │   ├── dtos/               # Data Transfer Objects (DTOs)
│   │   │   ├── entities/           # Entidades JPA
│   │   │   ├── exceptions/         # Classes de exceção
│   │   │   ├── repositories/       # Repositórios JPA
│   │   │   ├── services/           # Lógica de negócios
│   │   │   └── HealthcareSystemApplication.java
│   │   └── resources/
│   │       ├── application.properties
├── Dockerfile
├── docker-compose.yml
├── pom.xml
└── README.md
```

---

## **Contribuições**

Sinta-se à vontade para contribuir com o projeto:
1. Faça um fork do repositório.
2. Crie um branch para sua feature:
   ```bash
   git checkout -b minha-feature
   ```
3. Envie um pull request.