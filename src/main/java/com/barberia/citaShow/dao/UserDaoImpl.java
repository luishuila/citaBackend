package com.barberia.citaShow.dao;

import com.barberia.citaShow.dto.UsersDto;
import com.barberia.citaShow.entity.RoleEntity;
import com.barberia.citaShow.entity.UsersEntity;
import com.barberia.citaShow.mapper.RoleMapper;
import com.barberia.citaShow.mapper.UsersMapper;
import com.barberia.citaShow.repository.RolesCrudRepository;
import com.barberia.citaShow.repository.UserCrudRepository;
import com.barberia.citaShow.request.CreateRoleRequest;
import com.barberia.citaShow.request.CreateUsersRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Repository
public class UserDaoImpl implements UserDao {


    @Autowired(required=true)
    private UsersMapper mapper;

    @Autowired(required=true)
    private RoleMapper roleMapper;
    //JdbcTemplate jdbcTemplate;

    @Autowired
    private UserCrudRepository userCrudRepository;

    @Autowired
    private RolesCrudRepository rolesCrudRepository;

    public UserDaoImpl(DataSource dataSource) {
    //    jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Autowired
    private PasswordEncoder passwordEncoder;


    public  UsersEntity  getById( Long id){
            return  userCrudRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Clase no encontrada"));
    }

    @Override
    public UsersDto save(CreateUsersRequest request) {

        request.setPassword(passwordEncoder.encode(request.getPassword()));
        UsersEntity user = userCrudRepository.save( mapper.usersRequestToUsers( request));
        UsersEntity usefile = userCrudRepository.findById(user.getId()).orElseThrow(() -> new IllegalArgumentException("Clase no encontrada"));

        for (CreateRoleRequest variable : request.getRole()) {
            RoleEntity roles=    rolesCrudRepository.findById(variable.getId()).orElseThrow(() -> new IllegalArgumentException("Clase no encontrada"));
            roles.getUsers().add(user);
            usefile.getRole().add(roles);
        }

        UsersDto users = mapper.toUsersDto(user);

        return users;
    }
}
