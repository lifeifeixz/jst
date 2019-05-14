package org.flysli.gadget.plugins.transfer;

import org.flysli.gadget.plugins.transfer.annotation.Format;
import org.flysli.gadget.plugins.transfer.annotation.Import;
import org.flysli.gadget.plugins.transfer.annotation.Round;
import org.flysli.gadget.plugins.transfer.converter.PhoneFormatConverter;
import org.flysli.gadget.plugins.transfer.converter.PhoneParseConverter;

import javax.validation.constraints.NotNull;

@Import(procers = User.class)
public class User {

    private String name;
    private Integer age;
    private boolean isAdult;

    @NotNull
    private String address;

    @Round(digit = 2, ifnull = "3500.00")
    private Double salary;

    @Format(converter = {PhoneParseConverter.class, PhoneFormatConverter.class})
    private String phoneNumber;

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isAdult() {
        return isAdult;
    }

    public void setAdult(boolean adult) {
        isAdult = adult;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isAdult=" + isAdult +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
