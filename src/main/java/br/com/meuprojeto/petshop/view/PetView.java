package br.com.meuprojeto.petshop.view;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.meuprojeto.petshop.controller.BotaoPetsController;
import br.com.meuprojeto.petshop.controller.ComboPetsController;
import br.com.meuprojeto.petshop.controller.PetsController;
import br.com.meuprojeto.petshop.controller.RadioPetsController;
import br.com.meuprojeto.petshop.model.Pets;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class PetView extends JFrame {

	private JPanel contentPane;
	public JTextField tfID;
	public JTextField tfNomePet;
	public JTextField tfEspecie;
	private JTable tblPet;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PetView frame = new PetView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PetView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("");
		label.setBounds(5, 5, 568, 0);
		contentPane.add(label);

		JRadioButton rdbtnIncluir = new JRadioButton("Incluir");
		rdbtnIncluir.setBounds(32, 12, 109, 23);
		contentPane.add(rdbtnIncluir);
		rdbtnIncluir.setSelected(true);

		JRadioButton rdbtnAlterar = new JRadioButton("Alterar");
		rdbtnAlterar.setBounds(205, 12, 109, 23);
		contentPane.add(rdbtnAlterar);

		JRadioButton rdbtnExcluir = new JRadioButton("Excluir");
		rdbtnExcluir.setBounds(379, 12, 109, 23);
		contentPane.add(rdbtnExcluir);

		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnIncluir);
		bg.add(rdbtnAlterar);
		bg.add(rdbtnExcluir);

		JLabel lblId = new JLabel("ID");
		lblId.setBounds(32, 95, 46, 14);
		contentPane.add(lblId);

		tfID = new JTextField();
		tfID.setEditable(false);
		tfID.setBounds(130, 92, 109, 20);
		contentPane.add(tfID);
		tfID.setColumns(10);

		JLabel lblNomePet = new JLabel("Nome PET");
		lblNomePet.setBounds(32, 126, 109, 14);
		contentPane.add(lblNomePet);

		tfNomePet = new JTextField();
		tfNomePet.setBounds(130, 123, 309, 20);
		contentPane.add(tfNomePet);
		tfNomePet.setColumns(10);

		tfEspecie = new JTextField();
		tfEspecie.setBounds(130, 157, 316, 20);
		contentPane.add(tfEspecie);
		tfEspecie.setColumns(10);

		JLabel lblEspecie = new JLabel("Especie");
		lblEspecie.setBounds(32, 159, 86, 17);
		contentPane.add(lblEspecie);

		JLabel lblPets = new JLabel("PETS");
		lblPets.setBounds(32, 64, 46, 14);
		contentPane.add(lblPets);
		lblPets.setVisible(false);

		JComboBox<Pets> comboBox = new JComboBox<Pets>();
		comboBox.setBounds(130, 61, 290, 20);
		contentPane.add(comboBox);
		comboBox.setVisible(false);

		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(32, 219, 89, 23);
		contentPane.add(btnEnviar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 277, 558, 121);
		contentPane.add(scrollPane);

		tblPet = new JTable();
		scrollPane.setViewportView(tblPet);
		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {}, 
				new String[] { "ID_PET", "NOME_PET", "ESPECIE_PET" });
		tblPet.setModel(modelo);
		tblPet.getColumnModel().getColumn(1).setPreferredWidth(279);
		tblPet.getColumnModel().getColumn(2).setPreferredWidth(269);

		PetsController pController = new PetsController(tfID);
		pController.proximoId();
		
		pController = new PetsController(tblPet);
		pController.tablePets();

		RadioPetsController petController = new RadioPetsController(tfID, tfNomePet, tfEspecie, lblId,
				lblNomePet, lblEspecie, lblPets, rdbtnIncluir, rdbtnAlterar, rdbtnExcluir, btnEnviar, comboBox);
		rdbtnAlterar.addActionListener(petController);
		rdbtnIncluir.addActionListener(petController);
		rdbtnExcluir.addActionListener(petController);

		ComboPetsController cmController = new ComboPetsController(tfID, tfNomePet, tfEspecie, comboBox,
				rdbtnExcluir);
		comboBox.addActionListener(cmController);

		BotaoPetsController btnController = new BotaoPetsController(tfID, tfNomePet, tfEspecie, comboBox,
				rdbtnExcluir, rdbtnAlterar, rdbtnIncluir, tblPet);
		btnEnviar.addActionListener(btnController);

	}
}
