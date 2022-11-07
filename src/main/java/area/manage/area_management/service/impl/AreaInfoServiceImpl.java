package area.manage.area_management.service.impl;

import area.manage.area_management.bean.AreaInfo;
import area.manage.area_management.converter.AreaInfoConverter;
import area.manage.area_management.entity.AreaInfoDTO;
import area.manage.area_management.enums.AreaShapeEnum;
import area.manage.area_management.enums.AreaTypeEnum;
import area.manage.area_management.enums.ErrorCodeEnum;
import area.manage.area_management.exceptions.BizException;
import area.manage.area_management.mapper.AreaInfoMapper;
import area.manage.area_management.service.AreaInfoService;
import area.manage.area_management.tools.TaskIdGenerator;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.ejb.Local;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Jinglin
 * @since 2022-10-27
 */
@Service
public class AreaInfoServiceImpl extends ServiceImpl<AreaInfoMapper, AreaInfo> implements AreaInfoService {


    @Override
    public String saveOne(AreaInfoDTO areaInfoDTO) {
        System.out.println("1");
        final AreaInfo areaInfo1 = queryByName(areaInfoDTO.getName());
        if (null!=areaInfo1){
            throw new BizException(ErrorCodeEnum.ILLEGAL_PARAM_CODE.getCode(),"用户名重复");
        }
        areaInfoDTO.setCreateTime(LocalDateTime.now());
        areaInfoDTO.setModifyTime(LocalDateTime.now());
        String id = TaskIdGenerator.nextId();
        areaInfoDTO.setId(id);
        AreaInfo areaInfo = new AreaInfo();
        BeanUtils.copyProperties(areaInfoDTO, areaInfo);
        if (null == areaInfo.getStartTime()){
            areaInfo.setStartTime(LocalDateTime.now());
        }
        if (!areaInfoDTO.getShape().equals(AreaShapeEnum.CIRCLE.getCode())){
            areaInfo.setPoints(JSONObject.toJSONString(areaInfoDTO.getPointsList()));
        }else {
            areaInfo.setCenter(JSONObject.toJSONString(areaInfoDTO.getCenter()));
        }
        save(areaInfo);
        return id;
    }

    @Override
    public List<AreaInfoDTO> listAll() {
        List<AreaInfoDTO> areaInfoDTOS = new ArrayList<>();
        List<AreaInfo> list = list();
        list.forEach(l->{
            AreaInfoDTO areaInfoDTO = AreaInfoConverter.infoToDTO(l);
            areaInfoDTOS.add(areaInfoDTO);
        });
        return areaInfoDTOS;
    }

    @Override
    public AreaInfo queryByName(String name) {
        return getOne(new LambdaQueryWrapper<AreaInfo>().eq(AreaInfo::getName, name));
    }

    @Override
    public boolean update(AreaInfoDTO areaInfoDTO) {
        AreaInfo byId = getById(areaInfoDTO.getId());
        BeanUtils.copyProperties(areaInfoDTO,byId);
        if (!areaInfoDTO.getShape().equals(AreaShapeEnum.CIRCLE.getCode())){
            byId.setPoints(JSONObject.toJSONString(areaInfoDTO.getPointsList()));
        }else {
            byId.setCenter(JSONObject.toJSONString(areaInfoDTO.getCenter()));
        }
        return updateById(byId);
    }

    @Override
    public List<AreaInfoDTO> listCircles() {
        List<AreaInfoDTO> areaInfoDTOS = new ArrayList<>();
        QueryWrapper<AreaInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("shape",AreaShapeEnum.CIRCLE.getCode());
        list(queryWrapper).forEach(l->{
            AreaInfoDTO areaInfoDTO = AreaInfoConverter.infoToDTO(l);
            areaInfoDTOS.add(areaInfoDTO);
        });
        return areaInfoDTOS;
    }

    @Override
    public List<AreaInfoDTO> listSquares() {
        List<AreaInfoDTO> areaInfoDTOS = new ArrayList<>();
        QueryWrapper<AreaInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("shape",AreaShapeEnum.SQUARE.getCode());
        list(queryWrapper).forEach(l->{
            AreaInfoDTO areaInfoDTO = AreaInfoConverter.infoToDTO(l);
            areaInfoDTOS.add(areaInfoDTO);
        });
        return areaInfoDTOS;
    }

    @Override
    public List<AreaInfoDTO> listByType(String type) {
        List<AreaInfoDTO> areaInfoDTOS = new ArrayList<>();
        QueryWrapper<AreaInfo> queryWrapper = new QueryWrapper<>();
        if (type.equals(AreaTypeEnum.FENCE.getCode())){
            queryWrapper.eq("type",AreaTypeEnum.FENCE_O.getCode())
                    .or().eq("type",AreaTypeEnum.FENCE_C.getCode());
        }else {
            queryWrapper.eq("type",AreaTypeEnum.RESTRICTED.getCode());
        }
        list(queryWrapper).forEach(l->{
            AreaInfoDTO areaInfoDTO = AreaInfoConverter.infoToDTO(l);
            areaInfoDTOS.add(areaInfoDTO);
        });
        return areaInfoDTOS;
    }
}
