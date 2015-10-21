package entidade.profissional;


public interface IDaoProfissionalDeSaude {

	public boolean inserir(ProfissionalDeSaude profissional);

	public boolean remover(ProfissionalDeSaude profissional);

	public boolean atualizar(ProfissionalDeSaude profissional);

	public ProfissionalDeSaude buscar(String nome, String cpf);

	public ProfissionalDeSaude buscar(String nome, String cpf, String numero);
}
