package Design_Patterns;

import java.util.List;

/**
 * Created by Timo on 27/06/2016.
 */
public class Adapted_List<T> implements Iterator<T> {

    public List<T> Legacy_List;
    int number_in_list = -1;

    public Adapted_List(List<T> Original_list){
        this.Legacy_List = Original_list;
    }


    public Option<T> GetNext() {
        if ((this.number_in_list + 1) < this.Legacy_List.size()){
            this.number_in_list = this.number_in_list + 1;
            return new Some<T>(this.Legacy_List.get(this.number_in_list));
        }
        else {
            this.number_in_list = -1;
            return new None<T>();
        }
    }

}
