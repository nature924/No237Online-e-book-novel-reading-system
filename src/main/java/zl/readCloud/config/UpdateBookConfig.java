package zl.readCloud.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import zl.readCloud.aop.HttpAspect;
import zl.readCloud.dao.BookDao;
import zl.readCloud.pojo.BookPO;
import zl.readCloud.service.crawler.UpdateBook;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author ZhangLei
 * @Description:
 * @date 2021/11/15 9:51
 */
@Configuration
public class UpdateBookConfig {

    @Resource
    private BookDao bookDao;

    @Resource
    private UpdateBook updateBook;

    private static final Logger log = LoggerFactory.getLogger(HttpAspect.class);

    //秒 分 时 日 月 周
    @Scheduled(cron = "1 * * * * ?") //更新时间
    public void update(){
        updateBook();
    }

    private void updateBook(){
        // 获取所有地址不为空的小说
//        List<BookPO> bookPOS = bookDao.getBookListUrl();
//        // 循环更新小说
//        for (BookPO bookPO : bookPOS){
//            updateBook.updateBook(bookPO.getBId(),bookPO.getBookUrl());
//            try {
//                // 间隔3秒
//                Thread.sleep(1000 * 5);
//            } catch (InterruptedException e) {
//                log.info("线程休眠异常");
//                e.printStackTrace();
//            }
//        }
//        log.info("开始更新小说");

    }

}
