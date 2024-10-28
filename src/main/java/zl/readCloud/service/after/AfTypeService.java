package zl.readCloud.service.after;

import zl.readCloud.pojo.TypePO;

import java.util.List;

/**
 * @Author：ZhangLei
 */
public interface AfTypeService {


    /**
     * detail: 添加一个分类
     * @param cate
     * @return int
     */
    int addType(String cate);

    /**
     * detail: 展示所有分类
     * @param
     * @return List<Type>
     */
    List<TypePO> showAll();

    /**
     * detail: 搜索分类
     * @param cate
     * @return Type
     */
    TypePO showByType(String cate);

    /**
     * detail: 更新分类名
     * @param type
     * @return int
     */
    int updateById(TypePO type);

    /**
     * detail: 删除一个分类
     * @param tId
     * @return int
     */
    int deleteById(Integer tId);


}
