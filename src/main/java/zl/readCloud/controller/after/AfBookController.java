package zl.readCloud.controller.after;

import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import zl.readCloud.pojo.BookPO;
import zl.readCloud.pojo.ChapterPO;
import zl.readCloud.service.after.AfBookService;
import zl.readCloud.utils.DateUtils;
import zl.readCloud.utils.Result;
import zl.readCloud.utils.ToolsUtils;

import javax.annotation.Resource;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * @Author：ZhangLei
 */
@Transactional
@RequestMapping("/after/book")
@RestController
public class AfBookController {

    @Resource
    AfBookService afBookService;

    /**
     * detail: 分页展示所有书籍，条件查询
     */
    @PostMapping("/showAll")
    public Result showAll(Integer page, Integer limit, BookPO book) {
        if ("".equals(book.getAuthor())) {
            book.setAuthor(null);
        }
        if ("".equals(book.getBTitle())) {
            book.setBTitle(null);
        }
        if ("".equals(book.getCate())) {
            book.setCate(null);
        }
        // integer类型，前台传值时为空，转化为null
        if (book.getAuthor() == null && book.getBTitle() == null
                && book.getCate() == null && book.getGoodNum() == null
                && book.getReadNum() == null) {
            Integer pages = (page - 1) * limit;
            List<BookPO> list = afBookService.showAll(pages, limit);
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setBPicture(ToolsUtils.getImgPath(list.get(i).getBPicture()));
            }
            Integer count = afBookService.showAllItem().size();
            return Result.success(Result.SUCCESS, count, list);
        }
        List<BookPO> list = afBookService.showScreen(book);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setBPicture(ToolsUtils.getImgPath(list.get(i).getBPicture()));
        }
        LoggerFactory.getLogger(AfBookController.class).info(list.toString());
        return Result.success(list);
    }

    /**
     * detail: 添加书籍
     */
    @PostMapping("/addOne")
    public Result addOne(@RequestBody BookPO book) {
        // 获取一个当前时间,精确到毫秒，确保添加时间不会重，为后面客户端页面排序做准备
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String dateStr = simpleDateFormat.format(date);
        book.setUpdateTime(dateStr);
        if (book.getBPicture() == null || book.getBPicture() == "") {
            book.setBPicture(ToolsUtils.DEFAULT_IMG);
        }
        return Result.success(afBookService.addOne(book));
    }

    /**
     * detail: 删除书籍，改变状态
     *
     * @param bId
     * @return int
     */
    @PostMapping("/deleteById")
    public Result deleteById(Integer bId, Integer status) {
        if (status == 1) {
            return Result.success(200, "下架成功", 200, afBookService.deleteById(bId, 0));
        }
        return Result.success(200, "上架成功", 200, afBookService.deleteById(bId, 1));
    }

    /**
     * detail: 编辑书籍
     *
     * @param book
     * @return int
     */
    @PostMapping("/updateOne")
    public Result updateOne(@RequestBody BookPO book) {
        return Result.success(afBookService.updateOne(book));
    }

    /**
     * detail: 添加章节内容
     *
     * @param chapter
     * @return int
     */
    @PostMapping("/addChap")
    public Result addChap(ChapterPO chapter){
        //获取一个当前时间,精确到毫秒，确保添加时间不会重，为后面客户端页面排序做准备
        //创建一个date对象保存当前时间
        // Date date = new Date();
        // SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        //format()方法将Date转换成指定格式的String
        // String dateStr = simpleDateFormat.format(date);
        chapter.setETime(DateUtils.getCurrentTime());
        Integer bId = chapter.getBId();
        afBookService.updateByBId(bId,DateUtils.getCurrentTime());
        afBookService.deleteById(bId,1);
        return Result.success(afBookService.addChap(chapter));
    }

    /**
     * detail: 根据小说bId查询小说的所有条数，进而得出下一章的数字
     *
     * @param bId
     * @return int
     */
    @GetMapping("/showByBId")
    public Result showByBId(Integer bId){
        return Result.success(afBookService.showByBId(bId).size());
    }

    @GetMapping("/showByBTitle")
    public Result showByBTitle(String bTitle) {
        BookPO book = afBookService.showByBTitle(bTitle);
        if (book != null) {
            return Result.success(Result.SUCCESS,1,book);
        }
        return Result.success(Result.SUCCESS,0,null);
    }
}
