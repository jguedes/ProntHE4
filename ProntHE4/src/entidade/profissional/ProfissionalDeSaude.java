package entidade.profissional;

//TODO Super classe das classes Médico, Enfermeiro e Atendente

public class ProfissionalDeSaude {
	protected long id;
	protected String nome;
	protected String endereco;
	protected String telefone;
	protected String cpf;
	protected String numRegOrgRegulador;
	protected boolean status;
	protected String dataDeNascimento;
	protected String senha;

	public ProfissionalDeSaude() {

	}

	public ProfissionalDeSaude(String nome, String senha) {
		this.nome = nome;
		this.senha = senha;
	}

	public ProfissionalDeSaude(String nome, String cpf, String senha) {
		this(nome, senha);
		this.cpf = cpf;
	}

	public ProfissionalDeSaude(String nome, String cpf,
			String dataDeNascimento, String senha) {
		this(nome, cpf, senha);
		this.dataDeNascimento = dataDeNascimento;
	}

	public ProfissionalDeSaude(String nome, String cpf,
			String dataDeNascimento, String endereco, String senha) {
		this(nome, cpf, dataDeNascimento, senha);
		this.endereco = endereco;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNumRegOrgRegulador() {
		return numRegOrgRegulador;
	}

	public void setNumRegOrgRegulador(String numRegOrgRegulador) {
		this.numRegOrgRegulador = numRegOrgRegulador;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProfissionalDeSaude [id=");
		builder.append(id);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", endereco=");
		builder.append(endereco);
		builder.append(", telefone=");
		builder.append(telefone);
		builder.append(", cpf=");
		builder.append(cpf);
		builder.append(", numRegOrgRegulador=");
		builder.append(numRegOrgRegulador);
		builder.append(", status=");
		builder.append(status);
		builder.append(", dataDeNascimento=");
		builder.append(dataDeNascimento);
		builder.append(", senha=");
		builder.append(senha);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime
				* result
				+ ((dataDeNascimento == null) ? 0 : dataDeNascimento.hashCode());
		result = prime * result
				+ ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime
				* result
				+ ((numRegOrgRegulador == null) ? 0 : numRegOrgRegulador
						.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + (status ? 1231 : 1237);
		result = prime * result
				+ ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProfissionalDeSaude other = (ProfissionalDeSaude) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dataDeNascimento == null) {
			if (other.dataDeNascimento != null)
				return false;
		} else if (!dataDeNascimento.equals(other.dataDeNascimento))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numRegOrgRegulador == null) {
			if (other.numRegOrgRegulador != null)
				return false;
		} else if (!numRegOrgRegulador.equals(other.numRegOrgRegulador))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (status != other.status)
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}
}
