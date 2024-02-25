package project.Oshana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project.Oshana.payload.ResponeData;
import project.Oshana.service.imp.MenuServiceImp;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    MenuServiceImp menuServiceImp;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadMenu(@RequestParam MultipartFile file,
                                        @RequestParam String title,
                                        @RequestParam String timeShip,
                                        @RequestParam boolean isFreeShip,
                                        @RequestParam double price,
                                        @RequestParam int cateID){

        ResponeData responeData = new ResponeData();
        boolean isSuccess = menuServiceImp.insertMenu(file, title, timeShip, isFreeShip, price, cateID);
        responeData.setSuccess(isSuccess);
        return new ResponseEntity<>(responeData, HttpStatus.OK);
    }
}
