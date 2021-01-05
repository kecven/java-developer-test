package fr.travelfactory.test.test.controller.dto;

import com.sun.istack.NotNull;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

public class CampaignDto implements Serializable {

    @NotNull
    private Long id;

    @Size(min = 5, max = 50, message = "Invalid length for email")
    @Pattern(message = "Wrong format for field email", regexp = "^[\\w-.]+@([\\w-]+.)+[\\w-]{2,4}$")
    private String mail;

    @Size(min = 9, max = 15, message = "Invalid length for phone")
    @Pattern(message = "Wrong format for field phone", regexp = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$")
    private String phone;

    private String campaignName;

    private List<String> MandatoryFields;


    public CampaignDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }
}
