package fr.travelfactory.test.test.controller.rest.marketing.ws.partner;

import fr.travelfactory.test.test.Utils;
import fr.travelfactory.test.test.controller.dto.CampaignDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class CampaignControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Utils utils;

    @Test
    void startTest() throws Exception {

        CampaignDto campaignDto = new CampaignDto();
        campaignDto.setId(1L);
        campaignDto.setCampaignName("TestCamp");
        campaignDto.setMail("test@mail.com");
        campaignDto.setPhone("+97222222222");

        this.mockMvc.perform(
                post("/marketing/ws/partner/campaign/1")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(utils.toJson(campaignDto)))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("")));
    }


    @Test
    void wrongEmailTest() throws Exception {

        CampaignDto campaignDto = new CampaignDto();
        campaignDto.setId(1L);
        campaignDto.setCampaignName("TestCamp");
        campaignDto.setMail("@mail.com");
        campaignDto.setPhone("+97222222222");

        this.mockMvc.perform(
                post("/marketing/ws/partner/campaign/1")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(utils.toJson(campaignDto)))
                .andExpect(status().is(400))
                .andExpect(content().string(containsString("Wrong format for field email")));
    }

    @Test
    void wrongPhoneTest() throws Exception {

        CampaignDto campaignDto = new CampaignDto();
        campaignDto.setId(1L);
        campaignDto.setCampaignName("TestCamp");
        campaignDto.setMail("mail@mail.com");
        campaignDto.setPhone("+972222sdf22222");

        this.mockMvc.perform(
                post("/marketing/ws/partner/campaign/1")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(utils.toJson(campaignDto)))
                .andExpect(status().is(400))
                .andExpect(content().string(containsString("Wrong format for field phone")));
    }



    @Test
    void registerNotFoundTest() throws Exception {

        CampaignDto campaignDto = new CampaignDto();
        campaignDto.setId(2L);
        campaignDto.setCampaignName("TestCamp");
        campaignDto.setMail("test@mail.com");
        campaignDto.setPhone("+97222222222");

        this.mockMvc.perform(
                post("/marketing/ws/partner/campaign/2")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(utils.toJson(campaignDto)))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("")));


        this.mockMvc.perform(
                post("/marketing/ws/partner/campaign/3/registration")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(utils.toJson(campaignDto)))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("")));
    }



    @Test
    void registerFoundTest() throws Exception {

        CampaignDto campaignDto = new CampaignDto();
        campaignDto.setId(2L);
        campaignDto.setCampaignName("TestCamp");
        campaignDto.setMail("test@mail.com");
        campaignDto.setPhone("+97222222222");

        this.mockMvc.perform(
                post("/marketing/ws/partner/campaign/2")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(utils.toJson(campaignDto)))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("")));


        this.mockMvc.perform(
                post("/marketing/ws/partner/campaign/2/registration")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(utils.toJson(campaignDto)))
                .andExpect(status().is(409))
                .andExpect(content().string(containsString("ko")));
    }
}