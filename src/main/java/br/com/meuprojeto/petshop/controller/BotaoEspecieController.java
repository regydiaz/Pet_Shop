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

public class BotaoEspecieController implements ActionListener {

	private JTextField txID, textField, textField_1;
	private JComboBox<Pets> comboBox;
	private JRadioButton rdbtnExcluir, rdbtnAlterar, rdbtnIncluir;
	private JTable tblEspecie;

	public BotaoEspecieController(JTextField txID, JTextField textField, JTextField textField_1,
			JComboBox<Pets> comboBox,
			JRadioButton rdbtnExcluir, JRadioButton rdbtnAlterar, JRadioButton rdbtnIncluir, JTable tblEspecie ) {
		
		this.txID = txID;
		this.textField = textField;
		this.textField_1 = textField_1;
		
		this.comboBox = comboBox;
		
		this.rdbtnExcluir = rdbtnExcluir;
		this.rdbtnAlterar = rdbtnAlterar;
		this.rdbtnIncluir = rdbtnIncluir;
		
		this.tblEspecie = tblEspecie;

	}

	public void actionPerformed(ActionEvent e) {
		
		Pets esp = new Pets();
		if(comboBox.getSelectedItem()!= null){
			esp = (Pets) comboBox.getSelectedItem();
		}
		if(rdbtnExcluir.isSelected()){
			exclui(esp);
		}else{
			esp.setId_Pet(Integer.parseInt(txID.getText()));
			esp.setNome_Pet(textField.getText());
			if(rdbtnIncluir.isSelected()){
				cadastro(esp);
			}else{
				atualiza(esp);
				
			}
		}

	}
	private void limpaCampos(){
		textField.setText("");
		textField_1.setText("");
		if(!rdbtnIncluir.isSelected()){
			txID.setText("");
			
		}
	}
	
	private void atualiza(Pets esp) {
		try {
			PetsDAO eDao = new PetsDAO();
			eDao.atualizaPet(esp);
			JOptionPane.showMessageDialog(null, "Espécie atualizada com sucesso",
					"Sucesso", JOptionPane.INFORMATION_MESSAGE);
			IEspecieController eController = new EspecieController(comboBox);
			eController.listaEspecie();
			eController = new EspecieController(tblEspecie);
			eController.tableEspecie();
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
			JOptionPane.showMessageDialog(null, "Espécie inserida com sucesso",
					"Sucesso", JOptionPane.INFORMATION_MESSAGE);
			EspecieController eController = new EspecieController(txID);
			eController.proximoId();
			eController = new EspecieController(tblEspecie);
			eController.tableEspecie();
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
			JOptionPane.showMessageDialog(null, "Espécie excluida com sucesso",
					"Sucesso", JOptionPane.INFORMATION_MESSAGE);
			IEspecieController eController = new EspecieController(comboBox);
			eController.listaEspecie();
			eController = new EspecieController(tblEspecie);
			eController.tableEspecie();
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);			
			e.printStackTrace();
		}
	}

}
