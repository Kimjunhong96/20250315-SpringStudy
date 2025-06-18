package com.sist.vo;

import lombok.Data;
import java.util.*;
@Data
public class CommentVO {
	private int no,cno,type,group_id,group_step;
	private String userid,username,sex,msg,dbday;
	private Date regdate;
}
