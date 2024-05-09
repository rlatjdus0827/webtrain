package com.shinhan.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TrainDTO {
	private String trn_id;
	private String trn_pw;
	private String trn_name;
	private String trn_email;
	private String trn_phone;
}
