package boundary;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;


import control.controllore;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JScrollPane;

public class ListaPasseggeri extends JDialog {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaPasseggeri dialog = new ListaPasseggeri();
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
	public ListaPasseggeri() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblListaPasseggeri = new JLabel("listaPasseggeri");
		lblListaPasseggeri.setBounds(45, 27, 91, 13);
		getContentPane().add(lblListaPasseggeri);
		
		JTextArea AreaPasseggeri = new JTextArea();
		AreaPasseggeri.setBounds(10, 50, 416, 123);
		getContentPane().add(AreaPasseggeri);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(119, 143, 49, 0);
		getContentPane().add(scrollPane);
		
		JButton btnCerca = new JButton("cerca");
		btnCerca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ArrayList<String> lista = new ArrayList<String>();
				
				
				lista = controllore.elencoPasseggeri();
				
				AreaPasseggeri.setText("");
				int cont=0;
				
				for(int i=0; i<lista.size();i++) {
					
					if(cont==7) {
						
					AreaPasseggeri.append(lista.get(i)+"\n");
					cont=0;
						
					}else {
						
						AreaPasseggeri.append(lista.get(i)+"  ");
						cont+=1;
					}
					
					}
				
				}
		});
		btnCerca.setBounds(321, 215, 85, 21);
		getContentPane().add(btnCerca);
		
	}
}