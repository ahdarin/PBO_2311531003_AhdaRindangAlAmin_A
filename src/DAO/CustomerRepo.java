package DAO;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import config.DatabaseHelper;
import model.Customer;

public class CustomerRepo implements CustomerDAO{
	
	private Connection connection;
	final String insert = "INSERT INTO customer (name, address, phone) VALUES (?,?,?);";
	final String select = "SELECT * FROM customer;";
	final String delete = "DELETE FROM customer WHERE id=?;";
	final String update = "UPDATE customer SET name=?, address=?, phone=? WHERE id=?;";
	

	public CustomerRepo() {
		connection = DatabaseHelper.getConnection();
	}

	@Override
	public void save(Customer customer) {
		PreparedStatement st = null;
		try {
			st = connection.prepareStatement(insert);
			st.setString(1, customer.getNama());
			st.setString(2, customer.getAlamat());
			st.setString(3, customer.getNoHP());
			st.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				st.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	}

	@Override
	public List<Customer> show() {
		List<Customer> ls = null;
		try {
			ls = new ArrayList<Customer>();
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(select);
			while(rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getString("id"));
				customer.setNama(rs.getString("name"));
				customer.setAlamat(rs.getString("address"));
				customer.setNoHP(rs.getString("phone"));
				ls.add(customer);
			}
		} catch(SQLException e) {
			Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		return ls;
	} 

	@Override
	public void delete(String id) {
		PreparedStatement st = null;
		try {
			st = connection.prepareStatement(delete);
			st.setString(1, id);
			st.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}	
		}
		
	}

	@Override
	public void update(Customer customer) {
		PreparedStatement st = null;
		try {
			st= connection.prepareStatement(update);
			st.setString(1, customer.getNama());
			st.setString(2, customer.getAlamat());
			st.setString(3, customer.getNoHP());
			st.setString(4, customer.getId());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}}
		
	}
