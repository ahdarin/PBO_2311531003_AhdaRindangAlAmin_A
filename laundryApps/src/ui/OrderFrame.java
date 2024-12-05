package ui;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.OrderRepo;
import model.Order;
import table.TableOrder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrderFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblOrder;
	
	OrderRepo repo_od = new OrderRepo();
	List<Order> ls_od;
	String order_id="";
	
	public void loadTableOrder() {
		ls_od = repo_od.show();
		TableOrder tu = new TableOrder(ls_od);
		tblOrder.setModel(tu);
		tblOrder.getTableHeader().setVisible(true);
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderFrame frame = new OrderFrame();
					frame.setVisible(true);
					frame.loadTableOrder();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OrderFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 563, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblJudul = new JLabel("DATA ORDERAN");
		lblJudul.setBounds(10, 11, 131, 29);
		contentPane.add(lblJudul);
		
		JButton btnOrder = new JButton("Buat Orderan");
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderDetailFrame odf = new OrderDetailFrame();
				odf.setVisible(true);
				odf.loadTableDetail();
				odf.loadTableService();
			}
		});
		btnOrder.setBounds(10, 64, 119, 23);
		contentPane.add(btnOrder);
		
		JButton btnEditDetail = new JButton("Edit/Detail");
		btnEditDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditDetail.setBounds(390, 64, 155, 23);
		contentPane.add(btnEditDetail);
		
		JButton btnHapus = new JButton("Hapus");
		btnHapus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(order_id!="") {
					repo_od.delete(order_id);
				} else {
					JOptionPane.showMessageDialog(null, "Pilih data yang akan dihapus");
				}
			}
		});
		btnHapus.setBounds(288, 64, 89, 23);
		contentPane.add(btnHapus);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 98, 535, 242);
		contentPane.add(scrollPane);
		
		tblOrder = new JTable();
		scrollPane.setViewportView(tblOrder);
	}
}
