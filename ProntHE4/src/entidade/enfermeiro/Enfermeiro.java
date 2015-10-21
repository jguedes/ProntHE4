package entidade.enfermeiro;

import entidade.profissional.ProfissionalDeSaude;

public class Enfermeiro extends ProfissionalDeSaude {
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Enfermeiro [id=");
		builder.append(id);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", endereco=");
		builder.append(endereco);
		builder.append(", telefone=");
		builder.append(telefone);
		builder.append(", cpf=");
		builder.append(cpf);
		builder.append(", coren=");
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

}
