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
import java.util.ArrayList;
import javax.swing.JTextArea;

public class ElencoPrenotazioni extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldInserimento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ElencoPrenotazioni dialog = new ElencoPrenotazioni();
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
	public ElencoPrenotazioni() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblElenco = new JLabel("idViaggio");
		lblElenco.setBounds(43, 69, 62, 13);
		getContentPane().add(lblElenco);
		
		textFieldInserimento = new JTextField();
		textFieldInserimento.setBounds(128, 66, 96, 19);
		getContentPane().add(textFieldInserimento);
		textFieldInserimento.setColumns(10);
		
		JTextArea textArealLista = new JTextArea();
		textArealLista.setBounds(88, 137, 251, 101);
		getContentPane().add(textArealLista);
		
		JButton btnRicerca = new JButton("Inserisci");
		btnRicerca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int ret = -1;
				
				String id = textFieldInserimento.getText();
                    
                    
                    ArrayList<String> lista = new ArrayList<String>();
    				
    				
    				lista = controllore.elencoPrenotazioni(id);
    				
    				textArealLista.setText("");
    				int cont=0;
    				
    				for(int i=0; i<lista.size();i++) {
    					
    					if(cont==1) {
    						
    						textArealLista.append(lista.get(i)+"\n");
    					cont=0;
    						
    					}else {
    						
    						textArealLista.append(lista.get(i)+"  ");
    						cont+=1;
    					}
    					
    				}    
                    
				}
		});
		btnRicerca.setBounds(270, 65, 85, 21);
		getContentPane().add(btnRicerca);
		
		JLabel lblelenco = new JLabel("ElencoPrenotazioni");
		lblelenco.setBounds(88, 117, 117, 13);
		getContentPane().add(lblelenco);

	}
}