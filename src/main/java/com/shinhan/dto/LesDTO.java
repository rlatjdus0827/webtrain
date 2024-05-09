package com.shinhan.dto;

import java.sql.Date;

public class LesDTO {
	private String les_code;
	private String trn_id;
	String trn_name;
	private String les_machine;
	private Date les_date;
	private String les_start_time;
	private String les_end_time;
	private int les_available_cnt;
	private String les_porg;
	
	
	public LesDTO(String les_code, String trn_id, String trn_name, String les_machine, Date les_date, String les_start_time,
			String les_end_time, int les_available_cnt, String les_porg ) {
		this.les_code = les_code;
		this.trn_id = trn_id;
		this.trn_name = trn_name;
		this.les_machine = les_machine;
		this.les_date = les_date;
		this.les_start_time = les_start_time;
		this.les_end_time = les_end_time;
		this.les_available_cnt = les_available_cnt;
		this.les_porg = les_porg;
	}
	public LesDTO() {
		
	}
	public LesDTO(String les_code, String trn_id, String les_machine, Date les_date, String les_start_time,
			String les_end_time, int les_available_cnt, String les_porg) {
		super();
		this.les_code = les_code;
		this.trn_id = trn_id;
		this.les_machine = les_machine;
		this.les_date = les_date;
		this.les_start_time = les_start_time;
		this.les_end_time = les_end_time;
		this.les_available_cnt = les_available_cnt;
		this.les_porg = les_porg;
	}
	public String getLes_code() {
		return les_code;
	}
	public void setLes_code(String les_code) {
		this.les_code = les_code;
	}
	public String getTrn_id() {
		return trn_id;
	}
	public void setTrn_id(String trn_id) {
		this.trn_id = trn_id;
	}
	public String getLes_machine() {
		return les_machine;
	}
	public void setLes_machine(String les_machine) {
		this.les_machine = les_machine;
	}
	public Date getLes_date() {
		return les_date;
	}
	public void setLes_date(Date les_date) {
		this.les_date = les_date;
	}
	public String getLes_start_time() {
		return les_start_time;
	}
	public void setLes_start_time(String les_start_time) {
		this.les_start_time = les_start_time;
	}
	public String getLes_end_time() {
		return les_end_time;
	}
	public void setLes_end_time(String les_end_time) {
		this.les_end_time = les_end_time;
	}
	public int getLes_available_cnt() {
		return les_available_cnt;
	}
	public void setLes_available_cnt(int les_available_cnt) {
		this.les_available_cnt = les_available_cnt;
	}
	public String getLes_porg() {
		return les_porg;
	}
	public void setLes_porg(String les_porg) {
		this.les_porg = les_porg;
	}
	
	public String getTrn_name() {
		return trn_name;
	}
	public void setTrn_name(String trn_name) {
		this.trn_name = trn_name;
	}
	
	@Override
	public String toString() {
		return "[레슨 번호: " + les_code + " | 강사ID: " + trn_id + " | 기구 종류: " + les_machine + " | 레슨 날짜: "
				+ les_date + " | 시작 시간: " + les_start_time + " | 종료 시간: " + les_end_time
				+ " | 수강 가능 인원: " + les_available_cnt + " | 개인/그룹 여부: " + les_porg + "]";
	}
	
	
}
