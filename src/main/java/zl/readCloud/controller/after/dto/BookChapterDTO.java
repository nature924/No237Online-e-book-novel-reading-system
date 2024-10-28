package zl.readCloud.controller.after.dto;

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
public class BookChapterDTO {


    /**
     * 书bId
     */
    @JsonProperty(value = "bId")
    Integer bId;

    /**
     * 书籍类型
     */
    String cate;

    /**
     * 书名
     */
    @JsonProperty(value = "bTitle")
    String bTitle;

    /**
     * 章节名
     */
    @JsonProperty(value = "cTitle")
    String cTitle;

    /**
     * 作者
     */
    String author;

    /**
     * 最后一次更新时间，最后一次添加章节的时间
     */
    @JsonProperty(value = "eTime")
    String eTime;

    /**
     * 章节内容
     */
    String words;


}
