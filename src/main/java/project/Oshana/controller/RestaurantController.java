package project.Oshana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project.Oshana.dto.RestaurantDTO;
import project.Oshana.payload.ResponeData;
import project.Oshana.service.imp.FileServiceImp;
import project.Oshana.service.imp.RestaurantServiceImp;

import java.util.Date;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    FileServiceImp fileServiceImp;

    @Autowired
    RestaurantServiceImp restaurantServiceImp;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadNewRestaurant(@RequestParam MultipartFile file,
                                                 @RequestParam String title,
                                                 @RequestParam String subtitle,
                                                 @RequestParam String description,
                                                 @RequestParam boolean isFreeShip,
                                                 @RequestParam String address,
                                                 @RequestParam String openDate){
        ResponeData responeData = new ResponeData();
        boolean isSuccess = restaurantServiceImp.insertRestaurant(file, title, subtitle, description, isFreeShip, address, openDate);
        responeData.setSuccess(isSuccess);
        return new ResponseEntity<>(responeData, HttpStatus.OK);
    }

    @GetMapping("/file/{filename:.+}")
    public ResponseEntity<?> getFile(@PathVariable String filename){
        Resource file = fileServiceImp.loadFile(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @GetMapping("/get_home_restaurant")
    public ResponseEntity<?> getHomeRestaurant(){
        return new ResponseEntity<>(restaurantServiceImp.getHomePageRestaurant(), HttpStatus.OK);
    }

    @GetMapping("/details")
    public ResponseEntity<?> getDetailRestaurant(@RequestParam int id){
        return new ResponseEntity<>(restaurantServiceImp.getDetailRestaurant(id), HttpStatus.OK);
    }
}
