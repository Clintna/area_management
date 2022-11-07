package area.manage.area_management.enums;

/**
 * @Author: Jinglin
 * @Date: 2022/10/31
 * @Description:
 */
public enum AreaTypeEnum {

    FENCE("fence", "fence"),
    FENCE_C("fence_c","fence_c"),
    FENCE_O("fence_o","fence_o"),
    RESTRICTED("restricted", "restricted");

    private String code;
    private String msg;
    private AreaTypeEnum(String code, String msg) {
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
