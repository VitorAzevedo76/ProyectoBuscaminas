package proyecto;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;


public class vJuego extends JFrame implements NObserver {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JPanel panel;
	private	JButton bMatriz[][];
	private int DimX;
	private int DimY;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vJuego frame = new vJuego(5,5);
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
	public vJuego(int x, int y) {
		panel= new JPanel();
		DimX=x;
		DimY=y;
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
		bMatriz = new JButton[DimX][DimY];
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(DimX, DimY, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getLblNewLabel(), BorderLayout.SOUTH);
		contentPane.add(getPanel(), BorderLayout.CENTER);
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("X: 0 Y: 0");
		}
		return lblNewLabel;
	}
	private JPanel getPanel() {
	
	    panel.setLayout(new GridLayout(DimX,DimY));

	    for(int f=0;f<DimX;f++){
	      for(int c=0;c<DimY;c++){
	    	JButton boton=new JButton(""+f+","+c);
	        bMatriz[f][c] = boton;
	        bMatriz[f][c].setBounds(5,5,0,0);

	        panel.setBounds(140,15,270,300);
	        panel.add(bMatriz[f][c]); 
	        boton.addMouseListener(new controlador(f,c));
	        //boton.addActionListener(new ControladorB(f,c));

	      }
	    }
	    return panel;
		
	}
	private class controlador implements MouseListener{
		private int x;
		private int y;
		public controlador(int f, int c) {
			x=f; y=c;
		}


		@Override
		public void mouseEntered(MouseEvent e) {
			lblNewLabel.setText("X: "+x+" Y: "+y);		
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
			actualizar(x,y);
		}
	}
	
	private void actualizar(int x, int y) {
		//Código para que se actualize y cambie la casilla con la coordenada X e Y.
	}

	
}