package br.com.meuprojeto.petshop.controller;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.meuprojeto.petshop.model.EspecieModel;

public class EspecieController implements IEspecieController{
	private JComboBox<EspecieModel> comboBox;
	private JTextField tfId;
	private JTable tblEspecie;
	
	public EspecieController(JComboBox<EspecieModel>comboBox) {
		this.comboBox = comboBox;
			}
	public EspecieController(JTextField tfId){
		this.tfId = tfId;
		
	}
	public EspecieController(JComboBox<EspecieModel>comboBox,JTextField tfId ){
		this.comboBox = comboBox;
		this.tfId = tfId;
	
	}
	public EspecieController(JTable tblEspecie) {
		this.tblEspecie = tblEspecie;
		
	}

	public void proximoId() {

		try {
			EspecieDAO eDao = new EspecieDAO();
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
			EspecieDAO eDao = new EspecieDAO();
			List<EspecieModel> listaEspecie = eDao.consultaPet();
			if(comboBox.getItemCount() >0){
				comboBox.removeAllItems();
				
			}
			if (listaEspecie != null){
				for (EspecieModel especie : listaEspecie){
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
			EspecieDAO eDao;
			try {
				eDao = new EspecieDAO();
				List<EspecieModel> listaEspecie = eDao.consultaPet();
				for(EspecieModel e : listaEspecie){
					Object[] linha = new Object[3];
					linha[0] = e.getId();
					linha[1] = e.getNome_Pet();
					linha[1] = e.getNome_Dono();
					modelo.addRow(linha);
					
				}
			} catch (ClassNotFoundException | SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
		}
			}
		
		
	}

}
