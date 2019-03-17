package lfc.service.impl;

import lfc.mapper.UserMapper;
import lfc.pojo.User;
import lfc.pojo.UserExample;
import lfc.service.UserService;
import lfc.util.PasswordUtil;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, UserExample> implements UserService {
    @Override
    public boolean isExist(String username) throws Exception {
        return !list("name", username).isEmpty();
    }

    @Override
    public Integer add(User user) throws Exception {
        String rawPassword = user.getPassword();
        user.setPassword(PasswordUtil.encryptPassword(rawPassword));
        return super.add(user);
    }

    @Override
    public User get(String name, String password) {
        return (User) getOne("name", name, "password", password, "order","id asc");
    }
}