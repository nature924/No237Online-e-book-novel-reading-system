package zl.readCloud.service.front.Impl;

import org.springframework.stereotype.Service;
import zl.readCloud.controller.after.dto.BannerDTO;
import zl.readCloud.dao.BannerDao;
import zl.readCloud.dao.BookDao;
import zl.readCloud.dao.TypeDao;
import zl.readCloud.pojo.BannerPO;
import zl.readCloud.pojo.BookPO;
import zl.readCloud.pojo.TypePO;
import zl.readCloud.service.front.FrIndexService;
import zl.readCloud.controller.after.dto.BookChapterDTO;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author：ZhangLei
 */
@Service
public class FrIndexServiceImpl implements FrIndexService {


    @Resource
    TypeDao typeDao;

    @Resource
    BookDao bookDao;

    @Resource
    BannerDao bannerDao;

    @Override
    public List<TypePO> showTypeAll() {
        return typeDao.showAll();
    }

    @Override
    public List<BookPO> showByHotRec(String cate) {
        List<BookPO> list = bookDao.showByReadNum(cate);
        List<BookPO> list2 = bookDao.showByGoodNum(cate);
        list.addAll(list2);
        return list;
    }

    @Override
    public List<BookChapterDTO> showLastUpdate(Integer num, String cate) {
        return bookDao.showLastUpdate(num,cate);
    }

    @Override
    public List<BookChapterDTO> showLastUpdateBook(Integer num) {
        return bookDao.showLastUpdateBook(num);
    }

    @Override
    public List<BannerPO> getBannerList2(String nowDate) {
        return bannerDao.getBannerList2(nowDate);
    }

    @Override
    public List<BookPO> showBTitleByLike(String bTitle) {
        return bookDao.showBTitleByLike(bTitle);
    }


}
