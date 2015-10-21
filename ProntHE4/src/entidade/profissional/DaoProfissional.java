package entidade.profissional;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.Dao;

public abstract class DaoProfissional extends Dao implements
		IDaoProfissionalDeSaude {
	private String entidade, orgRegulamentador;

	public DaoProfissional(int entidade_Id) {
		super();
		// TODO Auto-generated constructor stub

		nomeDaEntidade(entidade_Id);
	}

	@Override
	public boolean inserir(ProfissionalDeSaude profissional) {
		boolean resposta = false;
		try {
			abrirConexao();
			PreparedStatement p = con.prepareStatement(sqlInsert());
			p.setString(1, profissional.getNome());
			p.setString(2, profissional.getNumRegOrgRegulador());
			p.setString(3, profissional.getCpf());
			p.setString(4, profissional.getEndereco());
			p.setBoolean(5, profissional.isStatus());
			p.setString(6, profissional.getDataDeNascimento());
			p.setString(7, profissional.getTelefone());
			p.setString(8, profissional.getSenha());
			if (p.executeUpdate() != 0) {
				resposta = true;
				mensagemSucessoInsercao(profissional.getNome());
			} else {
				mensagemFalhaInsercao(profissional.getNome());
			}
			p.close();
			fecharConexao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return resposta;
	}

	@Override
	public boolean remover(ProfissionalDeSaude profissional) {
		boolean resposta = false;
		if (!mensagemContinuarRemocao(profissional.getNome()))
			return resposta;
		try {
			abrirConexao();
			PreparedStatement p = con.prepareStatement(sqlDelete());
			p.setLong(1, profissional.getId());
			if (p.executeUpdate() != 0) {
				resposta = true;
				mensagemSucessoRemocao(profissional.getNome());
			} else {
				mensagemFalhaRemocao(profissional.getNome());
			}
			p.close();
			fecharConexao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return resposta;
	}

	@Override
	public boolean atualizar(ProfissionalDeSaude profissional) {
		boolean resposta = false;
		try {
			abrirConexao();
			PreparedStatement p = con.prepareStatement(sqlUpdate());
			p.setString(1, profissional.getNome());
			p.setString(2, profissional.getNumRegOrgRegulador());
			p.setString(3, profissional.getCpf());
			p.setString(4, profissional.getEndereco());
			p.setBoolean(5, profissional.isStatus());
			p.setString(6, profissional.getDataDeNascimento());
			p.setString(7, profissional.getTelefone());
			p.setString(8, profissional.getSenha());
			p.setLong(9, profissional.getId());// cláusula WHERE
			if (p.executeUpdate() != 0) {
				resposta = true;
				mensagemSucessoAtualizacao(profissional.getNome());
			} else {
				mensagemFalhaAtualizacao(profissional.getNome());
			}
			p.close();
			fecharConexao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return resposta;
	}

	@Override
	public ProfissionalDeSaude buscar(String nome, String cpf) {
		// TODO Auto-generated method stub
		ProfissionalDeSaude a = new ProfissionalDeSaude();
		try {
			abrirConexao();
			PreparedStatement p = con
					.prepareStatement(sqlSelectWhere_Nome_Cpf());
			p.setString(1, nome);
			p.setString(2, cpf);
			a = getProfissional(p.executeQuery());
			p.close();
			fecharConexao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public ProfissionalDeSaude buscar(String nome, String cpf,
			String numeroOrgRegulamentdor) {
		// TODO Auto-generated method stub
		ProfissionalDeSaude a = new ProfissionalDeSaude();
		try {
			abrirConexao();
			PreparedStatement p = con
					.prepareStatement(sqlSelectWhere_Nome_Cpf_OrgReg());
			p.setString(1, nome);
			p.setString(2, numeroOrgRegulamentdor);
			p.setString(3, cpf);
			a = getProfissional(p.executeQuery());
			p.close();
			fecharConexao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	public ProfissionalDeSaude buscar(Long id) {
		// TODO Auto-generated method stub
		ProfissionalDeSaude a = new ProfissionalDeSaude();
		try {
			abrirConexao();
			PreparedStatement p = con.prepareStatement(sqlSelectWhere_Id());
			p.setLong(1, id);
			a = getProfissional(p.executeQuery());
			p.close();
			fecharConexao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	public ProfissionalDeSaude buscar(String cpf) {
		// TODO Auto-generated method stub
		ProfissionalDeSaude a = new ProfissionalDeSaude();
		try {
			abrirConexao();
			PreparedStatement p = con.prepareStatement(sqlSelectWhere_Cpf());
			p.setString(1, cpf);
			a = getProfissional(p.executeQuery());
			p.close();
			fecharConexao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	private ProfissionalDeSaude getProfissional(ResultSet result) {
		ProfissionalDeSaude a = new ProfissionalDeSaude();
		try {
			while (result.next()) {
				a.setNome(result.getString("nome"));
				a.setNumRegOrgRegulador(result.getString(orgRegulamentador));
				a.setCpf(result.getString("cpf"));
				a.setDataDeNascimento(result.getString("dataDeNascimento"));
				a.setEndereco(result.getString("endereco"));
				a.setTelefone(result.getString("telefone"));
				a.setStatus(result.getBoolean("status"));
				a.setId(result.getLong("id"));
				a.setSenha(result.getString("senha"));
			}
			result.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	public ArrayList<ProfissionalDeSaude> buscarTodos() {
		// TODO Auto-generated method stub
		ArrayList<ProfissionalDeSaude> a = new ArrayList<>();
		try {
			abrirConexao();
			PreparedStatement p = con.prepareStatement(sqlSelectTodos());
			a = getTodos(p.executeQuery());
			p.close();
			fecharConexao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return a;
	}

	private ArrayList<ProfissionalDeSaude> getTodos(ResultSet result) {
		ArrayList<ProfissionalDeSaude> lista = new ArrayList<>();
		ProfissionalDeSaude a;
		try {
			while (result.next()) {
				a = new ProfissionalDeSaude();
				a.setNome(result.getString("nome"));
				a.setNumRegOrgRegulador(result.getString(orgRegulamentador));
				a.setCpf(result.getString("cpf"));
				a.setDataDeNascimento(result.getString("dataDeNascimento"));
				a.setEndereco(result.getString("endereco"));
				a.setTelefone(result.getString("telefone"));
				a.setStatus(result.getBoolean("status"));
				a.setId(result.getLong("id"));
				a.setSenha(result.getString("senha"));
				lista.add(a);
			}
			result.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

	private void nomeDaEntidade(int entidade_Id) {
		switch (entidade_Id) {
		case 1:
			entidade = "atendente";
			orgRegulamentador = "ctps";
			break;
		case 2:
			entidade = "enfermeiro";
			orgRegulamentador = "coren";
			break;
		case 3:
			entidade = "medico";
			orgRegulamentador = "crm";
			break;
		default:
			break;
		}
	}

	private String sqlInsert() {
		return "INSERT INTO "
				+ entidade
				+ " (nome,"
				+ orgRegulamentador
				+ ",cpf,endereco,status,dataDeNascimento,telefone,senha) values (?,?,?,?,?,?,?,?)";
	}

	private String sqlDelete() {
		return "delete from " + entidade + " where id = ?";
	}

	private String sqlUpdate() {
		return "UPDATE "
				+ entidade
				+ " SET nome = ?,"
				+ orgRegulamentador
				+ " = ?,cpf = ?,endereco = ?,status = ?,dataDeNascimento = ?,telefone = ?,senha = ?) WHERE id = ?";
	}

	private String sqlSelectTodos() {
		return "SELECT * FROM " + entidade;
	}

	private String sqlSelectWhere_Id() {
		return "SELECT * FROM " + entidade + " WHERE id = ?";
	}

	private String sqlSelectWhere_Cpf() {
		return "SELECT * FROM " + entidade + " WHERE cpf = ?";
	}

	private String sqlSelectWhere_Nome_Cpf() {
		return "SELECT * FROM " + entidade + " WHERE nome = ?, cpf = ?";
	}

	private String sqlSelectWhere_Nome_Cpf_OrgReg() {
		return "SELECT * FROM " + entidade + " WHERE nome = ?,"
				+ orgRegulamentador + " = ?, cpf = ?";
	}

	private void mensagemSucessoInsercao(String nomeDoProfissonal) {
		JOptionPane.showConfirmDialog(null, "Cadastro dos dados de "
				+ nomeDoProfissonal.toUpperCase() + " realizado com sucesso!",
				null, JOptionPane.DEFAULT_OPTION);
	}

	private void mensagemFalhaInsercao(String nomeDoProfissonal) {
		JOptionPane.showConfirmDialog(null,
				"Desculpe!\n\nFalha ao tentar realizar o cadastro dos dados de "
						+ nomeDoProfissonal.toUpperCase() + "!", null,
				JOptionPane.DEFAULT_OPTION);
	}

	private void mensagemSucessoAtualizacao(String nomeDoProfissonal) {
		JOptionPane.showConfirmDialog(null, "Atualização dos dados de "
				+ nomeDoProfissonal.toUpperCase() + " realizado com sucesso!",
				null, JOptionPane.DEFAULT_OPTION);
	}

	private void mensagemFalhaAtualizacao(String nomeDoProfissonal) {
		JOptionPane.showConfirmDialog(null,
				"Desculpe!\n\nFalha ao tentar realizar a atualização dos dados de "
						+ nomeDoProfissonal.toUpperCase() + "!", null,
				JOptionPane.DEFAULT_OPTION);
	}

	private void mensagemSucessoRemocao(String nomeDoProfissonal) {
		JOptionPane.showConfirmDialog(null, "Exclusão dos dados de "
				+ nomeDoProfissonal.toUpperCase() + " realizado com sucesso!",
				null, JOptionPane.DEFAULT_OPTION);
	}

	private void mensagemFalhaRemocao(String nomeDoProfissonal) {
		JOptionPane.showConfirmDialog(null,
				"Desculpe!\n\nFalha ao tentar realizar a exclusão dos dados de "
						+ nomeDoProfissonal.toUpperCase() + "!", null,
				JOptionPane.DEFAULT_OPTION);
	}

	private boolean mensagemContinuarRemocao(String nomeDoProfissonal) {
		if (JOptionPane
				.showConfirmDialog(
						null,
						"Tem certeza!\n\nEstá certo que deseja realizar a exclusão dos dados de "
								+ nomeDoProfissonal.toUpperCase()
								+ "!\n\nEsta operação não poderá ser desfeita!\n\nClique em Ok para continuar com a exclusão.",
						null, JOptionPane.CANCEL_OPTION) == JOptionPane.CANCEL_OPTION) {
			return false;
		}
		return true;
	}
}
