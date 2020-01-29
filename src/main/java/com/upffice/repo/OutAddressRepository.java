package com.upffice.repo;

import com.upffice.model.OutAddressDto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

public interface OutAddressRepository extends CrudRepository<OutAddressDto, Integer> {

    @Query("SELECT nameAndCompany from OutAddressDto nameAndCompany WHERE nameAndCompany.outName like ?1 or nameAndCompany.outCompany like ?2")
    List<OutAddressDto> findByNameAndOutCompanyLike(String outName, String outCompany);

    /* ManagerPage에서 외부주소록 수정시 사용 */
    @Modifying
    @Transactional
    @Query("UPDATE OutAddressDto SET outName = ?1, out_mobile = ?2, out_email=?3, " +
            "outCompany=?4, out_dep_phone=?5 WHERE out_id = ?6")
    int managerOutUpdate(String outName, String out_mobile, String out_email, String outCompany,
                         String  out_dep_phone, int out_id);




}
