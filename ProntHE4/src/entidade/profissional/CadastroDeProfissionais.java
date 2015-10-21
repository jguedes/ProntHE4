package entidade.profissional;

public class CadastroDeProfissionais {

	private RepositorioDeProfissionais repositorioDeProfissionais;

	public CadastroDeProfissionais(RepositorioDeProfissionais repositorio) {
		if (repositorio == null) {
			throw new IllegalArgumentException(
					"Argumento lista profissionai nula");
		}
		this.repositorioDeProfissionais = repositorio;
	}

	public void atualizar(ProfissionalDeSaude profissional)
			throws ProfissionalInexistenteException {
		repositorioDeProfissionais.atualizar(profissional);
	}

	public void inserir(ProfissionalDeSaude novoProfissional)
			throws ProfissonalExistenteException {
		String cpf = novoProfissional.getCpf();
		if (!repositorioDeProfissionais.existe(cpf)) {
			repositorioDeProfissionais.inserir(novoProfissional);
		} else {
			throw new ProfissonalExistenteException(novoProfissional.getCpf());
		}
	}

	public boolean remover(String cpf) throws ProfissionalInexistenteException {
		return repositorioDeProfissionais.remover(cpf);
	}

	public ProfissionalDeSaude procurar(String cpf)
			throws ProfissionalInexistenteException {
		return repositorioDeProfissionais.procurar(cpf);
	}

	public void carregarTodos() {
		repositorioDeProfissionais.carregarTodos();
	}

	public ProfissionalDeSaude exibir(int indice) {
		ProfissionalDeSaude resp = null;
		resp = repositorioDeProfissionais.exibir(indice);
		return resp;
	}

	public int tamanhoLista() {
		int i = repositorioDeProfissionais.maxTamanho();
		return i;
	}

	public boolean cadVazio() {

		boolean bvalor = true;

		bvalor = repositorioDeProfissionais.listaVazia();

		return bvalor;

	}

}