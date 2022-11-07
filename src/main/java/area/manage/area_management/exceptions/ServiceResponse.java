package area.manage.area_management.exceptions;

import area.manage.area_management.enums.ErrorCodeEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * 统一接口返回值
 *
 * @author Jinglin
 */
@Data
public class ServiceResponse<T> implements Serializable {

    private T data;

    private String code;

    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)//如果为null则不进行序列化
    private String error;

    public ServiceResponse(RuntimeException e) {
        this.setCode(ErrorCodeEnum.FAILED_CODE.getCode());
        this.setMessage(ErrorCodeEnum.FAILED_CODE.getMsg());
//        StringBuilder buffer = new StringBuilder(e.getMessage()).append(",堆栈信息：");
//        for (StackTraceElement element : e.getStackTrace()) {
//            String className = element.getClassName();
//            if (className.contains("com.bhhyy.aircraft")) {
//                buffer.append(className).append("（")
//                        .append(element.getMethodName()).append("：")
//                        .append(element.getLineNumber()).append("）。")
//                        .append(System.lineSeparator());
//            }
//        }
        this.setError(e.getMessage());
    }
}
