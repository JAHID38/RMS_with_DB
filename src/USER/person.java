
package USER;

import ADMIN.*;

public class person {
    
    public int code, total;
    public String food;

    
    person (int code, String food, int total){
        
        this.code = code;
        this.food = food;
        this.total = total;
        
        
    }
    
    public int getCode(){
        return code;
    }

    public String getFood(){
        return food;        
    }
    
    public int getTotal(){
        return total;
    }

    
}
