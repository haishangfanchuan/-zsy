package leetcode.letcode100;

import java.util.concurrent.atomic.AtomicReference;

public class Demo0903 {
    public static void main(String[] args) throws ClassNotFoundException {
        char char1 = 52;
        System.out.println(char1);
        Student student = new Student();
        Class<? extends Student> studentClass = student.getClass();
        ClassLoader parent = studentClass.getClassLoader();
        System.out.println(parent);
        Class<?> aClass = Class.forName("leetcode.letcode100.Student");
        Class<Student> aClass1 = Student.class;
    }
}

class Student{
    private String name;
    private int no;
    private int age;

    public Student() {
    }

    public Student(String name, int no, int age) {
        this.name = name;
        this.no = no;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class SpinLock {

    private AtomicReference<Thread> sign =new AtomicReference<>();

    public void lock(){
        Thread current = Thread.currentThread();
        while(!sign .compareAndSet(null, current)){
        }
    }

    public void unlock (){
        Thread current = Thread.currentThread();
        sign.compareAndSet(current, null);
    }
}