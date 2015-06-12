
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import BBDD.Conexion;


public class Ventanaclientes extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField editNumClientes;
	private JTextField editTimerClientes;
	private JButton botonRadiobase;
	Conexion con;
	public Ventanaclientes() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 441, 153);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Simulador de Radiobases Movistar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 411, 99);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 25, 394, 68);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNDeClientes = new JLabel("N\u00B0 de Clientes:");
		lblNDeClientes.setBounds(10, 11, 78, 14);
		panel_1.add(lblNDeClientes);
		
		editNumClientes = new JTextField();
		editNumClientes.setText("46");
		editNumClientes.setBounds(86, 8, 43, 20);
		panel_1.add(editNumClientes);
		editNumClientes.setColumns(10);
		
		JLabel lblTimerKa = new JLabel("Timer KA:");
		lblTimerKa.setBounds(10, 36, 59, 14);
		panel_1.add(lblTimerKa);
		
		editTimerClientes = new JTextField();
		editTimerClientes.setText("15");
		editTimerClientes.setBounds(86, 31, 43, 19);
		panel_1.add(editTimerClientes);
		editTimerClientes.setColumns(10);
		
		final JButton btn_start = new JButton("Iniciar");
		btn_start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int NumClientes=Integer.parseInt(editNumClientes.getText().toString());
				int Tiempo=Integer.parseInt(editTimerClientes.getText().toString());
				
				
				if (btn_start.getText().toString()=="Iniciar"){
					btn_start.setText("Detener");
					MultiCliente multiclient=new MultiCliente(Tiempo,NumClientes);
					multiclient.start();
				
				}else{
					btn_start.setText("Iniciar");
					Cliente.boolClientes=false;
					}
				
			}
		});
		btn_start.setBounds(139, 10, 245, 40);
		panel_1.add(btn_start);
		
		
		
		
		
		
	}
}
