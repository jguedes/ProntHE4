package utils;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import entidade.atendente.TelaFormAtendentes;
import entidade.enfermeiro.TelaFormEnfermeiros;
import entidade.medico.TelaFormMedicos;

public class TelaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JDesktopPane desktopPane;
	private JMenuItem miAtendentes, miEnfermeiros, miMedicos;
	private JMenuBar menuBar;
	private JMenu menu;
	private TelaFormAtendentes formAtendentes;
	private TelaFormEnfermeiros formEnfermeiros;
	private TelaFormMedicos formMedicos;

	public TelaPrincipal() {

		super("Prontuário Hospitalar Eletrônico - ProntHE");

		int inset = 50;

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(inset, inset, screenSize.width - inset * 2, screenSize.height
				- inset * 2);

		desktopPane = new JDesktopPane();
		miAtendentes = new JMenuItem("Atendentes");
		miAtendentes.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {
				
				if (formAtendentes == null) {
					formAtendentes = new TelaFormAtendentes();
					formAtendentes.setVisible(true);
					desktopPane.add(formAtendentes);
				} else if (!formAtendentes.isVisible()) {
					formAtendentes.setVisible(true);
					desktopPane.add(formAtendentes);

				}
			}
		});

		miEnfermeiros = new JMenuItem("Enfermeiros");
		miEnfermeiros.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {

				if (formEnfermeiros == null) {
					formEnfermeiros = new TelaFormEnfermeiros();
					formEnfermeiros.setVisible(true);
					desktopPane.add(formEnfermeiros);
				} else if (!formEnfermeiros.isVisible()) {
					formEnfermeiros.setVisible(true);
					desktopPane.add(formEnfermeiros);
				}
			}
		});

		miMedicos = new JMenuItem("Médicos");
		miMedicos.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {

				if (formMedicos == null) {
					formMedicos = new TelaFormMedicos();
					formMedicos.setVisible(true);
					desktopPane.add(formMedicos);
				} else if (!formMedicos.isVisible()) {
					formMedicos.setVisible(true);
					desktopPane.add(formMedicos);
				}
			}
		});

		menuBar = new JMenuBar();
		menu = new JMenu("Opções do Sistema");

		setContentPane(desktopPane);

		menu.add(miAtendentes);
		menu.add(miEnfermeiros);
		menu.add(miMedicos);

		menuBar.add(menu);

		setJMenuBar(menuBar);

		setVisible(true);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}