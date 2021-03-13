# Cadastro de Veículos
API RestFull Criando para cadastrar veículos buscando os preços dos mesmos na API "BKK_PRECO", e cadastrando os registros no banco de dados Postgress.   

Obs: Como ainda nao tenho toda a regra de negócio para buscar o preço correto na api que fornece o preço do carro, criei um método insolado responsável por realizar a consulta, atualmente este método gera um ID rondômico e consulta com base no id gerado, como este trexo de código está insolado é de facil manutenção e alteração.  

## Executando e testando o projeto

### Pré-requisitos
* PostgresSQL (O banco que foi testado).
* Java 8.
* Sistema Operacional Windows Pois este tutorial não irá abordar instalação em outros SO.

Opcional: Docker
 
### Passo a passo

#### 1 - Instalar o PostgresSQL:

A página oficial contém [links para download](https://www.postgresql.org/download/) do SGBD para diversas plataformas.


1.1 Instalar o PostgreSQL:

1.2 É bastante simples, basta dar um duplo clique no executável que foi baixado no passo à cima e seguir os passos do instalador.



#### 2 - Configurar as propriedades da aplicação 

Caminho até o arquivo de propriedades da aplicação:
`recrutamento-kotlin-jya-infortic/src/main/resources/application.yml`

O usuário e a senha cadastrados durante a instalação do BD deverão ser informados neste arquivo.  

Por exemplo, a string de conexão com o banco `postgres` rodando local na porta `8084`
seria `jdbc:postgresql://localhost:5432/recrutamento`. Para configurar usuário `postgres` e senha `root` uma configuração válida seria a abaixo:

```
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/recrutamento    
    username: postgres     
    password: root

```

#### 3 - Buildar e executar a aplicação

Dentro do diretório root da aplicação executar os passos abaixo.

3.1 Para rodar os testes:

##Obs para rodar os testes lembre-se que o maven precisa estar instalado e as variáves de ambiente devidamente configuradas. 

`$ mvn test #Para rodar os testes`

3.2 Para buildar a aplicação:
`$ mvn clean install #buildando o pacote da aplicação`

3.3 Para executar a aplicação:

O Maven através do `spring-boot-maven-plugin` gera o jar executável.
Então basta entrar no diretório `target/` e executar:

`$ java -jar cadastroDeVeiculos-0.1.jar`

A partir deste ponto se tudo ocorrer corretamente a aplicação estará rodando 
e atendendo requisições através da porta cadastrada no arquivo `application.yml` (se não foi alterado estará na porta 8084).

É possível utilizar o client do swagger através da url [http://localhost:8084/swagger-ui.html]

**Observação:**

Em ambiente Docker desconsidere os passos acima, pois basta executar `docker-compose up` dentro da pasta do projeto e tanto a imagem da API quanto do banco de dados seram iniciados via imagem docker. 
