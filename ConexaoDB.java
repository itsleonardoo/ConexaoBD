package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexaoDB {

Connection conexao = null;
String prefixoSGBD = null;
String hostName = null;
String userName = null;
String senha = null;
String jdbcDriver = null;
String dataBaseName = null;
String hostPort = null;
String url = null;
	
public ConexaoDB(String hostName, String hostPort, String userName, String senha, String dataBaseName) {

prefixoSGBD = "jdbc:mysql://";
jdbcDriver = "com.mysql.cj.jdbc.Driver";
this.hostName = hostName;
this.userName = userName;
this.senha = senha;
this.dataBaseName = dataBaseName;
this.hostPort = hostPort;

url = prefixoSGBD + hostName + ":" + hostPort + "/" + dataBaseName;
	
}

public Connection criarConexao() throws SQLException {

try {
	if (conexao == null) {
	Class.forName(jdbcDriver);
	conexao = DriverManager.getConnection(url, userName, senha);
	} else if (conexao.isClosed()) {
		conexao = null;
		return criarConexao();
	}
} catch (ClassNotFoundException e) {
	System.out.println("Driver não localizado!");
	
} catch (SQLException e) {
	System.out.println("Erro" + e.getMessage() + "ao acessar o banco de dados!");
}

return conexao;

		}

public void fecharConexao() {
	  if (conexao != null) {
	    try {
	      conexao.close();
	    } catch (SQLException e) {
	    	System.out.println("Erro" + e.getMessage() + "ao fechar o banco de dados!");
	    }
	  }
	}

public int inserirDados(String query, String[] dados) throws SQLException {
	
   PreparedStatement preparedStatement = conexao.prepareStatement(query); {
	   
	for (int i = 0; i < dados.length; i++) {
		preparedStatement.setString(i+1, dados[i]);
		}
		
	int linhasAfetadas = preparedStatement.executeUpdate();
 
   return linhasAfetadas;
            }
}
            
public int excluirDados(String query, String[] dados) throws SQLException {
	
	PreparedStatement preparedStatement = conexao.prepareStatement(query); {
		   
		for (int i = 0; i < dados.length; i++) {
			preparedStatement.setString(i+1, dados[i]);
			}
			
		int linhasAfetadas = preparedStatement.executeUpdate();
	 
	   return linhasAfetadas;      
            }
	}

public int atualizarDados(String query, String[] dados) throws SQLException {
	
	PreparedStatement preparedStatement = conexao.prepareStatement(query); {
		   
		for (int i = 0; i < dados.length; i++) {
			preparedStatement.setString(i+1, dados[i]);
			}
			
		int linhasAfetadas = preparedStatement.executeUpdate();
	 
	   return linhasAfetadas;          
	            }
		}

public ResultSet listarDados(String query) throws SQLException {
	
	ResultSet rs = conexao.createStatement().executeQuery(query);
	return rs;
	}

public void alterarDriver(String driver) {
	
jdbcDriver = driver;

}

public void alterarPrefixo(String prefixoSGBD) {

this.prefixoSGBD = prefixoSGBD;	
	
	}

}



