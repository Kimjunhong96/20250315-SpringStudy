package com.sist.vo;
/*
 *  1. ���� ��� / ����
 *  2. �����ͺ��̽� ���� => ȭ�� ���
 *  --------------------------- �ݺ�
 */
import java.util.*;

import lombok.Data;
// �ʼ� => CRUD 
@Data
public class BoardVO {
	private int no,hit;
	private String name,subject,content,pwd,dbday;
	private Date regdate;
}
