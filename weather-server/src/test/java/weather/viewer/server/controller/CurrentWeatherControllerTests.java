package weather.viewer.server.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import weather.viewer.server.controller.CurrentWeatherController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CurrentWeatherControllerTests {

	@Autowired
	private CurrentWeatherController currentWeatherController;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(currentWeatherController).build();
	}

	@Test
	public void testCurrentWeatherControllerReturnsOKForValidCity() throws Exception{
		ResultActions result = this.mockMvc.perform( get("/current?city=London")
				.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
	}

	@Test
	public void testCurrentWeatherControllerReturnsNotFoundForAnUnknownCity() throws Exception{
		ResultActions result = this.mockMvc.perform( get("/current?city=Norwich")
				.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(status().isNotFound());
	}

	@Test
	public void testCurrentWeatherControllerReturnsNotFoundForAnInvalidCity() throws Exception{
		ResultActions result = this.mockMvc.perform( get("/current?city=qwertyuiop^$_")
				.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(status().isNotFound());
	}

	@Test
	public void testCurrentWeatherControllerReturnsNotFoundForABlankCity() throws Exception{
		ResultActions result = this.mockMvc.perform( get("/current?city=")
				.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(status().isNotFound());
	}
	
	@Test
	public void testCurrentWeatherControllerReturnsBadRequestWhenCityParameterNotSupplied() throws Exception{
		ResultActions result = this.mockMvc.perform( get("/current")
				.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(status().isBadRequest());
	}


}
