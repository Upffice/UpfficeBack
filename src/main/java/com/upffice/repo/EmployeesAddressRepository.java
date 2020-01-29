package com.upffice.repo;

import com.upffice.model.EmployeesAddressDto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

public interface EmployeesAddressRepository extends CrudRepository<EmployeesAddressDto,Integer>{

    /* 내부 직원 성명과 직책으로 검색- EmployeesAddressMain에서 사용 */
    @Query("SELECT nameAndPosition from EmployeesAddressDto nameAndPosition " +
            "WHERE nameAndPosition.name like ?1 or nameAndPosition.position like ?2")
    List<EmployeesAddressDto> findByNameAndPositionLike(String name, String position);


    /* ManagerPage에서 내부주소록 수정시 사용 */
    @Modifying
    @Transactional
    @Query("UPDATE EmployeesAddressDto SET name = ?1, emp_email = ?2, position=?3, " +
            "hire_date=?4, extension_number=?5, phone_number=?6, dep_id=?7  WHERE emp_id = ?8")
    int managerEmployeesUpdate(String name, String emp_email, String position, Date hire_date,
                      String extension_number, String phone_number, int dep_id , int emp_id);


}
