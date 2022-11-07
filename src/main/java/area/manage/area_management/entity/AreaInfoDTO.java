package area.manage.area_management.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author: Jinglin
 * @Date: 2022/10/27
 * @Description:
 */
@Data
public class AreaInfoDTO {
    /**
     * 区域id
     */
    private String id;

    /**
     * 区域名称
     */
    private String name;

    /**
     * 区域类型：地理围栏（不许出）、地理围栏（不许进）、禁飞
     */
    private String type;

    /**
     * 区域形状：圆形、多边形
     */
    private String shape;

    /**
     * 如果是多边形则点集
     */
    private List<Double[]> pointsList;

    /**
     * 如果是圆形则圆心
     */
    private List<Double> center;

    /**
     * 如果是圆形则半径
     */
    private Double radius;

    /**
     * 最低高度
     */
    private Double altLow;

    /**
     * 最高高度
     */
    private Double altHigh;

    /**
     * 围栏生效开始时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime startTime;

    /**
     * 围栏生效结束时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime endTime;

    /**
     * 创建时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime modifyTime;

    /**
     * 创建者
     */
    private String creator;

    /**
     * 备注
     */
    private String note;

    /**
     * 扩展字段
     */
    private String extend;
}
