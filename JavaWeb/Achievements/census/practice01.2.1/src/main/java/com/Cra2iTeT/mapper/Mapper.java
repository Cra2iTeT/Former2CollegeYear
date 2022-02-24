package com.Cra2iTeT.mapper;

import com.Cra2iTeT.bean.Person;
import java.util.List;
import java.util.Map;

public interface Mapper {
    int add(Map map);

    int deleteByName(String name);

    int update(Map map);

    List<Person> query(Map map);

    Person show(String name);
}
