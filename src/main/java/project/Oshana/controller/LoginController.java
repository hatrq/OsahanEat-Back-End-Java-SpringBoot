package project.Oshana.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.Oshana.payload.ResponeData;
import project.Oshana.service.imp.LoginServiceImp;
import project.Oshana.utils.JwtUtilsHelper;

import javax.crypto.SecretKey;

@RestController
@RequestMapping("login")
public class LoginController {
    @Autowired
    LoginServiceImp loginServiceImp;

    @Autowired
    JwtUtilsHelper jwtUtilsHelper;

    @PostMapping("")
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password){
        ResponeData responeData = new ResponeData();

        if (loginServiceImp.login(username, password)){
            responeData.setStatusCode(200);
            responeData.setDescription("Login Success!");
            responeData.setData(jwtUtilsHelper.generateToken(username));
        } else {
            responeData.setStatusCode(401);
            responeData.setDescription("Login Failed!");
            responeData.setSuccess(false);
        }
        return new ResponseEntity<>(responeData, HttpStatus.OK);
    }
}
