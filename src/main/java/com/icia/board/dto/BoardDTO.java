package com.icia.board.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class BoardDTO {
	
	private long b_number;
	private String b_writer;
	private String b_password;
	private String b_title;
	private String b_contentsl;
	private int b_hits;
	private Timestamp b_date;

}
