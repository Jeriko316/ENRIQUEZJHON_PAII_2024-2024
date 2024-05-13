package com.edu.ec;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Conexion.Conexion;
import modelo.Student;

public class Front extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JTextField txt_nombre;
	private JTextField txt_apellido;
	private JTextField txt_edad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Front frame = new Front();
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
	public Front() {
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		Button button = new Button("New button");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Conexion conectar = Conexion.getInstance();
					Configuration configuration = new Configuration();
					configuration.configure("hibernate.cfg.xml");

					configuration.addAnnotatedClass(Student.class);
					SessionFactory sessionFactory = configuration.buildSessionFactory();
							Session session = sessionFactory.openSession();

					Student insertar = new Student();

					insertar.setName(txt_nombre.getText().trim());
					insertar.setLastName(txt_apellido.getText().trim());
					insertar.setAge(txt_edad.getText().trim());

					session.beginTransaction();
					session.persist(insertar);
					session.getTransaction().commit();

				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		button.setBounds(53, 162, 70, 22);
		contentPane.add(button);

		txt_nombre = new JTextField();
		txt_nombre.setBounds(174, 11, 151, 33);
		contentPane.add(txt_nombre);
		txt_nombre.setColumns(10);

		txt_apellido = new JTextField();
		txt_apellido.setColumns(10);
		txt_apellido.setBounds(174, 65, 151, 33);
		contentPane.add(txt_apellido);

		txt_edad = new JTextField();
		txt_edad.setColumns(10);
		txt_edad.setBounds(174, 123, 151, 33);
		contentPane.add(txt_edad);
	}
}
