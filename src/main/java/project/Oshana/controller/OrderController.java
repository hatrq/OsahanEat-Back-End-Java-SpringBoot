package project.Oshana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.Oshana.payload.request.OrderRequest;
import project.Oshana.service.imp.OrderServiceImp;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderServiceImp orderServiceImp;

    @PostMapping("/insert")
    public ResponseEntity<?> insertOrder(@RequestBody OrderRequest orderRequest){
        return new ResponseEntity<>(orderServiceImp.insertOrder(orderRequest), HttpStatus.OK);
    }
}
