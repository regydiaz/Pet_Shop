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

import br.com.meuprojeto.petshop.controller.BotaoEspecieController;
import br.com.meuprojeto.petshop.controller.ComboEspecieController;
import br.com.meuprojeto.petshop.controller.EspecieController;
import br.com.meuprojeto.petshop.controller.RadioEspecieController;
import br.com.meuprojeto.petshop.model.Pets;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class PetView extends JFrame {

	private JPanel contentPane;
	public JTextField tfID;
	public JTextField tfNomePet;
	public JTextField tfEspecie;
	private JTable tblEspecie;

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

		JLabel txtNomePet = new JLabel("Nome PET");
		txtNomePet.setBounds(32, 126, 109, 14);
		contentPane.add(txtNomePet);

		tfNomePet = new JTextField();
		tfNomePet.setBounds(130, 123, 309, 20);
		contentPane.add(tfNomePet);
		tfNomePet.setColumns(10);

		tfEspecie = new JTextField();
		tfEspecie.setBounds(130, 157, 316, 20);
		contentPane.add(tfEspecie);
		tfEspecie.setColumns(10);

		JLabel lblNomeDono = new JLabel("Espécie");
		lblNomeDono.setBounds(32, 159, 86, 17);
		contentPane.add(lblNomeDono);

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

		tblEspecie = new JTable();
		scrollPane.setViewportView(tblEspecie);
		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {}, 
				new String[] { "ID", "Nome Pet", "Nome Dono" });
		tblEspecie.setModel(modelo);
		tblEspecie.getColumnModel().getColumn(1).setPreferredWidth(279);
		tblEspecie.getColumnModel().getColumn(2).setPreferredWidth(269);

		EspecieController eController = new EspecieController(tfID);
		eController.proximoId();
		
		eController = new EspecieController(tblEspecie);
		eController.tableEspecie();

		RadioEspecieController rmController = new RadioEspecieController(tfID, tfNomePet, tfEspecie, lblId,
				txtNomePet, lblNomeDono, lblPets, rdbtnIncluir, rdbtnAlterar, rdbtnExcluir, btnEnviar, comboBox);
		rdbtnAlterar.addActionListener(rmController);
		rdbtnIncluir.addActionListener(rmController);
		rdbtnExcluir.addActionListener(rmController);

		ComboEspecieController cmController = new ComboEspecieController(tfID, tfNomePet, tfEspecie, comboBox,
				rdbtnExcluir);
		comboBox.addActionListener(cmController);

		BotaoEspecieController btnController = new BotaoEspecieController(tfID, tfNomePet, tfEspecie, comboBox,
				rdbtnExcluir, rdbtnAlterar, rdbtnIncluir, tblEspecie);
		btnEnviar.addActionListener(btnController);

	}
}
