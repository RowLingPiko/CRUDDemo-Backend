package cn.voidtech.cruddemo.mapper;

import cn.voidtech.cruddemo.domain.UserEntity;
import com.mybatisflex.annotation.UseDataSource;
import com.mybatisflex.core.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * 用户表 映射层。
 *
 * @author mybatis-flex-helper automatic generation
 * @since 1.0
 */
@Mapper
@UseDataSource("ds1")
public interface UserMapper extends BaseMapper<UserEntity> {
    @Update("truncate table user")
    void clear();
}
