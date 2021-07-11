package com.chen.bigwork;

import com.chen.bigwork.dao.LocationMapper;
import com.chen.bigwork.entities.Location;
import com.chen.bigwork.util.String2DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@SpringBootTest
class BigworkApplicationTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    LocationMapper locationMapper;

    @Test
    public void testDate() throws ParseException {
        Date date = String2DateUtil.string2Date("2005-05-07");
        System.out.println(date);
    }
    @Test
    public void testLocationMapper(){
        List<Location> list = locationMapper.
                findLocationByPlace("山西", "忻州市", "忻府区");
        if (list==null){
            System.out.println("null");
        }else {
            for (Location location:list){
                System.out.println(location.toString());
            }
        }

    }

    @Test
    void contextLoads() {
    }

    @Test
    public void testsql() throws SQLException {
        System.out.println("获取的数据库连接为:"+dataSource.getConnection());
    }

}
