USE pratica3_db;
-- 1. Listar os dados dos autores.
SELECT * FROM autores;

-- 2. Listar nome e idade dos alunos
SELECT nome, idade from alunos;

-- 3. Quais alunos pertencem à carreira de informática?
SELECT COUNT(*) AS alunos_informatica FROM alunos
	GROUP BY carreira
    HAVING carreira = 'informática';

-- 4. Quais autores são de nacionalidade francesa ou italiana?
SELECT * FROM autores WHERE nacionalidade = 'francesa' OR nacionalidade = 'italiana';

-- 5. Que livros não são da área da internet?
SELECT * FROM livros WHERE area != 'internet';

-- 6. Listar os livros da editora Salamandra.
SELECT * FROM livros WHERE editora = 'Salamandra';

-- 7. Listar os dados dos alunos cuja idade é maior que a média.
SELECT nome, idade FROM alunos
	WHERE idade > (SELECT AVG(idade) FROM alunos GROUP BY idade LIMIT 1);

-- 8. Listar os nomes dos alunos cujo sobrenome começa com a letra G.
SELECT nome FROM alunos WHERE sobrenome LIKE 'G%';

-- 9. Listar os autores do livro "O Universo: Guia de Viagem". (Apenas nomes devem ser listados.)
SELECT autores.nome FROM autores
	INNER JOIN livro_autor ON autores.id = livro_autor.autor_id
    INNER JOIN livros ON livro_autor.livro_id = livros.id
    WHERE livros.titulo = 'O Universo: Guia de Viagem';

-- 10. Listar autores que tenham nacionalidade italiana ou argentina.
SELECT * FROM autores WHERE nacionalidade = 'italiana' OR nacionalidade = 'argentina';

-- 11. Que livros foram emprestados ao leitor “Filippo Galli”?
SELECT livros.titulo FROM livros
	INNER JOIN emprestimos ON livros.id = emprestimos.livro_id
    INNER JOIN alunos ON emprestimos.aluno_id = alunos.id
    WHERE alunos.nome = 'Filippo' AND alunos.sobrenome = 'Galli';

-- 12. Listar o nome do aluno mais novo.
SELECT nome FROM alunos ORDER BY idade LIMIT 1;

-- 13. Listar os nomes dos alunos a quem os livros de Banco de Dados foram emprestados.
SELECT nome FROM alunos 
	INNER JOIN emprestimos ON alunos.id = emprestimos.aluno_id
    INNER JOIN livros ON emprestimos.livro_id = livros.id
    WHERE area = 'Banco de Dados';

-- 14. Listar os livros que pertencem ao autor J.K. Rowling.
SELECT titulo FROM livros 
	INNER JOIN livro_autor ON livros.id = livro_autor.livro_id
	INNER JOIN autores ON livro_autor.id = autores.id
	WHERE autores.nome = 'J.K. Rowling';

-- 15. Listar os títulos dos livros que deveriam ser devolvidos até 16/07/2021.
SELECT titulo FROM livros 
	INNER JOIN emprestimos ON livros.id = emprestimos.livro_id
	WHERE emprestimos.data_devolucao < '2021-07-16';