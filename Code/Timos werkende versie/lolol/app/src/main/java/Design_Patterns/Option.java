package Design_Patterns;

/**
 * Created by Timo on 24/06/2016.
 */
public interface Option<T> {
    // C# C# SYNTAX ==> U Visit<U> (IOptionVisitor<T,U> visitor);
    //Java syntax down here, so this is the real line!
    <U extends Option<T>> U Visit(IOptionVisitor<T, U> visitor) throws Exception;
    boolean IsSome();
}
