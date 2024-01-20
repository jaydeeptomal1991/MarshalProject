package com.jxb.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jxb.entity.Address;
import com.jxb.service.EmployeeService;

@RestController
public class EmployeeController {

    private @Autowired EmployeeService employeeService;

    @PostMapping("/xmlToObject")
    public ResponseEntity<?> convertXmlToObject(@RequestBody List<Address> address ){
        try{
            String line;
            StringBuilder sb=new StringBuilder();
            File file=new File("D:\\vendor\\Aroha.xml");
            if(file.isFile()) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file.getAbsoluteFile()));
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                    sb.append(line);
                }
                employeeService.marshalling(sb,address);
                return ResponseEntity.ok(sb);
            }else{
                return ResponseEntity.ok("File not found");
            }
        }catch (Exception ex){
            ex.printStackTrace();
            return ResponseEntity.ok(ex.getMessage());
        }

    }
}
