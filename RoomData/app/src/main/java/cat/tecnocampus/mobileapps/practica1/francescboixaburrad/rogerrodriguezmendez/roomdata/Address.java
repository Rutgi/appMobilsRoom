package cat.tecnocampus.mobileapps.practica1.francescboixaburrad.rogerrodriguezmendez.roomdata;

import androidx.room.ColumnInfo;

public class Address {

    public String street;
    public String state;
    public String city;

    @ColumnInfo(name = "post_code")
    public int postalCode;//no li agraden les majuscules

    public Address(String street, String state, String city, int postalCode) {
        this.street = street;
        this.state = state;
        this.city = city;
        this.postalCode = postalCode;
    }

    public String toStringAll(){
        return"Street: "+street+",  State:  "+state+", City:  "+", Post Code:  "+postalCode;
    }
}
