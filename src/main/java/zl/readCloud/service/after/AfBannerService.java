package zl.readCloud.service.after;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import zl.readCloud.controller.after.dto.BannerDTO;
import zl.readCloud.pojo.BannerPO;

import java.util.List;

/**
 * @author ZhangLei
 * @Description:
 * @date 2021/10/14 11:19
 */
public interface AfBannerService {

    /**
     * 拉取banner列表
     */
    List<BannerDTO> getBannerList(Integer pages, Integer limit);

    /**
     * 拉取banner列表条数
     */
    Integer getBannerListCount();

    /**
     * 添加banner
     */
    @Insert("insert into banner values (null,#{baPicture},#{bId},#{startDt},#{endDt},#{baLevel})")
    int addBanner(BannerPO banner);

    /**
     * 更新banner信息
     */
    @Update("update banner baPicture = #{baPicture}, bId = #{bId}, start_dt = #{startDt}, end_dt = #{endDt}, ba_level = #{baLevel} set where baId = #{baId}")
    int updateBanner(BannerPO banner);

    /**
     * 删除banner信息
     */
    @Delete("delete from banner where baId = #{baId}")
    int deleteBanner(int baId);

}
