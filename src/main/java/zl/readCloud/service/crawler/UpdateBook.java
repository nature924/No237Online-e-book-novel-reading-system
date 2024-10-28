package zl.readCloud.service.crawler;

/**
 * @author ZhangLei
 * @Description:
 * @date 2021/11/15 9:45
 */
public interface UpdateBook {

    /**
     * 更新数据库中的小说
     */
    void updateBook(int bId, String bookUrl);

    /**
     * 搜索功能，查不到时，去爬取网站的小说
     */
    int getBookList(String cTitle);


}
