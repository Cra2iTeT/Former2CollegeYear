package com.tea.lesson03.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Cra2iTeT
 * @version 1.0
 * @date 2022/3/25 9:51
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Station {
    private String stationId;
    private String stationName;
    private String ringFlag;
}
