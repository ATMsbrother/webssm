package ssm.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ssm.model.UserInfo;

import java.util.List;

//加载spring配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class UserDaoTest {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    public void testSelectUser(){
        int id = 1;
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(1);
        System.out.println("----------------------------"+userInfo.getUsername());
        List<UserInfo> userInfos = userInfoMapper.getAllUsers();
        System.out.println(userInfos.toString());
    }
}
