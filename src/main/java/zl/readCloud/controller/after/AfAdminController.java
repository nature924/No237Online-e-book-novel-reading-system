package zl.readCloud.controller.after;

import org.springframework.web.bind.annotation.*;
import zl.readCloud.pojo.AdminPO;
import zl.readCloud.service.after.AfAdminService;
import zl.readCloud.utils.Result;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author：ZhangLei
 */

@RequestMapping("/after/admin")
@RestController
public class AfAdminController {


    @Resource
    private AfAdminService afAdminService;

    /**
     *  登录验证
     */
    @PostMapping(value = "/login")
    public Result login(@RequestBody AdminPO admin, HttpServletRequest request){
        AdminPO res = afAdminService.showOne(admin);
        HttpSession session = request.getSession();
        if (res != null){
            session.setAttribute("admin",res);
        }
        return Result.success(res);
    }

    @GetMapping("/showAA")
    public Result showAA(String password,String account){
        AdminPO admin = new AdminPO();
        admin.setPassword(password);
        admin.setAccount(account);
        return Result.success(afAdminService.showOne(admin));
    }

    /**
     *  旧密码通过验证后，修改密码
     */
    @GetMapping("/updateByUAccount")
    Result updateByUAccount(String password,String account){
        return Result.success(afAdminService.updateByUAccount(password,account));
    }

    /**
     *  查询所有的管理员
     */
    @PostMapping(value = "/showAll")
    public Result showAll(){
        return Result.success(Result.SUCCESS,afAdminService.showAll().size(),afAdminService.showAll());
    }

    /**
     * 删除管理员
     */
    @PostMapping(value = "/deleteByAccount")
    public Result deleteByAccount(String account){
        return Result.success(afAdminService.deleteByAccount(account));
    }


    /**
     * 添加管理员
     */
    @PostMapping("/addOne")
    public Result addOne(@RequestBody AdminPO admin){
        System.out.println(admin);
        return Result.success(afAdminService.addOne(admin));
    }

    /**
     * 查找管理员
     */
    @GetMapping("/showByAccount")
    public Result showByAccount(String account){
        return Result.success(afAdminService.showByAccount(account));
    }
}
