package org.converter.service;

import org.converter.model.UserData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ConverterServiceTest {

    @Autowired
    ConverterService converterService;

    @Test
    public void ExchangeRateCalculationTest() {
        double val = Double.parseDouble("0200");
        UserData userData = converterService
                .setUserData(new UserData(BigDecimal.valueOf(val), "hero", "gyro"));
        BigDecimal output = converterService.calculateFinalAmount(userData);
        assertThat(output).isOne();
        //assertThat(output).isGreaterThanOrEqualTo(new BigDecimal(0.00011603014463157528));
        //assertTrue(String.valueOf(output).length() > 18);
    }

}
