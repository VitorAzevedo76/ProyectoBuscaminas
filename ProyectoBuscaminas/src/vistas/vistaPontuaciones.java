package vistas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.html.HTMLDocument.Iterator;

import proyecto.Puntuaciones;

import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class vistaPontuaciones extends JDialog {
	private boolean vjugar;
	
	JList jList1;
	DefaultListModel<String> elementos = new DefaultListModel();
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			vistaPontuaciones dialog = new vistaPontuaciones();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public vistaPontuaciones() {
		setModal(true);
		setBounds(100, 100, 262, 353);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			jList1 = new JList();
			jList1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			jList1.setBounds(15, 44, 230, 228);
			contentPanel.add(jList1);
			
			 
		}
		{
			JLabel lblCalificaciones = new JLabel("L@S DIEZ MEJORES SON:");
			lblCalificaciones.setBounds(15, 16, 156, 16);
			contentPanel.add(lblCalificaciones);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new BorderLayout(0, 0));
			{
				JButton cancelButton = new JButton("Cerrar");
				cancelButton.addMouseListener(new controlador(2));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			{
				JButton btnNewButton = new JButton("Volver a jugar");
				btnNewButton.addMouseListener(new controlador(1));
				buttonPane.add(btnNewButton, BorderLayout.WEST);
			}
			
			
		}
		
		Lista();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		vizualizar();
		setResizable(false);
		setVisible(true);
		
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
	}
	
	public void Lista(){
		ArrayList<String> list=Puntuaciones.getMisPuntuaciones().getRank();
		ListIterator itr= list.listIterator();
		String s;
		while (itr.hasNext()) {
			s=(String) itr.next();
			elementos.addElement(s);
		}		
		 jList1.setModel(elementos);		
	}

	public boolean volverJugar() {
		//si op es igual a 1 se quiere volver a jugar, caso contrario se devulve false
		return vjugar;
	}
	
	private class controlador implements MouseListener{
		int opcion;
		public controlador(int a) {opcion=a;}
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			//al pulsar algun botÃ³n se llama a volvejugar
				if(opcion==1) {
					vjugar=true;	
				}
				else if(opcion==2) {	
					vjugar=false;
				}
				vistaPontuaciones.this.dispose();
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
