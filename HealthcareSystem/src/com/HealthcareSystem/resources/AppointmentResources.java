package com.HealthcareSystem.resources;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.xdevapi.Statement;

import com.HealthcareSystem.utils.DBConnection;

public class AppointmentResources {
	
	//read the list of appointments
	
	
			public String readAppointment()
			 {
				String output = "";
								
				try
				{
					
					DBConnection db = new DBConnection();
					Connection conn = null;
					conn = db.getConnection();
					
					if (conn == null)
					{
						return "Error while connecting to the database for reading."; 
					}
			 
					// Prepare the html table to be displayed
					
					output = "<table border=\"1\"><tr><th>Appointment ID</th><th>Patient ID</th><th>Patient Name</th><th>Doctor ID</th><th>Doctor Name</th><th>Hospital ID</th><th>Hospital Name</th><th>Appointment Time</th><th>Appointment Date</th><th>Ward No</th></tr>";
			 
					String query = "select a.appointment_id,u.user_id,u.username,d.doctor_id,d.doctor_name,h.hospital_id,h.name,a.appointment_time,a.appointment_date,a.WardNo from users u, doctor d, hospital h,appointment_room r, appointments a where u.user_id=a.user_id and d.doctor_id=a.doctor_id and h.hospital_id=a.hospital_id and r.appointment_room_id=a.WardNo and h.hospital_id=r.hospital_ID";
				
					PreparedStatement stmt = conn.prepareStatement(query);
					ResultSet rs = stmt.executeQuery(query);
			
					// iterate through the rows in the result set
			 
					while (rs.next())
					{
						String appointment_id = Integer.toString(rs.getInt("appointment_id"));
						String user_id = Integer.toString(rs.getInt("user_id"));
						String username = rs.getString("username");
						String doctor_id = Integer.toString(rs.getInt("doctor_id"));
						String doctor_name = rs.getString("doctor_name");
						String hospital_id = Integer.toString(rs.getInt("hospital_id"));
						String hospital_name = rs.getString("name");
						String appointment_time = rs.getString("appointment_time");
						String appointment_date = rs.getString("appointment_date");
						String WardNo = rs.getString("WardNo");
			
						// Add into the html table
						output += "<tr><td>" + appointment_id + "</td>";
						output += "<td>" + user_id + "</td>";
						output += "<td>" + username + "</td>";
						output += "<td>" + doctor_id + "</td>";
						output += "<td>" + doctor_name + "</td>";
						output += "<td>" + hospital_id + "</td>";
						output += "<td>" + hospital_name + "</td>";
						output += "<td>" + appointment_time + "</td>";
						output += "<td>" + appointment_date + "</td>";
						output += "<td>" + WardNo + "</td>";
			
					}
			
					conn.close();
					// Complete the html table
			
					output += "</table>";
				}
				
				catch (Exception e)
				{
					output = "Error while reading the appointments.";
					System.err.println(e.getMessage());
				}
			
				return output;
			 } 

			
			// insert new appointments.
			
			public String insertAppointment(String user_id, String doctor_id, String hospital_id, String appointment_time, String appointment_date, String WardNo )
			{
				String output = "";
				
				try
				{
					DBConnection db = new DBConnection();
					Connection conn = null;
					conn = db.getConnection();
					
					if (conn == null)
					{
						return "Error while connecting to the database for inserting."; 
					}
			
					// create a prepared statement
			
					String query = " insert into appointments(`appointment_id`,`user_id`,`doctor_id`,`hospital_id`,`appointment_time`,`appointment_date`,`WardNo`)" + " values (?, ?, ?, ?, ?, ?, ?)";
			 
					PreparedStatement preparedStmt = conn.prepareStatement(query);
			
					// binding values
			
					preparedStmt.setInt(1, 0);
					preparedStmt.setString(2, user_id);
					//preparedStmt.setString(3, username);
					preparedStmt.setString(3, doctor_id);
					//preparedStmt.setString(5, doctor_name); 
					preparedStmt.setString(4, hospital_id);
					//preparedStmt.setString(7, hospital_name);
					preparedStmt.setString(5, appointment_time);
					preparedStmt.setString(6, appointment_date); 
					preparedStmt.setString(7, WardNo); 
			
					// execute the statement
					preparedStmt.execute();
					conn.close();
					output = "Inserted successfully";
				}
				catch (Exception e)
				{
					output = "Error while inserting the appointments.";
					System.err.println(e.getMessage());
				}
				
				return output;
			 } 
			
			
			//update appointments
			
			public String updateAppointment(String appointment_id, String user_id, String doctor_id, String hospital_id, String appointment_time, String appointment_date, String WardNo)
			{
				String output = "";
			
				try
				{
					DBConnection db = new DBConnection();
					Connection conn = null;
					conn = db.getConnection();
			
						if (conn == null)
						{
							return "Error while connecting to the database for updating."; }
			 
						// create a prepared statement
						String query = "UPDATE appointments SET user_id=?, doctor_id=?, hospital_id=?, appointment_time=?, appointment_date=?, WardNo=?  WHERE appointment_id=?";
						
						PreparedStatement preparedStmt = conn.prepareStatement(query);
						
						// binding values
						preparedStmt.setString(1, user_id);
						//preparedStmt.setString(2, username);
						preparedStmt.setString(2, doctor_id);
						//preparedStmt.setString(4, doctor_name);
						preparedStmt.setString(3, hospital_id);
						//preparedStmt.setString(6, hospital_name);
						preparedStmt.setString(4, appointment_time);
						preparedStmt.setString(5, appointment_date);
						preparedStmt.setString(6, WardNo);
						preparedStmt.setInt(7, Integer.parseInt(appointment_id)); 
			
						// execute the statement
						preparedStmt.execute();
			
						conn.close();
						output = "Updated successfully";
						}
				
				catch (Exception e)
				{
					output = "Error while updating the appointment.";
					System.err.println(e.getMessage());
				}
				
				return output;
			 } 
			
			
			//delete appointments
			
			public String deleteAppointment(String appointment_id)
			{
				
				String output = "";
				
				try
				{
					
					DBConnection db = new DBConnection();
					Connection conn = null;
					conn = db.getConnection();
				
					if (conn == null)
			
					{
						return "Error while connecting to the database for deleting."; }
			
						// create a prepared statement
						String query = "delete from appointments where appointment_id=?";
						PreparedStatement preparedStmt = conn.prepareStatement(query);
						
						// binding values
						preparedStmt.setInt(1, Integer.parseInt(appointment_id));
			
						// execute the statement
						preparedStmt.execute();
						
						conn.close();
			 
						output = "Deleted successfully";
			
					}
			
					catch (Exception e)
					{
			
						output = "Error while deleting the appointment.";
						System.err.println(e.getMessage());
					}
				return output;
				
				} 
	

}
