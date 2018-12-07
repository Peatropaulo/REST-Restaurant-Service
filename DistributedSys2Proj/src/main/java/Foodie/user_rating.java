package Foodie;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class user_rating {
    private double arregate_rating;

    public user_rating() {
    }

    public double getUser_Rating() {
        return this.arregate_rating;
    }

    public void setUser_Rating(double rating) {
        this.arregate_rating= rating;
    }
    @Override
    public String toString() {
        return "Rating{" +
                "Rating=" + arregate_rating;
    }
}