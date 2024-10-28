package zl.readCloud.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import zl.readCloud.pojo.ChapterPO;
import zl.readCloud.controller.after.dto.BookChapterDTO;

import java.util.List;

/**
 * @Author：ZhangLei
 */
public interface ChapterDao {


    /**
     * detail: 添加一章内容
     * @param chapter
     * @return int
     */
    @Insert("insert into chapter values (null ,#{cTitle} ,#{sort} ,#{bId} ,#{words} ,#{eTime} ,#{chapterUrl})")
    int addChap(ChapterPO chapter);

    /**
     * detail: 查询一本书的所有章节,升序（前一章的时间一定早与下一章的时间，修改章节内容不更新时间）
     * @return int
     */
    @Select("select * from chapter where bId = #{bId} order by eTime")
    List<ChapterPO> showByBId(Integer bId);

    /**
     * 根据书名 章节下标，连表查询  作者列，章节列，和章节内容列
     */
    @Select("SELECT author,cTitle,words FROM book AS bb,chapter AS cc " +
            "WHERE bb.bId = cc.bId AND bb.bId = (SELECT bId FROM book where bTitle = #{bTitle})" +
            "and cTitle = #{index} limit 1" )
    List<ChapterPO> showByBTitle(String bTitle, String index);

    /**
     * 根据书章节标题，更新内容
     */
    @Update("update chapter set words = #{words} where cTitle = #{cTitle}")
    int updateByCTitle(String cTitle, String words);

    /**
     * detail: 查询上一章或下一章
     *          动态sql，根据参数（compare），不为null max(t.eTime) < ($lt;)  上一章
     *                                    为null min(t.eTime) > ($gt;)   下一章
     * @param bId
     * @param eTime
     * @param compare
     * @return List<VoBookChapter>
     */
    @Select("<script> " +
            "select bo.bId,ch.cTitle " +
            "from chapter ch,book bo " +
            "where bo.bId = ch.bId and " +
            "ch.eTime = " +
            "(select<if test='compare == null '>min(t.eTime)</if> " +
            "<if test='compare != null '>max(t.eTime)</if>" +
            "from (SELECT * FROM chapter ORDER BY eTime) t " +
            "where <if test='compare == null '>t.eTime &gt; #{eTime}</if> " +
            "<if test='compare != null '>t.eTime &lt; #{eTime}</if> AND t.bId = #{bId} )" +
            "</script>")
    List<BookChapterDTO> showNextOrPrevious(Integer bId, String eTime, String compare);
}
