package zl.readCloud.service.front.Impl;

import org.springframework.stereotype.Service;
import zl.readCloud.dao.UserDao;
import zl.readCloud.pojo.UserPO;
import zl.readCloud.service.front.FrLoginService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author：ZhangLei
 */
@Service
public class FrLoginServiceImpl implements FrLoginService {


    @Resource
    UserDao userDao;

    @Override
    public UserPO showOne(String uAccount, String uPassword) {
        return userDao.showOne(uAccount,uPassword);
    }

    @Override
    public int addOne(UserPO user) {
        return userDao.addOne(user);
    }

    @Override
    public List<UserPO> showByUAccount(String uAccount) {
        return userDao.showByUAccount(uAccount);
    }


}
