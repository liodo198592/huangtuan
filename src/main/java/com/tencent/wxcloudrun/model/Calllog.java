package com.tencent.wxcloudrun.model;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * @Description: 调用记录
 * @Author: jeecg-boot
 * @Date:   2024-10-23
 * @Version: V1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="calllog对象", description="调用记录")
public class Calllog {
    
	/**id*/
	@TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "id")
	private java.lang.Integer id;
	/**desc*/
	@Excel(name = "descri", width = 15)
    @ApiModelProperty(value = "descri")
	private java.lang.String descri;
	/**time*/
	@Excel(name = "time", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "time")
	private java.util.Date time;
}
