package zl.readCloud.controller.after;

import org.springframework.web.bind.annotation.*;
import zl.readCloud.pojo.TypePO;
import zl.readCloud.service.after.AfTypeService;
import zl.readCloud.utils.Result;

import javax.annotation.Resource;

/**
 * @Author：ZhangLei
 */
@RequestMapping("/after/type")
@RestController
public class AfTypeController {


    @Resource
    AfTypeService afTypeService;

    @PostMapping("/addType")
    public Result addType(String cate) {
        if (afTypeService.showByType(cate) == null){
            return Result.success(200,"添加成功",0,afTypeService.addType(cate));
        }
        return Result.success(200,"该分类已存在，请添加新分类",0,0);
    }

    @PostMapping("/showAll")
    public Result showAll() {
        return Result.success(Result.SUCCESS, afTypeService.showAll().size(),afTypeService.showAll());
    }

    @GetMapping("/updateById")
    public Result updateById(@RequestBody TypePO type) {
        return Result.success(afTypeService.updateById(type));
    }

    @PostMapping("/deleteById")
    public Result deleteById(Integer tId) {
        return Result.success(afTypeService.deleteById(tId));
    }


}
