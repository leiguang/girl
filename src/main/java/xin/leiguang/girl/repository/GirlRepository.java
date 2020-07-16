package xin.leiguang.girl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xin.leiguang.girl.domain.Girl;

import java.util.List;

public interface GirlRepository extends JpaRepository<Girl, Integer> {

    // 通过过年龄来查询
    public List<Girl> findByAge(Integer age);

    // 通过 cupSize 来查询
    public List<Girl> findByCupSize(String cupSize);
}
