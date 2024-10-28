package zl.readCloud.controller.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import zl.readCloud.utils.Result;
import zl.readCloud.utils.ToolsUtils;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * @author ZhangLei
 * @Description:
 * @date 2021/11/8 16:46
 */
@RestController
@RequestMapping("/common")
public class commonController {

    @Autowired
    private ToolsUtils toolsUtils;

    /**
     * 上传图片
     */
    @PostMapping("/uploadPic")
    public Result uploadPic(MultipartFile file, @RequestParam("type_img")Integer typeImg) {
        try {
            String res = toolsUtils.uploadImg(file,typeImg);
            if (!"".equals(res) && res != null) {
                return Result.success(Result.SUCCESS,res);
            }else {
                return Result.success(Result.NULL, null);
            }
        } catch (Exception e) {
            log.print(e);
            return Result.error(Result.COLLAPSE, String.valueOf(e));
        }
    }

}
