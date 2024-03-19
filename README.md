# :cupcake: Lazuli :cupcake:

## Sobre o projeto :scroll:

Lazuli é um sistema ERP desenvolvido para uma confeitaria, com o objetivo de auxiliar no controle de entrada e saída de produtos, lucros, despesas, precificação de produtos, entre outras informações.

<img src="https://github.com/liberatov13/lazuli-ui/blob/master/.github/assets/home-page.png" />
<table>
  <tr>
    <td>
      <img src="https://github.com/liberatov13/lazuli-ui/blob/master/.github/assets/product-list-page.png"/>
    </td>
    <td>
      <img src="https://github.com/liberatov13/lazuli-ui/blob/master/.github/assets/product-form-page.png"/>
    </td>
  </tr>
</table>

## Índice
- [Sobre o projeto](#sobre-o-projeto-scroll)
  - [Funcionalidades do sistema](#funcionalidades)
  - [Tecnoogias utilizadas](#tecnologias-utilizadas-hammer_and_wrench)
- [Executando o projeto](#executando-projeto-)
  - [Máquina local](#m%C3%A1quina-local-desktop_computer)
  - [Docker](#docker-)
- [Créditos](#cr%C3%A9ditos-pencil2)

#### Funcionalidades
- [X] Cadastro de produtos
- [ ] Cadastro de receitas
- [ ] Controle de vendas e compras
- [ ] Controle de estoque
- [ ] Relatórios

## Tecnologias utilizadas :hammer_and_wrench:

- Java (v17)
- MySQL (v8)
- Spring Boot (v3)
  - Spring Data JPA
- ModelMapper
- Lombok

## Executando projeto 🧑‍💻

Esse aplicação deve ser utilizando em conjunto com o projeto front-end [Lazuli UI](https://github.com/liberatov13/lazuli-ui)

### Máquina local :desktop_computer:

#### Pré-requisitos
- Java (v17)
- MySQL (v8)
- Maven (v10)

Sugestão: Baixe e execute o [projeto front-end](https://github.com/liberatov13/lazuli-ui) do GitHub.
As instruções para executar o front-end estão disponíveis no [README do projeto](https://github.com/liberatov13/lazuli-ui/blob/master/README.md).

```bash
# Clone o projeto back-end
git clone https://github.com/liberatov13/lazuli-api.git

# Acesse o diretório do projeto
cd lazuli-api

# Instale as dependencias
./mvnw clean install

# Execute o projeto com maven
./mvnw spring-boot:run
```

### Docker 🐳

#### Pré-requisitos
- Docker
- Docker compose

```bash
# Clone o projeto
git clone https://github.com/liberatov13/lazuli-api.git

# Acesse o diretório do projeto
cd lazuli-api

# Execute a aplicação com docker compose
docker compose up -d
```

É possível acessar o Swagger da aplicação, através da URL http://localhost:8080/swagger-ui.html ou caso tenha executado utilizando o docker compose, http://localhost:8089/swagger-ui.html


## Créditos :pencil2:
[Elvis Liberato de Barros](https://github.com/liberatov13) (Desenvolvedor)
