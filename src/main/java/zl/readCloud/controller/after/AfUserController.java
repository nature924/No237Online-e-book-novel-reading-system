package zl.readCloud.controller.after;

import org.springframework.web.bind.annotation.*;
import zl.readCloud.pojo.UserPO;
import zl.readCloud.service.after.AfUserService;
import zl.readCloud.utils.Result;

import javax.annotation.Resource;

/**
 * @Author：ZhangLei
 */
@RequestMapping("/after/user")
@RestController
public class AfUserController {


    @Resource
    AfUserService afUserService;

    /**
     * detail: 分页展示所有用户、及查询用户
     *          1.layui会自动传page和limit两个参数过来,进行分页操作
     *          2.layui方法的重载，会在额外在传过来uAcc参数
     * @param
     * @return List<User>
     */
    @PostMapping("/showAll")
    Result showAll(Integer page, Integer limit, String uAcc){
        if (uAcc == null || uAcc == ""){
            Integer pages = (page-1) * limit;
            return Result.success(Result.SUCCESS, afUserService.showAllItem().size(), afUserService.showAll(pages, limit));
        }
        return Result.success(Result.SUCCESS, afUserService.showByUAccount(uAcc));


    }

    /**
     * detail: 注销用户,启用用户
     * @param uId
     * @return int
     */
    @PostMapping("/deleteById")
    Result deleteById(Integer uId,Integer status){
        if (status == 1){
            return Result.success(200,"注销成功",200,afUserService.deleteById(uId,0));
        }
        return Result.success(200,"启用成功",200,afUserService.deleteById(uId,1));
    }

    /**
     * detail: 批量注销用户
     * @param uIds
     * @return int
     */
    @PostMapping("/deleteByIds")
    Result deleteByIds(Integer[] uIds){
        return Result.success(afUserService.deleteByIds(uIds));
    }

    /**
     * detail: 验证用户，账号和密码
     * @param uAccount
     * @param uPassword
     * @return int
     */
    @GetMapping("/showOne")
    Result showOne(String uAccount,String uPassword){
        return Result.success(afUserService.showOne(uAccount,uPassword));
    }

    /**
     * detail: 修改密码操作：
     *           第一步，showOne，验证通过后，才可以修改密码
     *           第二步，根据已登录的用户名修改密码
     * @param uPassword
     * @param uAccount
     * @return int
     */
    @GetMapping("/updateByUAccount")
    Result updateByUAccount(String uPassword,String uAccount){
        return Result.success(afUserService.updateByUAccount(uPassword,uAccount));
    }

    /**
     * detail: 通过账号查询
     * @param uAccount
     * @return int
     */
    @GetMapping("/showByUAccount")
    Result showByUAccount(String uAccount){
        return Result.success(afUserService.showByUAccount(uAccount));
    }

    /**
     * detail: 添加用户
     * @param user
     * @return int
     */
    @PostMapping("/addOne")
    Result addOne(@RequestBody UserPO user){
        return Result.success(afUserService.addOne(user));
    }

    /**
     * detail: 编辑用户基本信息
     * @param user
     * @return int
     */
    @PostMapping("/updateById")
    Result updateById(@RequestBody UserPO user){
        return Result.success(afUserService.updateById(user));
    }
}
