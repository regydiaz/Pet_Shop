package br.com.meuprojeto.petshop.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import br.com.meuprojeto.petshop.model.Pets;

public class ComboEspecieController implements ActionListener {
	
	JTextField txID, textField, textField_1;
	JComboBox<Pets> comboBox;
	JRadioButton  rdbtnExcluir;
	
	public ComboEspecieController(JTextField txID, JTextField textField, JTextField textField_1,
			JComboBox<Pets> comboBox,
			JRadioButton  rdbtnExcluir){
		this.txID = txID;
		this.textField = textField;
		this.textField_1 = textField_1;
		
		this.comboBox = comboBox;
		
		this.rdbtnExcluir = rdbtnExcluir;	
		
	}

	public void actionPerformed(ActionEvent e) {
		if(comboBox.getItemCount() > 0){
			if (!rdbtnExcluir.isSelected()){
				Pets esp = (Pets) comboBox.getSelectedItem();
				preencheCampos(esp);
			}
		}
	}

	private void preencheCampos(Pets esp) {
		txID.setText(String.valueOf(esp.getId_Pet()));
		textField.setText(String.valueOf(esp.getNome_Pet()));
	}

}
