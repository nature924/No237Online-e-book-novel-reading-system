package zl.readCloud.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import zl.readCloud.pojo.BookPO;
import zl.readCloud.controller.after.dto.BookChapterDTO;

import java.util.List;

/**
 * @Author：ZhangLei
 */
public interface BookDao {


    /**
     * 查所有
     * @return List<User>
     */
    @Select("select * from book")
    List<BookPO> showAllItem();

    /**
     * 查所有地址不为空的书籍
     * @return List<User>
     */
    @Select("select * from book where bookUrl != ''")
    List<BookPO> getBookListUrl();

    /**
     * detail: 展示一页书籍，分页展示
     * @param pages
     * @param limit
     * @return List<Book>
     */
    @Select("select * from book limit #{pages},#{limit}")
    List<BookPO> showAll(Integer pages, Integer limit);

    /**
     * detail: 添加书籍
     * @param book
     * @return int
     */
    @Insert("insert into book values (null,#{bTitle},#{bPicture}," +
            "0,0,#{author},#{cate},2,#{introduce},#{updateTime})")
    int addOne(BookPO book);

    /**
     * detail: 改变书籍状态
     * @param bId
     * @param status
     * @return int
     */
    @Update("update book set status = #{status} where bId = #{bId}")
    int deleteById(Integer bId, Integer status);

    /**
     * detail: 编辑书籍，改变状态
     * @param book
     * @return int
     */
    @Update("update book set " +
            "bTitle = #{bTitle},readNum = #{readNum},goodNum = #{goodNum}," +
            "author = #{author},cate = #{cate},introduce = #{introduce}, bPicture = #{bPicture} " +
            "where bId = #{bId}")
    int updateOne(BookPO book);

    /**
     * detail: 更新书籍的章节更新时间
     * @param bId
     * @param updateTime
     * @return int
     */
    @Update("update book set updateTime = #{updateTime} where bId = #{bId}")
    int updateByBId(Integer bId,String updateTime);

    /**
     * detail: 查看书籍，多条件筛选
     * @param book
     * @return List<Book>
     */
    @Select("<script>" +
            " select * from book " +
            "<where> " +
            "<if test='cate != null '>  cate = #{cate} </if> " +
            "<if test='bTitle != null '> and bTitle = #{bTitle} </if> " +
            "<if test='author != null '> and author = #{author} </if> " +
            "<if test='goodNum != null '> and goodNum >= #{goodNum} </if> " +
            "<if test='readNum != null '> and readNum >= #{readNum} </if> " +
            "</where>  </script>")
    List<BookPO> showScreen(BookPO book);

    /**
     * detail: 根据书名，查询
     * @param bTitle
     * @return List<Book>
     */
    @Select("select * from book where bTitle = #{bTitle}")
    BookPO showByBTitle(String bTitle);










    /**
     * 客户端
     *
     *
     */

    /**
     * detail: 根据bId，查询
     * @param bId
     * @return List<Book>
     */
    @Select("select * from book where bId = #{bId}")
    BookPO showBookByBId(Integer bId);

    /**
     * detail: 根据书名模糊查询   顺序是：完全匹配>开头匹配>最后匹配>中间匹配
     * @param bTitle
     * @return List<Book>
     */
    @Select("select * from book where bTitle like concat('%',#{bTitle},'%') " +
            "ORDER BY ( " +
            "CASE " +
            "WHEN bTitle = #{bTitle} THEN 1 " +
            "WHEN bTitle like concat(#{bTitle},'%') THEN 2 " +
            "WHEN bTitle like concat('%',#{bTitle}) THEN 3 " +
            "WHEN bTitle like concat('%',#{bTitle},'%') THEN 4 " +
            "ELSE 5 END )")
    List<BookPO> showBTitleByLike(String bTitle);

    /**
     * detail: 热门推荐：根据阅读量排排序并取前6条(如果有类型，就只查单个类型)
     * @param
     * @return List<Book>
     */
    @Select("<script>" +
            " select * from book " +
            "where status = 1 <if test='cate != null '> and cate = #{cate} </if> " +
            "order by readNum DESC limit 0,6 " +
            "</script>")
    List<BookPO> showByReadNum(String cate);

    /**
     * detail: 热门推荐：根据点赞量排排序并取前6条(如果有类型，就只查单个类型)
     * @param
     * @return List<Book>
     */
    @Select("<script>" +
            " select * from book " +
            "where status = 1 <if test='cate != null '> and cate = #{cate} </if> " +
            "order by goodNum DESC limit 0,6 " +
            "</script>")
    List<BookPO> showByGoodNum(String cate);

    /**
     * detail: 查询最后更新的两本书各自的最后一章数据,且阅读量不能为0,状态必须为1（含有章节），
     * @param
     * @return List<VoBookChapter>
     */
    @Select("<script>" +
            "select b.bId,c.bId,b.bTitle,c.cTitle,b.cate,c.eTime,b.author " +
              "from chapter c,book b " +
                "where c.bId = b.bId AND" +
                " <if test='cate != null '>  cate = #{cate} AND</if> " +
                "c.etime in " +
                  "(select a.updateTime from " +
                    "(select * from book " +
                      "where `status` = 1 AND readNum != 0 ORDER BY updateTime DESC LIMIT #{num}) a)" +
            "</script>")
    List<BookChapterDTO> showLastUpdate(Integer num, String cate);

    /**
     * detail: 查询最近上架的图书，阅读量为0，状态为1（含有章节）
     * @param
     * @return List<VoBookChapter>
     */
    @Select("SELECT bId,cate,bTitle,author from book where readNum = 0 and `status` = 1 " +
            "ORDER BY updateTime DESC LIMIT #{num} ")
    List<BookChapterDTO> showLastUpdateBook(Integer num);

    /**
     * detail: 精确查询一章
     * @param bId
     * @param cTitle
     * @return List<VoBookChapter>
     */
    @Select("select bo.bId,bo.cate,bo.bTitle,ch.cTitle,ch.words,ch.eTime from chapter as ch,book as bo " +
            "where bo.bId = ch.bId and bo.bId = #{bId} and ch.cTitle = #{cTitle}")
    List<BookChapterDTO> showReadingChapter(Integer bId, String cTitle);


}
