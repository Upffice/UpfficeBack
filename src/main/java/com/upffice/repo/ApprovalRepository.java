package com.upffice.repo;

import com.upffice.model.ApprovalDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ApprovalRepository extends CrudRepository<ApprovalDto, Integer> {

        @Query("SELECT a FROM ApprovalDto a WHERE a.app_sign_id1=?1 or a.app_sign_id2=?2 or a.app_sign_id3=?3")
        Optional<ApprovalDto> findBySignId(int app_sign_id1, int app_sign_id2, int app_sign_id3);


}
