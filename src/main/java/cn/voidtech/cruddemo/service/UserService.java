package cn.voidtech.cruddemo.service;


import cn.voidtech.cruddemo.domain.UserEntity;
import cn.voidtech.cruddemo.utils.RUtil;
import com.mybatisflex.core.service.IService;

/**
 * 用户表 服务层。
 *
 * @author mybatis-flex-helper automatic generation
 * @since 1.0
 */
public interface UserService extends IService<UserEntity> {
    RUtil addUser(UserEntity userEntity);

    RUtil updateUser(UserEntity userEntity);

}