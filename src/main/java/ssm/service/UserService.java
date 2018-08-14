package ssm.service;

import ssm.model.UserInfo;

/**
 * @FileName
 * @Author 陈修斌
 * @Date 2018/8/14 11:39
 * @Description
 */
public interface UserService {

    public UserInfo selectUser(int userId);
}
