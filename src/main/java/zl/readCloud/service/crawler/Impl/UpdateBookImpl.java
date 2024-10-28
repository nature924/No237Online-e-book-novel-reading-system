package zl.readCloud.service.crawler.Impl;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import zl.readCloud.dao.BookDao;
import zl.readCloud.dao.ChapterDao;
import zl.readCloud.pojo.BookPO;
import zl.readCloud.pojo.ChapterPO;
import zl.readCloud.service.after.AfBookService;
import zl.readCloud.service.crawler.UpdateBook;
import zl.readCloud.utils.DateUtils;
import zl.readCloud.utils.JsoupUtil;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ZhangLei
 * @Description:
 * @date 2021/11/15 9:46
 */
@Service
public class UpdateBookImpl implements UpdateBook {

    @Resource
    private ChapterDao chapterDao;

    @Resource
    private BookDao bookDao;

    @Resource
    private AfBookService afBookService;

    /**
     * 系统调度 定时更新小说 此处开启了事务
     *
     * @param bId
     * @param bookUrl
     */
    @Async
    @Override
    public void updateBook(int bId, String bookUrl) {

        BookPO bookPO = bookDao.showBookByBId(bId);
        // 获取章节
        List<ChapterPO> list = chapterDao.showByBId(bId);
        // 现有小说章节的数量
        int catLength = list.size();
        // 获取url页面数据
        Document doc = JsoupUtil.getDoc(bookUrl);
        //获取章节内容
        Elements elements = doc.select("dd>a");
        // 上面的12个为，最新章节，，减掉它们
        int elnLength = elements.size() - 12;
        // 现有小说章节的数量  跟  网页的小说章节的数量
        if (catLength != elnLength) {
            // 现有小说章节的数量为0
            if (catLength == 0) {
                // 用来排序
                int sort = 1;
                // 帮助跳过前12个最新章节
                int cot = 0;
                ChapterPO chapterPO = new ChapterPO();
                for (Element element : elements) {
                    if (cot < 12) {
                        cot++;
                        continue;
                    }
                    // 获取绝对路径url
                    String url = element.attr("abs:href");
                    Document document = JsoupUtil.getDoc(url);
                    // 章节标题
                    String title = document.select("h1").text();
                    // 章节内容
                    String text = document.getElementById("content").html();
                    String date = DateUtils.getCurrentTime();
                    chapterPO.setBId(bId);
                    chapterPO.setCTitle(title);
                    chapterPO.setWords(text);
                    chapterPO.setETime(date);
                    System.out.println(url);
                    chapterPO.setChapterUrl(url);
                    chapterPO.setSort(sort);
                    // 保存小说内容
                    chapterDao.addChap(chapterPO);
                    afBookService.updateByBId(bId, date);
                    System.out.println("重新抓取小说：" + title);
                    sort++;
                }
            } else {
                //有更新
                ChapterPO chapterPO = new ChapterPO();
                int i = elements.size() - catLength - 12;
                System.out.println(bookPO.getBTitle() + "最新章节有：" + i + "章");
                int sort = catLength + 1;
                //最新章节下标
                int k = catLength + 12;
                // Chapter chapter=new Chapter();
                for (int j = 0; j < i; j++) {
                    String date = DateUtils.getCurrentTime();
                    String url = elements.get(k).attr("abs:href");
                    Document document = JsoupUtil.getDoc(url);
                    //章节标题
                    String title = document.select("h1").text();
                    //章节内容
                    String text = document.getElementById("content").html();
                    chapterPO.setCTitle(title);
                    chapterPO.setChapterUrl(url);
                    chapterPO.setWords(text);
                    chapterPO.setBId(bId);
                    chapterPO.setETime(date);
                    chapterPO.setSort(sort);
                    k++;
                    sort++;//排序
                    // 保存小说内容
                    chapterDao.addChap(chapterPO);
                    afBookService.updateByBId(bId, date);
                }
            }
        } else {
            System.out.println(bookPO.getBTitle() + "小说已经是最新");
        }

    }

    @Override
    public int getBookList(String cTitle) {

        return 0;
    }


}
