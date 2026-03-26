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

public class AggiungiPrenotazione extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField id;
	private JTextField costo;
	private JTextField idViaggio;
	private JTextField idPasseggero;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AggiungiPrenotazione dialog = new AggiungiPrenotazione();
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
	public AggiungiPrenotazione() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblprenotazione = new JLabel("idPrenotazione");
		lblprenotazione.setBounds(40, 44, 86, 16);
		getContentPane().add(lblprenotazione);
		
		JLabel lblCosto = new JLabel("costo");
		lblCosto.setBounds(40, 91, 45, 13);
		getContentPane().add(lblCosto);
		
		JLabel lblViaggio = new JLabel("idViaggio");
		lblViaggio.setBounds(40, 156, 63, 13);
		getContentPane().add(lblViaggio);
		
		JLabel lblPasseggero = new JLabel("idPasseggero");
		lblPasseggero.setBounds(40, 199, 86, 16);
		getContentPane().add(lblPasseggero);
		
		id = new JTextField();
		id.setBounds(136, 44, 96, 19);
		getContentPane().add(id);
		id.setColumns(10);
		
		costo = new JTextField();
		costo.setBounds(136, 88, 96, 19);
		getContentPane().add(costo);
		costo.setColumns(10);
		
		idViaggio = new JTextField();
		idViaggio.setBounds(136, 153, 96, 19);
		getContentPane().add(idViaggio);
		idViaggio.setColumns(10);
		
		idPasseggero = new JTextField();
		idPasseggero.setBounds(136, 199, 96, 19);
		getContentPane().add(idPasseggero);
		idPasseggero.setColumns(10);
		
		JButton btnPrenotazione = new JButton("carica");
		btnPrenotazione.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int ret = -1;
				
				
				
	            String idPrenotazione = id.getText();
				
				String costoPrenotazione = costo.getText();	
				String id_Viaggio = idViaggio.getText();
				String id_passeggero = idPasseggero.getText();
				
				System.out.println(id_passeggero+costoPrenotazione+id_Viaggio+id_passeggero);
				
				ret = controllore.InserisciViaggio(idPrenotazione,Float.parseFloat(costoPrenotazione),id_Viaggio,id_passeggero);
				
				
				
                 if(ret!=-1) {
					
					JOptionPane.showMessageDialog(btnPrenotazione, "prenotazione aggiunta correttamente", "Plain Text", JOptionPane.PLAIN_MESSAGE);


				}else {
					
					JOptionPane.showMessageDialog(btnPrenotazione, "Inserimennto non � andato a buon fine", "Error", JOptionPane.ERROR_MESSAGE);

				}
				
}
		});
		btnPrenotazione.setBounds(308, 117, 85, 21);
		getContentPane().add(btnPrenotazione);

	}

}