package entidade.profissional;

public class FachadaParaRepositorio {
	private static FachadaParaRepositorio instancia;
	private static int entidade_Id_;

	private CadastroDeProfissionais cadastro;

	private FachadaParaRepositorio(int entidade_Id) {

		initCadastros(entidade_Id);
	}

	private void initCadastros(int entidade_Id) {

		RepositorioDeProfissionais repositorio = new RepositorioArrayListDeProfissonais(
				entidade_Id);
		cadastro = new CadastroDeProfissionais(repositorio);
	}

	public static synchronized FachadaParaRepositorio obterInstancia(
			int entidade_Id) {

		if (instancia == null || entidade_Id != entidade_Id_) {
			instancia = new FachadaParaRepositorio(entidade_Id);
			entidade_Id_ = entidade_Id;
		}
		return instancia;
	}

	public void atualizar(ProfissionalDeSaude profissional)
			throws ProfissionalInexistenteException {

		cadastro.atualizar(profissional);

	}

	public ProfissionalDeSaude procurar(String cpf)
			throws ProfissionalInexistenteException {
		return cadastro.procurar(cpf);
	}

	public void inserir(ProfissionalDeSaude novoProfissional)
			throws ProfissonalExistenteException {
		cadastro.inserir(novoProfissional);
	}

	public boolean remover(String cpf) throws ProfissionalInexistenteException {
		return cadastro.remover(cpf);
	}

	public void carregar() {
		cadastro.carregarTodos();
	}

	public ProfissionalDeSaude exibir(int indice) {
		return cadastro.exibir(indice);
	}

	public int fachadaMaxTamanho() {
		return cadastro.tamanhoLista();

	}

	public boolean fachadaListaVazia() {

		return cadastro.cadVazio();
	}

}
