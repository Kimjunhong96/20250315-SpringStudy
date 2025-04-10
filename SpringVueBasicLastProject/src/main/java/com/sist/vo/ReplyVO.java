package com.sist.vo;

import java.util.Date;

import lombok.Data;
@Data
public class ReplyVO {
	private int no,bno,group_id,group_step,group_tab,root;
	private String id,name,msg,dbday;
	private Date regdate;
}
