package Foodie;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class nearby_restaurants {
    @JsonProperty("restaurant")
        private restaurant restaurant;

        public nearby_restaurants(){

        }
        public restaurant getRestaurant()
        {
            return restaurant;
        }
        public void setRestaurant(restaurant restaurant)
        {
            this.restaurant=restaurant;
        }
        @Override
        public String toString()
        {
            return restaurant.toString();
        }

}
