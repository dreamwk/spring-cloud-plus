package org.gourd.hu.base.common.entity;


import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 公共实体父类
 * @author gourd
 */
@Data
public class BaseEntity<T> extends Model{

    @ApiModelProperty(value = "主键id")
    @TableId(type= IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "承租人id")
    @TableField(exist = false)
    private Long tenantId;

    @ApiModelProperty(value = "创建人")
    @TableField(value = "created_by",fill = FieldFill.INSERT)
    private Long createdBy;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "created_time",fill = FieldFill.INSERT)
    private Date createdTime;

    @ApiModelProperty(value = "更新人")
    @TableField(value = "updated_by",fill = FieldFill.INSERT_UPDATE)
    private Long updatedBy;

    @ApiModelProperty(value = "更新时间")
    @TableField(value = "updated_time",fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    @ApiModelProperty(value = "版本号")
    @Version
    @TableField(fill = FieldFill.INSERT)
    private Long version;

    @ApiModelProperty(value = "是否已删除")
    @TableLogic
    @TableField(value = "is_deleted",fill = FieldFill.INSERT)
    private Boolean deleted;

    @ApiModelProperty(value = "冗余属性")
    private String attribute;

    @Override
    protected Serializable pkVal() {
        return null;
    }
}
