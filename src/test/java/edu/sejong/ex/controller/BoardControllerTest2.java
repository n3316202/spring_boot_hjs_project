package edu.sejong.ex.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.google.gson.Gson;

import edu.sejong.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
class BoardControllerTest2 {

    @Autowired
    MockMvc mockMvc;

    @Disabled
    @Test
    public void testHello() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());

    }
    @Disabled
    @Test
    public void testBoard() throws Exception {
        mockMvc.perform(get("/board/list2"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }
    @Disabled
    @Test
    public void testBoardList() throws Exception {
        mockMvc.perform(get("/board/list2"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }
    @Disabled
    @Test
    public void testBoard2() throws Exception {
        mockMvc.perform(get("/boards/list"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());

    }
    
    @Test
    public void testBoardInsert() throws Exception {
        BoardVO boardVO = new BoardVO();
        boardVO.setBcontent("아행행");
        boardVO.setBname("우씨씨");
        boardVO.setBtitle("깡깡깡");
        
        String jsonStr = new Gson().toJson(boardVO);
        
        log.info(jsonStr);
        
        mockMvc.perform(post("/boards/")
            .contentType(MediaType.APPLICATION_JSON)
            .content(jsonStr))
            .andExpect(status().is(200));
        

    }

}
