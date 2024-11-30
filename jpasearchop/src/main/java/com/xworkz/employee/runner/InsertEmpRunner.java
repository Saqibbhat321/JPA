package com.xworkz.employee.runner;

import com.xworkz.employee.dto.EmpDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class InsertEmpRunner {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        List<EmpDto> empDtoList = new ArrayList<>();
        empDtoList.add(new EmpDto("saqib", "saqib@gmail.com", 21, "6005370241"));
        empDtoList.add(new EmpDto("Ntr", "ntr@gmail.com", 34, "999999999"));
        empDtoList.add(new EmpDto("Osama", "osama@gmail.com", 23, "123456789"));
        try {
            et.begin();
            for (EmpDto empDto : empDtoList) {
                EmpDto dtoRef = new EmpDto();
                dtoRef.setAge(empDto.getAge());
                dtoRef.setEmail(empDto.getEmail());
                dtoRef.setName(empDto.getName());
                dtoRef.setPh_no(empDto.getPh_no());
                em.persist(dtoRef);
            }
            et.commit();
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }

    }
}
