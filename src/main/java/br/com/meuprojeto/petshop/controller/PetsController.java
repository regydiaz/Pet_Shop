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

/**
 * 
 * @author Inmetrics Classe com contrutores
 */
public class PetsController implements IPetsController {
	private JComboBox<Pets> comboBox;
	private JTextField tfId;
	private JTable tblPet;

	public PetsController(JComboBox<Pets> comboBox) {
		this.comboBox = comboBox;
	}

	public PetsController(JTextField tfId) {
		this.tfId = tfId;

	}

	public PetsController(JComboBox<Pets> comboBox, JTextField tfId) {
		this.comboBox = comboBox;
		this.tfId = tfId;

	}

	public PetsController(JTable tblPet) {
		this.tblPet = tblPet;

	}

	public void proximoId() {

		try {
			PetsDAO pDao = new PetsDAO();
			tfId.setText(String.valueOf(pDao.proximoId()));
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void listaPets() {
		try {
			PetsDAO pDao = new PetsDAO();
			List<Pets> listaPets = pDao.consultaPet();
			if (comboBox.getItemCount() > 0) {
				comboBox.removeAllItems();

			}
			if (listaPets != null) {
				for (Pets p : listaPets) {
					comboBox.addItem(p);
				}
			}
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void tablePets() {
		if (tblPet != null) {
			DefaultTableModel modelo = (DefaultTableModel) tblPet.getModel();
			if (modelo.getRowCount() > 0) {
				modelo.setRowCount(0);
			}
			PetsDAO eDao;
			try {
				eDao = new PetsDAO();
				List<Pets> listaEspecie = eDao.consultaPet();
				for (Pets e : listaEspecie) {
					Object[] linha = new Object[3];
					linha[0] = e.getId_Pet();
					linha[1] = e.getNome_Pet();
					linha[2] = e.getEspecie_Pet();
					modelo.addRow(linha);

				}
			} catch (ClassNotFoundException | SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}

	}

}
