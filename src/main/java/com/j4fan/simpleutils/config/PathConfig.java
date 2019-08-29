package com.j4fan.simpleutils.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class PathConfig {
    @Value("${root-location}")
    private String filePathBase;

    @Value("${root-url}")
    private String urlBase;

    @Bean(name = "filePath")
    public Path createFilePath(){
        Path path = Paths.get(filePathBase);
        return path;
    }

    @Bean(name = "urlBase")
    public Path createUrlPath(){
        Path path = Paths.get(urlBase);
        return path;
    }
}
