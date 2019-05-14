package org.flysli.gadget.plugins.transfer;

public class Test {
    public static void main(String[] args) {
        User user = new User();
        user.setName("李向阳");
        user.setAddress("北京市朝阳新区杜鹃路590号");
        user.setAdult(true);
        user.setAge(22);
        user.setSalary(null);
        user.setPhoneNumber("18914913629");

        Object newUser = Processer.process(user);
        System.out.println(newUser);
    }
}
