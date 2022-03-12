package com.example.springboot2.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
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
public class ESTest {

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    //@Autowired
    //private CustomerElasticsearchRepository customerElasticsearchRepository;


    //@Test
    //    //public void test() {
    //    //    RestClient restClient = RestClient.builder(
    //    //            new HttpHost("localhost", 9200, "http")).build();
    //    //}

    @Test
    public void save() {
        //for (int i = 0; i < 10; i++) {
            //Customer customer = new Customer();
            //customer.setId(String.valueOf(RandomUtils.nextInt()));
            //customer.setFirstName(RandomStringUtils.random(8));
            //customer.setLastName(RandomStringUtils.random(8));
            //
            //customerElasticsearchRepository.save(customer);
        //}


    }


    @Test
    public void index() {

    }
}