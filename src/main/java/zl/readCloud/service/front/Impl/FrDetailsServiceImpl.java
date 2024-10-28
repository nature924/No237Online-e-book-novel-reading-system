package zl.readCloud.service.front.Impl;

import org.springframework.stereotype.Service;
import zl.readCloud.dao.BookDao;
import zl.readCloud.dao.ChapterDao;
import zl.readCloud.pojo.BookPO;
import zl.readCloud.pojo.ChapterPO;
import zl.readCloud.service.front.FrDetailsService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author：ZhangLei
 */
@Service
public class FrDetailsServiceImpl implements FrDetailsService {


    @Resource
    BookDao bookDao;

    @Resource
    ChapterDao chapterDao;

    @Override
    public BookPO showBookByBId(Integer bId) {
        return bookDao.showBookByBId(bId);
    }

    @Override
    public List<ChapterPO> showChapterByBId(Integer bId) {
        return chapterDao.showByBId(bId);
    }
}
