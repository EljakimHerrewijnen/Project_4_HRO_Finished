package Design_Patterns;

/**
 * Created by Timo on 24/06/2016.
 */
public class None<T> implements Option<T> {

    @Override // I did auto resolve: add exception to method signature
    public <U> U Visit(IOptionVisitor<T, U> visitor) throws Exception {
        return visitor.onNone();
    }

    @Override
    public boolean IsSome() {
        return false;
    }
}
