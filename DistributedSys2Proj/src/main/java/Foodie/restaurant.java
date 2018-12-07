package Foodie;

import com.fasterxml.jackson.annotation.JsonProperty;

public class restaurant {
    @JsonProperty("name")
    private String name;
    @JsonProperty("cuisines")
    private String cuisines;
    @JsonProperty("location")
    private location loca;
    @JsonProperty("user_rating")
    private user_rating rating;
    public restaurant() {
    }

    public String getName() {
        return this.name;
    }

    public String getCuisines() {
        return this.cuisines;
    }

    public void setId(String id) {
        this.name = name;
    }

    public void setQuote(String cuisines) {
        this.cuisines = cuisines;
    }

    public location getlocation() {
        return this.loca;
    }

    public void setlocation(location location) {
        this.loca = location;
    }
    public user_rating getuser_rating() {
        return this.rating;
    }

    public void setuser_rating(user_rating rating) {
        this.rating = rating;
    }
    @Override
    public String toString() {
        return "name="+ name + ",\n"+
                ", cuisines=" +cuisines  +",\n"+
                ", locations="  +loca+".\n"+
                ", Rating="+rating;
    }
}
