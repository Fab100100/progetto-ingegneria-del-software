package boundary;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import control.controllore;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VisualizzaFeedback extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldFeed;
	private JTextField campoVisualizza;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizzaFeedback dialog = new VisualizzaFeedback();
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
	public VisualizzaFeedback() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lbFeedback = new JLabel("ID Feed:");
		lbFeedback.setBounds(21, 24, 60, 16);
		getContentPane().add(lbFeedback);
		
		textFieldFeed = new JTextField();
		textFieldFeed.setBounds(81, 24, 96, 19);
		getContentPane().add(textFieldFeed);
		textFieldFeed.setColumns(10);
		
		JButton btnFeed = new JButton("ricerca");
		btnFeed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
	            int ret = -1;
				
				String feed = textFieldFeed.getText();	
				String Risultato=controllore.ricercaFeedback(feed);
				System.out.println(Risultato);
				
				campoVisualizza.setText(Risultato);
				
				}
		});
		btnFeed.setBounds(222, 23, 85, 21);
		getContentPane().add(btnFeed);
		
		campoVisualizza = new JTextField();
		campoVisualizza.setBounds(10, 87, 416, 166);
		getContentPane().add(campoVisualizza);
		campoVisualizza.setColumns(10);

	}
}