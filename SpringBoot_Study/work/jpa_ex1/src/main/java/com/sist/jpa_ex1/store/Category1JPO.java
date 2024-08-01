package com.sist.jpa_ex1.store;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.GeneratedValue;

@Entity(name = "category_t")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category1JPO {
    @Id
    @GeneratedValue
    private Long cIdx;
    private String cName;
    private String cDesc;
    private String cStatus;
}
