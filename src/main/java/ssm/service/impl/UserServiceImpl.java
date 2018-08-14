package ssm.service.impl;

import org.springframework.stereotype.Service;
import ssm.dao.UserInfoMapper;
import ssm.model.UserInfo;
import ssm.service.UserService;

import javax.annotation.Resource;

/**
 * @FileName
 * @Author 陈修斌
 * @Date 2018/8/14 11:40
 * @Description
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserInfoMapper userInfoMapper;

    public UserInfo selectUser(int userId) {
        return this.userInfoMapper.selectByPrimaryKey(userId);
    }
}
