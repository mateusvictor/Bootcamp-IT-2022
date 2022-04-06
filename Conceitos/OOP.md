# OOP - Conceitos

## Encapsulação
* Agrupamento de métodos e propriedades em uma única entidade, facilitando a compreensão do programa.

#### Benefícios
* Diminui a complexidade do código 
* Aumenta a reusabilidade


## Abstração
* Processo de omissão de certos métodos e propriedades exibindo apenas o essencial para o usuário

### Benefícios
* Diminui a complexidade do código
* Ao isolar determinadas partes do programa, diminui o impacto de mudanças para o usuário

### Classe abstrata
* Uma digital/template de uma classe contendo a declaração de métodos que serão comuns às classes filhas
* Contém um ou mais métodos abstratos (métodos declarados, porém não implementados)
* Não é uma classe concreta
* Não se pode instanciar um objeto de uma classe abstrata, visto que não há implementação de métodos a serem utilizados


## Herança
* Herança dos atributos e métodos de uma classe para outra

### Benefícios
* Elimina código reduntante


## Polimorfismo
* Relacionado diretamente à herança, consiste na adaptação da classe mãe de modo a satisfazer a adaptar as necessidades da entidade
* Várias formas que um método de uma classe mãe pode assumir em classes filhas

```python
class Person:
	def say_hi(self):
		pass
	...

class BritishPerson(Person):
	def say_hi(self):
		print('Hi!')
	...

class BrazillianPerson(Person):
	def say_hi(self):
		print('Oi!')
	...
```
Sem polimorfismo:

```python
class Person:
	nacionality = ''
	def say_hi(self):
		if self.nacionality == 'brazillian':
			print('Oi!')
		elif self.nacionality == 'british':
			print('Hi!')
```

### Benefícios
* Substitui repetitivas estruturas de condição