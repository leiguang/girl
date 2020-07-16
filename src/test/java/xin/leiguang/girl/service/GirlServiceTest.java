package xin.leiguang.girl.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xin.leiguang.girl.domain.Girl;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void findOneTest() {
        Girl girl = girlService.findById(8);
        assertSame(8, girl.getAge());
    }
}