package Design_Patterns;

/**
 * Created by Timo on 24/06/2016.
 */
public class OptionVisitor <T> implements IOptionVisitor <T,T> {
    public T onSome(T value){
        return value;
    }

    public T onNone() throws Exception {
        throw new Exception("..");
    }

}
