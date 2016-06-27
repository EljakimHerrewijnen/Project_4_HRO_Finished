package Design_Patterns;

/**
 * Created by Timo on 24/06/2016.
 */
public interface IOptionVisitor <T,U> {
    U onSome(T value);
    U onNone() throws Exception;
}