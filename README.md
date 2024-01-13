﻿# Nunes Sports

 ## Sobre
 Projeto realizado como solução para o desafio EVERYMIND - Best Minds 2024. No desafio um cliente fictício cjamado Nunes Sports solicitou que seja desenvolvido um sistema para exibição, criação, edição e deleção dos produtos vendidos pela cia.  
 As tecnologias utilizadas para a realização do projetos foram os frameworks SpringBoot com maven e React para a API e para a exibição web respectivamentes e o banco de dados MySQL.  

 ## Pré Requisitos
#### 1- [Java](https://www.java.com/en/download/)  
#### 2- [Node](https://nodejs.org/)  
#### 3- [Maven](https://maven.apache.org/download.cgi?.)  
#### 4- [MySQL](https://www.mysql.com/downloads/)  

 ## Rodando a aplicação  
 #### 1- Criar a database nunes_sports no seu MySQL local, dentro dessa database criar a tabela _tb_produtos_ utilizando o comando no arquivo txt contido nesse repositório.  
 #### 2- Preencher os dados de login e senha do seu MySQL no arquivo _application.properties_ da api no SpringBoot.  
 #### 3- Garantir que a porta local 8080 esteja disponível e rodar a API.  
 #### 4- Executar o comando`npm install` na pasta "nunes-sports-front" para instalar os pacotes do react.  
 #### 5- executar o comando `npm start` para rodar o app react.

 ## Endpoints

### **POST** /produtos
Cadastro de novos produtos
```console
  {
  "nome": "string",
  "descricao": "string",
  "preco": 0
}
```
### **PUT** /produtos/{id}
Atualiza os dados preenchidos do produto cujo id foi selecionado na url
```console
  {
  "nome": "string",
  "descricao": "string",
  "preco": 0
}
```

### **GET** /produtos
Retorna todos os produtos cadastrados.

### **GET** /produtos/{id}
Retorna o produto do id selecionado na url

### **DELETE** /produtos/{id}
Deleta o produto do id selecionado na url



 
