package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Panel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

import DAO.CustomerRepo;
import model.Customer;
import table.TableCustomer;

import DAO.UserRepo;
import model.User;
import table.TableUser;

import DAO.ServiceDAO;
import DAO.ServiceRepo;
import model.Service;
import table.TableService;


public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 433, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPengguna = new JButton("Pengguna");
		btnPengguna.setBounds(26, 112, 117, 67);
		contentPane.add(btnPengguna);
		btnPengguna.setForeground(new Color(0, 0, 0));
		btnPengguna.setBackground(new Color(192, 192, 192));
		btnPengguna.setFont(new Font("Montserrat", Font.PLAIN, 11));
		
		JButton btnLayanan = new JButton("Layanan");
		btnLayanan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ServiceFrame servicef = new ServiceFrame();
				servicef.setVisible(true);
				servicef.loadTable();
				dispose();
			}
		});
		btnLayanan.setForeground(Color.BLACK);
		btnLayanan.setFont(new Font("Montserrat", Font.PLAIN, 11));
		btnLayanan.setBackground(Color.LIGHT_GRAY);
		btnLayanan.setBounds(153, 112, 117, 67);
		contentPane.add(btnLayanan);
		
		JButton btnPesanan = new JButton("Pesanan");
		btnPesanan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderFrame orderf = new OrderFrame();
				orderf.setVisible(true);
				orderf.loadTableOrder();
			}
		});
		btnPesanan.setForeground(Color.BLACK);
		btnPesanan.setFont(new Font("Montserrat", Font.PLAIN, 11));
		btnPesanan.setBackground(Color.LIGHT_GRAY);
		btnPesanan.setBounds(26, 202, 117, 67);
		contentPane.add(btnPesanan);
		
		JButton btnLaporan = new JButton("Laporan");
		btnLaporan.setForeground(Color.BLACK);
		btnLaporan.setFont(new Font("Montserrat", Font.PLAIN, 11));
		btnLaporan.setBackground(Color.LIGHT_GRAY);
		btnLaporan.setBounds(280, 202, 117, 67);
		contentPane.add(btnLaporan);
		
		JButton btnPelanggan = new JButton("Pelanggan");
		btnPelanggan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerFrame cusframe = new CustomerFrame();
				cusframe.setVisible(true);
				cusframe.loadTable();
				dispose();
			}
		});
		btnPelanggan.setForeground(Color.BLACK);
		btnPelanggan.setFont(new Font("Montserrat", Font.PLAIN, 11));
		btnPelanggan.setBackground(Color.LIGHT_GRAY);
		btnPelanggan.setBounds(280, 112, 117, 67);
		contentPane.add(btnPelanggan);
		
		JButton btnProfil = new JButton("Profil");
		btnProfil.setForeground(Color.BLACK);
		btnProfil.setFont(new Font("Montserrat", Font.PLAIN, 11));
		btnProfil.setBackground(Color.LIGHT_GRAY);
		btnProfil.setBounds(153, 202, 117, 67);
		contentPane.add(btnProfil);
		
		JButton btnKeluar = new JButton("Keluar");
		btnKeluar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnKeluar.setForeground(Color.BLACK);
		btnKeluar.setFont(new Font("Montserrat", Font.PLAIN, 11));
		btnKeluar.setBackground(Color.LIGHT_GRAY);
		btnKeluar.setBounds(153, 280, 117, 31);
		contentPane.add(btnKeluar);
		
		JLabel lblJudul = new JLabel("Laundry Apps");
		lblJudul.setHorizontalAlignment(SwingConstants.CENTER);
		lblJudul.setFont(new Font("Vivaldi", Font.BOLD, 25));
		lblJudul.setBounds(26, 25, 162, 46);
		contentPane.add(lblJudul);
		btnPengguna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserFrame userf = new UserFrame();
				userf.setVisible(true);
				userf.loadTable();
				dispose();
			}
		});
	}
}
