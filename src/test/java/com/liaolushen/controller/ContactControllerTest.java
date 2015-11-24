package com.liaolushen.controller;

import com.liaolushen.Application;
import com.liaolushen.domain.Contact;
import com.liaolushen.repository.ContactRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by liaolushen on 11/24/15.
 *
 * @author liaolushen
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class ContactControllerTest {
    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MockMvc mockMvc;

    private HttpMessageConverter mappingJackson2HttpMessageConverter;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    void setConverters(HttpMessageConverter<?>[] converters) {

        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream().filter(
                hmc -> hmc instanceof MappingJackson2HttpMessageConverter).findAny().get();

        Assert.assertNotNull("the JSON message converter must not be null",
                this.mappingJackson2HttpMessageConverter);
    }


    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
        this.contactRepository.deleteAll();

        this.contactRepository.save(new Contact("John", "15626470758"));
    }

    @Test
    public void addContact() throws Exception {
        mockMvc.perform(post("/add").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(this.json(new Contact("廖卢神", "1235523234"))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.type").value("success"))
                .andExpect(jsonPath("$.data.name").value("廖卢神"))
                .andExpect(jsonPath("$.data.phoneNumber").value("1235523234"));
    }

    @Test
    public void getAllContacts() throws Exception {
        mockMvc.perform(get("/get-all-contacts"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.type").value("success"))
                .andExpect(jsonPath("data").isArray());
    }

    @Test
    public void getContactByName() throws Exception {
        mockMvc.perform(get("/get-contact-by-name?name=John"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.type").value("success"))
                .andExpect(jsonPath("$.data.name").value("John"))
                .andExpect(jsonPath("$.data.phoneNumber").value("15626470758"));
    }

    @Test
    public void getContactByPhoneNumber() throws Exception {
        mockMvc.perform(get("/get-contact-by-phone-number?phoneNumber=15626470758"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.type").value("success"))
                .andExpect(jsonPath("$.data.name").value("John"))
                .andExpect(jsonPath("$.data.phoneNumber").value("15626470758"));
    }

    protected String json(Object o) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.mappingJackson2HttpMessageConverter.write(
                o, MediaType.APPLICATION_JSON_UTF8, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }
}
