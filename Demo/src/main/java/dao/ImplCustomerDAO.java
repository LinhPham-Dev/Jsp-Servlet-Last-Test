package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import connect.BKConnection;
import utils.Customer;

public class ImplCustomerDAO implements ICustomerDAO {

	public ImplCustomerDAO() {
	}

	@Override
	public List<Customer> list(String sql) {
		try {
			Connection con = BKConnection.GetConnection();
			PreparedStatement ppst = con.prepareStatement(sql);
			ResultSet rs = ppst.executeQuery();

			List<Customer> listCus = new LinkedList<Customer>();

			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				boolean gender = rs.getBoolean("gender");
				Date birthday = rs.getDate("birthday");
				String hometown = rs.getString("hometown");
				String email = rs.getString("email");
				String phone = rs.getString("phone");

				Customer c = new Customer(id, name, gender, birthday, hometown, email, phone);

				listCus.add(c);
			}

			return listCus;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean insert(Customer c) {
		try {
			Connection con = BKConnection.GetConnection();
			String sql = "INSERT INTO Customer VALUES (?,?,?,?,?,?,?)";
			PreparedStatement ppst = con.prepareStatement(sql);

			ppst.setString(1, c.getId());
			ppst.setNString(2, c.getName());
			ppst.setBoolean(3, c.isGender());
			ppst.setDate(4, c.getBirthday());
			ppst.setNString(5, c.getHometown());
			ppst.setString(6, c.getEmail());
			ppst.setString(7, c.getPhone());

			return ppst.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public Customer findById(String findId) {
		try {
			Connection con = BKConnection.GetConnection();
			String sql = "SELECT * FROM Customer WHERE id = ?";

			PreparedStatement ppst = con.prepareStatement(sql);
			ppst.setNString(1, findId);

			ResultSet rs = ppst.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				boolean gender = rs.getBoolean("gender");
				Date birthday = rs.getDate("birthday");
				String hometown = rs.getString("hometown");
				String email = rs.getString("email");
				String phone = rs.getString("phone");

				Customer c = new Customer(id, name, gender, birthday, hometown, email, phone);

				return c;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean update(Customer c) {
		try {
			Connection con = BKConnection.GetConnection();
			String sql = "UPDATE Customer SET " + "name = ?, " + "gender = ?, " + "birthday = ?, " + "hometown = ?,"
					+ "	email = ?, " + "phone = ? " + "WHERE id = ?";
			PreparedStatement ppst = con.prepareStatement(sql);

			ppst.setNString(1, c.getName());
			ppst.setBoolean(2, c.isGender());
			ppst.setDate(3, c.getBirthday());
			ppst.setNString(4, c.getHometown());
			ppst.setString(5, c.getEmail());
			ppst.setString(6, c.getPhone());
			ppst.setString(7, c.getId());

			return ppst.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean delete(String deleteId) {
		try {
			Connection con = BKConnection.GetConnection();
			String sql = "DELETE FROM Customer WHERE id = ?";
			PreparedStatement ppst = con.prepareStatement(sql);

			ppst.setNString(1, deleteId);

			return ppst.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

}
