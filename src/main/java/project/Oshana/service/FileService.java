package project.Oshana.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import project.Oshana.service.imp.FileServiceImp;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileService implements FileServiceImp {
    @Value("${fileUpload.rootPath}")
    private String root;

    private Path path;

    @Override
    public void init() {
        path = Paths.get(root);
        try{
            if (Files.notExists(path)){
                Files.createDirectories(path);
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize file for upload " + e.getMessage());
        }
    }

    @Override
    public boolean saveFile(MultipartFile file) {
        try{
            init();
            Files.copy(file.getInputStream(), path.resolve(file.getOriginalFilename()));
            return true;
        } catch (Exception e) {
            if (e instanceof FileAlreadyExistsException) {
                throw new RuntimeException("A file of that name already exists.");
            }
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Resource loadFile(String filename) {
        try{
            Path file = path.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()){
               return resource;
            } else {
               throw new RuntimeException("Could not read a file!");
            }
        } catch (MultipartException | MalformedURLException e){
            throw new MultipartException(e.getMessage());
        }
    }
}
