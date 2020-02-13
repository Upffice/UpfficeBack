package com.upffice.controller;

import com.upffice.model.EmployeesAddressDto;
import com.upffice.repo.EmployeesAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/employees")
public class EmployeesAddressController {

    @Autowired
    EmployeesAddressRepository employeesAddressRepository;

    @GetMapping("/employees")                               /*데이터 다 불러오기*/
    public List<EmployeesAddressDto> getAllEmployees() {
        System.out.println("Get all employees...");

        List<EmployeesAddressDto> employees = new ArrayList<>();
        employeesAddressRepository.findAll().forEach(employees::add);
        return employees;
    }


    @GetMapping("/employees/nameAndPosition/{nameAndPosition}")     /*이름,직책으로 찾기*/
    public List<EmployeesAddressDto> findByNameAndPositionLike(@PathVariable("nameAndPosition") String nameAndPosition) {
        System.out.println("이름,직책으로 찾기");
        List<EmployeesAddressDto> employeesaddress = employeesAddressRepository.findByNameAndPositionLike("%" + nameAndPosition + "%", "%" + nameAndPosition + "%");
        return employeesaddress;
    }

    /* UpfficeFront 의 MypageInfo.vue 가 mounted 되고 그 안의 메소드 호출 시, 매핑 됨 */
    @PostMapping("/detail/{id}")
    public EmployeesAddressDto getEmployeeInfo(@PathVariable("id") int id) {
        Optional<EmployeesAddressDto> emp = employeesAddressRepository.findById(id);

        /* 어차피 id 값이 있을 거라 if 필요없을 것 같긴 하지만,
         안전하게 결과값 존재하는지 조건문으로 검사함. */
        if (emp.isPresent()) {
            EmployeesAddressDto _emp = emp.get();
            return _emp; // emp_id에 해당하는 사원 정보를 리턴한다.
        }

        return null; // 없으면 null 리턴
    }

    @PutMapping("/update/{id}")                             /*내부주소록 수정*/
    public int updateInfo(@PathVariable("id") int id, @RequestBody EmployeesAddressDto data) {

        int chk = employeesAddressRepository.managerEmployeesUpdate(data.getName(), data.getEmp_email(),
                data.getPosition(), data.getHire_date(), data.getExtension_number(),
                data.getPhone_number(), data.getDep_id(), id);
        return chk;

    }

    @PostMapping("/employees/add")                                    /*내부주소록 직원 추가*/
    public EmployeesAddressDto addEmployees(@RequestBody EmployeesAddressDto employees) {
        System.out.println(employees);
        EmployeesAddressDto _employees = employeesAddressRepository.save(new EmployeesAddressDto(employees.getEmp_id(),
                employees.getEmp_pw(), employees.getName(), employees.getEmp_email(), employees.getPosition(),
                employees.getHire_date(), employees.getExtension_number(), employees.getPhone_number(), employees.getDep_id()));
        System.out.println(_employees);
        return _employees;

    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> deleteEmployees(@PathVariable("id") int id) {
        System.out.println("Delete Employees with ID = " + id + "...");

        employeesAddressRepository.deleteById(id);

        return new ResponseEntity<>("Employees has been deleted!", HttpStatus.OK);
    }
/*---------------------------------이미지 업로드(manager Page)---------------------------------------------------*/
    @PostMapping("/image")
    public String uploadImage(@RequestParam("file") MultipartFile[] files) throws IllegalStateException, IOException {
        /* C:\Users\elfin\UpfficeProject\UpfficeBack */
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);

        /* C:\Users\elfin\UpfficeProject\UpfficeBack\src\assets\문서번호\파일명 */
        String UPLOADED_FOLDER = projectPath + "\\src\\main\\resources\\static\\emp_img\\";
//        System.out.println(UPLOADED_FOLDER);
//        System.out.println("파일이"+files.length+"개 들어왔음");

        String status = "";
        File dir = new File(UPLOADED_FOLDER);
        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            try {
                byte[] bytes = file.getBytes();

                if (!dir.exists())
                    dir.mkdirs();

                File uploadFile = new File(dir.getAbsolutePath()
                        + File.separator + file.getOriginalFilename());
                BufferedOutputStream outputStream = new BufferedOutputStream(
                        new FileOutputStream(uploadFile));
                outputStream.write(bytes);
                outputStream.close();

                status = status + "You successfully uploaded file=" + file.getOriginalFilename();
            } catch (Exception e) {
                status = status + "Failed to upload " + file.getOriginalFilename() + " " + e.getMessage();
            }
        }
        return status;
    }

    /*---------------------------------파일 업로드,다운로드(manager Page)---------------------------------------------------*/


    @PostMapping("/multiple-files")
    public String uploadMultipleFiles(@RequestParam("file") MultipartFile[] files) throws IllegalStateException, IOException {
        /* C:\Users\elfin\UpfficeProject\UpfficeBack */
        String projectPath = System.getProperty("user.dir");

        /* C:\Users\elfin\UpfficeProject\UpfficeBack\src\assets\문서번호\파일명 */
        String UPLOADED_FOLDER = projectPath + "\\src\\main\\resources\\static\\m_file\\";
//        System.out.println(UPLOADED_FOLDER);
//        System.out.println("파일이"+files.length+"개 들어왔음");

        String status = "";
        File dir = new File(UPLOADED_FOLDER);
        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            try {
                byte[] bytes = file.getBytes();

                if (!dir.exists())
                    dir.mkdirs();

                File uploadFile = new File(dir.getAbsolutePath()
                        + File.separator + file.getOriginalFilename());
                BufferedOutputStream outputStream = new BufferedOutputStream(
                        new FileOutputStream(uploadFile));
                outputStream.write(bytes);
                outputStream.close();

                status = status + "You successfully uploaded file=" + file.getOriginalFilename();
            } catch (Exception e) {
                status = status + "Failed to upload " + file.getOriginalFilename() + " " + e.getMessage();
            }
        }
        return status;
    }

    /*전체다운로드*/
    @PostMapping("/files-download")
    public InputStreamResource downloadMultipleFiles(@RequestBody String filename) throws FileNotFoundException {
        System.out.println("다운로드 대기 : " + filename);

        /* C:\Users\elfin\UpfficeProject\UpfficeBack */
        String projectPath = System.getProperty("user.dir");

        /* C:\Users\elfin\UpfficeProject\UpfficeBack\src\assets\문서번호\파일명 */
        String UPLOADED_FOLDER = projectPath + "\\src\\main\\resources\\static\\m_file\\";
        String status = "";
        File dirFile = new File(UPLOADED_FOLDER);
        File[] fileList = dirFile.listFiles();
        InputStreamResource input = null;
        File uploadFile = new File(UPLOADED_FOLDER
                + File.separator + filename);
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(uploadFile));
        InputStreamResource inputStreamResource = new InputStreamResource(inputStream);

        return inputStreamResource;
    }



    /*파일명 가져오는애*/
    @GetMapping("/down")
    public String[] downloadLink() {
        /* C:\Users\elfin\UpfficeProject\UpfficeBack */
        String projectPath = System.getProperty("user.dir");

        /* C:\Users\elfin\UpfficeProject\UpfficeBack\src\m_file\문서번호\파일명 */
        String UPLOADED_FOLDER = projectPath + "\\src\\main\\resources\\static\\m_file\\";
        String status = "";
        File dirFile = new File(UPLOADED_FOLDER);
        File[] fileList = dirFile.listFiles();
        InputStreamResource input = null;
        String[] filename = new String[fileList.length];

        for (int i = 0; i < fileList.length; i++) {
            File tempFile = fileList[i];
            if (tempFile.isFile()) {
                String tempPath = tempFile.getParent();
                String tempFileName = tempFile.getName();
                System.out.println("Path=" + tempPath);
                System.out.println("FileName=" + tempFileName);
                filename[i] = tempFileName;
            }
        }
        return filename;
    }



}