package hello.hellospring.domain;

import javax.persistence.*;

// jpa가 관리하는 Entity이다.
@Entity
public class Member {


    @Id // id가 Primary Key임을 알림
    @GeneratedValue(strategy = GenerationType.IDENTITY) // db가 알아서 생성할 것임을 알림
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
