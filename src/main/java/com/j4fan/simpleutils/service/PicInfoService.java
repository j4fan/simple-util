package com.j4fan.simpleutils.service;

import com.j4fan.simpleutils.domin.PicInfo;
import com.j4fan.simpleutils.repository.PicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PicInfoService {

    @Autowired
    PicRepository picRepository;

    public void savePic(PicInfo picInfo) {
        picRepository.save(picInfo);
    }

    public PicInfo getPicByName(int id) {
        Optional<PicInfo> picInfo = picRepository.findById(id);
        return picInfo.get();
    }

    public void deletePicById(int id) {
        picRepository.deleteById(id);
    }

}
