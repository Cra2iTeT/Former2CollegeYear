package com.Cra2iTeT.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Document {
    private int id;
    private String title;
    private String text;
    private int state;
    private String advice;
    private int up;
    private String upDepart;
}
