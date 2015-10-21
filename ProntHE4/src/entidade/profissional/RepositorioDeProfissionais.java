package entidade.profissional;

public interface RepositorioDeProfissionais {

	public abstract boolean existe(String cpf);

	public abstract void inserir(ProfissionalDeSaude novoProfissional);

	public abstract void atualizar(ProfissionalDeSaude profissional)
			throws ProfissionalInexistenteException;

	public abstract ProfissionalDeSaude procurar(String cpf)
			throws ProfissionalInexistenteException;;

	public abstract boolean remover(String cpf)
			throws ProfissionalInexistenteException;

	public abstract void carregarTodos();

	public abstract ProfissionalDeSaude exibir(int indice);

	public abstract int maxTamanho();

	public abstract boolean listaVazia();

}