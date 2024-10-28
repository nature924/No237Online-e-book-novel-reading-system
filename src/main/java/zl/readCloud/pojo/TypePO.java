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
public class TypePO {


    /**
     * Integer驼峰命名必须加次注解，不然拿不到值
     * id，主键
     */
    @JsonProperty(value = "tId")
    private Integer tId;

    /**
     * 分类名，
     */
    private String cate;

    /**
     * 备用
     */
    private String remark;

}
