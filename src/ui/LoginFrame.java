package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import error.ValidationException;
import model.User;
import service.LoginService;
import util.ValidationUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtPassword;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 354, 334);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblJudul = new JLabel("Laundry Apps");
		lblJudul.setHorizontalAlignment(SwingConstants.CENTER);
		lblJudul.setFont(new Font("Vivaldi", Font.BOLD, 25));
		lblJudul.setBounds(86, 47, 162, 46);
		contentPane.add(lblJudul);
		
		JLabel lblPelangganBaru = new JLabel("Pelanggan baru?");
		lblPelangganBaru.setFont(new Font("Montserrat", Font.PLAIN, 8));
		lblPelangganBaru.setBounds(10, 270, 72, 18);
		contentPane.add(lblPelangganBaru);
		
		JButton btnDaftar = new JButton("Daftar");
		btnDaftar.setHorizontalAlignment(SwingConstants.LEFT);
		btnDaftar.setForeground(Color.BLACK);
		btnDaftar.setFont(new Font("Montserrat", Font.PLAIN, 8));
		btnDaftar.setBackground(UIManager.getColor("Button.background"));
		btnDaftar.setBounds(79, 270, 60, 18);
		contentPane.add(btnDaftar);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(32, 104, 280, 155);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Masuk");
		btnNewButton_1.setBounds(88, 121, 89, 23);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userValue = txtUsername.getText();
				String passValue = txtPassword.getText();
				
				User user = new User(userValue, passValue);
				
				try {
					ValidationUtil.validate(user);
					LoginService loginService = new LoginService();
					if(loginService.authenticate(user)) {
						System.out.println("Login successful!");
						new MainFrame().setVisible(true);
						dispose();
					} else {
						System.out.println("Invalid username or password.");
						JOptionPane.showMessageDialog(null, "Login Gagal, Invalid username or password.");
					}
				} catch (NullPointerException | ValidationException exception) {
					System.out.println("Data tidak valid : " + exception.getMessage());
					JOptionPane.showMessageDialog(null, "Login Gagal: "+exception.getMessage());
				} finally {
					System.out.println("Selalu di eksekusi");
				}
			}
		});
		btnNewButton_1.setFont(new Font("Montserrat", Font.PLAIN, 14));
		
		JButton btnLupaKataSandi = new JButton("Lupa kata sandi");
		btnLupaKataSandi.setBounds(170, 95, 100, 18);
		panel.add(btnLupaKataSandi);
		btnLupaKataSandi.setForeground(Color.BLACK);
		btnLupaKataSandi.setFont(new Font("Montserrat", Font.PLAIN, 8));
		btnLupaKataSandi.setBackground(UIManager.getColor("Button.background"));
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 70, 81, 18);
		panel.add(lblPassword);
		lblPassword.setFont(new Font("Montserrat", Font.PLAIN, 14));
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(10, 40, 81, 18);
		panel.add(lblUsername);
		lblUsername.setFont(new Font("Montserrat", Font.PLAIN, 14));
		
		txtUsername = new JTextField();
		txtUsername.setBounds(101, 39, 169, 20);
		panel.add(txtUsername);
		txtUsername.setFont(new Font("Montserrat", Font.PLAIN, 14));
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setFont(new Font("Montserrat", Font.PLAIN, 14));
		txtPassword.setColumns(10);
		txtPassword.setBounds(101, 70, 169, 20);
		panel.add(txtPassword);
	}
}
