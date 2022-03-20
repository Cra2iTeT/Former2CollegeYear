package com.Cra2iTeT.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author Cra2iTeT
 * @version 1.0
 * @date 2022/3/9 22:41
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Dept implements Serializable {
    private Long dNo;
    private String dName;
    private String db_source;

    public Dept(Long dNo) {
        this.dNo = dNo;
    }
}
