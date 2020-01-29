package com.upffice.repo;

import com.upffice.model.ApprovalDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ApprovalRepository extends CrudRepository<ApprovalDto, Integer> {

        //결재자 1,2,3 중에 현재 접속중인 ID와 같으면 결재대기함으로 select all
        @Query("SELECT a FROM ApprovalDto a WHERE a.app_sign_id1=?1 or a.app_sign_id2=?2 or a.app_sign_id3=?3 order by a.app_doc_num desc")
        List<ApprovalDto> findBySignId(int app_sign_id1, int app_sign_id2, int app_sign_id3);

        @Query("SELECT a From ApprovalDto a WHERE a.app_doc_num=?1")
        ApprovalDto findByApp_doc_num(int app_doc_num);

        @Query("SELECT a FROM ApprovalDto a WHERE a.app_writer_id=?1 order by a.app_doc_num desc")
        List<ApprovalDto> findByWriterId(int app_writer_id);

        @Query("SELECT a FROM ApprovalDto a order by a.app_doc_num desc")
        List<ApprovalDto> findDocs();

        @Query("SELECT a FROM ApprovalDto a JOIN EmployeeDto e" +
                " ON e.emp_id = a.app_sign_id1 OR e.emp_id = a.app_sign_id2 OR e.emp_id = a.app_sign_id3 WHERE e.dep_id=?1 order by a.app_doc_num desc")
        List<ApprovalDto> findByDepId(int dep_id);

       /* select a.* from approval a
        join employees e
        on e.emp_id = a.app_sign_id1
        or e.emp_id = a.app_sign_id2
        or e.emp_id = a.app_sign_id3
        where e.dep_id = 4;*/
        /*@Modifying
        @Transactional
        @Query("UPDATE ApprovalDto SET emp_pw = ?1, phone_number = ?2 WHERE emp_id = ?3")
        int updatePhone(String emp_pw, String phone_number, int emp_id);*/
}
