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
public class UserPO {


    /**
     * 主键
     */
    @JsonProperty(value = "uId")
    private Integer uId;

    /**
     * 账号，唯一
     */
    @JsonProperty(value = "uAccount")
    private String uAccount;

    /**
     * 密码
     */
    @JsonProperty(value = "uPassword")
    private String uPassword;

    /**
     * 性别（1:男，0:女）
     */
    private Integer sex;

    /**
     * 状态（1：正常，0：注销）
     */
    private Integer status;

    /**
     * 手机号，11位数字
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 备用字段2
     */
    private String remark2;

}
