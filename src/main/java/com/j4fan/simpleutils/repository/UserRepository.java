package com.j4fan.simpleutils.repository;

import com.j4fan.simpleutils.domin.UserInfo;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserInfo, Long> {

    @Override
    <S extends UserInfo> S save(S s);

    UserInfo getById(Long id);

    UserInfo getByUserName(String userName);
}
