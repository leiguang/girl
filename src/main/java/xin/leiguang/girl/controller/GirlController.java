package xin.leiguang.girl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import xin.leiguang.girl.domain.Girl;
import xin.leiguang.girl.domain.Result;
import xin.leiguang.girl.repository.GirlRepository;
import xin.leiguang.girl.service.GirlService;
import xin.leiguang.girl.utils.ResultUtil;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 查询所有女生列表
     */
    @GetMapping("/girls")
    public List<Girl> girlList() {
        return girlRepository.findAll();
    }

    /**
     * 添加一个女生
     */
    @PostMapping("/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(girlRepository.save(girl));
    }

    /**
     * 查询一个女生
     */
    @GetMapping("/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id) {
        return girlRepository.findById(id).orElse(null);
    }

    /**
     * 更新
     */
    @PutMapping("/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age) {
        Optional<Girl> optionalGirl = girlRepository.findById(id);
        if (optionalGirl.isPresent()) {
            Girl girl = optionalGirl.get();
            girl.setCupSize(cupSize);
            girl.setAge(age);
            return girlRepository.save(girl);
        }
        return null;
    }

    /**
     * 删除
     */
    @DeleteMapping("/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id) {
        girlRepository.deleteById(id);
    }

    /**
     * 通过年龄查询女生列表
     */
    @GetMapping("/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }

    /**
     * 通过cupSize来查询女生列表
     */
    @GetMapping("/girls/cupSize/{cupSize}")
    public List<Girl> girlListByCupSize(@PathVariable("cupSize") String cupSize) {
        return girlRepository.findByCupSize(cupSize);
    }

    @PostMapping("/girls/two")
    public void girlTwo() {
        girlService.insertTwo();
    }

    @GetMapping("/girls/getAge/{id}")
    public Integer getAge(@PathVariable("id") Integer id) throws Exception {
        return girlService.getAge(id);
    }
}
