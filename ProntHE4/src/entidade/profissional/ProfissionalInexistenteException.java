package entidade.profissional;

public class ProfissionalInexistenteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cpf;

	public ProfissionalInexistenteException(String cpf) {
		super("Profissional" + cpf + " não cadastrado");
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}
}
