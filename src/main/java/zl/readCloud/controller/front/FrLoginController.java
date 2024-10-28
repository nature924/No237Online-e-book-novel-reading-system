package zl.readCloud.controller.front;

import org.springframework.web.bind.annotation.*;
import zl.readCloud.pojo.UserPO;
import zl.readCloud.service.front.FrLoginService;
import zl.readCloud.utils.Result;

import javax.annotation.Resource;

/**
 * @Author：ZhangLei
 */
@RequestMapping("/front/login")
@RestController
public class FrLoginController {


    @Resource
    FrLoginService frLoginService;

    /**
     * 注册用户
     */
    @PostMapping("/addOne")
    public Result addOne(UserPO user){
        return Result.success(frLoginService.addOne(user));
    }

    /**
     * 用户登录
     */
    @GetMapping("/showOne")
    public Result showOne(String uAccount,String uPassword){
        return Result.success(frLoginService.showOne(uAccount,uPassword));
    }

    /**
     * 查重用户名
     */
    @GetMapping("/showByUAccount")
    public Result showByUAccount(String uAccount){
        return Result.success(frLoginService.showByUAccount(uAccount));
    }

}
