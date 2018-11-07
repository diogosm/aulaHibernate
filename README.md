# aulaHibernate

## Banco de dados

Crie o banco de dados (no meu caso usei *docker*)

`sudo docker run --name postgres -e POSTGRES_PASSWORD=123123 -p 5432:5432 -d postgres`

Após iniciar o banco acesse-o e crie as tabelas e sequências, por exemplo:

`psql -U postgres -h 127.0.0.1 -W`

Cria o banco teste:

`create database teste;`

Acessa o banco e cria tabela(s)

`\c teste;`

```
create table contatos ( 
    id bigserial,
    nome VARCHAR(255),
    email VARCHAR(255),
    endereco VARCHAR(255),
    dataNascimento DATE,
    primary key (id)
);
```

Cria a sequência para o hibernate das tabelas. Caso uma sequência com nome específico seja criada, então cada classe do pacote aula1 deve apontar para essa sua sequence.

`CREATE SEQUENCE hibernate_sequence START 1;`

## Aplicação

O projeto se divide em 3 pacotes: 

* `default`: contém o arquivo de configuração hibernate apropriado (todos os jars incluso).
* `aula1`: contém as classes principais que do modelo. São as classes mapeadas no banco. Também incluímos uma `main.java` que pode ser usado para testar as classes caso haja ausência de JUnit. Na `main.java` tem as informações necessárias para trabalhar-se com os *factories* do *hibernate*
* `controller`: contém as classes associadas aos servlets. Não fizemos separação pra pacotes de controller e servlets, então a chamada dos pacotes de `aula1` são feitas direto no servlet

Na seção de páginas web também tem o `web.xml` responsável pelo mapeamento de servlets. Uma tela de listagem (`listagem.jsp`) e uma tela de inserção (`adicionar.jsp`) simples foram criadas
