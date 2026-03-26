package boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton list_autisti = new JButton("listaAutisti");
		list_autisti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ListaAutisti form=new ListaAutisti();
				form.setVisible(true);
						
				
				
			}
		});
		list_autisti.setBounds(70, 32, 135, 68);
		contentPane.add(list_autisti);
		
		JButton ins_utente = new JButton("Inserisci utente");
		ins_utente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			InserisciUtente form=new InserisciUtente();
			form.setVisible(true);
				
			}
		});
		ins_utente.setBounds(260, 104, 145, 68);
		contentPane.add(ins_utente);
		
		JButton listaPasseggeri = new JButton("listaPasseggeri");
		listaPasseggeri.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ListaPasseggeri form=new ListaPasseggeri();
				form.setVisible(true);	
				
			}
		});
		listaPasseggeri.setBounds(70, 140, 126, 80);
		contentPane.add(listaPasseggeri);
		
		JButton btnIncasso = new JButton("VisualizzaIncasso");
		btnIncasso.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				Incasso form=new Incasso();
				form.setVisible(true);		
				
			}
		});
		btnIncasso.setBounds(260, 56, 146, 21);
		contentPane.add(btnIncasso);
		
		JButton btnFeedback = new JButton("Feedback");
		btnFeedback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				VisualizzaFeedback form=new VisualizzaFeedback();
				form.setVisible(true);		
				
			}
		});
		btnFeedback.setBounds(264, 210, 119, 21);
		contentPane.add(btnFeedback);
	}
}