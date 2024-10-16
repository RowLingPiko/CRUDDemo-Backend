package cn.voidtech.cruddemo.controller;

import cn.voidtech.cruddemo.domain.UserEntity;
import cn.voidtech.cruddemo.domain.dto.IDDto;
import cn.voidtech.cruddemo.domain.dto.SearchDto;
import cn.voidtech.cruddemo.domain.dto.UserDto;
import cn.voidtech.cruddemo.domain.dto.UserUpdateDto;
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
 * @author RowLingKaslana
 * @project CRUDDemo
 * @date 2024/10/15 17:35
 * This is the honor of the Kaslana!!!!
 * 願 人 類 榮 耀 長 存
 * 人 类 に 栄 光 あ れ
 * Glory to mankind！
 */
@Slf4j
@RestController
public class BaseController {
    private final UserService userService;

    public BaseController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/list")
    public RUtil<Object> list() {
        return RUtil.ok(userService.list());
    }

    @RequestMapping("/add")
    public RUtil<Object> add(@Validated @RequestBody UserDto userDto) {
        return userService.addUser(UserEntity.builder()
                .nickname(userDto.getNickname())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .build());
    }

    @PostMapping("/update")
    public RUtil<Object> update(@Validated @RequestBody UserUpdateDto userUpdateDto) {
        return userService.updateUser(UserEntity.builder()
                .id(userUpdateDto.getId())
                .email(userUpdateDto.getEmail())
                .nickname(userUpdateDto.getNickname())
                .password(userUpdateDto.getPassword())
                .build());
    }

    @PostMapping("/delete")
    public RUtil<Object> delete(@RequestBody IDDto dto) {
        return userService.removeById(dto.getId()) ? RUtil.ok() : RUtil.fail();
    }

    @PostMapping("/search")
    public RUtil<Object> search(@Validated @RequestBody SearchDto searchDto) {
        return RUtil.ok(userService.list(QueryWrapper.create().where(USER_ENTITY.NICKNAME.like(searchDto.getKeyword()).or(USER_ENTITY.EMAIL.like(searchDto.getKeyword())))));
    }

    @PostMapping("/getById")
    public RUtil<Object> getById(@RequestBody IDDto dto) {
        return RUtil.ok(userService.getById(dto.getId()));
    }
}
