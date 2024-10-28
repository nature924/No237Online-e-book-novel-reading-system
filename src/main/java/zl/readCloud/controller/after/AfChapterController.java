package zl.readCloud.controller.after;

import org.springframework.web.bind.annotation.*;
import zl.readCloud.pojo.ChapterPO;
import zl.readCloud.service.after.AfChapterService;
import zl.readCloud.utils.Result;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author：ZhangLei
 */
@RequestMapping("/after/chapter")
@RestController
public class AfChapterController {


    @Resource
    AfChapterService afChapterService;

    @GetMapping("/showByBTitle")
    public Result showByBTitle(String bTitle, String index){
//        index = index - 1;
        List<ChapterPO> list = afChapterService.showByBTitle(bTitle, index);
        if (list.size() == 0 ){
            return Result.success(0);
        }
        return Result.success(list);
    }

    @PostMapping("/updateByCTitle")
    public Result updateByCTitle(String cTitle, String words){
        return Result.success(afChapterService.updateByCTitle(cTitle, words));
    }

}
