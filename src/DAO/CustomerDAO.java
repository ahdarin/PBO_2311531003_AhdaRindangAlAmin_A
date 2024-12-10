package DAO;

import java.util.List;
import model.Customer;

public interface CustomerDAO {
	public void save(Customer customer);
	public List<Customer> show();
	public void delete(String id);
	public void update(Customer customer);
}
