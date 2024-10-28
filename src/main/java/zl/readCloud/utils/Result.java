package zl.readCloud.utils;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @Author：ZhangLei
 */
@Data
public class Result implements Serializable {


    private static final long serialVersionUID = -1802122468331526708L;

    public static final Integer SUCCESS = 200;
    public static final Integer COLLAPSE = 500;
    public static final Integer NULL = -1;

    /**
     * 状态码
     */
    private Integer code;
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 总记录数
     */
    private Integer count;
    /**
     * 返回数据
     */
    private Object data;



    /**
     * 自定义code,msg,data,count
     * 返回所有
     */
    public Result(Integer code, String msg, Integer count, Object data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    /**
     * 自定义data
     * 只传入数据，自动获取状态码和提示信息
     */
    private Result(Object data) {
        this.data = data;
        this.code = HttpStatus.OK.value();
        this.msg = HttpStatus.OK.getReasonPhrase();
    }

    /**
     * 自定义data,count
     * 只传入数据和总记录条数，自动获取状态码和提示信息
     */
    private Result(Integer code, Integer count, Object data) {
        this.data = data;
        this.count = count;
        this.code = code;
        this.msg = HttpStatus.OK.getReasonPhrase();
    }

    /**
     * 自定义code,msg
     */
    private Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 自定义code,data
     */
    private Result(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }

    /**
     * 只有状态码和提示信息
     */
    private Result() {
        this.code = HttpStatus.OK.value();
        this.msg = HttpStatus.OK.getReasonPhrase();
    }

    /**
     * 以下所有方法，调用时，给什么参数返回什么
     * 不输值，就返回一个空对象
     */


    public static Result success(Integer code, String msg, Integer count, Object data) {
        return new Result(code, msg, count, data);
    }

    public static Result error(Integer code, String msg) {
        return new Result(code, msg);
    }

    public static Result success(Integer code, Object data) {
        return new Result(code, data);
    }

    public static Result success(Integer code, Integer count, Object data) {
        return new Result(code,count,data);
    }

    public static Result success(Object data) {
        return new Result(data);
    }

    public static Result success() {
        return new Result();
    }
}
