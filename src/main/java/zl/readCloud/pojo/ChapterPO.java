package zl.readCloud.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.StandardEmitterMBean;

/**
 * @Author：ZhangLei
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChapterPO {

    /**
     * 章节表id
     */
    @JsonProperty(value = "cId")
    Integer cId;

    /**
     * 章节标题
     */
    @JsonProperty(value = "cTitle")
    String cTitle;

    /**
     * 小说ID
     */
    @JsonProperty(value = "bId")
    Integer bId;

    /**
     * 小说章节内容
     */
    String words;

    /**
     * 时间
     */
    @JsonProperty(value = "eTime")
    String eTime;

    /**
     * 自定义的字段  book表中的作者字段
     */
    String author;

    /**
     * 章节地址
     */
    @JsonProperty(value = "chapterUrl")
    private String chapterUrl;

    /**
     * sort  排序
     */
    @JsonProperty(value = "sort")
    private Integer sort;

}
