# ACID

__Transação:__ uma unidade de trabalho executada dentro de um sistema de gerenciamento de banco dados. (1 ou muitas queries)

- __A__: Atomicity
	* Transação completa deve ser finalizada ou o banco de dados retorna ao estado anterior.
- __C__: Consistency
	* Garante que os dados estão no estado correto.
	* Restrições dos dados devem ser seguidas.
- __I__: Isolation
	* Execução segura e sequencial de transações
	* Impede que dois usuários executem uma transação ao mesmo tempo, comprometendo a integridade de um dado
- __D__: Durability
	* Transações efetuadas devem persitir na memória