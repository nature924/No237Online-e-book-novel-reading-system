package zl.readCloud.service.after;

import zl.readCloud.pojo.AdminPO;

import java.util.List;

/**
 * @Author：ZhangLei
 */
public interface AfAdminService {
    /**
     * detail: 展示所有管理员
     * @return List<Admin>
     */
    List<AdminPO> showAll();


    /**
     * detail: 添加管理员
     * @param admin
     * @return admin
     */
    int addOne(AdminPO admin);

    /**
     * detail: 管理员登录验证
     * @param admin
     * @return admin
     */
    AdminPO showOne(AdminPO admin);

    /**
     * detail: 删除管理员
     * @param account
     * @return int
     */
    int deleteByAccount(String account);

    /**
     * detail: 修改密码操作：
     * 第一步，showOne，验证通过后，才可以修改密码
     * 第二步，根据已登录的用户名修改密码
     * @param password
     * @param account
     * @return int
     */
    int updateByUAccount(String password, String account);

    /**
     * detail: 查找管理员
     * @param account
     * @return Admin
     */
    AdminPO showByAccount(String account);
}
