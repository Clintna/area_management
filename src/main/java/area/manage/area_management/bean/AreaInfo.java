package area.manage.area_management.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author Jinglin
 * @since 2022-10-27
 */
@Getter
@Setter
@TableName("area_info")
public class AreaInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 区域id
     */
    @TableId(value = "id")
    private String id;

    /**
     * 区域名称
     */
    @TableField("name")
    private String name;

    /**
     * 区域类型：地理围栏（不许出）、地理围栏（不许进）、禁飞
     */
    @TableField("type")
    private String type;

    /**
     * 区域形状：圆形、多边形
     */
    @TableField("shape")
    private String shape;

    /**
     * 如果是多边形则点集
     */
    @TableField("points")
    private String points;

    /**
     * 如果是圆形则圆心
     */
    @TableField("center")
    private String center;

    /**
     * 如果是圆形则半径
     */
    @TableField("radius")
    private Double radius;

    /**
     * 最低高度
     */
    @TableField("alt_low")
    private Double altLow;

    /**
     * 最高高度
     */
    @TableField("alt_high")
    private Double altHigh;

    /**
     * 围栏生效开始时间
     */
    @TableField("start_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime startTime;

    /**
     * 围栏生效结束时间
     */
    @TableField("end_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime endTime;

    /**
     * 创建时间
     */
    @TableField("create_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @TableField("modify_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime modifyTime;

    /**
     * 创建者
     */
    @TableField("creator")
    private String creator;

    /**
     * 备注
     */
    @TableField("note")
    private String note;

    /**
     * 扩展字段
     */
    @TableField("extend")
    private String extend;


}
