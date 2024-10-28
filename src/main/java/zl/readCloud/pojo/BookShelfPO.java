package zl.readCloud.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ZhangLei
 * @Description:
 * @date 2021/10/14 14:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookShelfPO {

    /**
     * id
     */
    @JsonProperty("bsId")
    int bsId;

    /**
     * 用户id
     */
    @JsonProperty("uId")
    int uId;

    /**
     * 章节id
     */
    @JsonProperty("cId")
    int cId;

    /**
     * 书籍id
     */
    @JsonProperty("bId")
    int bId;

    /**
     * 最后阅读时间
     */
    @JsonProperty("endTiem")
    int endTiem;

}
