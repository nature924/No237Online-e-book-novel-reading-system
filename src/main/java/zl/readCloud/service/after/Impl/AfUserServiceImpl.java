package zl.readCloud.service.after.Impl;

import org.springframework.stereotype.Service;
import zl.readCloud.dao.UserDao;
import zl.readCloud.pojo.UserPO;
import zl.readCloud.service.after.AfUserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author：ZhangLei
 */
@Service
public class AfUserServiceImpl implements AfUserService {


    @Resource
    UserDao userDao;


    @Override
    public List<UserPO> showAllItem() {
        return userDao.showAllItem();
    }

    @Override
    public List<UserPO> showAll(Integer pages, Integer limit) {
        return userDao.showAll(pages, limit);
    }


    @Override
    public List<UserPO> showByUAccount(String uAccount) {
        return userDao.showByUAccount(uAccount);
    }

    @Override
    public int deleteById(Integer uId, Integer status) {
        return userDao.deleteById(uId,status);
    }

    @Override
    public int deleteByIds(Integer[] uIds) {
        return userDao.deleteByIds(uIds);
    }

    @Override
    public UserPO showOne(String uAccount, String uPassword) {
        return userDao.showOne(uAccount,uPassword);
    }

    @Override
    public int updateByUAccount(String uPassword, String uAccount) {
        return userDao.updateByUAccount(uPassword,uAccount);
    }

    @Override
    public int addOne(UserPO user) {
        return userDao.addOne(user);
    }

    @Override
    public int updateById(UserPO user) {
        return userDao.updateById(user);
    }


}
