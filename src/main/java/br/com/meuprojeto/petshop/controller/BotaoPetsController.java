package br.com.meuprojeto.petshop.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.com.meuprojeto.petshop.model.Pets;
import br.com.meuprojeto.petshop.persistence.PetsDAO;

public class BotaoPetsController implements ActionListener {

	private JTextField tfId, tfNomePet, tfEspecie;
	private JComboBox<Pets> comboBox;
	private JRadioButton rdbtnExcluir, rdbtnAlterar, rdbtnIncluir;
	private JTable tblPet;

	public BotaoPetsController(JTextField tfId, JTextField tfNomePet, JTextField tfEspecie,
			JComboBox<Pets> comboBox,
			JRadioButton rdbtnExcluir, JRadioButton rdbtnAlterar, JRadioButton rdbtnIncluir, JTable tblPet ) {
		
		this.tfId = tfId;
		this.tfNomePet = tfNomePet;
		this.tfEspecie = tfEspecie;
		
		this.comboBox = comboBox;
		
		this.rdbtnExcluir = rdbtnExcluir;
		this.rdbtnAlterar = rdbtnAlterar;
		this.rdbtnIncluir = rdbtnIncluir;
		
		this.tblPet = tblPet;

	}

	public void actionPerformed(ActionEvent e) {
		
		Pets esp = new Pets();
		if(comboBox.getSelectedItem()!= null){
			esp = (Pets) comboBox.getSelectedItem();
		}
		if(rdbtnExcluir.isSelected()){
			exclui(esp);
		}else{
			esp.setId_Pet(Integer.parseInt(tfId.getText()));
			esp.setNome_Pet(tfNomePet.getText());
			esp.setEspecie_Pet(tfEspecie.getText());
			if(rdbtnIncluir.isSelected()){
				cadastro(esp);
			}else{
				atualiza(esp);
			}
		}

	}
	private void limpaCampos(){
		tfNomePet.setText("");
		tfEspecie.setText("");
		if(!rdbtnIncluir.isSelected()){
			tfId.setText("");
		}
	}
	
	private void atualiza(Pets esp) {
		try {
			PetsDAO eDao = new PetsDAO();
			eDao.atualizaPet(esp);
			JOptionPane.showMessageDialog(null, "PET atualizado com sucesso =)",
					"Sucesso", JOptionPane.INFORMATION_MESSAGE);
			IPetsController eController = new PetsController(comboBox);
			eController.listaPets();
			eController = new PetsController(tblPet);
			eController.tablePets();
			limpaCampos();
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);			
			e.printStackTrace();
		}
	}

	private void cadastro(Pets esp) {
		try {
			PetsDAO eDao = new PetsDAO();
			eDao.inserePet(esp);
			JOptionPane.showMessageDialog(null, "PET inserido com sucesso =)",
					"Sucesso", JOptionPane.INFORMATION_MESSAGE);
			PetsController eController = new PetsController(tfId);
			eController.proximoId();
			eController = new PetsController(tblPet);
			eController.tablePets();
			limpaCampos();
		} catch (ClassNotFoundException | SQLException e) {
		JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);			
			e.printStackTrace();
		}
	}

	private void exclui(Pets esp) {
		try {
			PetsDAO eDao = new PetsDAO();
			eDao.excluiPet(esp);
			JOptionPane.showMessageDialog(null, "PET excluido com sucesso",
					"Sucesso", JOptionPane.INFORMATION_MESSAGE);
			IPetsController eController = new PetsController(comboBox);
			eController.listaPets();
			eController = new PetsController(tblPet);
			eController.tablePets();
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);			
			e.printStackTrace();
		}
	}

}
