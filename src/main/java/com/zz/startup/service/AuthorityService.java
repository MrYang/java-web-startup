package com.zz.startup.service;

import com.google.common.collect.Lists;
import com.zz.startup.entity.Authority;
import com.zz.startup.repository.AuthorityDao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityService extends BaseService<Authority, String> {

    @Autowired
    private AuthorityDao authorityDao;

    public void createAuthority(Authority authority) {
        authorityDao.save(authority);

        String parentId = authority.getParentId();

        if (!StringUtils.equals(parentId, "#")) {
            Authority parent = get(parentId);
            List<String> children = parent.getChildren();
            if (children == null) {
                children = Lists.newArrayList();
            }
            children.add(authority.getId());
            parent.setChildren(children);
            authorityDao.save(parent);
        }
    }
}