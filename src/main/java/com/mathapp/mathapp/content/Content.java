package com.mathapp.mathapp.content;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
public class Content {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Size(min = 1, max = (int)1e5, message = "1 <= Title length <= 1e5")
    @Column(length = (int)1e5)
    private String title;

    @NotBlank
    @Size(min = 1, max = (int)1e5, message = "1 <= Body text length <= 1e5")
    @Column(length = (int)1e5)
    private String body;
}
