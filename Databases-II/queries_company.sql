-- 1. Selecione o nome, cargo e localização dos departamentos onde os vendedores trabalham.
SELECT employees.first_name, employees.job, departments.location FROM employees
	INNER JOIN departments ON employees.department_id = departments.id;
    
-- 2. Visualize departamentos com mais de cinco funcionários.
SELECT departments.id, departments.name, departments.location, COUNT(*) AS employees_number FROM departments
	INNER JOIN employees ON departments.id = employees.department_id
    GROUP BY departments.id
    HAVING employees_number > 5;
    
-- 3. Exiba o nome, salário e nome do departamento dos funcionários que têm o mesmo cargo que 'Mito Barchuk'.
SELECT employees.first_name, employees.salary, departments.name FROM employees 
	INNER JOIN departments ON employees.department_id = departments.id
    WHERE departments.name = (
		SELECT name FROM departments
			INNER JOIN employees ON employees.department_id = departments.id
            WHERE employees.first_name = 'Mito');

-- 4. Mostre os dados dos funcionários que trabalham no departamento de contabilidade, ordenados por nome.          
SELECT employees.id, employees.first_name, employees.last_name, employees.job, employees.salary FROM employees
	INNER JOIN departments on employees.department_id = departments.id
	WHERE departments.name = 'Contabilidade'
    ORDER BY first_name;
    
-- 5. Mostre o nome do funcionário que tem o menor salário.
SELECT first_name FROM employees
	ORDER BY salary LIMIT 1;

-- 6. Mostre os dados do funcionário que tem o maior salário no departamento 'Vendas'.
SELECT employees.id, employees.first_name, employees.last_name, employees.job, employees.salary FROM employees
	INNER JOIN departments ON employees.department_id = departments.id
	WHERE departments.name = 'Vendas'
    ORDER BY salary DESC LIMIT 1;