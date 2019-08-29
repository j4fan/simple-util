package com.j4fan.simpleutils.domin;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity(name = "pic_info")
@Accessors(chain = true)
public class PicInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String location;
    private String url;
    private String description;
    private Date createTime;
    private Date updateTime;

    public PicInfo() {
    }

    public PicInfo(String name, String location, String url, String description) {
        this.name = name;
        this.location = location;
        this.url = url;
        this.description = description;
    }
}
