package com.aaa.service.Impl;

import com.aaa.config.UserCredentialsMatcher;
import com.aaa.entity.DataGridView;
import com.aaa.entity.Role;
import com.aaa.entity.User;
import com.aaa.entity.UserRole;
import com.aaa.mapper.UserMapper;
import com.aaa.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public List<User> selectAllUser(User user) {
        return userMapper.selectAllUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public List<Role> initUserRole(Role role) {
        return userMapper.initUserRole(role);
    }
     //添加用户
    @Override
    public int addUser(User user) {

        return userMapper.addUser(user);
    }

    @Override
    public void deleteUser(Integer userid) {

        userMapper.deleteUserById(userid);
        userMapper.deleteRoleUser(userid);

    }

    @Override
    public int resetUserPwd(User user) {
        return userMapper.resetUserPwd(user);
    }

    @Override
    public DataGridView queryUserRole(Integer userid) {
        Integer uid=userid;
        List<Role> allRole = userMapper.queryAllRole();
        List<Role> userRole = userMapper.queryRoleById(uid);
        List<Map<String,Object>> data=new ArrayList<>();
        for (Role r1 : allRole) {
            Boolean LAY_CHECKED = false;
            for (Role r2 : userRole) {
                if (r1.getRoleid() == r2.getRoleid()) {
                    LAY_CHECKED = true;
                }
            }
            Map<String, Object> map = new HashMap<String, Object>();

            map.put("roleid", r1.getRoleid());
            map.put("rolename", r1.getRolename());
            map.put("roledesc", r1.getRoledesc());
            map.put("LAY_CHECKED", LAY_CHECKED);
            data.add(map);
        }
            return new DataGridView(data);
    }

    @Override
    public void saveUserRole(UserRole userRole) {
     Integer userid=userRole.getUserid();
     Integer[] roleids=userRole.getIds();
        userMapper.deleteRoleUser(userid);
        //循环添加用户分配的角色
        if(roleids!=null&&roleids.length>0){
            for(Integer rid:roleids){
                userMapper.insertUserRole(userid,rid);
            }
        }

    }

    @Override
    public List<User> updateLogin(User user) {
        return userMapper.updateLogin(user);
    }

    @Override
    public int editLogin(User user) {
        return userMapper.editLogin(user);
    }

    @Override
    public int editPwd(User user) {
        return userMapper.editPwd(user);
    }


}