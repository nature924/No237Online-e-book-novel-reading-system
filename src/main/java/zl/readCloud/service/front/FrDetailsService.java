package zl.readCloud.service.front;


import zl.readCloud.pojo.BookPO;
import zl.readCloud.pojo.ChapterPO;

import java.util.List;

/**
 * @Author：ZhangLei
 */
public interface FrDetailsService {


    /**
     * detail: 展示一本书的所有详情信息
     * @param
     * @return List<Book>
     */
    BookPO showBookByBId(Integer bId);

    /**
     * detail: 展示一本书的所有章节
     * @param
     * @return List<Book>
     */
    List<ChapterPO> showChapterByBId(Integer bId);



}
