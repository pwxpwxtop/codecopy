package pwx.codecopy.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class SysCode {

  private Long id;

  //标题
  private String title;

  //标签
  private String label;

  //上传的代码
  private String code;

  private Date createTime;

  private String createBy;

  private Date updateTime;

  private String updateBy;

  private Integer deleteState;


}
