package com.upffice.controller;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

import com.upffice.model.AnnualDto;
import com.upffice.model.WorkingDto;
import com.upffice.repo.AnnualRepository;
import com.upffice.repo.EmployeeRepository;
import com.upffice.repo.WorkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/working")
public class WorkingController {
    /*
     * UpfficeFront 의 근태관리 기능에 사용되는 Controller
     */

    //근무 시간과 관련된 조회에 사용되는 Repository
    @Autowired
    WorkingRepository workingRepository;

    //연차와 관련된 조회에 사용되는 Repository
    @Autowired
    AnnualRepository annualRepository;

    //근속년수 계산을 위해 입사일을 가져올 때 사용 Repository
    @Autowired
    EmployeeRepository employeeRepository;

    //------------------------------------------------------------------------------------------
    //WorkingSubMenu에서 사용
    //------------------------------------------------------------------------------------------

    // UpfficeFront 의 WorkingSubMenu.vue가 mounted 되고 그 안의 메소드 호출 시, 매핑 됨
    // 당일 출근시간, 퇴근시간, 근무시간이 있다면 전송
    @GetMapping("/readToday/{empId}")
    public ResponseEntity<WorkingDto> workingReadToday(@PathVariable("empId") int empId) {
        Optional<WorkingDto> workingData = workingRepository.findByEmpIdAndWorkingDate(empId, new Date(System.currentTimeMillis()));

        if (workingData.isPresent()) {
            WorkingDto _working = workingData.get();
            return new ResponseEntity<>(_working, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // UpfficeFront 의 WorkingSubMenu.vue에서 출근 했을 시, 매핑 됨
    // 출근시간을 DB에 저장하고 성공 시 출근 시간을 전송
    @GetMapping("/saveIn/{empId}")
    public String workingSaveIn(@PathVariable("empId") int empId) {
        Time nowTime = new Time(System.currentTimeMillis());
        workingRepository.save(new WorkingDto(empId, new Date(System.currentTimeMillis()), nowTime));
        System.out.println(new Date(System.currentTimeMillis()));
        return nowTime + "";
    }

    // UpfficeFront 의 WorkingSubMenu.vue에서 퇴근 했을 시, 매핑 됨
    // 퇴근시간을 DB에 저장하고 성공 시 퇴근 시간을 전송
    @GetMapping("/saveOut/{empId}")
    public ResponseEntity<String> workingSaveOut(@PathVariable("empId") int empId) {
        Optional<WorkingDto> workingData = workingRepository.findByEmpIdAndWorkingDate(empId, new Date(System.currentTimeMillis()));

        if (workingData.isPresent()) {
            WorkingDto _working = workingData.get();
            _working.setWorkingOut(new Time(System.currentTimeMillis()));
            workingRepository.save(_working);
            return new ResponseEntity<>(_working.getWorkingOut() + "", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // UpfficeFront 의 WorkingSubMenu.vue에서 근무시간을 저장할 때, 매핑 됨
    // 근무시간을을 DB에 저장하고 성공 시 근무 시간을을 전송
    @GetMapping("/saveTime/{empId}")
    public ResponseEntity<String> workingSaveTime(@PathVariable("empId") int empId, @RequestParam("time") String workingTime) {
        Optional<WorkingDto> workingData = workingRepository.findByEmpIdAndWorkingDate(empId, new Date(System.currentTimeMillis()));
        if (workingData.isPresent()) {
            WorkingDto _working = workingData.get();
            _working.setWorkingTime(workingTime);
            workingRepository.save(_working);
            return new ResponseEntity<>(_working.getWorkingTime() + "", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //------------------------------------------------------------------------------------------
    //WorkingStatus에서 사용
    //------------------------------------------------------------------------------------------


    //------------------------------------------------------------------------------------------
    //AnnulDetail에서 사용
    //------------------------------------------------------------------------------------------

    // UpfficeFront 의 AnnualDetail.vue가 mounted 되고 그 안의 메소드 호출 시, 매핑 됨
    // 사용 연차 내역 조회
    @GetMapping("/annuals/{empId}")
    public List<Object> readAnnuals(@PathVariable("empId") int empId) {
        String janFirst = new Date(System.currentTimeMillis()).toString().substring(0, 4) + "-01-01";
        List<Object> annuals = annualRepository.findAnnualDatesByEmpId(empId, janFirst);
        return annuals;
    }

    // UpfficeFront 의 annualDetail.vue mounted 되고 그 안의 메소드 호출 시, 매핑 됨
    // 총 연차를 계산하여 전송
    @GetMapping("/totalAnnuals/{empId}")
    public ResponseEntity<Integer> readTotalAnnual(@PathVariable("empId") int empId) {
        Date hireDate = employeeRepository.getHireDateById(empId);
        int workingDays = annualRepository.getWorkingDays(hireDate);// 근무 일수 조회
        if (workingDays >= 0) { // 근무 중 이면
            int total = (workingDays - 365) / 730 + 15; // 연차 계산
            return new ResponseEntity<>(total, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // UpfficeFront 의 annualDetail.vue에서 연차를 신청할 때, 매핑 됨
    // 연차신청일을 DB에 저장
    @GetMapping("/applyAnnual/{empId}")
    public ResponseEntity<String> applyAnnual(@PathVariable("empId") int empId, @RequestParam("date") String applyDate) {
        Optional<AnnualDto> annualData = annualRepository.findAnnualByEmpId(empId, applyDate);
        if (!annualData.isPresent()) {
            annualRepository.save(new AnnualDto(empId,applyDate));
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}