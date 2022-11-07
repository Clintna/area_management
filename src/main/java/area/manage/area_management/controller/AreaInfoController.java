package area.manage.area_management.controller;

import area.manage.area_management.bean.AreaInfo;
import area.manage.area_management.entity.AreaInfoDTO;
import area.manage.area_management.entity.FlightResponse;
import area.manage.area_management.service.AreaInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Jinglin
 * @since 2022-10-27
 */
@RestController
@RequestMapping("/areaInfo")
@Slf4j
public class AreaInfoController {

    @Resource
    private AreaInfoService areaInfoService;

    @PostMapping("/save")
    public FlightResponse save(@RequestBody AreaInfoDTO areaInfo){
        return new FlightResponse().success().put("id",this.areaInfoService.saveOne(areaInfo));
    }

    @PostMapping("/delete/{id}")
    public FlightResponse delete(@NotBlank(message = "{id}") @PathVariable String id){
        this.areaInfoService.removeById(id);
        return new FlightResponse().success();
    }

    @PostMapping("/listAll")
    public FlightResponse listAll(){
        return new FlightResponse().success().data(this.areaInfoService.listAll());
    }

//    @PostMapping("/queryById")
//    public FlightResponse queryById(@RequestParam Integer id){
//        return new FlightResponse().success().data(this.areaInfoService.getById(id));
//    }
//    @PostMapping("/queryByName")
//    public FlightResponse queryByName(@RequestParam String name){
//        return new FlightResponse().success().data(this.areaInfoService.queryByName(name));
//    }

    @PostMapping("/update")
    public FlightResponse update(@RequestBody AreaInfoDTO areaInfoDTO){
        return new FlightResponse().success().data(this.areaInfoService.update(areaInfoDTO));
    }

    @PostMapping("/listByType")
    public FlightResponse listByType(String type){
        return new FlightResponse().success().data(this.areaInfoService.listByType(type));
    }
}
