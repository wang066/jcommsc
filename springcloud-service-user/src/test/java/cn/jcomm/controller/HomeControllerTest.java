package cn.jcomm.controller;

import cn.jcomm.model.DO.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author: jowang
 * @date: 2018-12-17 16:02
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
//MockMvc mockMvc
@AutoConfigureMockMvc
public class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test(timeout = 3000)
    public void index() {
        //mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.GET, "/user").param()
        //        .contentType("application/json").content())
        //        .andExpect(MockMvcResultMatchers.status().isOk())
        //        .andExpect(MockMvcResultMatchers.content().string("ok"));
    }


    //
    @Autowired
    private TestRestTemplate testRestTemplate;
    @Test
    public void userMapping() throws Exception {
        User user = new User();
        user.setUserName("pj_pj");
        user.setUserPwdHash("123456");
        ResponseEntity<String> responseEntity = testRestTemplate.postForEntity("/user", user, String.class);
        System.out.println("Result: "+responseEntity.getBody());
        System.out.println("状态码: "+responseEntity.getStatusCodeValue());
    }

}