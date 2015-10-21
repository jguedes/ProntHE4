package entidade.enfermeiro;

import entidade.profissional.DaoProfissional;
import entidade.profissional.Entidade_Id;
import entidade.profissional.IDaoProfissionalDeSaude;

public class DaoEnfermeiro extends DaoProfissional implements
		IDaoProfissionalDeSaude {
	
	public DaoEnfermeiro() {
		super(Entidade_Id.enfermeiro);
	}
}
