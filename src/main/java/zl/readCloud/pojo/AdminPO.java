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
public class AdminPO {


    /**
     * id,主键
     */
    private Integer id;

    /**
     * 账号,唯一
     */
    private String account;

    /**
     * 密码
     */
    private String password;


}
