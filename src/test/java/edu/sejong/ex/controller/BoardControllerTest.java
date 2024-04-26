package edu.sejong.ex.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
class BoardControllerTest {

	@Autowired
    private MockMvc mockMvc;   // HTTP 호출을 위한 MockMVC 사용
	
    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new HomeController()).build();
    }
	
    @Test
	public void helloTest() throws Exception {
	 mockMvc.perform(MockMvcRequestBuilders.get("/"))
	         .andExpect(MockMvcResultMatchers.status().isOk());
	}


}
