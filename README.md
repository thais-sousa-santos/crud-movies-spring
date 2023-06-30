
# CRUD Movies Application

Este projeto foi iniciado com a intenção de treinar como aplicar um CRUD básico de uma locadora de filmes.


## Documentação da API

#### Retorna todos os filmes para venda

```http
  GET /movies
```

#### Retorna todos os filmes da locadora pelo id

```http
  GET /movies/search/{id}
```

#### Cadastra um novo filme para vender

```http
  POST /movies
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `name`      | `string` | **Obrigatório**. O nome do produto que você quer cadastrar |
| `director`      | `string` | **Obrigatório**. O nome do diretor do filme |   
| `releaseYear`      | `integer` | **Obrigatório**. O ano de lançamento do filme |
| `available`      | `boolean` | **Obrigatório**. Se o filme está disponível ou não para venda |
| `price`      | `integer` | **Obrigatório**. O valor do filme que você quer cadastrar |

#### Altera um filme enviando o ID no body do JSON

```http
  PUT /movies
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | **Obrigatório**. O ID do filme que você quer alterar |
| `name`      | `string` | **Obrigatório**. O nome do produto que você quer alterar |
| `director`      | `string` | **Obrigatório**. O nome do diretor do filme |   
| `releaseYear`      | `integer` | **Obrigatório**. O ano de lançamento do filme |
| `available`      | `boolean` | **Obrigatório**. Se o filme está disponível ou não para venda |
| `price`      | `integer` | **Obrigatório**. O valor do filme que você quer alterar |


#### Deleta um filme enviando o ID no path da requisição

```http
  DELETE /movies/{id}
```




## Stack utilizada

**Back-end:** Java 17, Spring Boot


