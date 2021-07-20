# AluraFlix

AluraFlix é um projeto da Alura Challenge Back-End, onde será construído uma API REST de um catálogo de vídeos, com tecnologias a escolha do participante.

## Tecnologias

| Nome          |Versão         |
| ------------- |:-------------:|
| Kotlin        |   1.5.20      |
| Spring Boot   |   2.5.2       |
| ElasticSearch |   7.13.3      |

## Roadmap

### Semana 1

- [x] Banco de dados
- [x] Rota de criação de vídeo (POST)
- [x] Rota de atualização de vídeo (PUT/PATCH)
- [x] Rota de consulta de todos os vídeos (GET)
- [x] Rota de consulta de vídeo por id (GET)
- [x] Validação dos campos
- [ ] Testes unitários
- [ ] Testes integrados

## Como executar

1. Clone o repositório
2. Vá para a pasta docker e execute ```docker-compose up```, que irá subir o ElasticSearch na porta 9200
3. Faça uma requisição PUT para ```http://localhost:9200/videos``` com o conteúdo do arquivo ```elasticsearch_mapping.json``` no body para criar o índice do ElasticSearch
4. Execute a aplicação pela função ```main()``` no arquivo ```AluraFlixApplication.kt```

## Como os dados são armazenados no ElasticSearch

```json
{
  "mappings": {
    "properties": {
      "titulo": { "type": "text" },
      "descricao":  { "type": "text"  },
      "url":   { "type": "keyword"  }
    }
  }
}

```

