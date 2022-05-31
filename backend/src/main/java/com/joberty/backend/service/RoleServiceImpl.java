package com.joberty.backend.service;

import com.joberty.backend.model.Role;
import com.joberty.backend.repository.RoleRepository;
import com.joberty.backend.service.interfaces.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Role findById(Integer id) { return this.roleRepository.findById(id).get(); }

    @Override
    public List<Role> findByName(String name) { return this.roleRepository.findByName(name); }

    @Override
    public Role findOneByName(String name) { return this.roleRepository.findOneByName(name); }
}
