package com.upffice.repo;

import com.upffice.model.DepartmentDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<DepartmentDto, Integer> {

    /* 부서 번호로 부서 이름 가져오는 쿼리 */
    @Query("SELECT dep_name FROM DepartmentDto WHERE dep_id=?1")
    String getDepNameById(int dep_id);
}
