package hello.typeconverter.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import hello.typeconverter.fomatter.MyNumberFormatter;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Controller
public class FormatterController {

    @GetMapping("/formatter/edit")
    public String formatterForm(Model model) {
        Form form = new Form();
        form.setNumber(10000);
        form.setLocalDateTime(LocalDateTime.now());
        model.addAttribute("form", form);
        return "formatter-form";
    }


    @ResponseBody
    @GetMapping(value = "/json/formatter/edit", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> jsonFormatterForm() {
        Map<String, Object> result = new HashMap<>();
        JacksonForm jsonForm = new JacksonForm();

        // 포맷 형식 지정
        DecimalFormat decimalFormat = new DecimalFormat("###,###");

        String number = decimalFormat.format(10000);
        jsonForm.setNumber(number);
        jsonForm.setLocalDateTime(LocalDateTime.now());
        System.out.println("jsonForm.getNumber() = " + jsonForm.getNumber());
        System.out.println("jsonForm.getLocalDateTime() = " + jsonForm.getLocalDateTime());
        result.put("jsonForm", jsonForm);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/formatter/edit")
    public String formatterEdit(@ModelAttribute Form form) {
        return "formatter-view";
    }

    @Data
    static class Form {

        @NumberFormat(pattern = "###,###")
        private Integer number;

        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime localDateTime;

    }

    @Data
    static class JacksonForm {

        private String number;

        // 제이슨 데이터 날짜 포맷
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime localDateTime;

    }
}
