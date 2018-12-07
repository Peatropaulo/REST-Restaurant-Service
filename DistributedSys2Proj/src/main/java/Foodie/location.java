package Foodie;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class location {
    @JsonProperty("address")
        private String address;

    public location() {
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String addr) {
        this.address= addr;
    }
    @Override
    public String toString() {
        return "Location{" +
                "address=" + address;
    }
}
