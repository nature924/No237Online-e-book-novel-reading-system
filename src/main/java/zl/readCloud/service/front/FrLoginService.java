package zl.readCloud.service.front;

import zl.readCloud.pojo.UserPO;

import java.util.List;

/**
 * @Author：ZhangLei
 */
public interface FrLoginService {


    /**
     * detail: 根据账号查寻用户
     * @param uAccount
     * @return User
     */
    UserPO showOne(String uAccount, String uPassword);

    /**
     * detail: 添加用户
     * @param user
     * @return int
     */
    int addOne(UserPO user);

    /**
     * detail: 根据账号查寻用户
     * @param uAccount
     * @return User
     */
    List<UserPO> showByUAccount(String uAccount);

}
