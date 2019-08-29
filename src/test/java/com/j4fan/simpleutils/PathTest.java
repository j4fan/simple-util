package com.j4fan.simpleutils;

import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {

    @Test
    public void testPath() {

        Path path = Paths.get("/app/new/web");
        System.out.println(path.toAbsolutePath());

        Path path2 =Paths.get("/app/web/a.txt");
        System.out.println(path.resolve(path2.getFileName()));
        System.out.println(path2.getFileName().resolve(path));
    }
}
