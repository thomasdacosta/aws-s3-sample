# AWS S3 com Spring Cloud AWS

Usando o AWS S3 em uma aplicação Spring Boot com Spring Cloud AWS.

### LocalStack

Para habilitar o LocalStack, usar o seguinte profile:

```
-Dspring.profiles.active=localstack
```

Para execução com o LocalStack é necessário mudar o endpoint do S3 no arquivo **bootstrap.yml** para o endereço do LocalStack:

```
cloud:
  aws:
    s3:
      endpoint: http://s3.localhost.localstack.cloud:4566/
    stack:
      auto: false
```

Além disso a região padrão deve ser sempre **us-east-1** para testar com LocalStack.

Crie um profile separado com o AWS Cli:

```
aws configure --profile localstack

AWS Access Key ID [None]: test
AWS Secret Access Key [None]: test
Default region name [None]: us-east-1
Default output format [None]:
```

Comando para criar o bucket no S3:

```
aws --endpoint http://localhost:4566 --profile localstack s3 mb s3://dccomics
```

---

Thomás da Costa - [https://thomasdacosta.com.br](https://thomasdacosta.com.br)




