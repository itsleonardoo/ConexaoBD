
# ConexãoBD
[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](https://choosealicense.com/licenses/mit/)

## 📄 Descrição

**ConexãoBD** é uma biblioteca simples criada para facilitar conexões SQL utilizando **JDBC**. Ela fornece métodos para **listar**, **inserir**, **atualizar** e **excluir** registros. O projeto também faz uso de **tratamento de exceções**, **prepared statements** e **result set**.

## 📦 Instalação

1. Configure o driver JDBC apropriado para o seu banco de dados. Para MySQL, utilize o MySQL Connector/J disponibilizado abaixo. Adicione-o ao seu Build Path (ClassPath).

        https://dev.mysql.com/downloads/connector/j/

2. Alternativamente, você pode utilizar o Maven para instalá-lo. Adicione-o como dependência no pom.xml.

        https://mvnrepository.com/artifact/com.mysql/mysql-connector-j

3. Após isso, baixe o ConexãoBD disponibilizado e adicione-o ao seu Build Path (ClassPath)





## 🛠 Uso/Exemplos

###  1. Criar uma conexão com o Banco de Dados
#### Para isso, utilize a função `criarConexao()` para inicializar a conexão com o banco de dados.

      ConexaoDB conexao = new ConexaoDB("hostName", "hostPort", "userName", "senha", "dataBaseName");

      conexao.criarConexao();

Exemplos de informações:

`hostName = localhost`

`hostPort = 3306`

`userName = root`

`senha = 00000`

`dataBaseName = exemplo`
 
As informações acima são apenas exemplos do que passar em cada um dos parâmetros definidos, **em ordem.**

###  2. Fechar uma conexão com o Banco de Dados
#### Para isso, utilize a função `fecharConexao()` para encerrar a conexão com o banco de dados.

    conexao.fecharConexao();

Conexão no caso sendo o nome que você atribuiu na hora da criação. Neste exemplo, é conexao.

###  3. Inserir dados no Banco de Dados
#### Para isso, utilize a função `inserirDados()` para registrar dados.

		String[] dados = {"7500", "Paulo"};
		conexao.inserirDados("INSERT INTO equipe (salario, nome) VALUES (?, ?);", dados); 
	
Vamos entender. Para os dados, é necessário criar um Array de Strings. 
Após isso, passar as informações lá dentro de acordo com a ordem dos "?" na query.

Por exemplo, salário no MySQL está como um inteiro, portanto, passei 7500, contudo, sempre dentro de uma String.
Se no MySQL fosse um Double, apenas passaria "7500.0". Simples assim!

É possível ter quantos valores você quiser, apenas lembre-se de passar a mesma quantidade de informações!
Por exemplo, se tiverem 5 campos a serem preenchidos, devem ter 5 "?" na query, e deverá passar 5 dados na String[].

 Contudo, se você deseja passar apenas um dado, ainda é necessário criar o Array de Strings.

###  4. Excluir dados do Banco de Dados
#### Para isso, utilize a função `excluirDados()` para deletar registros.

		String[] dados = {"9"};
		conexao.excluirDados("DELETE FROM equipe WHERE id = ?", dados); 

Apenas isso! Do mesmo jeito que o anterior!

###  5. Atualizar dados do Banco de Dados
#### Para isso, utilize a função `atualizarDados()` para atualizar registros.

		String[] dados = {"Arthur", "2"};
		conexao.atualizarDados("UPDATE equipe SET nome = ? WHERE id = ?;", dados);

###  6. Listar dados do Banco de Dados
#### Para isso, utilize a função `listarDados()` para listar dados.

    ResultSet rs = conexao.listarDados("SELECT * FROM equipe");
        while(rs.next()) {
          System.out.println("Nome: " + rs.getString("nome"));
          System.out.println("ID: " + rs.getInt("id"));
          System.out.println("Salário: " + rs.getInt("salario"));
        }
  
Vamos entender. Para exibir os dados é necessário atribuir um ResultSet ao método listarDados(). Esse ResultSet armazenará as informações que pedimos na query, neste caso, `SELECT * FROM equipe`. 

Porém, para exibir as informações, temos que iterar pelas linhas, o que é feito usando while e o método do ResultSet, chamado next, que verifica se existe uma próxima linha.

Por último, utilizamos os métodos do ResultSet chamados getString e getInt para pegar as informações da coluna descrita, como "nome" e "salario". Existem diversos outros para diversos tipos de dados, como getDouble, etc.

###  7. Extras
#### Nesta biblioteca, por padrão, já vem o prefixo e drivers do MySQL, porém, existem métodos para mudar isso, caso você esteja usando outro SGBD, como PostgreSQL, que será utilizado neste exemplo. Os métodos em questão são: `alterarDriver()` e `alterarPrefixo()`.

		conexao.alterarDriver("org.postgresql.Driver");
		conexao.alterarPrefixo("jdbc:postgresql://");

#### Se não estiver utilizando MySQL, é necessário usar esses comandos com o Driver e Prefixo do seu SGBD **após** instanciar o seu ConexaoDB, mas **antes** de usar o método `criarConexao()`. Também é necessário instalar a dependência correta para o seu SGBD, o que é descrito acima na parte de Instalação.

### 7.1 Extra 2
#### Nesta biblioteca, os métodos `excluirDados()`, `inserirDados()` e `atualizarDados()` possuem retorno, sendo este o número de linhas afetadas. Então é possível atribuir uma variável a estes métodos que guardará o valor das linhas afetadas pela ação do método.








  
  

## 🤝 Contribuições

Contribuições são sempre bem-vindas! Sinta-se á vontade para **reportar** problemas ou abrir **pull requests**!


## 📄 Licença

Este projeto está licenciado sobre a licença [MIT](https://choosealicense.com/licenses/mit/).

