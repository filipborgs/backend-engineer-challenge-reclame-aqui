# Backend Engineer Challenge

### Made with:

Java / Spring / MongoDB

## INSTALATION

This API required Java 11 and Maven to compile the project

//install maven if needed
pacman -S maven //Arch based distros
apt install maven //Debian based distros

git clone https://github.com/filipborgs/backend-engineer-challenge-reclame-aqui.git
cd backend-engineer-challenge-reclame-aqui
mvn install
docker-compose up

## Endpoints

This API is divided into microservices to consult and create new registres. A gateway connects these services.

#### GET /consult/claims/all

This endpoint are responsible for return all claims registered in database.

#### Parameters

N/A

#### Responses

```
[
    {
        "id": "60bf839d5afe7a1eb32cf5ea",
        "title": "Computador quebrado",
        "createdAt": "2021-06-08T14:50:05.401+00:00",
        "description": "Celular não funciona",
        "address": {
            "street": "Av froes da mota",
            "city": "Feira de santana",
            "cep": "44021-222",
            "uf": "BA"
        },
        "consumer": {
            "name": "zxczxc",
            "email": "teste@gmail.com"
        },
        "company": {
            "name": "teste",
            "category": null
        }
    },
    {
        "id": "60bf84025afe7a1eb32cf5eb",
        "title": "Computador não funciona",
        "createdAt": "2021-06-08T14:51:46.030+00:00",
        "description": "Comprei um computador e ele veio quebrado",
        "address": {
            "street": "Gabriela II",
            "city": "Feira de santana",
            "cep": "44028-222",
            "uf": "BA"
        },
        "consumer": {
            "name": "Filipe Borges",
            "email": "filipe@gmail.com"
        },
        "company": {
            "name": "Dell",
            "category": null
        }
    }
]
```

#### GET /consult/claims/id/{id of claim}

This endpoint are responsible for return a single claim registered in database whith its relations.

#### Parameters

{id of claim}: This endpoint recive a id of claim in path

#### Responses

```
{
    "id": "60bf855a5afe7a1eb32cf5ed",
    "title": "Empresa não responde",
    "createdAt": "2021-06-08T14:57:30.556+00:00",
    "description": "Contratei uma empresa de serviços e ela nunca apareceu",
    "address": {
        "street": "Rua A",
        "city": "Minas",
        "cep": "54021-222",
        "uf": "MG"
    },
    "consumer": {
        "name": "Rodrigo",
        "email": null
    },
    "company": {
        "name": "Serviços SA",
        "category": null
    }
}
```

#### GET /consult/claims/uf/{uf}

This endpoint are responsible for return an array of claims of the UF receved in URL.

#### Parameters

{uf}: This endpoint recive a UF of the state in path

#### Responses

```
[
    {
        "id": "60bf855a5afe7a1eb32cf5ed",
        "title": "Empresa não responde",
        "createdAt": "2021-06-08T14:57:30.556+00:00",
        "description": "Contratei uma empresa de serviços e ela nunca apareceu",
        "address": {
            "street": "Rua A",
            "city": "Minas",
            "cep": "54021-222",
            "uf": "MG"
        },
        "consumer": {
            "name": "Rodrigo",
            "email": null
        },
        "company": {
            "name": "Serviços SA",
            "category": null
        }
    }
]
```

#### POST /register/claims

This endpoint are responsible for insert a single claim in database.

#### Parameters

This endpoint recive a json in body of the request

```
{
    "title": "Computador não funciona",
    "description": "Comprei um computador e ele veio quebrado",
    "address": {
        "uf": "BA",
        "cep": "44028-222",
        "city": "Feira de santana",
        "street": "Gabriela II"
    },
    "company": {
        "name": "Dell"
    },
    "consumer":{
        "name": "Filipe Borges",
        "email": "filipe@gmail.com"
    }
}
```

#### Responses

```
{
    "id": "60bf84025afe7a1eb32cf5eb",
}
```

#### POST /register/claims/many

This endpoint are responsible for insert many claims in database.

#### Parameters

This endpoint recive a array of jsons in body of the request

```
[
    {
    "title": "Atraso na entrega do produto",
    "description": "Comprei um celular na Magazine, o prazo de entrega já passou e o produto ainda não chegou",
    "address": {
        "uf": "SP",
        "cep": "34021-221",
        "city": "São Paulo",
        "street": "Av paulista"
    },
    "company": {
        "name": "Magazine"
    },
    "consumer":{
        "name": "Patricia"
    }
},
{
    "title": "Empresa não responde",
    "description": "Contratei uma empresa de serviços e ela nunca apareceu",
    "address": {
        "uf": "MG",
        "cep": "54021-222",
        "city": "Minas",
        "street": "Rua A"
    },
    "company": {
        "name": "Serviços SA"
    },
    "consumer":{
        "name": "Rodrigo"
    }
}
]
```

#### Responses

```
[
    {
        "id": "60bf855a5afe7a1eb32cf5ec",
    },
    {
        "id": "60bf855a5afe7a1eb32cf5ed",
    }
]
```