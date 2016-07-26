package com.springapp.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

/**
 * Created by Administrator on 2016-07-20.
 */
@Controller
@RequestMapping("/test1")
public class druidTestController {
    private static final Logger logger = LoggerFactory.getLogger(druidTestController.class);
    private JdbcTemplate jdbcTemplate;
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
   public String Get(){
        String result ="druid is very good";
        ClassPathXmlApplicationContext context =  new ClassPathXmlApplicationContext("mvc-dispatcher-servlet.xml");
        DataSource dataSource = (DataSource)context.getBean("dataSource");

        jdbcTemplate = new JdbcTemplate(dataSource);
        Map<String,Object> map = jdbcTemplate.queryForMap("SELECT * FROM TEST WHERE ROWNUM<2");
        logger.info("druid:{}",map.toString());
        return result;
   }
    private void test(){
        ClassPathXmlApplicationContext context =  new ClassPathXmlApplicationContext("mvc-dispatcher-servlet.xml");
        DataSource dataSource = (DataSource)context.getBean("dataSource");
        /*
        jdbcTemplate = new JdbcTemplate(dataSource);
        Map<String,Object> map = jdbcTemplate.queryForMap("SELECT * FROM VIEW_REGLIST WHERE ROWNUM<10;");
        */
        Connection con = null;
        try {
            con = dataSource.getConnection();
            Statement st  = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM VIEW_REGLIST WHERE ROWNUM<10");
            while (rs.next()) {
                System.out.println("personName: " + rs.getString("PATIENT_NAME"));
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            logger.error(ex.getMessage()+ex.getStackTrace());
        } finally {
            if (con != null) try {con.close();} catch (Exception ignore){}
        }
    }
}
