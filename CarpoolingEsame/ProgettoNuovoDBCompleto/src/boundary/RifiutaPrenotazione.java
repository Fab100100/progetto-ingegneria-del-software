package boundary;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import control.controllore;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RifiutaPrenotazione extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RifiutaPrenotazione dialog = new RifiutaPrenotazione();
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
	public RifiutaPrenotazione() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblid = new JLabel("idPrenotazione");
		lblid.setBounds(74, 38, 99, 16);
		getContentPane().add(lblid);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(183, 35, 96, 19);
		getContentPane().add(textFieldId);
		textFieldId.setColumns(10);
		
		JButton btnRifiuta = new JButton("conferma");
		btnRifiuta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int ret = -1;
				
				String id = textFieldId.getText();
				
				ret = controllore.eliminaViaggio(id);
				
				
	          if(ret!=-1) {
					
					JOptionPane.showMessageDialog(btnRifiuta, "prenotazione rifiutata correttamente", "Plain Text", JOptionPane.PLAIN_MESSAGE);


				}else {
					
					JOptionPane.showMessageDialog(btnRifiuta, "Inserimennto non � andato a buon fine", "Error", JOptionPane.ERROR_MESSAGE);

				}
				
			}
		});
		btnRifiuta.setBounds(309, 34, 85, 21);
		getContentPane().add(btnRifiuta);

	}
}