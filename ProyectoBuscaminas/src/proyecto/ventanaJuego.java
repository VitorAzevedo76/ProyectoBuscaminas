package proyecto;

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

public class ventanaJuego extends JFrame implements NObserver{

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private	JButton bMatriz[][];
	private int DimX;
	private int DimY;
	private int TamX;
	private int TamY;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaJuego frame = new ventanaJuego(7,10);
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
	public ventanaJuego(int x, int y) {
		setResizable(false);
		setTitle("BUSCAMINA");
		DimX=x;
		DimY=y;
		initialize();
		vizualizar();
	}
	private void vizualizar() {
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
			        bMatriz[f][c].setSize(TamX,TamY);
			        panel.add(bMatriz[f][c]); 
			        boton.addMouseListener(new controlador(f,c));
			        //boton.addActionListener(new ControladorB(f,c));

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
			panel_1.add(getLblNewLabel_2());
		}
		return panel_1;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("numBombas");
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel();
			lblNewLabel_1.setIcon(new ImageIcon("./img/happy.png"));
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("tiempo");
		}
		return lblNewLabel_2;
	}
	private class controlador implements MouseListener{
		private int x;
		private int y;
		public controlador(int f, int c) {
			x=f; y=c;
		}


		@Override
		public void mouseEntered(MouseEvent e) {
			//lblNewLabel.setText("X: "+x+" Y: "+y);		
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
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
	@Override
	public void update(NObservable o, int x, int y) {
		
		if(o instanceof Tablero) {
			Casilla act= ((Tablero) o).getCasilla(x, y);
			Estado eAct=act.getEstado();
			
			//if(!act.esMina()||(eAct instanceof Señalada)) {
			
			if(eAct instanceof Senalada) {
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
					}
			}
			
			
			// Comprobación a ver si sigue o no el juego
			if(!((Tablero) o).finPartida()) {
				if(((Tablero) o).haGanado()) {
				JOptionPane.showMessageDialog(null,"Has Ganado el juego");
				ventanaJuego.this.dispose();}
				else {
				JOptionPane.showMessageDialog(null,"Has Perdido el juego");
				ventanaJuego.this.dispose();
				}
			}
		}
	}
	
	private void ObtenerTamanioObjetos(int cantX, int cantY)
    {
        TamX = 500/cantX;
        TamY = 500/cantY;
    }
	

	

}
