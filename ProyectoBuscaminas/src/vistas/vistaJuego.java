package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import proyecto.Casilla;
import proyecto.Estado;
import proyecto.NObservable;
import proyecto.NObserver;
import proyecto.Puntuaciones;
import proyecto.Senalada;
import proyecto.Tablero;
import proyecto.Tapada;
import proyecto.cronometro;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class vistaJuego extends JFrame implements NObserver{

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	//private JLabel lblNewLabel_2;
	private	JButton bMatriz[][];
	private int DimX;
	private int DimY;
	private int TamX;
	private int TamY;
	private JMenuBar menuBar;
	private JMenu opciones;
	private JMenuItem VolverEmperzar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vistaJuego frame = new vistaJuego(7,10);
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
	public vistaJuego(int x, int y) {
		setResizable(false);
		setTitle("BUSCAMINA");
		DimX=x;
		DimY=y;
		initialize();
		vizualizar();
	}
	private void vizualizar() {
		if (Tablero.getMiTablero().getBombasRestantes()==75) {
			this.setSize(1200,1000);
		}
		else {
			this.setSize(750,750);
		}
		this.setSize(500,500);
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
		bMatriz = new JButton[DimX][DimY];
		ObtenerTamanioObjetos(DimX,DimY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 500, 500);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(1, 1, 1, 1));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel(), BorderLayout.CENTER);
		contentPane.add(getPanel_1(), BorderLayout.NORTH);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setSize(500, 500);
			panel.setLayout(new GridLayout(DimX,DimY));
			 for(int f=0;f<DimX;f++){
			      for(int c=0;c<DimY;c++){
			    	JButton boton=new JButton();
			        bMatriz[f][c] = boton;
			        bMatriz[f][c].setSize(DimX,DimY);
			        panel.add(bMatriz[f][c]); 
			        
			        boton.addMouseListener(new controlador(f,c));

			      }
			    }
			 
			
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.add(getLblNewLabel());
			panel_1.add(getLblNewLabel_1());
			
		}
		return panel_1;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Bombas restantes: "+String.valueOf(Tablero.getMiTablero().getBombasRestantes()));
			
		}
		return lblNewLabel;
	}
	
	
	private void editBombas() {
		
	 lblNewLabel.setText(String.valueOf("Bombas restantes: "+Tablero.getMiTablero().getBombasRestantes()));
	}
	
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel();
			lblNewLabel_1.setIcon(new ImageIcon("./img/happy.png"));
		}
		return lblNewLabel_1;
	}
	
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getOpciones());
		}
		return menuBar;
	}
	private JMenu getOpciones() {
		if (opciones == null) {
			opciones = new JMenu("Juego");
			opciones.add(getVolverEmperzar());
		}
		return opciones;
	}
	private JMenuItem getVolverEmperzar() {
		if (VolverEmperzar == null) {
			VolverEmperzar = new JMenuItem("Volver empezar");
			VolverEmperzar.addMouseListener(new reset());
		}
		return VolverEmperzar;
	}
	private class controlador implements MouseListener{
		private int x;
		private int y;
		public controlador(int f, int c) {
			x=f; y=c;
		}


		@Override
		public void mouseEntered(MouseEvent e) {
				
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			//cronometro.getMiCronometro();
			// 1- Click izquierdo
			// 3- Click derecho			
			int n=e.getButton();
			if(n==1) {
				Tablero.getMiTablero().pulsarCasillaIzq(x, y);
			}
			else if(n==3) {
				Tablero.getMiTablero().pulsarCasillaDer(x, y);
			}
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

	
	}
	
	private class reset implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			volverEmpezar();
			
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
	@Override
	public void update(NObservable o, int x, int y) {

		editBombas();
		
		if(o instanceof Tablero) {
			Casilla act= ((Tablero) o).getCasilla(x, y);
			Estado eAct=act.getEstado();
			
			if(eAct instanceof Senalada) {  							//Cambiar a un string
				ImageIcon imagen = new ImageIcon("./img/flag.png");
				bMatriz[x][y].setIcon(imagen);
			
			
			}
			else if(eAct instanceof Tapada){
				bMatriz[x][y].setIcon(null);
				
			}
			else {
				if(!act.esMina()) {
				int valor=act.getValor();
				bMatriz[x][y].setEnabled(false);
				bMatriz[x][y].setText(String.valueOf(valor));
				}
				else 
					{ImageIcon imagen = new ImageIcon("./img/bomb.png");
					bMatriz[x][y].setIcon(imagen);
					lblNewLabel_1.setIcon(new ImageIcon("./img/sad.png"));
					}
			}
			
			
			// Comprobación a ver si sigue o no el juego
			if(!((Tablero) o).finPartida()) {
				vistaPontuaciones vp =new vistaPontuaciones();

				if(vp.volverJugar()){
					vistaJuego.this.volverEmpezar();}
				else {
					this.dispose();
				}
				 
			}
		}
	}
	private void volverEmpezar() {
		Tablero.getMiTablero().resert();
		lblNewLabel_1.setIcon(new ImageIcon("./img/happy.png"));
		for(int f=0;f<DimX;f++){
		      for(int c=0;c<DimY;c++){
		        bMatriz[f][c].setEnabled(true);
		        bMatriz[f][c].setIcon(null);
		        bMatriz[f][c].setText(null);
		        panel.add(bMatriz[f][c]);

		      }
		    }
		editBombas();
		lblNewLabel.setText("Bombas restantes: "+String.valueOf(Tablero.getMiTablero().getBombasRestantes()));
	}
	
	private void ObtenerTamanioObjetos(int cantX, int cantY)
    {
        TamX = 500/cantX;
        TamY = 500/cantY;
    }

}
