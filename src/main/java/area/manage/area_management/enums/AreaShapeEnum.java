package area.manage.area_management.enums;

/**
 * @Author: Jinglin
 * @Date: 2022/10/31
 * @Description:
 */
public enum AreaShapeEnum {

    CIRCLE("circle", "circle"),
    SQUARE("square", "square");

    private String code;
    private String msg;
    private AreaShapeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}
