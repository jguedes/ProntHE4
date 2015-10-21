package dao;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class Dao {
	protected Connection con = null;

	protected void abrirConexao() {
		// TODO Auto-generated method stub
		con = new Conexao().abrir();
	}

	protected void fecharConexao() {
		// TODO Auto-generated method stub
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
