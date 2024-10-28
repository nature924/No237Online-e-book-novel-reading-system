package zl.readCloud.dao;

import org.apache.ibatis.annotations.*;
import zl.readCloud.pojo.AdminPO;

import java.util.List;

/**
 * @Author：ZhangLei
 * detail: 管理员所有方法
 */
public interface AdminDao {


    /**
     * detail: 展示所有管理员
     * @return List<Admin>
     */
    @Select("select * from admin")
    List<AdminPO>  showAll();

    /**
     * detail: 添加管理员
     * @param admin
     * @return admin
     */
    @Insert("insert into admin values (null,#{account},#{password},null)")
    int addOne(AdminPO admin);

    /**
     * detail: 管理员登录验证 和 修改密码,验证用户，账号和密码
     * @param admin
     * @return admin
     */
    @Select("select * from admin " +
            "where account = #{account} and password = #{password}")
    AdminPO showOne(AdminPO admin);

    /**
     * detail: 修改密码操作：
     *           第一步，showOne，验证通过后，才可以修改密码
     *           第二步，根据已登录的用户名修改密码
     * @param password
     * @param account
     * @return int
     */
    @Update("update admin set password = #{password} where account = #{account}")
    int updateByUAccount(String password, String account);



    /**
     * detail: 删除管理员
     * @param account
     * @return int
     */
    @Delete("delete from admin where account = #{account}")
    int deleteByAccount(String account);

    /**
     * detail: 查找管理员
     * @param account
     * @return Admin
     */
    @Select("select * from admin where account = #{account}")
    AdminPO showByAccount(String account);

}
