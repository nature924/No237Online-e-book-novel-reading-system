package zl.readCloud.service.after;

import zl.readCloud.pojo.BookPO;
import zl.readCloud.pojo.ChapterPO;

import java.util.List;

/**
 * @Author：ZhangLei
 */
public interface AfBookService {


    /**
     * 查所有
     * @return List<User>
     */
    List<BookPO> showAllItem();

    /**
     * detail: 展示一页书籍,分页展示
     * @param pages
     * @param limit
     * @return List<Book>
     */
    List<BookPO> showAll(Integer pages, Integer limit);

    /**
     * detail: 添加书籍
     * @param book
     * @return int
     */
    int addOne(BookPO book);

    /**
     * detail: 修改书籍最后更新时间
     * @param bId
     * @param updateTime
     * @return int
     */
    int updateByBId(Integer bId,String updateTime);

    /**
     * detail: 删除书籍，改变状态
     * @param bId
     * @param status
     * @return int
     */
    int deleteById(Integer bId, Integer status);

    /**
     * detail: 编辑书籍，改变状态
     * @param book
     * @return int
     */
    int updateOne(BookPO book);

    /**
     * detail: 查看书籍，多条件筛选
     * @param book
     * @return List<Book>
     */
    List<BookPO> showScreen(BookPO book);

    /**
     * detail: 添加一章内容
     * @param chapter
     * @return int
     */
    int addChap(ChapterPO chapter);

    /**
     * detail: 查询一本书的所有章节
     * @param bId
     * @return int
     */
    List<ChapterPO> showByBId(Integer bId);

    /**
     * detail: 根据书名，查询
     * @param bTitle
     * @return List<Book>
     */
    BookPO showByBTitle(String bTitle);
}
