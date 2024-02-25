package project.Oshana.service.imp;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileServiceImp {
    void init();
    boolean saveFile(MultipartFile multipartFile);
    Resource loadFile(String filename);
}
