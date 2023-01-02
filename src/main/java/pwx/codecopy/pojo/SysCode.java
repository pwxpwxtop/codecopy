package pwx.codecopy.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class SysCode {

  @TableId(type = IdType.AUTO)
  private Long id;

  //标题
  private String title;

  //标签
  private String label;

  //上传的代码
  private String code;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  @TableField(fill = FieldFill.INSERT)
  private Date createTime;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Date updateTime;


  @TableField(fill = FieldFill.INSERT_UPDATE)
  private String updateBy;

  @TableLogic(value = "0" , delval = "1")
  @TableField(fill = FieldFill.INSERT)
  private Integer deleteState;


}
