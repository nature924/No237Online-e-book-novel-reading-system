package zl.readCloud.service.after.Impl;

import org.springframework.stereotype.Service;
import zl.readCloud.dao.TypeDao;
import zl.readCloud.pojo.TypePO;
import zl.readCloud.service.after.AfTypeService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author：ZhangLei
 */
@Service
public class AfTypeServiceImpl implements AfTypeService {


    @Resource
    TypeDao typeDao;

    @Override
    public int addType(String cate) {
        return typeDao.addType(cate);
    }

    @Override
    public List<TypePO> showAll() {
        return typeDao.showAll();
    }

    @Override
    public TypePO showByType(String cate) {
        return typeDao.showByType(cate);
    }

    @Override
    public int updateById(TypePO type) {
        return typeDao.updateById(type);
    }

    @Override
    public int deleteById(Integer tId) {
        return typeDao.deleteById(tId);
    }


}
