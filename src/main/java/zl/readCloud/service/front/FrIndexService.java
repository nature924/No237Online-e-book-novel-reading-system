package zl.readCloud.service.front;


import zl.readCloud.controller.after.dto.BannerDTO;
import zl.readCloud.pojo.BannerPO;
import zl.readCloud.pojo.BookPO;
import zl.readCloud.pojo.TypePO;
import zl.readCloud.controller.after.dto.BookChapterDTO;

import java.util.List;

/**
 * @Author：ZhangLei
 */
public interface FrIndexService {


    /**
     * detail: 展示所有分类：展示在页面头部的分类导航
     * @param
     * @return List<Type>
     */
    List<TypePO> showTypeAll();

    /**
     * detail: 热门推荐:从阅读量排序中取前6，在点赞量排序中取前6，合并两个list集合
     * @param
     * @return List<Book>
     */
    List<BookPO> showByHotRec(String cate);

    /**
     * detail: 查询最后更新的两本书各自的最后一章数据
     * @param: num
     * @return List<VoBookChapter>
     */
    List<BookChapterDTO> showLastUpdate(Integer num, String cate);

    /**
     * detail: 查询最近上架的图书，阅读量为0，状态为1（含有章节）
     * @param
     * @return List<VoBookChapter>
     */
    List<BookChapterDTO> showLastUpdateBook(Integer num);

    /**
     * 查询banner
     */
    List<BannerPO> getBannerList2(String nowDate);

    /**
     * 模糊查询
     */
    List<BookPO> showBTitleByLike(String bTitle);

}
