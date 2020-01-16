package com.upffice.repo;

import com.upffice.model.EmployeeDto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
<<<<<<< HEAD
=======
import java.sql.Date;
>>>>>>> origin/master

public interface EmployeeRepository extends CrudRepository<EmployeeDto, Integer> {
    /*
     * Employees 테이블에 해당하는 Repository
     */

    /* UpfficeFront의 MainView.vue 에서 로그인 체크 할 때 사용 */
    @Query("SELECT COUNT(emp_id) FROM EmployeeDto WHERE emp_id=?1 and emp_pw=?2")
    int checkLogin(int emp_id, String emp_pw);

    /* UpfficeFront의 emp_id에 해당하는 사원명 필요할 때 사용 */
    @Query("SELECT emp_name FROM EmployeeDto WHERE emp_id=?1")
    String getNameById(int emp_id);

    /*
    * UPDATE 쿼리 작성 할 때는 @Modifying, @transactinal 어노테이션을 추가 사용해야 한다.
    * UpfficeFront의 MypageInfo.vue 에서 정보 수정 시에 사용. : 비밀번호와 휴대폰 번호 수정
    */
    @Modifying
    @Transactional
    @Query("UPDATE EmployeeDto SET emp_pw = ?1, phone_number = ?2 WHERE emp_id = ?3")
    int updatePhone(String emp_pw, String phone_number, int emp_id);

    /* UpfficeFront의 emp_id에 해당하는 입사일이 필요할 때 사용 */
    @Query("SELECT hire_date FROM EmployeeDto WHERE emp_id=?1")
    Date getHireDateById(int emp_id);

}
