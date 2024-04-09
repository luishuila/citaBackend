package com.barberia.citaShow.controller;



import com.barberia.citaShow.config.Errores.ApplicationCustomException;
import com.barberia.citaShow.request.CreateUsersRequest;
import com.barberia.citaShow.response.UsersResponse;
import com.barberia.citaShow.services.UserServicesImpl;

import com.barberia.citaShow.util.MessagesConstants;
import com.barberia.citaShow.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserServicesImpl  userServices;
    @GetMapping()
    public ResponseEntity<String> all() {
        return new ResponseEntity<>("Hola mundo", HttpStatus.CREATED);
    }
    @PostMapping()

    public ResponseEntity<ResponseMessage<UsersResponse>> save(@RequestBody CreateUsersRequest request)throws ApplicationCustomException {
        if (false) {
            throw new ApplicationCustomException(1, String.format(MessagesConstants.ENTITY_ALREADY_EXISTS, "ENTITY_NAME"));
        }
        return ResponseEntity.ok(new ResponseMessage<>(43, null, userServices.save(request)));
     // return new ResponseEntity<>(userServices.save(request), HttpStatus.CREATED).getBody();
    }

    public UsersResponse udpate(@RequestBody CreateUsersRequest request) {

        return new ResponseEntity<>(userServices.save(request), HttpStatus.CREATED).getBody();
    }


    @GetMapping({"/{id}"})
    public UsersResponse getById(@PathVariable Long id) {
        return new ResponseEntity<>(userServices.getById( id), HttpStatus.CREATED).getBody();
    }


    @GetMapping({"/getAll"})
    public void  getAll() {

    }

    @PostMapping({"/delete"})
    public void delete(@RequestBody  CreateUsersRequest request){


    }

}
