package utils;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Panel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblNome, lblsenha;
	private JTextField txtNome, txtsenha;
	private JButton btnOk,btnCancel;
	private GridLayout grid;
	private Panel panel;

	public Login() throws HeadlessException {
		super("ProntHE - Login");
		// TODO Auto-generated constructor stub

		lblNome = new JLabel();
		lblNome.setText("Digite o seu nome:");
		lblNome.setSize(10, 20);
		txtNome = new JTextField();
		txtNome.setSize(50, 10);

		lblsenha = new JLabel();
		lblsenha.setText("Digite sua senha:");
		txtsenha = new JTextField();
		txtsenha.setSize(50, 20);

		btnOk = new JButton();
		btnOk.setText("Ok");
		btnCancel=new JButton("Cancelar");
		grid = new GridLayout(3, 2);

		panel = new Panel();
		panel.setLayout(grid);
		panel.add(lblNome);
		panel.add(txtNome);
		panel.add(lblsenha);
		panel.add(txtsenha);
		panel.add(btnOk);
		panel.add(btnCancel);

		setSize(300, 120);
		setLayout(new FlowLayout());
		add("North", panel);
		setResizable(false);
		setLocationRelativeTo(null);// -->centraliza jframe na tela
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void setNome(String nome) {
		txtNome.setText(nome);
	}

	public String getNome() {
		return txtNome.getText();
	}

	public void setSenha(String senha) {
		txtsenha.setText(senha);
	}

	public String getSenha() {
		return txtsenha.getText();
	}

	public JButton getBtnOk() {
		return btnOk;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}
}
