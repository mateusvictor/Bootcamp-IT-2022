# Injeção de Dependência

* Conceito que permite a injeção/inserção de uma determinada dependência (um objeto, por exemplo) no instanciamento de um novo objeto.
* Significa dar a um objeto suas variáveis (e não defini-las no interior de sua classe)
* Facilita o teste de componentes individuais, visto que é possível passar dependências falsas para o objeto a fim de promover um comportamento específico na execução do programa.


## Exemplo:

```python
class SomeClass:
	myObject = OtherClass()
	...
```

Como o funcionamento da classe `SomeClass` depende do objeto `myObject`, seria impossível testar unicamente o funcionamento da primeira, visto que não temos como impedir a instanciação do segundo.

```python
class SomeClass:
	def __init__(self, myObject = {}):
		self.myObject = myObject or OtherClass()
	...

obj = SomeClass(myObject=fakeObject)
```

Neste exemplo, é possível injetar uma depêndencia falsa `fakeObject` na instanciação do objeto `obj`, desprezando o funcionamento de `OtherClass`, e facilitando, por fim, o teste exclusivo da classe `SomeClass`.

## Outras referências
* <a href="https://stackoverflow.com/questions/130794/what-is-dependency-injection/140655#140655">https://stackoverflow.com/questions/130794/what-is-dependency-injection/140655#140655</a>
