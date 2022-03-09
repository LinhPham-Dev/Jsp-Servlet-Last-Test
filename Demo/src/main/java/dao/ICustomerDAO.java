package dao;

import java.util.List;

import utils.Customer;

public interface ICustomerDAO {
	public List<Customer> list(String sql);

	public boolean insert(Customer c);

	public Customer findById(String findId);

	public boolean update(Customer c);

	public boolean delete(String deleteId);
}
