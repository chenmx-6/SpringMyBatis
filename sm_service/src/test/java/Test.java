import com.miles.sm.entity.Department;
import com.miles.sm.entity.Staff;
import com.miles.sm.service.DepartmentService;
import com.miles.sm.service.StaffService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author Miles
 * @date 2020/12/27 14:20
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class Test {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private StaffService staffService;

    @org.junit.Test
    public void testDepartment(){
//        Department department = new Department();
//        department.setName("人事部");
//        department.setAddress("3#1101");
//        departmentService.add(department);
        List<Department> departments = departmentService.getAll();
        for (Department department : departments) {
            System.out.println(department);
        }
    }

    @org.junit.Test
    public void testStaff(){
        Staff staff = new Staff();
        staff.setAccount("123");
        staff.setPassword("000");
        staff.setStatus("1");
        staff.setDid(1);
        staff.setName("荆轲");
        staff.setSex("M");
    }
}
