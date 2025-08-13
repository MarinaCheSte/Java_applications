package jaxb.test;

import jaxb.model.Department;
import jaxb.model.Employee;
import jaxb.model.Organization;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TestExample {

    private static final String XML_FILE = "dept-info.xml";

    public static void main(String[] args) {


//Department #1
        Employee emp1 = new Employee("E01", "Tom", null);
        Employee emp2 = new Employee("E02", "Mary", "E01");
        Employee emp3 = new Employee("E03", "John", null);


        List<Employee> list1 = new ArrayList<Employee>();
        list1.add(emp1);
        list1.add(emp2);
        list1.add(emp3);

        Department dept1 = new Department("D01", "ACCOUNTING", "NEW YORK");

        List<Department> depList = new ArrayList<Department>();
        depList.add(dept1);

        dept1.setEmployees(list1);
//Department #2

        Employee emp4 = new Employee("E04", "Harry", null);
        Employee emp5 = new Employee("E05", "Cris", "E01");
        Employee emp6 = new Employee("E06", "Mary", null);

        List<Employee> list2 = new ArrayList<Employee>();
        list2.add(emp4);
        list2.add(emp5);
        list2.add(emp6);

        Department dept2 = new Department("D02", "MANAGEMENT", "WASHINGTON");
        depList.add(dept2);

        dept2.setEmployees(list2);

        //Organization
        Organization organization = new Organization("Nestle", "USA");
        organization.setDepartments(depList);

        try {
            // create JAXB context and instantiate marshaller
            JAXBContext context = JAXBContext.newInstance(Organization.class);

            // (1) Marshaller : Java Object to XML content.
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            m.marshal(organization, System.out);

            // Write to File
            File outFile = new File(XML_FILE);
            m.marshal(organization, outFile);

            System.err.println("Write to file: " + outFile.getAbsolutePath());
// (2) Unmarshaller : Read XML content to Java Object.
           Unmarshaller um = context.createUnmarshaller();

            // XML file create before.

            Organization organizationFromFile1=(Organization) um.unmarshal(new FileReader(
                    XML_FILE));
           List<Department> deps = organizationFromFile1.getDepartments();
           System.out.println(deps);

            for (Department dep : deps) {
                System.out.println("Department: " + dep.getDeptName());
                List<Employee> emps=dep.getEmployees();
                for (Employee emp: emps){

                    System.out.println("Employee: " + emp.getEmpName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
