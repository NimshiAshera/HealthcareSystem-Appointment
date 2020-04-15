package com.HealthcareSystem.service.Appointment;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document; 

import com.google.gson.*;

import com.HealthcareSystem.resources.AppointmentResources;


@Path("/Appointments")
public class AppointmentService {
	
	AppointmentResources appointmentObj = new AppointmentResources();
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	
	public String readAppointment()
	 {
		return appointmentObj.readAppointment(); 

	 } 
	
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	
	public String insertAppointment
	(	@FormParam("user_id") String user_id,
		//@FormParam("username") String username,
		@FormParam("doctor_id") String doctor_id,
		//@FormParam("doctor_name") String doctor_name,
		@FormParam("hospital_id") String hospital_id,
		//@FormParam("hospital_name") String hospital_name,
		@FormParam("appointment_time") String appointment_time,
		@FormParam("appointment_date") String appointment_date,
		@FormParam("WardNo") String WardNo)
	
	{
		String output = appointmentObj.insertAppointment(user_id, doctor_id, hospital_id, appointment_time, appointment_date, WardNo);
	
		return output;
	}
	
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	
	public String updateAppointment(String appointmentData)
	{
		//Convert the input string to a JSON object
		JsonObject appointmentObject = new JsonParser().parse(appointmentData).getAsJsonObject();
	
		//Read the values from the JSON object
		String appointment_id = appointmentObject.get("appointment_id").getAsString();
		String user_id = appointmentObject.get("user_id").getAsString();
		//String username = appointmentObject.get("username").getAsString();
		String doctor_id = appointmentObject.get("doctor_id").getAsString();
		//String doctor_name = appointmentObject.get("doctor_name").getAsString();
		String hospital_id = appointmentObject.get("hospital_id").getAsString();
		//String hospital_name = appointmentObject.get("hospital_name").getAsString();
		String appointment_time = appointmentObject.get("appointment_time").getAsString();
		String appointment_date = appointmentObject.get("appointment_date").getAsString();
		String WardNo = appointmentObject.get("WardNo").getAsString();
	 
		String output = appointmentObj.updateAppointment(appointment_id, user_id, doctor_id, hospital_id, appointment_time, appointment_date, WardNo);
	
		return output;
	}
	
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	
	public String deleteAppointment(String appointmentData)
	{
		
		//Convert the input string to an XML document
		Document doc = Jsoup.parse(appointmentData, "", Parser.xmlParser());

		//Read the value from the element <itemID>
		String appointment_id = doc.select("appointment_id").text();
		String output = appointmentObj.deleteAppointment(appointment_id);
		return output;
	}


}
