package utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class TelaDeEntrada {
	private boolean logou;
	private Login jfm;

	public boolean boasVindas() {
		if (continuar())
			login();
		return logou;
	}

	private boolean continuar() {
		if (JOptionPane.showConfirmDialog(null, "Bem vindo!\n"
				+ "Este é o ProntHE - Prontuário Hospitalar Eletrônico\n"
				+ "Clique em Ok para continuar.", null,
				JOptionPane.CANCEL_OPTION) == JOptionPane.CANCEL_OPTION)
			return false;
		return true;
	}

	private void logar() {
		if (oNomeESenhaForamDigitados()) {
			if (averguarNome() && averiguarSenha()) {
				JOptionPane.showConfirmDialog(null, "Bem vindo! Master.", null,
						JOptionPane.DEFAULT_OPTION);
				jfm.setVisible(false);
				new TelaPrincipal();
			} else {
				JOptionPane.showConfirmDialog(null, "Nome ou senha inválidos",
						null, JOptionPane.DEFAULT_OPTION);
				jfm.setNome("");
				jfm.setSenha("");
			}
		}
	}

	private boolean oNomeESenhaForamDigitados() {
		if (jfm.getNome().isEmpty()) {
			JOptionPane
					.showConfirmDialog(
							null,
							"ERRO!\nO nome não foi digitado\nPor favor digite um nome!",
							null, JOptionPane.DEFAULT_OPTION);
			return false;
		} else if (jfm.getSenha().isEmpty()) {
			JOptionPane
					.showConfirmDialog(
							null,
							"ERRO!\nA senha não foi digitada\nPor favor digite uma senha!",
							null, JOptionPane.DEFAULT_OPTION);
			return false;
		}
		return true;
	}

	private void login() {
		jfm = new Login();
		jfm.getBtnOk().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logar();
			}
		});
		jfm.getBtnCancel().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fecharPrograma();
				jfm.setVisible(false);
				logou = false;
			}
		});
	}

	private void fecharPrograma() {
		JOptionPane.showConfirmDialog(null, "Fechando o programa", null,
				JOptionPane.DEFAULT_OPTION);
	}

	private boolean averguarNome() {
		return jfm.getNome().toLowerCase().equals("master");
	}

	private boolean averiguarSenha() {
		return jfm.getSenha().equals("123456");
	}
}
