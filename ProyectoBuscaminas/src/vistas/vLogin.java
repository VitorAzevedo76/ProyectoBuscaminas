package vistas;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import proyecto.Tablero;
import proyecto.nombreVacioException;
import proyecto.ventanaJuego;

import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class vLogin extends JDialog {
	private JPanel panel;
	private JTextField pNombre;
	private JPanel panel_1;
	private JPanel panel_2;
	private JRadioButton n1;
	private JRadioButton n2;
	private JRadioButton n3;
	private JButton btnAceptar;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vLogin dialog = new vLogin();
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
	public vLogin() {

		initialize();
		vizualizar();
	}
	private void vizualizar() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = getSize();
		if (frameSize.height > screenSize.height) {
		frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width) {
		frameSize.width = screenSize.width;
		}
		setLocation((screenSize.width - frameSize.width) / 2,
		(screenSize.height - frameSize.height) / 2);
		setVisible(true);
	}
	private void initialize() {
		setResizable(false);
		setTitle("Buscaminas");
		setBounds(100, 100, 296, 173);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(getPanel(), BorderLayout.NORTH);
		getContentPane().add(getPanel_1(), BorderLayout.CENTER);
		getContentPane().add(getPanel_2(), BorderLayout.SOUTH);
		ButtonGroup g = new ButtonGroup();
		g.add(n1);
		g.add(n2);
		g.add(n3);
		btnAceptar.addActionListener(new Controlador());
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getLblNewLabel());
			panel.add(getPNombre());
		}
		return panel;
	}
	private JTextField getPNombre() {
		if (pNombre == null) {
			pNombre = new JTextField();
			pNombre.setColumns(10);
		}
		return pNombre;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.add(getN1());
			panel_1.add(getN2());
			panel_1.add(getN3());
			panel_1.add(getLblNewLabel_1());
		}
		return panel_1;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.add(getBtnAceptar());
		}
		return panel_2;
	}
	private JRadioButton getN1() {
		if (n1 == null) {
			n1 = new JRadioButton("Nivel 1");
			n1.setBounds(6, 33, 76, 23);
		}
		return n1;
	}
	private JRadioButton getN2() {
		if (n2 == null) {
			n2 = new JRadioButton("Nivel 2");
			n2.setBounds(105, 33, 76, 23);
		}
		return n2;
	}
	private JRadioButton getN3() {
		if (n3 == null) {
			n3 = new JRadioButton("Nivel 3");
			n3.setBounds(214, 33, 76, 23);
		}
		return n3;
	}
	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton("Aceptar");
		}
		return btnAceptar;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("¿Cómo te llamas?");
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("¿En qué nivel deseas jugar?");
			lblNewLabel_1.setBounds(63, 6, 176, 16);
		}
		return lblNewLabel_1;
	}
	
	
	private class Controlador implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
			String texto=pNombre.getText();
		    texto=texto.replaceAll(" ", "");	
			if(texto.length()==0) 
			{	
				throw new nombreVacioException();}
			else {
			if(n1.isSelected()) {
				vLogin.this.dispose();
				Tablero.getMiTablero().generarTablero(7,10,1);
				vistaJuego vf= new vistaJuego(7,10);
				Tablero.getMiTablero().anadirObservers(vf);		
				Tablero.getMiTablero().actualizarJugador(pNombre.getText());
				
			}
			else if(n2.isSelected()) {
				vLogin.this.dispose();
				Tablero.getMiTablero().generarTablero(10,15,2);
				ventanaJuego vf= new ventanaJuego(10,15);
				Tablero.getMiTablero().anadirObservers(vf);
				Tablero.getMiTablero().actualizarJugador(pNombre.getText());
			}
			else if(n3.isSelected()){
				vLogin.this.dispose();
				Tablero.getMiTablero().generarTablero(12,25,3);
				ventanaJuego vf= new ventanaJuego(12,25);
				Tablero.getMiTablero().anadirObservers(vf);
				Tablero.getMiTablero().actualizarJugador(pNombre.getText());
			}
			
			}
			}
			catch(nombreVacioException e1){
				JOptionPane.showMessageDialog(null,"Debes introducir un nombre :( ");
			}
			
		}
		
	}
}
