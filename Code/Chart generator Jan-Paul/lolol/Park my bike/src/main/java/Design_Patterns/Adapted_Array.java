package Design_Patterns;

/**
 * Created by Timo on 27/06/2016.
 */
public class Adapted_Array<T> implements Iterator<T> {
    public T[] Legacy_List;
    int number_in_list = -1;

    public Adapted_Array(T[] Original_list){
        this.Legacy_List = Original_list;
    }

    @Override
    public Option<T> GetNext(){
        if ((this.number_in_list + 1) < this.Legacy_List.length){
            this.number_in_list = this.number_in_list + 1;
            return new Some<T>(this.Legacy_List[this.number_in_list]);
        }
        else{
            this.number_in_list = -1;
            return new None<T>();
        }
    }
}
