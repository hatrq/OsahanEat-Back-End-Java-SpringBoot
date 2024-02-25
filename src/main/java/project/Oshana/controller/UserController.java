package project.Oshana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.Oshana.service.UserService;
import project.Oshana.service.imp.UserServiceImp;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserServiceImp userServiceImp;

    @GetMapping("/all_users")
    public ResponseEntity<?> getAllUsers(){

        return new ResponseEntity<>(userServiceImp.getAllUsers(), HttpStatus.OK);
    }
}
