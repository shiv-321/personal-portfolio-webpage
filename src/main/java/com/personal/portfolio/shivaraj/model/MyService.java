package com.personal.portfolio.shivaraj.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Comparator;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "my_service")
@Table
public class MyService implements Comparable<MyService> {
    @Getter
    @Setter
    @Id
    @Column(name = "service_name")
    @NotEmpty(message = "service name should not be empty")
    private String serviceName;
    @Getter
    @Setter
    @Column(name = "service_description", length = 500)
    @NotEmpty(message = "service description should not be empty")
    @Size(min = 10, max = 500, message = "service description should not be more than 500 characters")
    private String serviceDescription;

//    private String serviceImage;
    @Getter
    @Setter
    @Column(name = "icon")
    @NotEmpty(message = "icon should not be empty")
    private String icon;


    @Override
    public int compareTo(MyService o) {
        return this.serviceName.compareTo(o.serviceName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyService myService = (MyService) o;
        return serviceName.equals(myService.serviceName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceName);
    }

    @Override
    public String toString() {
        return "MyService{" +
                "serviceName='" + serviceName + '\'' +
                ", serviceDescription='" + serviceDescription + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}

