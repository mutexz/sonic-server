package org.cloud.sonic.controller.models.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.gitee.sunchenbin.mybatis.actable.annotation.*;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlCharsetConstant;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlEngineConstant;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.cloud.sonic.controller.models.base.TypeConverter;
import org.cloud.sonic.controller.models.dto.RolesDTO;

import java.io.Serializable;
import java.util.Date;

@Data
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("roles")
@TableComment("角色表 AUTO_INCREMENT=100")
@TableCharset(MySqlCharsetConstant.DEFAULT)
@TableEngine(MySqlEngineConstant.InnoDB)
public class Roles implements Serializable, TypeConverter<Roles, RolesDTO> {
    @TableId(value = "id", type = IdType.AUTO)
    @IsAutoIncrement
    private Integer id;

    @TableField("role_name")
    @Column(value = "role_name", isNull = false, comment = "描述")
    private String roleName;

    @TableField("comment")
    @Column(value = "comment", isNull = false, comment = "描述")
    private String comment;

    @ApiModelProperty(value = "创建时间", example = "2021-08-15 11:36:00")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT)
    @Column(value = "create_time", type = MySqlTypeConstant.DATETIME, isNull = false, comment = "创建时间")
    Date createTime;

    @ApiModelProperty(value = "更新时间", example = "2021-08-15 11:36:00")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @Column(value = "update_time", type = MySqlTypeConstant.DATETIME, comment = "更新时间")
    Date updateTime;

}
