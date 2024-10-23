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
 * @Description: 阵容
 * @Author: jeecg-boot
 * @Date:   2024-10-22
 * @Version: V1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="team对象", description="阵容")
public class Team {
    
	/**tongmeng*/
	@Excel(name = "tongmeng", width = 15)
    @ApiModelProperty(value = "tongmeng")
	private java.lang.String tongmeng;
	/**fenzu*/
	@Excel(name = "fenzu", width = 15)
    @ApiModelProperty(value = "fenzu")
	private java.lang.String fenzu;
	/**wanjia*/
	@Excel(name = "wanjia", width = 15)
    @ApiModelProperty(value = "wanjia")
	private java.lang.String wanjia;
	/**duiwu*/
	@Excel(name = "duiwu", width = 15)
    @ApiModelProperty(value = "duiwu")
	private java.lang.String duiwu;
	/**zhuangtai*/
	@Excel(name = "zhuangtai", width = 15)
    @ApiModelProperty(value = "zhuangtai")
	private java.lang.String zhuangtai;
	/**daying*/
	@Excel(name = "daying", width = 15)
    @ApiModelProperty(value = "daying")
	private java.lang.String daying;
	/**zhongjun*/
	@Excel(name = "zhongjun", width = 15)
    @ApiModelProperty(value = "zhongjun")
	private java.lang.String zhongjun;
	/**qianfeng*/
	@Excel(name = "qianfeng", width = 15)
    @ApiModelProperty(value = "qianfeng")
	private java.lang.String qianfeng;
	/**zhuli*/
	@Excel(name = "zhuli", width = 15)
    @ApiModelProperty(value = "zhuli")
	private java.lang.String zhuli;
	/**hongdu*/
	@Excel(name = "hongdu", width = 15)
    @ApiModelProperty(value = "hongdu")
	private java.lang.String hongdu;
	/**wujiangdengji*/
	@Excel(name = "wujiangdengji", width = 15)
    @ApiModelProperty(value = "wujiangdengji")
	private java.lang.String wujiangdengji;
	/**wuqijuexing*/
	@Excel(name = "wuqijuexing", width = 15)
    @ApiModelProperty(value = "wuqijuexing")
	private java.lang.String wuqijuexing;
	/**zuidabingli*/
	@Excel(name = "zuidabingli", width = 15)
    @ApiModelProperty(value = "zuidabingli")
	private java.lang.String zuidabingli;
	/**zuihoushijian*/
	@Excel(name = "zuihoushijian", width = 15)
    @ApiModelProperty(value = "zuihoushijian")
	private java.lang.String zuihoushijian;
	/**chuduiwuxiaoshi*/
	@Excel(name = "chuduiwuxiaoshi", width = 15)
    @ApiModelProperty(value = "chuduiwuxiaoshi")
	private java.lang.String chuduiwuxiaoshi;
	/**shashang*/
	@Excel(name = "shashang", width = 15)
    @ApiModelProperty(value = "shashang")
	private java.lang.String shashang;
	/**zhansun*/
	@Excel(name = "zhansun", width = 15)
    @ApiModelProperty(value = "zhansun")
	private java.lang.String zhansun;
	/**diwozhansunbi*/
	@Excel(name = "diwozhansunbi", width = 15)
    @ApiModelProperty(value = "diwozhansunbi")
	private java.lang.String diwozhansunbi;
	/**jingong*/
	@Excel(name = "jingong", width = 15)
    @ApiModelProperty(value = "jingong")
	private java.lang.String jingong;
	/**fangshou*/
	@Excel(name = "fangshou", width = 15)
    @ApiModelProperty(value = "fangshou")
	private java.lang.String fangshou;
	/**zhuliduizhan*/
	@Excel(name = "zhuliduizhan", width = 15)
    @ApiModelProperty(value = "zhuliduizhan")
	private java.lang.String zhuliduizhan;
	/**shengli*/
	@Excel(name = "shengli", width = 15)
    @ApiModelProperty(value = "shengli")
	private java.lang.String shengli;
	/**zhanbai*/
	@Excel(name = "zhanbai", width = 15)
    @ApiModelProperty(value = "zhanbai")
	private java.lang.String zhanbai;
	/**pingju*/
	@Excel(name = "pingju", width = 15)
    @ApiModelProperty(value = "pingju")
	private java.lang.String pingju;
	/**shenglv*/
	@Excel(name = "shenglv", width = 15)
    @ApiModelProperty(value = "shenglv")
	private java.lang.String shenglv;
	/**bailv*/
	@Excel(name = "bailv", width = 15)
    @ApiModelProperty(value = "bailv")
	private java.lang.String bailv;
	/**pinglv*/
	@Excel(name = "pinglv", width = 15)
    @ApiModelProperty(value = "pinglv")
	private java.lang.String pinglv;
	/**dayingsiwanglv*/
	@Excel(name = "dayingsiwanglv", width = 15)
    @ApiModelProperty(value = "dayingsiwanglv")
	private java.lang.String dayingsiwanglv;
	/**zhongjunsiwanglv*/
	@Excel(name = "zhongjunsiwanglv", width = 15)
    @ApiModelProperty(value = "zhongjunsiwanglv")
	private java.lang.String zhongjunsiwanglv;
	/**qianfengsiwanglv*/
	@Excel(name = "qianfengsiwanglv", width = 15)
    @ApiModelProperty(value = "qianfengsiwanglv")
	private java.lang.String qianfengsiwanglv;
	/**dayingzhuzhanfa*/
	@Excel(name = "dayingzhuzhanfa", width = 15)
    @ApiModelProperty(value = "dayingzhuzhanfa")
	private java.lang.String dayingzhuzhanfa;
	/**dayingzhanfa1*/
	@Excel(name = "dayingzhanfa1", width = 15)
    @ApiModelProperty(value = "dayingzhanfa1")
	private java.lang.String dayingzhanfa1;
	/**dayingzhanfa2*/
	@Excel(name = "dayingzhanfa2", width = 15)
    @ApiModelProperty(value = "dayingzhanfa2")
	private java.lang.String dayingzhanfa2;
	/**zhongjunzhuzhanfa*/
	@Excel(name = "zhongjunzhuzhanfa", width = 15)
    @ApiModelProperty(value = "zhongjunzhuzhanfa")
	private java.lang.String zhongjunzhuzhanfa;
	/**zhongjunzhuzhanfa1*/
	@Excel(name = "zhongjunzhuzhanfa1", width = 15)
    @ApiModelProperty(value = "zhongjunzhuzhanfa1")
	private java.lang.String zhongjunzhuzhanfa1;
	/**zhongjunzhuzhanfa2*/
	@Excel(name = "zhongjunzhuzhanfa2", width = 15)
    @ApiModelProperty(value = "zhongjunzhuzhanfa2")
	private java.lang.String zhongjunzhuzhanfa2;
	/**qianfengzhuzhanfa*/
	@Excel(name = "qianfengzhuzhanfa", width = 15)
    @ApiModelProperty(value = "qianfengzhuzhanfa")
	private java.lang.String qianfengzhuzhanfa;
	/**qianfengzhuzhanfa1*/
	@Excel(name = "qianfengzhuzhanfa1", width = 15)
    @ApiModelProperty(value = "qianfengzhuzhanfa1")
	private java.lang.String qianfengzhuzhanfa1;
	/**qianfengzhuzhanfa2*/
	@Excel(name = "qianfengzhuzhanfa2", width = 15)
    @ApiModelProperty(value = "qianfengzhuzhanfa2")
	private java.lang.String qianfengzhuzhanfa2;
	/**wuqi*/
	@Excel(name = "wuqi", width = 15)
    @ApiModelProperty(value = "wuqi")
	private java.lang.String wuqi;
	/**bingzhong*/
	@Excel(name = "bingzhong", width = 15)
    @ApiModelProperty(value = "bingzhong")
	private java.lang.String bingzhong;
	/**wujiangjuexing*/
	@Excel(name = "wujiangjuexing", width = 15)
    @ApiModelProperty(value = "wujiangjuexing")
	private java.lang.String wujiangjuexing;
	/**zhanbao*/
	@Excel(name = "zhanbao", width = 15)
    @ApiModelProperty(value = "zhanbao")
	private java.lang.String zhanbao;
	/**id*/
	@TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "id")
	private java.lang.Integer id;
}
