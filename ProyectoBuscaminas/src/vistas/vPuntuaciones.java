
package vistas;

import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SwingConstants;


import javax.swing.DefaultListModel;
import javax.swing.JList;
public class vPuntuaciones extends JDialog {
	int op;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vPuntuaciones window = new vPuntuaciones();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public vPuntuaciones() {
		this.setVisible(true);
		//ARRAY DE PRUEBA
		String[] prueba = new String[10];
		for(int i=0; i<prueba.length-1; i++) {
			prueba[i] = "Paco";
		}
		prueba[9] = "Juan";
		//CREACIÓN DE ARRAY DE PRUEBA HASTA AQUÍ
		
		initialize(prueba);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param prueba 
	 */
	private void initialize(String[] prueba) {
		//frame = new JFrame();
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("L@S DIEZ MEJORES SON:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		this.getContentPane().add(panel, BorderLayout.SOUTH);
		JButton btnNewButton = new JButton("Cerrar");
		JButton volverAjugar = new JButton("Seguir jugando");
		
		panel.add(volverAjugar);
		panel.add(btnNewButton);
		
		volverAjugar.addMouseListener(new controlador(1));
		btnNewButton.addMouseListener(new controlador(2));
	
		
		JList<String> ranking;
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for (int i = 0; i < prueba.length; i++) {
			listModel.addElement(prueba[i]);
		}
		
		ranking = new JList<>(listModel);
		
		this.getContentPane().add(ranking, BorderLayout.CENTER);

	}
	
	public boolean volverJugar() {
		//si op es igual a 1 se quiere volver a jugar, caso contrario se devulve false
		return op==1;
	}
	
	private class controlador implements MouseListener{
		public controlador(int a) {op=a;}
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			//al pulsar algun botón se llama a volvejugar
				if(!volverJugar()) {vPuntuaciones.this.dispose();}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

}