package com.accolite.Rest_Assignment.Person_Rest_Assignment.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.accolite.Rest_Assignment.Person_Rest_Assignment.Model.DB_Connection;
import com.accolite.Rest_Assignment.Person_Rest_Assignment.Model.Person;

public class PersonService {

	Connection con;
	Statement stmt;
	List<Person> persons = new ArrayList<Person>();

	public PersonService() {
		try {
			con = DB_Connection.get_Db_Connection();
			stmt = con.createStatement();
			System.out.println("Success");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String addPerson(Person obj) {
		try {
			String query = "insert into person VALUES (" + obj.getP_id() + ", '" + obj.getName() + "', '"
					+ obj.getEmail() + "', '" + obj.getPhone() + "')";
			int rs = stmt.executeUpdate(query);
			if (rs == 1) {
				return "Successfully added " + obj.getName();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Failed to add " + obj.getName();
	}

	public List<Person> getAllPersons() {
		try {
			String query = "select * from person";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				persons.add(new Person(Integer.parseInt(rs.getString("p_id")), rs.getString("name"),
						rs.getString("email"), rs.getString("phone")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return persons;
	}

	public Person getPersonbyId(int id) {
		try {
			String query = "select * from person where p_id = " + id;
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				return new Person(Integer.parseInt(rs.getString("p_id")), rs.getString("name"),
						rs.getString("email"), rs.getString("phone"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Person updatePerson(Person obj) {
		if(getPersonbyId(obj.getP_id()) == null) {
			return null;
		}
		String query = "update person SET name = '" + obj.getName() + "', email = '" + obj.getEmail() 
					  +"', phone = '" + obj.getPhone() + "' where p_id = " + obj.getP_id();
		try {
			int rs = stmt.executeUpdate(query);
			if(rs == 1) {
				return getPersonbyId(obj.getP_id());
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return obj;
	}
	
	public String deletePerson(int id) {
		String query = "delete from person where p_id = " + id;
		try {
			int rs  = stmt.executeUpdate(query);
			if(rs == 1) {
				return "Succesfully Deleted Person";
			}
			System.out.println("rs : " + rs);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return "Failed to Delete Person";
		
	}

}
