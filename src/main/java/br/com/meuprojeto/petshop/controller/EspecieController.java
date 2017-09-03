package br.com.meuprojeto.petshop.controller;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.meuprojeto.petshop.model.Pets;
import br.com.meuprojeto.petshop.persistence.PetsDAO;

public class EspecieController implements IEspecieController{
	private JComboBox<Pets> comboBox;
	private JTextField tfId;
	private JTable tblEspecie;
	
	public EspecieController(JComboBox<Pets>comboBox) {
		this.comboBox = comboBox;
			}
	public EspecieController(JTextField tfId){
		this.tfId = tfId;
		
	}
	public EspecieController(JComboBox<Pets>comboBox,JTextField tfId ){
		this.comboBox = comboBox;
		this.tfId = tfId;
	
	}
	public EspecieController(JTable tblEspecie) {
		this.tblEspecie = tblEspecie;
		
	}

	public void proximoId() {

		try {
			PetsDAO eDao = new PetsDAO();
			tfId.setText(String.valueOf(eDao.proximoId()));
		} catch (ClassNotFoundException  e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void listaEspecie() {
		try {
			PetsDAO eDao = new PetsDAO();
			List<Pets> listaEspecie = eDao.consultaPet();
			if(comboBox.getItemCount() >0){
				comboBox.removeAllItems();
				
			}
			if (listaEspecie != null){
				for (Pets especie : listaEspecie){
					comboBox.addItem(especie);
				}
				
			}
		} catch (ClassNotFoundException  e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}
	@Override
	public void tableEspecie() {
		if (tblEspecie != null){
			DefaultTableModel modelo = (DefaultTableModel) tblEspecie.getModel();
			if (modelo.getRowCount()>0){
				modelo.setRowCount(0);
			}
			PetsDAO eDao;
			try {
				eDao = new PetsDAO();
				List<Pets> listaEspecie = eDao.consultaPet();
				for(Pets e : listaEspecie){
					Object[] linha = new Object[3];
					linha[0] = e.getId_Pet();
					linha[1] = e.getNome_Pet();
					modelo.addRow(linha);
					
				}
			} catch (ClassNotFoundException | SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
		}
			}
		
		
	}

}
