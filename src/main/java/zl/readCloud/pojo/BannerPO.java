package zl.readCloud.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：ZhangLei
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BannerPO {


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
     * banner图的书籍id
     */
    @JsonProperty("bId")
    Integer bId;

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
     * 备用字段
     */
    @JsonProperty("ba_level")
    String baLevel;

}
