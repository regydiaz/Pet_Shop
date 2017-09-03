package br.com.meuprojeto.petshop.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import br.com.meuprojeto.petshop.model.Pets;

/**
 * 
 * @author Inmetrics
 * Classe responsável pelo controle de telas, ações dos radio buttons
 */

public class RadioPetsController implements ActionListener {
	JTextField tfID, tfNomePet, tfEspecie;
	JLabel lblId, lblNomePet, lblEspecie,lblPets ;
	JRadioButton rdbtnIncluir, rdbtnAlterar, rdbtnExcluir;
	JButton btnEnviar;
	JComboBox<Pets> comboBox;

	public RadioPetsController(JTextField tfID, JTextField tfNomePet, JTextField tfEspecie,
			JLabel lblId, JLabel lblNomePet, JLabel lblEspcie, JLabel lblPets, 
			JRadioButton rdbtnIncluir, JRadioButton rdbtnAlterar, JRadioButton rdbtnExcluir, JButton btnEnviar, JComboBox<Pets> comboBox) {

		this.tfID = tfID;
		this.tfNomePet = tfNomePet;
		this.tfEspecie = tfEspecie;

		this.lblId = lblId;
		this.lblNomePet = lblNomePet;
		this.lblEspecie = lblEspcie;
		this.lblPets = lblPets;

		this.rdbtnIncluir = rdbtnIncluir;
		this.rdbtnAlterar = rdbtnAlterar;
		this.rdbtnExcluir = rdbtnExcluir;
		this.btnEnviar = btnEnviar;

		this.comboBox = comboBox;
	}

	public void actionPerformed(ActionEvent arg) {

		limpaCampos();
		if (rdbtnIncluir.isSelected()) {
			IPetsController pController = new PetsController(tfID);
			pController.proximoId();
			montaTelaCadastro();
		} else {
			IPetsController pController = new PetsController(comboBox);
			pController.listaPets();
			if (rdbtnAlterar.isSelected()) {
				montaTelaAtualiza();
			} else {
				montaTelaExclui();
			}
		}
	}

	private void limpaCampos() {
		tfID.setText("");
		tfNomePet.setText("");
		tfEspecie.setText("");
	}

	private void montaTelaExclui() {

		lblEspecie.setVisible(false);
		lblId.setVisible(false);
		lblNomePet.setVisible(false);
		lblPets.setVisible(true);
		

		tfID.setVisible(false);
		tfNomePet.setVisible(false);
		tfEspecie.setVisible(false);
		comboBox.setVisible(true);
		btnEnviar.setVisible(true);

	}

	private void montaTelaAtualiza() {

		lblEspecie.setVisible(true);
		lblId.setVisible(true);
		lblNomePet.setVisible(true);
		lblPets.setVisible(true);
		
		tfID.setVisible(true);
		tfNomePet.setVisible(true);
		tfEspecie.setVisible(true);
		comboBox.setVisible(true);
		btnEnviar.setVisible(true);

	}

	private void montaTelaCadastro() {
		lblEspecie.setVisible(true);
		lblId.setVisible(true);
		lblNomePet.setVisible(true);
		lblPets.setVisible(false);
		
		tfID.setVisible(true);
		tfNomePet.setVisible(true);
		tfEspecie.setVisible(true);
		comboBox.setVisible(false);
		btnEnviar.setVisible(true);

	}
}
