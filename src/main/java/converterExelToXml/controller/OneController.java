package converterExelToXml.controller;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import converterExelToXml.service.ExelService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@RequestMapping("/order")
@CrossOrigin("http://localhost:3000")
public class OneController {

    @Autowired
    ExelService exelService;
    @PostMapping("/2")
    public ResponseEntity<String> uploadExcel(@RequestBody MultipartFile file) throws IOException {
        Workbook workbook = new XSSFWorkbook(file.getInputStream());
        exelService.processWorkbook((MultipartFile) workbook);
        return new ResponseEntity<>("File processed successfully", HttpStatus.OK);
    }
}


