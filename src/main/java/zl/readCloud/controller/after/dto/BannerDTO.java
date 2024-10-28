package zl.readCloud.controller.after.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ZhangLei
 * @Description:
 * @date 2021/10/22 15:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BannerDTO {

    /**
     * banner图id
     */
    @JsonProperty("baId")
    Integer baId;

    /**
     * banner图地址
     */
    @JsonProperty("baPicture")
    String baPicture;

    /**
     * banner 书籍名
     */
    @JsonProperty("bTitle")
    String bTitle;

    /**
     * banner图开始展示时间
     */
    @JsonProperty("start_dt")
    String startDt;

    /**
     * banner图结束展示时间
     */
    @JsonProperty("end_dt")
    String endDt;

    /**
     * 级别
     */
    @JsonProperty("ba_level")
    String baLevel;

}
