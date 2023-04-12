# Minsait Projeto Final - Empréstimo
API para prover recursos para nossa plataforma de empréstimo.

### Autor

- [José Edson Teles Fontes Junior](https://www.linkedin.com/in/edsontelesfontes/)

Repositório contendo o código fonte do projeto final de empréstimo da minsait.

# Demonstração

Foi nos solicitados a construção de um sistema de empréstimo, a partir disso começamos a desenhar um sistema de empréstimo com algumas regras de pré estabelecidas.

O fluxo principal da plataforma de empréstimos consiste em um sistema de cadastro de clientes e empréstimos.
A arquitetura da nossa plataforma é constituida por:

**Pacotes:**

| Pacote     | Definição                                                                                                 |
|------------|-----------------------------------------------------------------------------------------------------------|
| Enum       | Existência das classes para manter a integridade do negócio                                               |
| Model      | Classes e entidades com base nas diretivas do negócio da aplicação                                        |
| Repository | Intefarces para persistências de dados com base no Spring Data JPA                                        |
| Service    | Classes contendo todas as regras de negócio da aplicação                                                  |
| Controller | Recursos HTTPs para disponibilizar o acesso as funcionalidades da aplicação                               |
| Mapper     | Recursos para mapeamento de dtos e entidades para criar uma "blindagem" gerando consistência da nossa API |
| Resource      | Recursos para utilidades do sistema, como classes DTO               |
| Utils      | Recursos para utilidades do sistema, como classes para consumos de api, formatações, etc...               |
| Validation | Recursos para validações de atributos do sistema, como por exemplo @Phone para validação de telefone   |
| Configuration | Recursos para configurações do sistema, como por exemplo habilitação de CORS para consumo no front     |


**Módulos:**

| Módulo     | Definição                                                                                 |
|------------|-------------------------------------------------------------------------------------------|
| Cliente    | Módulo contendo as classes necessárias para o registro de novos usuários                  |
| Empréstimo | Módulo para etapa de um pedido de empréstimo                                            |


##### Tecnologias

* Java
* Spring DATA JPA / JPA Hibernate
* H2
* Spring Boot
* Swagger
* Map Struct
* Postman


Para a nossa demonstração estamos interagindo com nossa api diretamente atrvés do postman, mas também pode ser acessada através do swagger confome url:
```
http://localhost:8080/swagger-ui/index.html
```
### Você pode ter acesso as requisições através do postman no botão baixo
[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/26875423-643b5d8c-b374-432a-92c9-36ac50a8059e?action=collection%2Ffork&collection-url=entityId%3D26875423-643b5d8c-b374-432a-92c9-36ac50a8059e%26entityType%3Dcollection%26workspaceId%3Db2d70d72-c200-4ed8-8639-4a2257531b4d)


##### Endpoints
* Cliente

<img src= "https://imgur.com/L4n9Lnm.png">

* Empréstimo
<img src = "https://imgur.com/ztE4wyF.png">

* Enum tipo de relacionamento 
<img src = "https://imgur.com/hWjB2z5.png">

### 1° Etapa - Cadastramento de usuarios.

1. Adicionando um cliente

```
POST:/api/v1/clientes
```
```
{
  "name": "string",
  "cpf": "string",
  "phoneNumber": "stringst",
  "address": {
    "street": "string",
    "number": 1,
    "zipCode": "string"
  },
  "salary": 1320,
  "clientType": "BRONZE"
}
```
2. Consultando a lista de usuários.
```
GET:/api/v1/clientes/
```

3. Consultando a lista de usuários com CPF do banco de dados.
```
GET:/api/v1/clientes/{cpf}
```
3. Alterando alguma propriedade ou o cliente inteiro.
```
PUT:/api/v1/clientes/{cpf}
```
```
Exemplo
{
  "phoneNumber": "string",
}
```

3. Deletando o usuário
```
DELETE:/api/v1/clientes/{cpf}
```
```
Retorno void
```
## 2° Etapa - Contratando um empréstimo.

1. Contratando um empréstimo
```
POST:/api/v1/clientes/{cpf}/emprestimos
```
```
{
  "cpf": "string",
  "loanAmount": 2,
  "enumClientType": "BRONZE",
  "endDate": "2023-04-12"
}
```
2. Procurando todos os empréstimos através de um CPF
```
GET:/api/v1/clientes/{cpf}/emprestimos
```
```
Retorna todos os empréstimos vinculados aquele CPF
```
Pesquisando um empréstimo através de um ID
```
GET:/api/v1/clientes/{cpf}/emprestimos/{id}
```

Deletando um empréstimo através do CPF e do ID.
```
DELETE:/api/v1/clientes/{cpf}/emprestimos/{id}
```
## 3ª Etapa - Buscando o tipo de relacionamento do cliente
1. Buscando todos os tipos disponíveis de enum/relacionamento do cliente para ser consumido no front.
```
GET:/api/v1/clientes/enum
```