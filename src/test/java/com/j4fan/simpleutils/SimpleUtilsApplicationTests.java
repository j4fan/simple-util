package com.j4fan.simpleutils;

import com.j4fan.simpleutils.service.PicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleUtilsApplicationTests {
    @Autowired
    PicService picService;
    @Test
    public void contextLoads() {
    }

}
