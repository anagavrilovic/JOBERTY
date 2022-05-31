package com.joberty.backend.service.interfaces;

import com.joberty.backend.model.Role;
import java.util.List;

public interface RoleService {

    Role findById(Integer id);
    List<Role> findByName(String name);
    Role findOneByName(String name);
}
