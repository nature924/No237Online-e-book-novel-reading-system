package zl.readCloud.service.after;

import zl.readCloud.pojo.UserPO;

import java.util.List;

/**
 * @Author：ZhangLei
 */
public interface AfUserService {


    /**
     * detail: 展示所有用户
     * @param
     * @return List<User>
     */
    List<UserPO> showAllItem();

    /**
     * detail: 分页展示用户，每页用户的数据
     * @param pages
     * @param limit
     * @return List<User>
     */
    List<UserPO> showAll(Integer pages, Integer limit);

    /**
     * detail: 根据id查寻用户
     * @param uAccount
     * @return User
     */
    List<UserPO> showByUAccount(String uAccount);

    /**
     * detail: 注销用户,和启用用户
     * @param uId
     * @param status
     * @return int
     */
    int deleteById(Integer uId,Integer status);

    /**
     * detail: 批量注销用户
     * @param uIds
     * @return int
     */
    int deleteByIds(Integer[] uIds);

    /**
     * detail: 验证用户，账号和密码
     * @param uAccount
     * @param uPassword
     * @return int
     */
    UserPO showOne(String uAccount, String uPassword);

    /**
     * detail: 修改密码操作：
     *           第一步，showOne，验证通过后，才可以修改密码
     *           第二步，根据已登录的用户名修改密码
     * @param uPassword
     * @param uAccount
     * @return int
     */
    int updateByUAccount(String uPassword,String uAccount);

    /**
     * detail: 添加用户
     * @param user
     * @return int
     */
    int addOne(UserPO user);

    /**
     * detail: 编辑用户基本信息
     * @param user
     * @return int
     */
    int updateById(UserPO user);

}
