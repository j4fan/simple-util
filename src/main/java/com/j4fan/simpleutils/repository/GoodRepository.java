package com.j4fan.simpleutils.repository;

import com.j4fan.simpleutils.domin.Goods;
import org.springframework.data.repository.CrudRepository;

public interface GoodRepository extends CrudRepository<Goods,Integer> {

    @Override
    <S extends Goods> S save(S s);
}
