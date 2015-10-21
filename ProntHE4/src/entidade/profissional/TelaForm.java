package entidade.profissional;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public abstract class TelaForm extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblNome, lblCpf, lblEndereco, lblTelefone,
			lblCountRegistros, lblRegistroAtual;
	private JTextField txtNome, txtCpf, txtEndereco, txtTelefone;

	private JButton btNovo = null, btAlterar = null, btExcluir = null,
			btFirst = null, btPrior = null, btNext = null, btLast = null,
			btGravar = null;

	private FachadaParaRepositorio fachada;

	private int icontrole = 0;
	private ProfissionalDeSaude objProfissional;

	public TelaForm(int entidade_Id) {
		super(titulo(entidade_Id), true, // resizable
				true, // closable
				true, // maximizable
				true);// iconifiable

		fachada = FachadaParaRepositorio.obterInstancia(entidade_Id);

		iniciarTela();
		definirEventos();
		showDados(0);
	}

	private static String titulo(int entidade_Id) {
		switch (entidade_Id) {
		case 1:
			return "Cadastro de Atendente";
		case 2:
			return "Cadastro de Enfermeiro";
		case 3:
			return "Cadastro de Médico";
		default:
			return null;
		}
	}

	private void iniciarTela() {

		setSize(600, 400);
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setSize(300, 400);

		lblNome = new JLabel("Nome: ");
		lblCpf = new JLabel("CPF: ");
		lblEndereco = new JLabel("Endereco: ");
		lblTelefone = new JLabel("Telefone: ");
		lblCountRegistros = new JLabel("Nº de registros: "
				+ String.valueOf(fachada.fachadaMaxTamanho()));
		lblRegistroAtual = new JLabel("Registro " + (icontrole + 1));

		txtNome = new JTextField();
		txtCpf = new JTextField();
		txtEndereco = new JTextField();
		txtTelefone = new JTextField();

		btFirst = new JButton("<<");
		btLast = new JButton(">>");
		btPrior = new JButton("<");
		btNext = new JButton(">");

		btNovo = new JButton("Novo");
		btAlterar = new JButton("Editar");
		btExcluir = new JButton("Excluir");
		btGravar = new JButton("Gravar");

		lblNome.setBounds(10, 20, 80, 20);
		lblCpf.setBounds(10, 50, 80, 20);
		lblEndereco.setBounds(10, 80, 80, 20);
		lblTelefone.setBounds(10, 110, 80, 20);
		lblRegistroAtual.setBounds(10, 140, 160, 20);

		txtNome.setBounds(150, 20, 300, 25);
		txtCpf.setBounds(150, 50, 120, 25);
		txtEndereco.setBounds(150, 80, 400, 25);
		txtTelefone.setBounds(150, 110, 100, 25);

		btFirst.setBounds(20, 300, 50, 25);
		btPrior.setBounds(80, 300, 50, 25);
		btNext.setBounds(140, 300, 50, 25);
		btLast.setBounds(200, 300, 50, 25);

		btNovo.setBounds(450, 150, 100, 25);
		btAlterar.setBounds(450, 200, 100, 25);
		btExcluir.setBounds(450, 250, 100, 25);
		btGravar.setBounds(450, 300, 100, 25);
		lblCountRegistros.setBounds(450, 325, 100, 25);

		add(lblNome);
		add(lblCpf);
		add(lblEndereco);
		add(lblTelefone);
		add(lblCountRegistros);
		add(lblRegistroAtual);

		add(txtNome);
		add(txtCpf);
		add(txtEndereco);
		add(txtTelefone);

		add(btFirst);
		add(btPrior);
		add(btNext);
		add(btLast);
		add(btNovo);
		add(btAlterar);
		add(btExcluir);
		add(btGravar);

		Container container = getContentPane();
		container.add(panel);
	}

	private void definirEventos() {

		btFirst.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				icontrole = 0;
				if (icontrole <= fachada.fachadaMaxTamanho()) {
					objProfissional = fachada.exibir(icontrole);
					atualizarTela();
				}
			}
		});

		btNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				icontrole = icontrole + 1;

				if ((icontrole >= 0)
						&& (icontrole < fachada.fachadaMaxTamanho())) {

					objProfissional = fachada.exibir(icontrole);
					atualizarTela();

				}
			}
		});

		btLast.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				icontrole = fachada.fachadaMaxTamanho() - 1;
				objProfissional = fachada.exibir(icontrole);
				atualizarTela();
			}
		});

		btPrior.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				icontrole = icontrole - 1;

				if ((icontrole >= 0)
						&& (icontrole < fachada.fachadaMaxTamanho())) {

					objProfissional = fachada.exibir(icontrole);
					atualizarTela();
				}
			}
		});

		btNovo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				limparCampos();
			}
		});

		btGravar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				ProfissionalDeSaude c = new ProfissionalDeSaude();
				c.setCpf(txtCpf.getText());
				c.setNome(txtNome.getText());
				c.setEndereco(txtEndereco.getText());
				c.setTelefone(txtTelefone.getText());
				try {

					fachada.inserir(c);

				} catch (ProfissonalExistenteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		btExcluir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				try {

					if (fachada.remover(txtCpf.getText()))
						showDados(0);

				} catch (ProfissionalInexistenteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

	}

	public void showDados(int indexArray) {

		limparCampos();
		objProfissional = fachada.exibir(indexArray);
		if (!(objProfissional == null)) {
			txtNome.setText(objProfissional.getNome());
			txtCpf.setText(objProfissional.getCpf());
			txtEndereco.setText(objProfissional.getEndereco());
			txtTelefone.setText(objProfissional.getTelefone());
		}
	}

	public void atualizarTela() {

		limparCampos();
		txtNome.setText(objProfissional.getNome());
		txtCpf.setText(objProfissional.getCpf());
		txtEndereco.setText(objProfissional.getEndereco());
		txtTelefone.setText(objProfissional.getTelefone());
		lblRegistroAtual.setText("Registro " + String.valueOf(icontrole + 1));
	}

	public void limparCampos() {
		txtNome.setText("");
		txtCpf.setText("");
		txtEndereco.setText("");
		txtTelefone.setText("");
	}

	public void controleBotoes(int iModo) {

		if (iModo == 1) {
			btNovo.setVisible(false);
			btAlterar.setVisible(false);
			btExcluir.setVisible(false);
			btGravar.setVisible(true);
		} else {
			btNovo.setVisible(true);
			btAlterar.setVisible(true);
			btExcluir.setVisible(true);
			btGravar.setVisible(false);
		}

	}

}
