package zl.readCloud.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import zl.readCloud.pojo.UserPO;

import java.util.List;

/**
 * @Author：ZhangLei
 */
public interface UserDao {


    /**
     * 查所有
     * @return List<User>
     */
    @Select("select * from user")
    List<UserPO> showAllItem();

    /**
     * detail: 展示一页所有用户
     * @param pages
     * @param limit
     * @return List<User>
     */
    @Select("select * from user limit #{pages},#{limit}")
    List<UserPO> showAll(Integer pages, Integer limit);

    /**
     * detail: 根据账号查寻用户
     * @param uAccount
     * @return User
     */
    @Select("select * from user where uAccount = #{uAccount}")
    List<UserPO> showByUAccount(String uAccount);

    /**
     * detail: 注销用户
     * @param uId
     * @param status
     * @return uId
     */
    @Update("update user set status = #{status} where uId = #{uId} ")
    int deleteById(Integer uId ,Integer status);

    /**
     * detail: 批量注销用户
     * @param uIds
     * @return int
     */
    @Update("<script> update user set status = 0 where uId in " +
            "<foreach collection='uIds' item='item' open='(' separator=',' close=')'>" +
            " #{item} " +
            "</foreach> </script>")
    int deleteByIds(Integer[] uIds);

    /**
     * detail: 验证用户，账号和密码
     * @param uAccount
     * @param uPassword
     * @return int
     */
    @Select("select * from user where uPassword = #{uPassword} and uAccount = #{uAccount}")
    UserPO showOne(String uAccount, String uPassword);

    /**
     * detail: 修改密码操作：
     *           第一步，showOne，验证通过后，才可以修改密码
     *           第二步，根据已登录的用户名修改密码
     * @param uPassword
     * @param uAccount
     * @return int
     */
    @Update("update user set uPassword = #{uPassword} where uAccount = #{uAccount}")
    int updateByUAccount(String uPassword,String uAccount);

    /**
     * detail: 添加用户
     * @param user
     * @return int
     */
    @Insert("insert into user values " +
            "(null,#{uAccount},#{uPassword},#{sex},1,#{phone},#{email},#{remark2})")
    int addOne(UserPO user);

    /**
     * detail: 编辑用户基本信息
     * @param user
     * @return int
     */
    @Update("update user set uAccount = #{uAccount},sex = #{sex},phone = #{phone},email = #{email} " +
            "where uId = #{uId}")
    int updateById(UserPO user);
}
