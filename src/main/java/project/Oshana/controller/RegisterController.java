package project.Oshana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.Oshana.payload.ResponeData;
import project.Oshana.payload.request.RegisterRequest;
import project.Oshana.service.imp.RegisterServiceImp;

@RestController
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    RegisterServiceImp registerServiceImp;

    @PostMapping("")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest){
        ResponeData responeData = new ResponeData();
        if (registerServiceImp.register(registerRequest)){
            responeData.setStatusCode(200);
            responeData.setDescription("Register Success!");
        } else {
            responeData.setStatusCode(401);
            responeData.setDescription("Register Failed!");
        }
        return new ResponseEntity<>(responeData, HttpStatus.OK);
    }
}
