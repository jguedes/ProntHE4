package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	{

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Conexao() {

	}

	public Connection abrir() {
		Connection conn = null;
		try {
			conn = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/clin_bd?user=root&password=123456&createDatabaseIfNotExist=true");

			conn.createStatement().execute(criarTabMedico());
			conn.createStatement().execute(criarTabEnfermeiro());
			conn.createStatement().execute(criarTabAtendente());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	private String criarTabMedico() {
		return "CREATE TABLE IF NOT EXISTS medico" + "("
				+ "id int AUTO_INCREMENT NOT NULL PRIMARY KEY,"
				+ "nome VARCHAR(255)," + "crm VARCHAR(10),"
				+ "cpf VARCHAR(11)," + "endereco VARCHAR(255)," + "status int,"
				+ "dataDeNascimento VARCHAR(10)," + "telefone VARCHAR(13),"
				+ "senha VARCHAR(8)" + ")";
	}

	private String criarTabEnfermeiro() {
		return "CREATE TABLE IF NOT EXISTS enfermeiro" + "("
				+ "id int AUTO_INCREMENT NOT NULL PRIMARY KEY,"
				+ "nome VARCHAR(255)," + "coren VARCHAR(10),"
				+ "cpf VARCHAR(11)," + "endereco VARCHAR(255)," + "status int,"
				+ "dataDeNascimento VARCHAR(10)," + "telefone VARCHAR(13),"
				+ "senha VARCHAR(8)" + ")";
	}

	private String criarTabAtendente() {
		return "CREATE TABLE IF NOT EXISTS atendente" + "("
				+ "id int AUTO_INCREMENT NOT NULL PRIMARY KEY,"
				+ "nome VARCHAR(255)," + "ctps VARCHAR(5),"
				+ "cpf VARCHAR(11)," + "endereco VARCHAR(255)," + "status int,"
				+ "dataDeNascimento VARCHAR(10)," + "telefone VARCHAR(13),"
				+ "senha VARCHAR(8)" + ")";
	}

}
