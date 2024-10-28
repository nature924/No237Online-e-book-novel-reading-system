package zl.readCloud.dao;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import zl.readCloud.pojo.TypePO;

import java.util.List;

/**
 * @Author：ZhangLei
 * detail: 分类所有方法
 */
public interface TypeDao {


    /**
     * detail: 添加一个分类
     * @param cate
     * @return int
     */
    @Insert("insert into type values (null,#{cate},null)")
    int addType(String cate);

    /**
     * detail: 展示所有分类
     * @param
     * @return List<Type>
     */
    @Select("select * from type")
    List<TypePO> showAll();

    /**
     * detail: 搜索分类
     * @param cate
     * @return Type
     */
    @Select("select * from type where cate = #{cate}")
    TypePO showByType(String cate);

    /**
     * detail: 更新分类名
     * @param type
     * @return int
     */
    @Update("update type set cate = #{cate} where tId = #{tId}")
    int updateById(TypePO type);

    /**
     * detail: 删除一个分类
     * @param tId
     * @return int
     */
    @Delete("delete from type where tId = #{tId} ")
    int deleteById(Integer tId);
}
