package com.education.center.main.service.impl;

import com.education.FamilyEducationApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = FamilyEducationApplication.class)
public class CityServiceImplTest {

    @Autowired
    private CityServiceImpl cityService;
    @Test
    public void convertForPinYin() {
//        cityService.convertForPinYin();
    }
}