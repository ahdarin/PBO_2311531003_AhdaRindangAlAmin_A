package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.ServiceRepo;
import model.Service;
import table.TableService;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.*;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ServiceFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtJenis;
	private JTextField txtSatuan;
	private JTextField txtHarga;
	private JTable tableService;
	JComboBox cbStatus;
	
	public void reset() {
		txtJenis.setText("");
		txtSatuan.setText("");
		txtHarga.setText("");
		cbStatus.setSelectedIndex(0);
	}
	
	ServiceRepo svr = new ServiceRepo();
	List<Service> ls;
	public String id;
	
	public void loadTable() {
		ls = svr.show();
		TableService tu = new TableService(ls);
		tableService.setModel(tu);
		tableService.getTableHeader().setVisible(true);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServiceFrame frame = new ServiceFrame();
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
	public ServiceFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 618);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(10, 11, 423, 265);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblJenis = new JLabel("Jenis");
		lblJenis.setBounds(31, 45, 56, 20);
		panel.add(lblJenis);
		
		txtJenis = new JTextField();
		txtJenis.setBounds(97, 41, 244, 28);
		panel.add(txtJenis);
		txtJenis.setColumns(10);
		
		txtSatuan = new JTextField();
		txtSatuan.setColumns(10);
		txtSatuan.setBounds(97, 84, 244, 28);
		panel.add(txtSatuan);
		
		txtHarga = new JTextField();
		txtHarga.setColumns(10);
		txtHarga.setBounds(97, 128, 244, 28);
		panel.add(txtHarga);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Service service = new Service();
				service.setJenis(txtJenis.getText());
				service.setSatuan(txtSatuan.getText());
				service.setHarga(Integer.parseInt(txtHarga.getText()));
				service.setStatus(cbStatus.getSelectedItem().toString());
				svr.save(service);
				reset();
				loadTable();
			}
		});
		btnSave.setBounds(43, 231, 63, 23);
		panel.add(btnSave);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Service service = new Service();
				service.setJenis(txtJenis.getText());
				service.setSatuan(txtSatuan.getText());
				service.setHarga(Integer.parseInt(txtHarga.getText()));
				service.setStatus(cbStatus.getSelectedItem().toString());
				service.setId(id);
				svr.update(service);
				reset();
				loadTable();
				
			}
		});
		btnUpdate.setBounds(114, 231, 84, 23);
		panel.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(id != null) {
					svr.delete(id);
					reset();
					loadTable();
				} else {
					JOptionPane.showMessageDialog(null, 
							"SIlahkan pilih data yang akan dihapus");
				}
			}
		});
		btnDelete.setBounds(208, 231, 84, 23);
		panel.add(btnDelete);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(302, 231, 84, 23);
		panel.add(btnCancel);
		
		JLabel lblService = new JLabel("Service");
		lblService.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblService.setBounds(10, 11, 56, 23);
		panel.add(lblService);
		
		JLabel lblSatuan = new JLabel("Satuan");
		lblSatuan.setBounds(31, 91, 56, 20);
		panel.add(lblSatuan);
		
		JLabel lblHarga = new JLabel("Harga");
		lblHarga.setBounds(31, 135, 56, 20);
		panel.add(lblHarga);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(31, 177, 56, 20);
		panel.add(lblStatus);
		
		cbStatus = new JComboBox();
		cbStatus.setModel(new DefaultComboBoxModel(new String[] {"Tidak Aktif", "Aktif"}));
		cbStatus.setBounds(97, 176, 244, 21);
		panel.add(cbStatus);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(10, 287, 423, 265);
		contentPane.add(panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 403, 243);
		panel_1.add(scrollPane);
		
		tableService = new JTable();
		scrollPane.setViewportView(tableService);
		tableService.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				id = tableService.getValueAt(tableService.getSelectedRow(),0).toString();
				txtJenis.setText(tableService.getValueAt(tableService.getSelectedRow(),1).toString());
				txtSatuan.setText(tableService.getValueAt(tableService.getSelectedRow(),2).toString());
				txtHarga.setText(tableService.getValueAt(tableService.getSelectedRow(),3).toString());
			}
		});
	}
}
