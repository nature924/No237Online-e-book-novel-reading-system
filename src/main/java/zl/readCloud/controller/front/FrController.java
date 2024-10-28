package zl.readCloud.controller.front;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zl.readCloud.controller.after.dto.BannerDTO;
import zl.readCloud.pojo.BannerPO;
import zl.readCloud.pojo.BookPO;
import zl.readCloud.pojo.ChapterPO;
import zl.readCloud.pojo.TypePO;
import zl.readCloud.service.front.FrDetailsService;
import zl.readCloud.service.front.FrIndexService;
import zl.readCloud.service.front.FrReadingService;
import zl.readCloud.utils.Result;
import zl.readCloud.controller.after.dto.BookChapterDTO;
import zl.readCloud.utils.ToolsUtils;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author：ZhangLei
 */
@RequestMapping("/front")
@RestController
public class FrController {

    // 首页banner图的数量
    private static final Integer BANNER_COUNT = 5;

    @Resource
    FrIndexService frIndexService;

    @Resource
    FrDetailsService frDetailsService;

    @Resource
    FrReadingService frReadingService;

    /**
     * 头部的搜索功能
     * @return list<book>
     * @param bTitle 输入的书籍名称，模糊查询
     */
    @GetMapping("/frSearch")
    public Result frSearch(String bTitle){
        List<TypePO> types = frIndexService.showTypeAll();
        List<BookPO> books = frIndexService.showBTitleByLike(bTitle);
        if (books.size() == 0) {

        }
        Map<String,List> map = new HashMap<>();
        map.put("types",types);
        map.put("books",books);
        return Result.success(map);
    }


    /**
     * index页面的所有数据
     * @return map
     * @param lastNnm 最近更新章节的条数
     * @param lastBookNum 最近上架书籍的条数
     */
    @GetMapping("/frIndex")
    public Result frIndex(Integer lastNnm, Integer lastBookNum){
        Date time = new Date();
        SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowDate = sdf.format(time);
        List<TypePO> types = frIndexService.showTypeAll();
        List<BannerPO> banners = frIndexService.getBannerList2(nowDate);
        for (BannerPO banner : banners) {
            banner.setBaPicture(ToolsUtils.getImgPath(banner.getBaPicture()));
        }
        List<BookPO> hotRec = frIndexService.showByHotRec(null);
        for (BookPO book : hotRec) {
            book.setBPicture(ToolsUtils.getImgPath(book.getBPicture()) );
        }
        List<BookChapterDTO> lastChapter = frIndexService.showLastUpdate(lastNnm,null);
        List<BookChapterDTO> lastBook = frIndexService.showLastUpdateBook(lastBookNum);
        Map<String,List> map = new HashMap<>();
        map.put("types",types);
        map.put("banners",banners);
        map.put("hotRec",hotRec);
        map.put("lastChapter",lastChapter);
        map.put("lastBook",lastBook);
        return Result.success(map);
    }


    /**
     * type页面的所有数据
     * @return map
     * @param cate 类型
     * @param lastNnm 最近更新章节的条数
     */
    @GetMapping("/frType")
    public Result frType(Integer lastNnm, String cate){
        List<TypePO> types = frIndexService.showTypeAll();
        List<BookPO> hotRec = frIndexService.showByHotRec(cate);
        for (BookPO bookPO : hotRec) {
            bookPO.setBPicture(ToolsUtils.getImgPath(bookPO.getBPicture()));
        }
        List<BookChapterDTO> lastChapter = frIndexService.showLastUpdate(lastNnm,cate);
        Map<String,List> map = new HashMap<>();
        map.put("types",types);
        map.put("hotRec",hotRec);
        map.put("lastChapter",lastChapter);
        return Result.success(map);
    }

    /**
     * details页面的所有数据
     * @return map
     * @param  bId
     */
    @GetMapping("/frDetail")
    public Result frDetail(Integer bId){
        List<TypePO> types = frIndexService.showTypeAll();
        BookPO book = frDetailsService.showBookByBId(bId);
        book.setBPicture(ToolsUtils.getImgPath(book.getBPicture()));
        List<BookPO> list = new ArrayList<>();
        list.add(book);
        List<ChapterPO> chapters = frDetailsService.showChapterByBId(bId);
        Map<String,List> map = new HashMap<>();
        map.put("types",types);
        map.put("book",list);
        map.put("chapters", chapters);
        return Result.success(map);
    }


    /**
     * reading页面的所有数据
     * @return map
     * @param  bId
     */
    @GetMapping("/frReading")
    public Result frReading(Integer bId,String cTitle){
        List<TypePO> types = frIndexService.showTypeAll();
        List<BookChapterDTO> chapter = frReadingService.showReadingChapter(bId,cTitle);
        Map<String,List> map = new HashMap<>();
        map.put("types",types);
        map.put("chapter",chapter);
        return Result.success(map);
    }

    /**
     * reading页面的翻页
     * @return map
     * @param  bId
     */
    @GetMapping("/frNextOrPrevious")
    public Result frNextOrPrevious(Integer bId, String eTime, String compare){
        if ("".equals(compare)){
            return Result.success(frReadingService.showNextOrPrevious(bId,eTime,null));
        }
        return Result.success(frReadingService.showNextOrPrevious(bId,eTime,compare));
    }


}
