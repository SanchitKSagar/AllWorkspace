package com.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping(value = "/plain", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public String PlainText()
	{
		return "<h2>HelloCont</h2>";
	}
	@RequestMapping(value = "/html", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	public String HTMLText()
	{
		return "<h2>HelloCont</h2>";
	}
	@RequestMapping(value = "/xml", method = RequestMethod.GET, produces = MediaType.TEXT_XML_VALUE)
	public String xmlText()
	{
		return "<h2>HelloCont</h2>";
	}
}
