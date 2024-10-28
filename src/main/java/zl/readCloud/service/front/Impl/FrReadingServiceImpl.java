package zl.readCloud.service.front.Impl;

import org.springframework.stereotype.Service;
import zl.readCloud.dao.BookDao;
import zl.readCloud.dao.ChapterDao;
import zl.readCloud.service.front.FrReadingService;
import zl.readCloud.controller.after.dto.BookChapterDTO;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author：ZhangLei
 */
@Service
public class FrReadingServiceImpl implements FrReadingService {


    @Resource
    BookDao bookDao;

    @Resource
    ChapterDao chapterDao;

    @Override
    public List<BookChapterDTO> showReadingChapter(Integer bId, String cTitle) {
        return bookDao.showReadingChapter(bId,cTitle);
    }

    @Override
    public List<BookChapterDTO> showNextOrPrevious(Integer bId, String eTime, String compare) {
        return chapterDao.showNextOrPrevious(bId,eTime,compare);
    }
}
