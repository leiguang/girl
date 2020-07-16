package xin.leiguang.girl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.leiguang.girl.domain.Girl;
import xin.leiguang.girl.enums.ResultEnum;
import xin.leiguang.girl.exception.GirlException;
import xin.leiguang.girl.repository.GirlRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo() {
        Girl girl1 = new Girl();
        girl1.setAge(18);
        girl1.setCupSize("A");
        girl1.setMoney(100.0);
        girlRepository.save(girl1);

        Girl girl2 = new Girl();
        girl2.setAge(19);
        girl2.setCupSize("B");
        girl2.setMoney(200.0);
        girlRepository.save(girl2);
    }

    public Integer getAge(Integer id) throws Exception {
        Optional<Girl> optionalGirl = girlRepository.findById(id);
        if (!optionalGirl.isPresent()) {
            throw new GirlException(ResultEnum.UNKNOW_ERROR);
        }

        Integer age = optionalGirl.get().getAge();
        if (age < 10) {
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        } else if (age > 10 && age < 16) {
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }

        return age;
    }
}
