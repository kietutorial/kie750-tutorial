package com.aikiinc.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.aikiinc.hello.domain.Message;
import com.aikiinc.hello.kie.service.util.KieUtils;
import com.aikiinc.hello.kie.service.util.ProcessUtil;

@Controller
public class ProcessJBPMController {
	private final Logger log = LoggerFactory.getLogger(ProcessJBPMController.class);

	@GetMapping("/")
	public String greetingForm(Model model) {
		model.addAttribute("message", new Message());

		return "index";
	}

	@PostMapping("/kieprocess")
	public String processKIE(@ModelAttribute Message message, Model model) {

		try {
			KieUtils.showHeader("Controller Processing Message: " + message);
			
			if (message != null) {
				// The Message fact
				message.setStatus(Message.HELLO);

				KieUtils.executeJbpmProcess(message, "ksession-process", "com.aikiinc.bpmn.hello");
			}

			log.debug(message.toString());
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		}

		return "index";
	}

}
