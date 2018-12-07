package Foodie;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Info {
        @JsonProperty("nearby_restaurants")
        private List<nearby_restaurants> rest;

        public List<nearby_restaurants> getRest(){
            return  rest;
        }
        public void setRest(List<nearby_restaurants> rest){
            this.rest = rest;
        }
    public String toString() {
        StringBuilder Sand = new StringBuilder();
                for(int x =0;x<rest.size();x++)
                {
                    Sand.append(rest.get(x).toString());
                    Sand.append("\n");
                }
            return Sand.toString();
    }
}
