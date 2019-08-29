package com.j4fan.simpleutils.repository;

import com.j4fan.simpleutils.domin.PicInfo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PicRepository extends CrudRepository<PicInfo,Integer> {

    List<PicInfo> findByName(String name);

}
