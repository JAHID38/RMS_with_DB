
package USER;

import ADMIN.*;

public class food {
    
    public int code, price;
    public String category, food, date;
    public byte [] image;
    
    food (int code, String category, String food, int price, String date, byte [] image){
        
        this.code = code;
        this.category = category;
        this.food = food;
        this.price = price;
        this.date = date;
        this.image = image;        
        
    }
    
    public int getCode(){
        return code;
    }
    public String getCategory(){
        return category;
    }
    public String getFood(){
        return food;        
    }
    public int getPrice(){
        return price;
    }
    public String getDate(){
        return date;
    }
    public byte [] getImage(){
        return image;
    }
    
}
