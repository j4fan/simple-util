package com.j4fan.simpleutils.service;

import com.j4fan.simpleutils.domin.PicInfo;
import com.j4fan.simpleutils.exception.StorageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Service
public class PicService {

    @Autowired
    @Qualifier("filePath")
    private Path filePathRoot;

    @Autowired
    @Qualifier("urlBase")
    private Path urlBase;

    public PicInfo saveFile(MultipartFile file) throws Exception {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        Path filePath = filePathRoot.resolve(filename);
        Path url = urlBase.resolve(filename);
        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file" + filename);
            }
            if (filename.contains("..")) {
                // This is a security check
                throw new StorageException(
                        "Cannot store file with relative path outside current directory "
                                + filename);
            }
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            PicInfo picInfo = new PicInfo().setName(filename).setLocation(filePath.toString()).setUrl(url.toString()).setDescription("upload");
            return picInfo;
        } catch (IOException e) {
            e.printStackTrace();
            throw new StorageException("Failed to store file");
        }
    }

}
