package entidade.medico;

import entidade.profissional.DaoProfissional;
import entidade.profissional.Entidade_Id;

public class DaoMedico extends DaoProfissional {

	public DaoMedico() {
		super(Entidade_Id.medico);
	}
}
