package DAO;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import config.DatabaseHelper;
import model.Service;

public class ServiceRepo implements ServiceDAO{
	
	private Connection connection;
	final String insert = "INSERT INTO service (jenis, satuan, harga, status) VALUES (?,?,?,?);";
	final String select = "SELECT * FROM service;";
	final String delete = "DELETE FROM service WHERE id=?;";
	final String update = "UPDATE service SET jenis=?, satuan=?, harga=?, status=? WHERE id=?;";
	

	public ServiceRepo() {
		connection = DatabaseHelper.getConnection();
	}

	@Override
	public void save(Service service) {
		PreparedStatement st = null;
		try {
			st = connection.prepareStatement(insert);
			st.setString(1, service.getJenis());
			st.setString(2, service.getSatuan());
			st.setInt(3, service.getHarga());
			st.setString(4, service.getStatus());
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
	public List<Service> show() {
		List<Service> ls = null;
		try {
			ls = new ArrayList<Service>();
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(select);
			while(rs.next()) {
				Service service = new Service();
				service.setId(rs.getString("id"));
				service.setJenis(rs.getString("jenis"));
				service.setSatuan(rs.getString("satuan"));
				service.setHarga(rs.getInt("harga"));
				service.setStatus(rs.getString("status"));
				ls.add(service);
			}
		} catch(SQLException e) {
			Logger.getLogger(ServiceDAO.class.getName()).log(Level.SEVERE, null, e);
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
	public void update(Service service) {
		PreparedStatement st = null;
		try {
			st= connection.prepareStatement(update);
			st.setString(1, service.getJenis());
			st.setString(2, service.getSatuan());
			st.setInt(3, service.getHarga());
			st.setString(4, service.getStatus());
			st.setString(5, service.getId());
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
