package com.sist.vo;
import java.util.*;

import lombok.Data;
@Data
public class BoardVO {
  private int no,hit,group_id,group_step,group_tab,root,depth;
  private String name,subject,content,pwd;
  private Date regdate;
}
