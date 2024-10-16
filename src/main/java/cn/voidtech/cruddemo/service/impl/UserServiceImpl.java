package cn.voidtech.cruddemo.service.impl;


import cn.hutool.core.util.ObjectUtil;
import cn.voidtech.cruddemo.domain.UserEntity;
import cn.voidtech.cruddemo.mapper.UserMapper;
import cn.voidtech.cruddemo.service.UserService;
import cn.voidtech.cruddemo.utils.RUtil;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.List;

import static cn.voidtech.cruddemo.domain.table.UserEntityTableDef.USER_ENTITY;

/**
 * 用户表 服务层实现。
 *
 * @author mybatis-flex-helper automatic generation
 * @since 1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

    @Override
    @CacheEvict(allEntries = true)
    public boolean remove(QueryWrapper query) {
        return super.remove(query);
    }

    @Override
    @CacheEvict(key = "#id")
    public boolean removeById(Serializable id) {
        return super.removeById(id);
    }

    @Override
    @CacheEvict(allEntries = true)
    public boolean removeByIds(Collection<? extends Serializable> ids) {
        return super.removeByIds(ids);
    }

    @Override
    @CacheEvict(allEntries = true)
    public boolean update(UserEntity entity, QueryWrapper query) {
        return super.update(entity, query);
    }

    @Override
    @CacheEvict(key = "#entity.#(primaryKey)")
    public boolean updateById(UserEntity entity, boolean ignoreNulls) {
        return super.updateById(entity, ignoreNulls);
    }

    @Override
    @CacheEvict(allEntries = true)
    public boolean updateBatch(Collection<UserEntity> entities, int batchSize) {
        return super.updateBatch(entities, batchSize);
    }

    @Override
    @Cacheable(key = "#id")
    public UserEntity getById(Serializable id) {
        return super.getById(id);
    }

    @Override
    @Cacheable(key = "#root.methodName + ':' + #query.toSQL()")
    public UserEntity getOne(QueryWrapper query) {
        return super.getOne(query);
    }

    @Override
    @Cacheable(key = "#root.methodName + ':' + #query.toSQL()")
    public <R> R getOneAs(QueryWrapper query, Class<R> asType) {
        return super.getOneAs(query, asType);
    }

    @Override
    @Cacheable(key = "#root.methodName + ':' + #query.toSQL()")
    public List<UserEntity> list(QueryWrapper query) {
        return super.list(query);
    }

    @Override
    @Cacheable(key = "#root.methodName + ':' + #query.toSQL()")
    public <R> List<R> listAs(QueryWrapper query, Class<R> asType) {
        return super.listAs(query, asType);
    }

    /**
     * @deprecated 无法通过注解进行缓存操作。
     */
    @Override
    @Deprecated
    public List<UserEntity> listByIds(Collection<? extends Serializable> ids) {
        return super.listByIds(ids);
    }

    @Override
    @Cacheable(key = "#root.methodName + ':' + #query.toSQL()")
    public long count(QueryWrapper query) {
        return super.count(query);
    }

    @Override
    @Cacheable(key = "#root.methodName + ':' + #page.getPageSize() + ':' + #page.getPageNumber() + ':' + #query.toSQL()")
    public <R> Page<R> pageAs(Page<R> page, QueryWrapper query, Class<R> asType) {
        return super.pageAs(page, query, asType);
    }

    @Transactional
    @Override
    public RUtil addUser(UserEntity userEntity) {
        if (ObjectUtil.isNotEmpty(super.getOne(QueryWrapper.create().where(USER_ENTITY.EMAIL.eq(userEntity.getEmail()))))) {
            throw new RuntimeException("该邮箱已存在");
        }
        if (super.save(UserEntity.builder()
                .nickname(userEntity.getNickname())
                .email(userEntity.getEmail())
                .password(DigestUtils.md5DigestAsHex(userEntity.getPassword().getBytes(StandardCharsets.UTF_8)))
                .build())) {
            return RUtil.ok();
        }
        return RUtil.fail();
    }

    @Transactional
    @Override
    public RUtil updateUser(UserEntity userEntity) {
        if (ObjectUtil.isNotEmpty(userEntity.getPassword())) {
            userEntity.setPassword(DigestUtils.md5DigestAsHex(userEntity.getPassword().getBytes(StandardCharsets.UTF_8)));
        } else {
            userEntity.setPassword(null);
        }

        if (super.updateById(userEntity, true)) {
            return RUtil.ok();
        }
        return RUtil.fail();
    }
}