//package com.neusoft.nepm;
//
//import com.neusoft.nepm.common.api.CommonResult;
//import com.neusoft.nepm.common.po.Aqi;
//import com.neusoft.nepm.controller.AqiController;
//import com.neusoft.nepm.service.AqiService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//public class AqiControllerTest {
//
//    private MockMvc mockMvc;
//
//    @Mock
//    private AqiService aqiService;
//
//    @InjectMocks
//    private AqiController aqiController;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(aqiController).build();
//    }
//
//    @Test
//    public void testListAqiAll() throws Exception {
//        Aqi aqi1 = new Aqi();
//        aqi1.setCity("City1");
//        aqi1.setAqi(100);
//
//        Aqi aqi2 = new Aqi();
//        aqi2.setCity("City2");
//        aqi2.setAqi(150);
//
//        List<Aqi> aqiList = Arrays.asList(aqi1, aqi2);
//
//        when(aqiService.AqiByAll()).thenReturn(aqiList);
//
//        mockMvc.perform(get("/aqi/all"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.data[0].city").value("City1"))
//                .andExpect(jsonPath("$.data[1].city").value("City2"));
//    }
//}