package com.HealthcareSystem.model;

public class AppointmentView {
	
	private int ref_id;
	private int doctor_id;
	private int doctor_name;
	private int hospital_id;
	private int name;
	private int appointment_time;
	private int appointment_date;
	private int WardNo;
	
	public AppointmentView() {
		
	}

	public int getRef_id() {
		return ref_id;
	}

	public void setRef_id(int ref_id) {
		this.ref_id = ref_id;
	}

	public int getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}

	public int getDoctor_name() {
		return doctor_name;
	}

	public void setDoctor_name(int doctor_name) {
		this.doctor_name = doctor_name;
	}

	public int getHospital_id() {
		return hospital_id;
	}

	public void setHospital_id(int hospital_id) {
		this.hospital_id = hospital_id;
	}

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public int getAppointment_time() {
		return appointment_time;
	}

	public void setAppointment_time(int appointment_time) {
		this.appointment_time = appointment_time;
	}

	public int getAppointment_date() {
		return appointment_date;
	}

	public void setAppointment_date(int appointment_date) {
		this.appointment_date = appointment_date;
	}

	public int getWardNo() {
		return WardNo;
	}

	public void setWardNo(int wardNo) {
		WardNo = wardNo;
	}




}
