package entidade.profissional;

import java.util.ArrayList;

import entidade.atendente.DaoAtendente;
import entidade.enfermeiro.DaoEnfermeiro;
import entidade.medico.DaoMedico;

public class RepositorioArrayListDeProfissonais implements
		RepositorioDeProfissionais {

	private ArrayList<ProfissionalDeSaude> arrayListDeProfissionais;
	private int entidade_Id;

	public RepositorioArrayListDeProfissonais(int entidade_Id) {
		arrayListDeProfissionais = new ArrayList<>();
		this.entidade_Id = entidade_Id;
		carregarTodos();
	}

	private int procurarIndice(String cpf) {

		int i = -1;

		for (ProfissionalDeSaude c : arrayListDeProfissionais) {
			if (c.getCpf().equals(cpf)) {
				i = arrayListDeProfissionais.indexOf(c);
			}
		}

		return i;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see RepositorioClientes#existe(java.lang.String)
	 */
	public boolean existe(String cpf) {
		boolean resp = false;

		resp = arrayListDeProfissionais.contains(cpf);
		if (resp) {
			return resp;
		}

		for (ProfissionalDeSaude c : arrayListDeProfissionais) {
			if (c.getCpf().equals(cpf)) {
				resp = true;
			}
		}

		return resp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see RepositorioClientes#inserir(Cliente)
	 */
	public void inserir(ProfissionalDeSaude novoProfissional) {
		if (getDao().inserir(novoProfissional)) {
			arrayListDeProfissionais.add(getDao().buscar(
					novoProfissional.getCpf()));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see RepositorioClientes#atualizar(Cliente)
	 */
	public void atualizar(ProfissionalDeSaude profissional)
			throws ProfissionalInexistenteException {

		int i = procurarIndice(profissional.getCpf());

		if (i != -1) {
			if (getDao().atualizar(profissional)) {
				arrayListDeProfissionais.set(i, profissional);
			}
		} else {
			throw new ProfissionalInexistenteException(profissional.getCpf());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see RepositorioClientes#procurar(java.lang.String)
	 */
	public ProfissionalDeSaude procurar(String cpf)
			throws ProfissionalInexistenteException {

		ProfissionalDeSaude resp = null;

		int i = this.procurarIndice(cpf);
		if (i != -1) {
			resp = arrayListDeProfissionais.get(i);
		} else {
			throw new ProfissionalInexistenteException(cpf);
		}

		return resp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see RepositorioClientes#remover(java.lang.String)
	 */
	public boolean remover(String cpf) throws ProfissionalInexistenteException {
		boolean resposta = false;
		int i = this.procurarIndice(cpf);

		if (i != -1) {
			if (getDao().remover(arrayListDeProfissionais.get(i))) {
				arrayListDeProfissionais.remove(i);
				resposta = true;
			}
		} else {
			throw new ProfissionalInexistenteException(cpf);
		}
		return resposta;
	}

	@Override
	public void carregarTodos() {
		arrayListDeProfissionais = getDao().buscarTodos();
	}

	@Override
	public ProfissionalDeSaude exibir(int indice) {
		// TODO Auto-generated method stub
		// int i = 1;

		ProfissionalDeSaude resp = null;
		if (listaVazia())
			resp = null;
		else
			resp = arrayListDeProfissionais.get(indice);
		return resp;
	}

	@Override
	public int maxTamanho() {
		// TODO Auto-generated method stub

		int i = arrayListDeProfissionais.size();

		return i;
	}

	@Override
	public boolean listaVazia() {
		// TODO Auto-generated method stub

		boolean bvalor = true;

		bvalor = arrayListDeProfissionais.isEmpty();

		return bvalor;
	}

	private DaoProfissional getDao() {
		switch (entidade_Id) {
		case 1:
			return new DaoAtendente();
		case 2:
			return new DaoEnfermeiro();
		case 3:
			return new DaoMedico();
		default:
			return null;
		}
	}
}