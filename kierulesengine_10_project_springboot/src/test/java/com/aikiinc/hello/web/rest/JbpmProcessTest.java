package com.aikiinc.hello.web.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.aikiinc.hello.kie.sample.Message;
import com.aikiinc.hello.kie.service.util.KieUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class JbpmProcessTest {
	private static Logger LOG = LoggerFactory.getLogger(JbpmProcessTest.class);

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper mapper;

	@Test
	public void getJBPMProcess() throws Exception {
		Message message = new Message();
		message.setMessage("Hello World");
		//message.setMessage("Need A Million");

		String json = mapper.writeValueAsString(message);
		MvcResult result = this.mockMvc.perform(post("/api/jbpm/process").contentType(MediaType.APPLICATION_JSON).content(json)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk()).andReturn();


		String content = result.getResponse().getContentAsString();
		//JSON file to Java object
		ObjectMapper mapper = new ObjectMapper();
		message = mapper.readValue(content, Message.class);
		
		KieUtils.showSubHeader("After Processing: " + message.toString());
	}

}
