package area.manage.area_management.converter;

import area.manage.area_management.bean.AreaInfo;
import area.manage.area_management.entity.AreaInfoDTO;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * @Author: Jinglin
 * @Date: 2022/10/31
 * @Description:
 */
public class AreaInfoConverter {

    public static AreaInfoDTO infoToDTO(AreaInfo areaInfo){
        AreaInfoDTO areaInfoDTO = new AreaInfoDTO();
        BeanUtils.copyProperties(areaInfo,areaInfoDTO);
        if (!areaInfoDTO.getShape().equals("circle")){
            JSONArray array = JSONArray.parseArray(areaInfo.getPoints());
            final List<Double[]> list1 = array.toJavaObject(List.class);

//                List<List> lists = array.toJavaList(List.class);
            areaInfoDTO.setPointsList(list1);
        }else {
            JSONArray array = JSONArray.parseArray(areaInfo.getCenter());
            List<Double> doubles = array.toJavaObject(List.class);
            areaInfoDTO.setCenter(doubles);
        }
        return areaInfoDTO;
    }
}
