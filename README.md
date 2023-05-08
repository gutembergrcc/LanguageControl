## Ferramentas necessárias

- IDE de sua preferência
- JDK 17
- Docker

## Como executar?

1. Clonar o repositório ou importar o projeto:
```shell
git clone 
```

2. Executar o Docker compose para que as imagens sejam baixadas e os containers criados:
```shell
docker-compose up -d
```
## Alterando a App e Regerando a Imagem da App:

Gerar a Imagem da Aplicação atraves do DockerFile
```shell
docker build -t gutembergrcc/spring-boot-docker-language-app .
```

Caso queira gerar o build do Gradle e gerar a imagem, basta executar o comando abaixo:
```shell
docker build -f Dockerfile.dev -t gutembergrcc/spring-boot-docker-language-app:latest .
```

Para subir a imagem para o Hub:
```shell
docker push gutembergrcc/spring-boot-docker-language-app
```

4. Documentação: 
```http://localhost:8080/api/swagger-ui/index.html```


## Banco de dados

Para não precisar enviar arquivo DDL, foi configurado o DDL do Hibernate como:
ddl-auto: create-drop
Com isso a base/table é criado quando a App é criada, deve ser atualizado para os DDLs serem criados uma só vez.