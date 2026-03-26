package boundary;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import control.controllore;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ListaAutisti extends JDialog {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaAutisti dialog = new ListaAutisti();
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
	public ListaAutisti() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lbllistaAutisti = new JLabel("Lista Autisti");
		lbllistaAutisti.setBounds(28, 25, 85, 13);
		getContentPane().add(lbllistaAutisti);
		
		JTextArea textAreaLista = new JTextArea();
		textAreaLista.setBounds(10, 85, 416, 79);
		getContentPane().add(textAreaLista);
		
		JButton btnListaAutisti = new JButton("cerca");
		btnListaAutisti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
	ArrayList<String> lista = new ArrayList<String>();
				
				
				lista = controllore.elencoAutisti();
				
				textAreaLista.setText("");
				int cont=0;
				
				for(int i=0; i<lista.size();i++) {
					
					if(cont==7) {
						
						textAreaLista.append(lista.get(i)+"\n");
					cont=0;
						
					}else {
						
						textAreaLista.append(lista.get(i)+"  ");
						cont+=1;
					}
					
					}
					
			}
		});
		btnListaAutisti.setBounds(316, 213, 85, 21);
		getContentPane().add(btnListaAutisti);

	}

}