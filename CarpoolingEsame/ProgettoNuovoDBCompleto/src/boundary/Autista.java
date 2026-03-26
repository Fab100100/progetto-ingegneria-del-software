package boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Autista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Autista frame = new Autista();
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
	public Autista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRicerca = new JButton("Ricerca");
		btnRicerca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ElencoPrenotazioni form=new ElencoPrenotazioni();
				form.setVisible(true);	
				
				
			}
		});
		btnRicerca.setBounds(77, 103, 85, 21);
		contentPane.add(btnRicerca);
		
		JButton btnAggiungi = new JButton("AggiungiPrenotazione");
		btnAggiungi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				AggiungiPrenotazione form=new AggiungiPrenotazione();
				form.setVisible(true);		
				
			}
		});
		btnAggiungi.setBounds(210, 41, 162, 21);
		contentPane.add(btnAggiungi);
		
		JButton btnRimuovi = new JButton("RimuoviPrenotazione");
		btnRimuovi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				RifiutaPrenotazione form=new RifiutaPrenotazione();
				form.setVisible(true);		
				
			}
		});
		btnRimuovi.setBounds(210, 151, 162, 21);
		contentPane.add(btnRimuovi);
	}
}