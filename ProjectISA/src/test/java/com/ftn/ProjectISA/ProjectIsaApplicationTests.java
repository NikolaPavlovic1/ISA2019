package com.ftn.ProjectISA;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;

import com.ftn.ProjectISA.service.AddressServiceTest;
import com.ftn.ProjectISA.service.ClinicServiceTest;
import com.ftn.ProjectISA.service.MedicalExaminationServiceTest;
import com.ftn.ProjectISA.service.MedicalRecordServiceTest;
import com.ftn.ProjectISA.service.MedicalRoomServiceTest;
import com.ftn.ProjectISA.service.UserServiceTest;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        AddressServiceTest.class,
        UserServiceTest.class,
        ClinicServiceTest.class,
        MedicalExaminationServiceTest.class,
        MedicalRecordServiceTest.class,
        MedicalRoomServiceTest.class,
})
@SpringBootTest
class ProjectIsaApplicationTests {

	@Test
	void contextLoads() {
	}

}
