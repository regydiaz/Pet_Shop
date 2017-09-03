package br.com.meuprojeto.petshop.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import br.com.meuprojeto.petshop.model.Pets;

public class RadioEspecieController implements ActionListener {
	JTextField txID, textField, textField_1;
	JLabel lblId, txtNomePet, lblNomeDono, lblEspcie;
	JRadioButton rdbtnIncluir, rdbtnAlterar, rdbtnExcluir;
	JButton btnEnviar;
	JComboBox<Pets> comboBox;

	public RadioEspecieController(JTextField txID, JTextField textField, JTextField textField_1, JLabel lblId,
			JLabel txtNomePet, JLabel lblNomeDono, JLabel lblEspcie, JRadioButton rdbtnIncluir,
			JRadioButton rdbtnAlterar, JRadioButton rdbtnExcluir, JButton btnEnviar, JComboBox<Pets> comboBox) {

		this.txID = txID;
		this.textField = textField;
		this.textField_1 = textField_1;

		this.lblId = lblId;
		this.txtNomePet = txtNomePet;
		this.lblNomeDono = lblNomeDono;
		this.lblEspcie = lblEspcie;

		this.rdbtnIncluir = rdbtnIncluir;
		this.rdbtnAlterar = rdbtnAlterar;
		this.rdbtnExcluir = rdbtnExcluir;
		this.btnEnviar = btnEnviar;

		this.comboBox = comboBox;
	}

	public void actionPerformed(ActionEvent e) {

		limpaCampos();
		if (rdbtnIncluir.isSelected()) {
			IEspecieController eController = new EspecieController(txID);
			eController.proximoId();
			montaTelaCadastro();
		} else {
			IEspecieController eController = new EspecieController(comboBox);
			eController.listaEspecie();
			if (rdbtnIncluir.isSelected()) {
				montaTelaAtualiza();
			} else {
				montaTelaExclui();
			}
		}
	}

	private void limpaCampos() {
		lblId.setText("");
		txtNomePet.setText("");
		lblNomeDono.setText("");
	}

	private void montaTelaExclui() {

		lblId.setVisible(false);
		txtNomePet.setVisible(false);
		lblNomeDono.setVisible(false);
		lblEspcie.setVisible(true);

		txID.setVisible(false);
		textField.setVisible(false);
		textField_1.setVisible(false);
		comboBox.setVisible(true);
		btnEnviar.setVisible(true);

	}

	private void montaTelaAtualiza() {

		lblId.setVisible(true);
		txtNomePet.setVisible(true);
		lblNomeDono.setVisible(true);
		lblEspcie.setVisible(true);

		txID.setVisible(true);
		textField.setVisible(true);
		textField_1.setVisible(true);
		comboBox.setVisible(true);
		btnEnviar.setVisible(true);

	}

	private void montaTelaCadastro() {
		lblId.setVisible(true);
		txtNomePet.setVisible(true);
		lblNomeDono.setVisible(true);
		lblEspcie.setVisible(false);

		txID.setVisible(true);
		textField.setVisible(true);
		textField_1.setVisible(true);
		comboBox.setVisible(false);
		btnEnviar.setVisible(true);

	}
}
