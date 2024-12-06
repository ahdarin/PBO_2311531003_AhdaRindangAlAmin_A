package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.CustomerRepo;
import model.Customer;
import table.TableCustomer;

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

public class CustomerFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtPhone;
	public static JTable tableCustomer;
	
	public void reset() {
		txtName.setText("");
		txtAddress.setText("");
		txtPhone.setText("");
	}
	
	CustomerRepo cusr = new CustomerRepo();
	List<Customer> ls;
	public String id;
	
	public void loadTable() {
		ls = cusr.show();
		TableCustomer tu = new TableCustomer(ls);
		tableCustomer.setModel(tu);
		tableCustomer.getTableHeader().setVisible(true);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerFrame frame = new CustomerFrame();
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
	public CustomerFrame() {
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
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(31, 45, 56, 20);
		panel.add(lblName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(31, 88, 63, 20);
		panel.add(lblAddress);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(31, 132, 63, 20);
		panel.add(lblPhone);
		
		txtName = new JTextField();
		txtName.setBounds(97, 41, 244, 28);
		panel.add(txtName);
		txtName.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(97, 84, 244, 28);
		panel.add(txtAddress);
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(97, 128, 244, 28);
		panel.add(txtPhone);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer customer = new Customer();
				customer.setNama(txtName.getText());
				customer.setAlamat(txtAddress.getText());
				customer.setNoHP(txtPhone.getText());
				cusr.save(customer);
				reset();
				loadTable();
			}
		});
		btnSave.setBounds(43, 182, 63, 23);
		panel.add(btnSave);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer customer = new Customer();
				customer.setNama(txtName.getText());
				customer.setAlamat(txtAddress.getText());
				customer.setNoHP(txtPhone.getText());
				customer.setId(id);
				cusr.update(customer);
				reset();
				loadTable();
				
			}
		});
		btnUpdate.setBounds(114, 182, 84, 23);
		panel.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(id != null) {
					cusr.delete(id);
					reset();
					loadTable();
				} else {
					JOptionPane.showMessageDialog(null, 
							"SIlahkan pilih data yang akan dihapus");
				}
			}
		});
		btnDelete.setBounds(208, 182, 84, 23);
		panel.add(btnDelete);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame mainf = new MainFrame();
				mainf.setVisible(true);
				dispose();
			}
		});
		btnCancel.setBounds(302, 182, 84, 23);
		panel.add(btnCancel);
		
		JLabel lblCustomer = new JLabel("Customer");
		lblCustomer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCustomer.setBounds(10, 11, 96, 23);
		panel.add(lblCustomer);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(10, 287, 423, 265);
		contentPane.add(panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 403, 243);
		panel_1.add(scrollPane);
		
		tableCustomer = new JTable();
		scrollPane.setViewportView(tableCustomer);
		tableCustomer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				id = tableCustomer.getValueAt(tableCustomer.getSelectedRow(),0).toString();
				txtName.setText(tableCustomer.getValueAt(tableCustomer.getSelectedRow(),1).toString());
				txtAddress.setText(tableCustomer.getValueAt(tableCustomer.getSelectedRow(),2).toString());
				txtPhone.setText(tableCustomer.getValueAt(tableCustomer.getSelectedRow(),3).toString());
			}
		});
	}
}
