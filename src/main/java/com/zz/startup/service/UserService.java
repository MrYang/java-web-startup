package com.zz.startup.service;

import com.zz.startup.entity.User;
import com.zz.startup.repository.UserDao;
import com.zz.startup.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springside.modules.security.utils.Digests;
import org.springside.modules.utils.Encodes;

@Service
public class UserService extends BaseService<User, String> {

    @Autowired
    private UserDao userDao;

    public void createUser(User user){
        entryptPassword(user);
        userDao.save(user);
    }

    public void entryptPassword(User user) {
        byte[] salt = Digests.generateSalt(Constants.SALT_SIZE);
        user.setSalt(Encodes.encodeHex(salt));

        byte[] hashPassword = Digests.sha1(user.getPlainPassword().getBytes(), salt, Constants.HASH_INTERATIONS);
        user.setPassword(Encodes.encodeHex(hashPassword));
    }
}
