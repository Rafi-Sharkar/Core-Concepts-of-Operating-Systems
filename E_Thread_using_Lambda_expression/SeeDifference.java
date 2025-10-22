package E_Thread_using_Lambda_expression;

// Method_1: General/Traditional method.
//      Step_1: Create an interface Student
//      Step_2: Create a class(EngineeringStudent) and implement(Student) and override the method.
//      Step_3: Create an instance of EngineeringStudent as engStu1 and get the attribute such as engStu1.getInfo("Rafi")

// Method_2: Anonymous function method.
//      Step_1: Create an interface(must be functional interface or can contain one abstract method) Student
//      Step_2: Create an instance of Student function and implement immediately there.

// Method_3: Using Lambda expression method.
//      Step_1: Create an interface(must be functional interface or can contain one abstract method) Student
//      Step_2: Create an instance of Student function and implement(more simple implementation) immediately there.


public class SeeDifference {
    public static void main(String[] args) {
//      Method_1
        EngineeringStudent engStu1 = new EngineeringStudent();
        System.out.println(engStu1.getInfo("Rafi"));

//      Method_2
        Student engStu2 = new Student() {
            @Override
            public String getInfo(String name) {
                return name + " is an Engineering student. [Method_2]";
            }
        };
        System.out.println(engStu2.getInfo("Rafi"));

//      Method_3
        Student engStu3 = name -> name + " is an engineering student. [Method_3]";
        System.out.println(engStu3.getInfo("Rafi"));

    }

}
