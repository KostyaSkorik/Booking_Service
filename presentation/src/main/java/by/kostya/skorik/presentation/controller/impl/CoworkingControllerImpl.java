package by.kostya.skorik.presentation.controller.impl;

import by.kostya.skorik.presentation.controller.in.CoworkingController;
import by.kostya.skorik.presentation.dto.CoworkingDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("coworking/api")
public class CoworkingControllerImpl implements CoworkingController {

    public ResponseEntity<List<CoworkingDto>> getCoworkings(){
//        System.out.println(client.getAttributes().get("email"));
        return ResponseEntity.ok().body(null);
    }

}
