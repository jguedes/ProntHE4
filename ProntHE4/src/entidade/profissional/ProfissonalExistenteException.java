package entidade.profissional;

public class ProfissonalExistenteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cpf;

	public ProfissonalExistenteException(String cpf) {
		super("Profissonal " + cpf + " ja cadastrado");
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}
}
