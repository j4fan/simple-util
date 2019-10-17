package com.j4fan.simpleutils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.log4j.Log4j2;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class TestMockMvc {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    @Transactional
    public void getMockTest() throws Exception {
        Goods goods = new Goods().setName("tt").setCount(3).setVersion(3).
                setCreateTime(LocalDate.of(2019,1,2).toString()).
                setUpdateTime(LocalDate.of(2019,2,3).toString());

        ObjectMapper objectMapper = new ObjectMapper();


        String responseString = mockMvc.perform(
                post("/goods/insert")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(objectMapper.writeValueAsString(goods))).
                andExpect(status().isOk())    //返回的状态是200
                .andDo(print())         //打印出请求和相应的内容
                .andReturn().getResponse().getContentAsString();
        System.out.println(responseString);

    }


    @Data
    @Accessors(chain = true)
    static class Goods {
        private Integer id;
        private String name;
        private Integer count;
        private Integer version;
        private String createTime;
        private String updateTime;
    }

}
