package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.UserRepo;
import model.User;
import table.TableUser;

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

public class UserFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTable tableUsers;
	
	public void reset() {
		txtName.setText("");
		txtUsername.setText("");
		txtPassword.setText("");
	}
	
	UserRepo usr = new UserRepo();
	List<User> ls;
	public String id;
	
	public void loadTable() {
		ls = usr.show();
		TableUser tu = new TableUser(ls);
		tableUsers.setModel(tu);
		tableUsers.getTableHeader().setVisible(true);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserFrame frame = new UserFrame();
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
	public UserFrame() {
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
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(31, 88, 63, 20);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(31, 132, 63, 20);
		panel.add(lblPassword);
		
		txtName = new JTextField();
		txtName.setBounds(97, 41, 244, 28);
		panel.add(txtName);
		txtName.setColumns(10);
		
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBounds(97, 84, 244, 28);
		panel.add(txtUsername);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(97, 128, 244, 28);
		panel.add(txtPassword);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user = new User();
				user.setNama(txtName.getText());
				user.setUsername(txtUsername.getText());
				user.setPassword(txtPassword.getText());
				usr.save(user);
				reset();
				loadTable();
			}
		});
		btnSave.setBounds(43, 182, 63, 23);
		panel.add(btnSave);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user = new User();
				user.setNama(txtName.getText());
				user.setUsername(txtUsername.getText());
				user.setPassword(txtPassword.getText());
				user.setId(id);
				usr.update(user);
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
					usr.delete(id);
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
				dispose();
			}
		});
		btnCancel.setBounds(302, 182, 84, 23);
		panel.add(btnCancel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(10, 287, 423, 265);
		contentPane.add(panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 403, 243);
		panel_1.add(scrollPane);
		
		tableUsers = new JTable();
		scrollPane.setViewportView(tableUsers);
		tableUsers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				id = tableUsers.getValueAt(tableUsers.getSelectedRow(),0).toString();
				txtName.setText(tableUsers.getValueAt(tableUsers.getSelectedRow(),1).toString());
				txtUsername.setText(tableUsers.getValueAt(tableUsers.getSelectedRow(),2).toString());
				txtPassword.setText(tableUsers.getValueAt(tableUsers.getSelectedRow(),3).toString());
			}
		});
	}
}
