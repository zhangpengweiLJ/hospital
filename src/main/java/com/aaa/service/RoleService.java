package com.aaa.service;

import com.aaa.entity.DataGridView;
import com.aaa.entity.Role;
import com.aaa.entity.RoleMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleService {
    /*
     *
     * */
    List<Role> loadAllRole(Role role);

    int insertRole(Role role);

    int updateRole(Role role);

    int deleteRoleId(Integer roleid);

    int deleteRoleMenuId(Integer roleid);

    int deleteRoleUserId(Integer roleid);
    DataGridView initRoleMenuTreeJson(Integer roleid);
    void saveRoleMenu(RoleMenu roleMenu);
}