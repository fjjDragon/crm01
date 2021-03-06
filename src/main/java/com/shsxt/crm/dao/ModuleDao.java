package com.shsxt.crm.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.shsxt.crm.model.Module;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by fjj on 2017/8/16.
 */
public interface ModuleDao {

    PageList<Module> selectForPage(PageBounds pageBounds);
    PageList<Module> selectParentName(PageBounds pageBounds);

    Module findById(@Param(value="id")Integer id);

    void insert(Module module);

    Module findByOptValue(String optValue);

    void update(Module moduleFromDB);

    void deleteBatch(@Param(value="ids") String ids);

    @Select("select id, module_name from t_module where is_valid = 1 and grade = #{grade}")
    List<Module> findByGrade(@Param(value="grade") Integer grade);

}
