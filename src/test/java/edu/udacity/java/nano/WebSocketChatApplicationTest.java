package edu.udacity.java.nano;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


    @RunWith(SpringJUnit4ClassRunner.class)
    @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {WebSocketChatApplication.class})
    @AutoConfigureMockMvc
    public class WebSocketChatApplicationTest {

        @Autowired
        private MockMvc mvc;

        @Test
        public void givenUser_whenNavigatesToMainURL_thenLoginPageIsOpen() throws Exception {
            this.mvc.perform(get("/")).andDo(print()).andExpect(status().isOk()).andExpect(view().name("/login"));
        }

        @Test
        public void givenUser_whenEntersChatWithUsername_thenChatIsOpen() throws Exception {
            //should be modelAndView(/chat);
            this.mvc.perform(get("/index?username=Alena")).andDo(print()).andExpect(status().isOk()).andExpect(view().name("/chat"));
        }

    }
