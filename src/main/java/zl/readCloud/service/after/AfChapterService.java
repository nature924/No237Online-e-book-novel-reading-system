package zl.readCloud.service.after;

import zl.readCloud.pojo.ChapterPO;

import java.util.List;

/**
 * @Author：ZhangLei
 */
public interface AfChapterService {


    /**
     * 根据书名，连表查询  作者列，章节列，和章节内容列
     */
    List<ChapterPO> showByBTitle(String bTitle, String index);

    /**
     * 根据书章节标题，更新内容
     */
    int updateByCTitle(String cTitle, String words);

}
