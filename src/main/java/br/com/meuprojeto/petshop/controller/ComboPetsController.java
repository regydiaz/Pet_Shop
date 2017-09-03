package br.com.meuprojeto.petshop.controller;
/**
 * Classe q conecta o persistence ao view
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import br.com.meuprojeto.petshop.model.Pets;

public class ComboPetsController implements ActionListener {
	
	JTextField tfId, tfNomePet, tfEspecie;
	JComboBox<Pets> comboBox;
	JRadioButton  rdbtnExcluir;
	
	public ComboPetsController(JTextField tfId, JTextField tfNomePet, JTextField tfEspecie,
			JComboBox<Pets> comboBox,
			JRadioButton  rdbtnExcluir){
		this.tfId = tfId;
		this.tfNomePet = tfNomePet;
		this.tfEspecie = tfEspecie;
		
		this.comboBox = comboBox;
		
		this.rdbtnExcluir = rdbtnExcluir;	
	}

	public void actionPerformed(ActionEvent e) {
		if(comboBox.getItemCount() > 0){
			if (!rdbtnExcluir.isSelected()){
				Pets pets = (Pets) comboBox.getSelectedItem();
				preencheCampos(pets);
			}
		}
	}

	private void preencheCampos(Pets esp) {
		tfId.setText(String.valueOf(esp.getId_Pet()));
		tfNomePet.setText(String.valueOf(esp.getNome_Pet()));
		tfEspecie.setText(String.valueOf(esp.getEspecie_Pet()));
	}
}
