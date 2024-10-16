package cn.voidtech.cruddemo.controller;

import cn.voidtech.cruddemo.domain.UserEntity;
import cn.voidtech.cruddemo.domain.dto.*;
import cn.voidtech.cruddemo.service.UserService;
import cn.voidtech.cruddemo.utils.RUtil;
import com.mybatisflex.core.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static cn.voidtech.cruddemo.domain.table.UserEntityTableDef.USER_ENTITY;

/**
 * 基础控制器类，处理与用户相关的CRUD操作.
 *
 * @author RowLingKaslana
 * @project CRUDDemo
 * @date 2024/10/15 17:35
 * This is the honor of the Kaslana!!!!
 * 願 人 類 覺 長 存
 * 人 类 に 栄 光 あ れ
 * Glory to mankind！
 */
@Slf4j
@RestController
public class BaseController {
    // 用户服务接口实例，用于操作用户相关的业务逻辑
    private final UserService userService;

    // 构造方法注入UserService
    public BaseController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 查询所有用户列表.
     *
     * @return 所有用户实体的列表
     */
    @RequestMapping("/list")
    public RUtil<Object> list() {
        return RUtil.ok(userService.list());
    }

    /**
     * 添加新用户.
     *
     * @param userInsertDto 包含新用户信息的数据传输对象，需要经过验证
     * @return 操作结果，添加成功或失败
     */
    @RequestMapping("/add")
    public RUtil<Object> add(@Validated @RequestBody UserInsertDto userInsertDto) {
        return userService.addUser(UserEntity.builder()
                .nickname(userInsertDto.getNickname())
                .email(userInsertDto.getEmail())
                .password(userInsertDto.getPassword())
                .build());
    }

    /**
     * 更新现有用户信息.
     *
     * @param userUpdateDto 包含更新用户信息的数据传输对象，需要经过验证
     * @return 操作结果，更新成功或失败
     */
    @PostMapping("/update")
    public RUtil<Object> update(@Validated @RequestBody UserUpdateDto userUpdateDto) {
        return userService.updateUser(UserEntity.builder()
                .id(userUpdateDto.getId())
                .email(userUpdateDto.getEmail())
                .nickname(userUpdateDto.getNickname())
                .password(userUpdateDto.getPassword())
                .build());
    }

    /**
     * 删除指定用户.
     *
     * @param dto 包含待删除用户ID的数据传输对象
     * @return 操作结果，删除成功或失败
     */
    @PostMapping("/delete")
    public RUtil<Object> delete(@RequestBody IDDto dto) {
        return userService.removeById(dto.getId()) ? RUtil.ok() : RUtil.fail();
    }

    /**
     * 搜索用户，根据关键字搜索用户昵称或邮箱.
     *
     * @param searchDto 包含搜索关键字的数据传输对象，需要经过验证
     * @return 匹配搜索关键字的用户列表
     */
    @PostMapping("/search")
    public RUtil<Object> search(@Validated @RequestBody SearchDto searchDto) {
        return RUtil.ok(userService.list(QueryWrapper.create().where(USER_ENTITY.NICKNAME.like(searchDto.getKeyword()).or(USER_ENTITY.EMAIL.like(searchDto.getKeyword())))));
    }

    /**
     * 根据ID获取用户信息.
     *
     * @param dto 包含用户ID的数据传输对象
     * @return 指定ID的用户信息
     */
    @PostMapping("/getById")
    public RUtil<Object> getById(@RequestBody IDDto dto) {
        return RUtil.ok(userService.getById(dto.getId()));
    }

    /**
     * 清空所有用户数据.
     *
     * @param clearDto 包含密码的数据传输对象，需要经过验证
     * @return
     */
    @PostMapping("/clear")
    public RUtil<Object> clear(@RequestBody ClearDto clearDto) {
        if (!clearDto.getPassword().equals("123456")) {
            return RUtil.fail("密码错误");
        }
        return userService.clear();
    }
}
