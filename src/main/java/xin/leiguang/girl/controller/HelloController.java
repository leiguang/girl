package xin.leiguang.girl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.leiguang.girl.properties.GirlProperties;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;

    @GetMapping("/say/{id}")
    public String say(@PathVariable("id") Integer myId) {
        return "id: " + myId;
    }

    @GetMapping("/age")
    public String age() {
        return "age: " + girlProperties.getAge();
    }
}
