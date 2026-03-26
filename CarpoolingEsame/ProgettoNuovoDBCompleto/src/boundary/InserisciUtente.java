package boundary;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.controllore;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InserisciUtente extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField campo_id;
	private JTextField campo_nome;
	private JTextField campoCognome;
	private JTextField campo_email;
	private JTextField campo_tipoAuto;
	private JTextField campo_posti;
	private JTextField campo_telefono;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InserisciUtente dialog = new InserisciUtente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InserisciUtente() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		campo_id = new JTextField();
		campo_id.setBounds(112, 25, 96, 19);
		contentPanel.add(campo_id);
		campo_id.setColumns(10);
		
		JLabel idUtente = new JLabel("idUtente");
		idUtente.setBounds(33, 28, 69, 13);
		contentPanel.add(idUtente);
		
		campo_nome = new JTextField();
		campo_nome.setBounds(112, 54, 96, 19);
		contentPanel.add(campo_nome);
		campo_nome.setColumns(10);
		
		campoCognome = new JTextField();
		campoCognome.setBounds(112, 87, 96, 19);
		contentPanel.add(campoCognome);
		campoCognome.setColumns(10);
		
		campo_email = new JTextField();
		campo_email.setBounds(112, 145, 96, 19);
		contentPanel.add(campo_email);
		campo_email.setColumns(10);
		
		campo_tipoAuto = new JTextField();
		campo_tipoAuto.setBounds(112, 182, 96, 19);
		contentPanel.add(campo_tipoAuto);
		campo_tipoAuto.setColumns(10);
		
		campo_posti = new JTextField();
		campo_posti.setBounds(127, 223, 96, 19);
		contentPanel.add(campo_posti);
		campo_posti.setColumns(10);
		
		campo_telefono = new JTextField();
		campo_telefono.setBounds(112, 116, 96, 19);
		contentPanel.add(campo_telefono);
		campo_telefono.setColumns(10);
		
		JLabel lbNome = new JLabel("nome");
		lbNome.setBounds(33, 57, 69, 13);
		contentPanel.add(lbNome);
		
		JLabel lblCognome = new JLabel("cognome");
		lblCognome.setBounds(33, 90, 69, 16);
		contentPanel.add(lblCognome);
		
		JLabel lblTelefono = new JLabel("telefono");
		lblTelefono.setBounds(33, 119, 69, 13);
		contentPanel.add(lblTelefono);
		
		JLabel lbEmail = new JLabel("email");
		lbEmail.setBounds(33, 148, 69, 13);
		contentPanel.add(lbEmail);
		
		JLabel lblTipoAuto = new JLabel("TipoAuto");
		lblTipoAuto.setBounds(33, 185, 69, 13);
		contentPanel.add(lblTipoAuto);
		
		JLabel lblPostiDisponibili = new JLabel("PostiDisponibili");
		lblPostiDisponibili.setBounds(33, 226, 96, 13);
		contentPanel.add(lblPostiDisponibili);
		
		JButton btnInvia = new JButton("Inserisci");
		btnInvia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int ret = -1;
				
				String id = campo_id.getText();
				
				String nome = campo_nome.getText();	
				String cognome = campoCognome.getText();
				String telefono = campo_telefono.getText();
				String email = campo_email.getText();
				String TipoAuto = campo_tipoAuto.getText();
				String PostiDisponibili = campo_posti.getText();
				
				
				ret = controllore.InserisciUtente(id,nome,cognome,telefono,email,TipoAuto, Integer.parseInt(PostiDisponibili));
				
				System.out.println(ret);
				
				if(ret!=-1) {
					
					JOptionPane.showMessageDialog(btnInvia, "Testo inserito correttamente", "Plain Text", JOptionPane.PLAIN_MESSAGE);


				}else {
					
					JOptionPane.showMessageDialog(btnInvia, "Inserimennto non � andato a buon fine", "Error", JOptionPane.ERROR_MESSAGE);

				}
				
			}
		});
		btnInvia.setBounds(285, 115, 85, 21);
		contentPanel.add(btnInvia);
	}
}