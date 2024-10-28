package zl.readCloud.service.after.Impl;

import org.springframework.stereotype.Service;
import zl.readCloud.dao.BookDao;
import zl.readCloud.dao.ChapterDao;
import zl.readCloud.pojo.BookPO;
import zl.readCloud.pojo.ChapterPO;
import zl.readCloud.service.after.AfBookService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author：ZhangLei
 */
@Service
public class AfBookServiceImpl implements AfBookService {


    @Resource
    BookDao bookDao;

    @Resource
    ChapterDao chapterDao;

    @Override
    public List<BookPO> showAllItem() {
        return bookDao.showAllItem();
    }

    @Override
    public List<BookPO> showAll(Integer pages, Integer limit) {
        return bookDao.showAll(pages,limit);
    }

    @Override
    public int addOne(BookPO book) {
        return bookDao.addOne(book);
    }

    @Override
    public int updateByBId(Integer bId, String updateTime) {
        return bookDao.updateByBId(bId,updateTime);
    }

    @Override
    public int deleteById(Integer bId, Integer status) {
        return bookDao.deleteById(bId,status);
    }

    @Override
    public int updateOne(BookPO book) {
        return bookDao.updateOne(book);
    }


    @Override
    public List<BookPO> showScreen(BookPO book) {
        return bookDao.showScreen(book);
    }

    @Override
    public int addChap(ChapterPO chapter) {
        return chapterDao.addChap(chapter);
    }

    @Override
    public List<ChapterPO> showByBId(Integer bId) {
        return chapterDao.showByBId(bId);
    }

    @Override
    public BookPO showByBTitle(String bTitle) {
        return bookDao.showByBTitle(bTitle);
    }

}
