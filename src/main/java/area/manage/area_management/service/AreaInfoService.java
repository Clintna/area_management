package area.manage.area_management.service;

import area.manage.area_management.bean.AreaInfo;
import area.manage.area_management.entity.AreaInfoDTO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Jinglin
 * @since 2022-10-27
 */
public interface AreaInfoService extends IService<AreaInfo> {
    /**
     * 保存
     * @param areaInfoDTO
     * @return
     */
    String saveOne(AreaInfoDTO areaInfoDTO);

    /**
     * 查询所有
     * @return
     */
    List<AreaInfoDTO> listAll();

    /**
     * 根据名称查询区域
     * @param Name
     * @return
     */
    AreaInfo queryByName(String Name);

    /**
     * 更新
     * @param areaInfoDTO
     * @return
     */
    boolean update(AreaInfoDTO areaInfoDTO);

    /**
     * 获取所有圆形区域
     * @return
     */
    List<AreaInfoDTO> listCircles();

    /**
     * 获取所有多边形区域
     * @return
     */
    List<AreaInfoDTO> listSquares();

    /**
     * 根据类型筛选
     * @param type
     * @return
     */
    List<AreaInfoDTO> listByType(String type);
}
