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
public class BookPO {


    /**
     * 主键
     */
    @JsonProperty(value = "bId")
    private Integer bId;

    /**
     * 书名
     */
    @JsonProperty(value = "bTitle")
    private String bTitle;

    /**
     * 书的照片（存地址）
     */
    @JsonProperty(value = "bPicture")
    private String bPicture;

    /**
     * 阅读量
     */
    @JsonProperty(value = "readNum")
    private Integer readNum;

    /**
     * 点赞量
     */
    @JsonProperty(value = "goodNum")
    private Integer goodNum;

    /**
     * 作者
     */
    private String author;

    /**
     * 类型
     */
    private String cate;

    /**
     * 状态（1:上架（且已添加章节），0:下架，2：上架（还没有添加章节））
     */
    private Integer status;

    /**
     * 简介
     */
    private String introduce;

    /**
     * 书籍最后更新时间
     */
    @JsonProperty(value = "updateTime")
    private String updateTime;

    /**
     * 书籍url
     */
    @JsonProperty(value = "bookUrl")
    private String bookUrl;


}
