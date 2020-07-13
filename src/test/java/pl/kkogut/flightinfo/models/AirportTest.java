package pl.kkogut.flightinfo.models;

import lombok.val;
import org.apache.tomcat.jni.Local;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AirportTest {

    @Before
    void init(){

    }

    @Test
    void should_give_proper_local_time() {
        //given
        LocalDateTime localDateTime = LocalDateTime.now(ZoneOffset.UTC);
        Airport target = spy(new Airport());

        given(target.getNow()).willReturn(localDateTime);
        given(target.getGMT()).willReturn("-24","-12","0","23","100","", null);

        //then
        Assert.assertEquals(localDateTime.plusHours(-24).toString()     ,target.getLocalTime());
        Assert.assertEquals(localDateTime.plusHours(-12).toString()     ,target.getLocalTime());
        Assert.assertEquals(localDateTime.plusHours(0).toString()       ,target.getLocalTime());
        Assert.assertEquals(localDateTime.plusHours(23).toString()      ,target.getLocalTime());
        Assert.assertEquals(localDateTime.plusHours(100).toString()     ,target.getLocalTime());
        Assert.assertEquals(localDateTime.plusHours(0).toString()       ,target.getLocalTime());
        Assert.assertEquals(localDateTime.plusHours(0).toString()       ,target.getLocalTime());
        Assert.assertNotEquals(localDateTime.plusHours(-24).toString()  ,target.getLocalTime());
        Assert.assertNotEquals(localDateTime.plusHours(24).toString()   ,target.getLocalTime());

    }
}