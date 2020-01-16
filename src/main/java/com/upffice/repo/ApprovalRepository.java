package com.upffice.repo;

import com.upffice.model.ApprovalDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ApprovalRepository extends CrudRepository<ApprovalDto, Integer> {

        //결재자 1,2,3 중에 현재 접속중인 ID와 같으면 결재대기함으로 select all
        @Query("SELECT a FROM ApprovalDto a WHERE a.app_sign_id1=?1 or a.app_sign_id2=?2 or a.app_sign_id3=?3 order by a.app_date desc")
        List<ApprovalDto> findBySignId(int app_sign_id1, int app_sign_id2, int app_sign_id3);

}
