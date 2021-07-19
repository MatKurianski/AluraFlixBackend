# AluraFlix

AluraFlix é um projeto da Alura Challenge Back-End, onde será construído uma API REST de um catálogo de vídeos, com tecnologias a escolha do participante.

### Tecnologias

| Nome          |Versão         |
| ------------- |:-------------:|
| Kotlin        |   1.5.20      |
| Spring        |   2.5.2       |
| ElasticSearch |   7.13.3      |

### Como os dados são armazenados no ElasticSearch

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

