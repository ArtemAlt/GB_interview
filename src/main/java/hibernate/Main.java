package hibernate;

import hibernate.DAO.StudentDAO;
import hibernate.entity.Student;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        List<Student> sl = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            sl.add(new Student("Student "+i,"mark"));
        }
        dao.persistList(sl);
        System.out.println(dao.findById(500L));
        System.out.println(dao.updateById(500L, "test1"));
        System.out.println(dao.deleteById(501L));
        System.out.println(dao.deleteAll());


    }
}
