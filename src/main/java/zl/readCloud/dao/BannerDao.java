package zl.readCloud.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import zl.readCloud.controller.after.dto.BannerDTO;
import zl.readCloud.pojo.BannerPO;

import java.util.List;

/**
 * @Author：ZhangLei
 */
public interface BannerDao {


    /**
     * 查询banner列表，后台展示
     */
    @Select("select baId,baPicture,bTitle,start_dt,end_dt,ba_level " +
            "from banner a INNER JOIN book b ON a.bId = b.bId order by start_dt limit #{pages},#{limit} ")
    List<BannerDTO> getBannerList(Integer pages, Integer limit);

//    /**
//     * 查询banner列表，首页展示
//     */
//    @Select("select baId,baPicture,bId,start_dt,end_dt,ba_level " +
//            "from banner where start_dt < #{nowDate} and end_dt > #{nowDate} order by ba_level desc limit 3 ")
//    List<BannerPO> getBannerList2(String nowDate);
    /**
     * 查询banner列表，首页展示
     */
    @Select("select baId,baPicture,bId,start_dt,end_dt,ba_level " +
            "from banner where 1=1 order by ba_level desc limit 3 ")
    List<BannerPO> getBannerList2(String nowDate);
    /**
     * 查询banner列表条数
     */
    @Select("select count(*) from banner a INNER JOIN book b ON a.bId = b.bId ")
    Integer getBannerListCount();

    /**
     * 添加banner
     */
    @Insert("insert into banner values (null,#{baPicture},#{bId},#{startDt},null,#{endDt},#{baLevel})")
    int addBanner(BannerPO banner);

    /**
     * 更新banner信息
     */
    @Update("update banner baPicture = #{baPicture}, bId = #{bId}, start_dt = #{startDt}, " +
            "end_dt = #{endDt}, ba_level = #{baLevel} set where baId = #{baId}")
    int updateBanner(BannerPO banner);

    /**
     * 删除banner信息
     */
    @Delete("delete from banner where baId = #{baId}")
    int deleteBanner(int baId);
}
