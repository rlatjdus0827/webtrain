package com.shinhan.dto;


public class ResDTO {
	private String res_code;
	private String mem_id;
	private String les_code;
	
	
	
	public ResDTO() {
		super();
	}
	public ResDTO(String res_code, String mem_id, String les_code) {
		super();
		this.res_code = res_code;
		this.mem_id = mem_id;
		this.les_code = les_code;
	}
	public String getRes_code() {
		return res_code;
	}
	public void setRes_code(String res_code) {
		this.res_code = res_code;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getLes_code() {
		return les_code;
	}
	public void setLes_code(String les_code) {
		this.les_code = les_code;
	}
	@Override
	public String toString() {
		return "[예약 번호 : " + res_code + " | 회원id : " + mem_id + " | 레슨 번호 : " + les_code + "]";
	}
	
	
}