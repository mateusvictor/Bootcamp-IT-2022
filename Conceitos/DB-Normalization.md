# Normalização de Banco de Dados

* Processo que visa a organização de um banco de dados relacional de forma a minimizar a redundâcia de dados e problemas nas queries.

* As formas de normalização objetivam a divisão dos dados em multiplas tabelas, que se relacionam entre si.

## Exemplo

### Tabela inicial

 id |   name    | course | coordinator
----|-----------|--------|-------------
  1 | Mateus    | SI     | Jorge Santos
  2 | Joao      | SI     | Jorge Santos
  3 | Reginaldo | SI     | Jorge Santos
  4 | Carlos    | SI     | Jorge Santos

Na tabela acima, é notório a redundância dos dados nas colunas ```course``` e ```coordinator```.

### Problemas ocasionados pela redundância dos dados
* __Anomalias de inserção (insertion anomalies):__ sempre que um novo estudante for adicionado, será necessário repetir informações que poderiam ser evitadas.
	
* __Anomalias de atualização (updation anomalies):__ supondo que o coordenador do curso de SI seja substituido e que 100 estudantes estejam matriculados, será necessário atualizar a coluna ```coordinator``` de cada célula.

* __Anomalias de remoção (deletion anomalies):__ como múltiplos estudantes são deletados ao final de cada período, as informações relacionadas aos cursos também serão excluídas.

### Normalização

A fim de normalizar a tabela inicial, é possível dividi-la em outras duas tabelas:

* Estudantes:

 id |   name    | course_id
----|-----------|-----------
  1 | Mateus    |         1
  2 | Joao      |         1
  3 | Reginaldo |         1
  4 | Carlos    |         1

* Cursos:

 id | name | coordinator
----|------|-------------
  1 | SI   | Jorge Santos

Assim, uma query que simularia a tabela inicial seria:

```sql
SELECT students.id,
	students.name as student_name, 
    courses.name as course_name, 
    courses.coordinator 
FROM students INNER JOIN courses 
    ON students.course_id = courses.id;
 ```

 id | student_name | course_name | coordinator
----|--------------|-------------|--------------
  1 | Mateus       | SI          | Jorge Santos
  2 | Joao         | SI          | Jorge Santos
  3 | Reginaldo    | SI          | Jorge Santos	
  4 | Carlos       | SI          | Jorge Santos

## Normal Forms

### 1NF
1. __Um único valor em cada célula:__
    - Exemplo: não se pode armazenar dois telefones em uma mesma célula de uma coluna ```contato```;
    - Ao invés disso, deve-se separar os dois valores em duas linhas.

2. __O tema/assunto de uma coluna é imutável.__
3. __Nome único para colunas.__
4. __A ordem dos dados da tabela não importa.__

### 2NF
1. __Normas estabelecidas pela 1NF.__
2. __Uma tabela não pode possuir dependências parciais:__
    - Uma dependência é uma coluna ou uma série de colunas que a tabela "depende" (exemplo de dependência: chave primária);
    - Tendo em vista que uma chave primária pode vir a ser um conjunto de colunas, uma dependência parcial é quando as colunas de uma tabela dependem apenas de parte da chave primária.

### 3NF
1. __Normas estabelecidas pela 2NF__
2. __Uma tabela não pode possuir dependência transitiva:__
    - Dependência transitiva é quando um atributo não-primo (atributo que não é uma chave primaria, chave estrangeira, etc) depende de outro atributo não primo ao invés de uma chave primária. 


