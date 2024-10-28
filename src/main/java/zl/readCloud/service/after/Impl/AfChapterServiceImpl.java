package zl.readCloud.service.after.Impl;

import org.springframework.stereotype.Service;
import zl.readCloud.dao.ChapterDao;
import zl.readCloud.pojo.ChapterPO;
import zl.readCloud.service.after.AfChapterService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author：ZhangLei
 */
@Service
public class AfChapterServiceImpl implements AfChapterService {


    @Resource
    ChapterDao chapterDao;

    @Override
    public List<ChapterPO> showByBTitle(String bTitle, String index) {
        return chapterDao.showByBTitle(bTitle, index);
    }

    @Override
    public int updateByCTitle(String cTitle, String words) {
        return chapterDao.updateByCTitle(cTitle, words);
    }
}
