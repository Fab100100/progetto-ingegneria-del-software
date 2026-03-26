package boundary;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import control.controllore;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Incasso extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField campoId;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Incasso dialog = new Incasso();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Incasso() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblViaggio = new JLabel("idViaggio");
		lblViaggio.setBounds(25, 44, 82, 13);
		getContentPane().add(lblViaggio);
		
		campoId = new JTextField();
		campoId.setBounds(102, 41, 96, 19);
		getContentPane().add(campoId);
		campoId.setColumns(10);
		
		JButton btnViaggio = new JButton("cerca");
		btnViaggio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int ret = -1;
				
				String incasso = campoId.getText();	
				String Risultato=controllore.ricercaIncasso(incasso);
				System.out.println(Risultato);
				
				textField.setText(Risultato);
				
				}
		});
		btnViaggio.setBounds(208, 40, 85, 21);
		getContentPane().add(btnViaggio);
		
		textField = new JTextField();
		textField.setBounds(20, 121, 383, 94);
		getContentPane().add(textField);
		textField.setColumns(10);

	}
}