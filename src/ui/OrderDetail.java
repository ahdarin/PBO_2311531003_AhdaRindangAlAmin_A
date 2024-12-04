package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.ServiceRepo;
import model.Service;
import table.TableService;

import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class OrderDetail extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textOrderID;
	private JTextField textTanggal;
	private JTextField textTanggalPengembalian;
	private JTextField textHarga;
	private JTextField textJumlah;
	private JTextField textTotal;
	private JTable tableOrder;

	
	ServiceRepo svr = new ServiceRepo();
	List<Service> ls;
	public String id;
	private JTable tableLayanan;
	
	public void loadTable() {
		ls = svr.show();
		TableService tu = new TableService(ls);
		tableLayanan.setModel(tu);
		tableLayanan.getTableHeader().setVisible(true);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderDetail frame = new OrderDetail();
					frame.setVisible(true);
					frame.loadTable();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OrderDetail() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 904, 682);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel order = new JPanel();
		order.setBackground(new Color(192, 192, 192));
		order.setBounds(10, 11, 277, 623);
		contentPane.add(order);
		order.setLayout(null);
		
		JLabel lblOrderID = new JLabel("Order ID");
		lblOrderID.setFont(new Font("Montserrat", Font.PLAIN, 13));
		lblOrderID.setBounds(10, 11, 108, 27);
		order.add(lblOrderID);
		
		textOrderID = new JTextField();
		textOrderID.setFont(new Font("Montserrat", Font.PLAIN, 12));
		textOrderID.setBounds(10, 38, 255, 27);
		order.add(textOrderID);
		textOrderID.setColumns(10);
		
		JLabel lblPelanggan = new JLabel("Pelanggan");
		lblPelanggan.setFont(new Font("Montserrat", Font.PLAIN, 13));
		lblPelanggan.setBounds(10, 76, 108, 27);
		order.add(lblPelanggan);
		
		JComboBox cbPelanggan = new JComboBox();
		cbPelanggan.setFont(new Font("Montserrat", Font.PLAIN, 12));
		cbPelanggan.setBounds(10, 104, 257, 27);
		order.add(cbPelanggan);
		
		JLabel lblTanggal = new JLabel("Tanggal");
		lblTanggal.setFont(new Font("Montserrat", Font.PLAIN, 13));
		lblTanggal.setBounds(10, 142, 108, 27);
		order.add(lblTanggal);
		
		textTanggal = new JTextField();
		textTanggal.setFont(new Font("Montserrat", Font.PLAIN, 12));
		textTanggal.setColumns(10);
		textTanggal.setBounds(10, 170, 255, 27);
		order.add(textTanggal);
		
		JLabel lblTanggalPengembalian = new JLabel("Tanggal Pengembalian");
		lblTanggalPengembalian.setFont(new Font("Montserrat", Font.PLAIN, 13));
		lblTanggalPengembalian.setBounds(10, 208, 197, 27);
		order.add(lblTanggalPengembalian);
		
		textTanggalPengembalian = new JTextField();
		textTanggalPengembalian.setFont(new Font("Montserrat", Font.PLAIN, 12));
		textTanggalPengembalian.setColumns(10);
		textTanggalPengembalian.setBounds(10, 236, 255, 27);
		order.add(textTanggalPengembalian);
		
		JComboBox cbStatusOrder = new JComboBox();
		cbStatusOrder.setFont(new Font("Montserrat", Font.PLAIN, 12));
		cbStatusOrder.setBounds(10, 302, 257, 27);
		order.add(cbStatusOrder);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Montserrat", Font.PLAIN, 13));
		lblStatus.setBounds(10, 274, 108, 27);
		order.add(lblStatus);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Montserrat", Font.PLAIN, 13));
		lblTotal.setBounds(12, 340, 108, 27);
		order.add(lblTotal);
		
		JLabel lblRp = new JLabel("Rp. 10.000");
		lblRp.setFont(new Font("Montserrat", Font.PLAIN, 16));
		lblRp.setBounds(12, 364, 108, 27);
		order.add(lblRp);
		
		JLabel lblPembayaran = new JLabel("Pembayaran");
		lblPembayaran.setFont(new Font("Montserrat", Font.PLAIN, 13));
		lblPembayaran.setBounds(12, 397, 108, 27);
		order.add(lblPembayaran);
		
		JComboBox cbPembayaran = new JComboBox();
		cbPembayaran.setFont(new Font("Montserrat", Font.PLAIN, 12));
		cbPembayaran.setBounds(12, 425, 257, 27);
		order.add(cbPembayaran);
		
		JLabel lblStatusPembayaran = new JLabel("Status Pembayaran");
		lblStatusPembayaran.setFont(new Font("Montserrat", Font.PLAIN, 13));
		lblStatusPembayaran.setBounds(10, 463, 164, 27);
		order.add(lblStatusPembayaran);
		
		JComboBox cbStatusPembayaran = new JComboBox();
		cbStatusPembayaran.setFont(new Font("Montserrat", Font.PLAIN, 12));
		cbStatusPembayaran.setBounds(10, 491, 257, 27);
		order.add(cbStatusPembayaran);
		
		JButton btnSimpan = new JButton("Simpan");
		btnSimpan.setFont(new Font("Montserrat", Font.PLAIN, 11));
		btnSimpan.setBounds(29, 556, 89, 23);
		order.add(btnSimpan);
		
		JButton btnBatal = new JButton("Batal");
		btnBatal.setFont(new Font("Montserrat", Font.PLAIN, 11));
		btnBatal.setBounds(156, 556, 89, 23);
		order.add(btnBatal);
		
		JPanel layanan = new JPanel();
		layanan.setBackground(new Color(192, 192, 192));
		layanan.setBounds(297, 11, 583, 378);
		contentPane.add(layanan);
		layanan.setLayout(null);
		
		JLabel lblLayanan = new JLabel("Layanan");
		lblLayanan.setFont(new Font("Montserrat", Font.PLAIN, 13));
		lblLayanan.setBounds(10, 0, 108, 27);
		layanan.add(lblLayanan);
		
		JLabel lblHargakg = new JLabel("Harga/Kg");
		lblHargakg.setFont(new Font("Montserrat", Font.PLAIN, 13));
		lblHargakg.setBounds(10, 209, 197, 27);
		layanan.add(lblHargakg);
		
		textHarga = new JTextField();
		textHarga.setFont(new Font("Montserrat", Font.PLAIN, 12));
		textHarga.setColumns(10);
		textHarga.setBounds(10, 237, 255, 27);
		layanan.add(textHarga);
		
		JLabel lblJumlah = new JLabel("Jumlah");
		lblJumlah.setFont(new Font("Montserrat", Font.PLAIN, 13));
		lblJumlah.setBounds(10, 270, 197, 27);
		layanan.add(lblJumlah);
		
		textJumlah = new JTextField();
		textJumlah.setFont(new Font("Montserrat", Font.PLAIN, 12));
		textJumlah.setColumns(10);
		textJumlah.setBounds(10, 298, 255, 27);
		layanan.add(textJumlah);
		
		JLabel lblTotal_1 = new JLabel("Total");
		lblTotal_1.setFont(new Font("Montserrat", Font.PLAIN, 13));
		lblTotal_1.setBounds(318, 270, 197, 27);
		layanan.add(lblTotal_1);
		
		textTotal = new JTextField();
		textTotal.setFont(new Font("Montserrat", Font.PLAIN, 12));
		textTotal.setColumns(10);
		textTotal.setBounds(318, 298, 255, 27);
		layanan.add(textTotal);
		
		JButton btnSimpanlayanan = new JButton("Simpan");
		btnSimpanlayanan.setFont(new Font("Montserrat", Font.PLAIN, 11));
		btnSimpanlayanan.setBounds(78, 336, 89, 23);
		layanan.add(btnSimpanlayanan);
		
		JButton btnUbah = new JButton("Ubah");
		btnUbah.setFont(new Font("Montserrat", Font.PLAIN, 11));
		btnUbah.setBounds(177, 336, 89, 23);
		layanan.add(btnUbah);
		
		JButton btnHapus = new JButton("Hapus");
		btnHapus.setFont(new Font("Montserrat", Font.PLAIN, 11));
		btnHapus.setBounds(276, 336, 89, 23);
		layanan.add(btnHapus);
		
		JButton btnBatal_1 = new JButton("Batal");
		btnBatal_1.setFont(new Font("Montserrat", Font.PLAIN, 11));
		btnBatal_1.setBounds(375, 336, 89, 23);
		layanan.add(btnBatal_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 25, 563, 183);
		layanan.add(scrollPane);
		
		tableLayanan = new JTable();
		scrollPane.setViewportView(tableLayanan);
		tableLayanan.setFont(new Font("Montserrat", Font.PLAIN, 11));
		tableLayanan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textHarga.setText(tableLayanan.getValueAt(tableLayanan.getSelectedRow(),3).toString());

			}
		});
		
		JPanel tabelOrder = new JPanel();
		tabelOrder.setBounds(297, 400, 583, 234);
		contentPane.add(tabelOrder);
		tabelOrder.setLayout(null);
		
		tableOrder = new JTable();
		tableOrder.setFont(new Font("Montserrat", Font.PLAIN, 11));
		tableOrder.setBounds(0, 0, 583, 234);
		tabelOrder.add(tableOrder);
	}
}
