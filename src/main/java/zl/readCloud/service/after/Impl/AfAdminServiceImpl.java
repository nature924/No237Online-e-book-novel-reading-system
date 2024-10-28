package zl.readCloud.service.after.Impl;

import org.springframework.stereotype.Service;
import zl.readCloud.dao.AdminDao;
import zl.readCloud.pojo.AdminPO;
import zl.readCloud.service.after.AfAdminService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author：ZhangLei
 */
@Service
public class AfAdminServiceImpl implements AfAdminService {


    @Resource
    private AdminDao adminDao;

    /**
     * detail: 展示所有管理员
     * @return List<Admin>
     */
    @Override
    public List<AdminPO> showAll(){
        return adminDao.showAll();
    }

    /**
     * detail: 添加管理员
     * @param admin
     * @return admin
     */
    @Override
    public int addOne(AdminPO admin){
        return adminDao.addOne(admin);
    }

    /**
     * detail: 管理员登录验证
     * @param admin
     * @return admin
     */
    @Override
    public AdminPO showOne(AdminPO admin) {
        return adminDao.showOne(admin);
    }


    /**
     * detail: 修改密码操作：
     * 第一步，showOne，验证通过后，才可以修改密码
     * 第二步，根据已登录的用户名修改密码
     *
     * @param password
     * @param account
     * @return int
     */
    @Override
    public int updateByUAccount(String password, String account) {
        return adminDao.updateByUAccount(password,account);
    }

    @Override
    public AdminPO showByAccount(String account) {
        return adminDao.showByAccount(account);
    }

    /**
     * detail: 删除管理员，只改变状态
     * @param account
     * @return int
     */
    @Override
    public int deleteByAccount(String account){
        return adminDao.deleteByAccount(account);
    }


}
