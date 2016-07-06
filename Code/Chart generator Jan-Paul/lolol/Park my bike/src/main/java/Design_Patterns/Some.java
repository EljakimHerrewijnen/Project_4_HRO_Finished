package Design_Patterns;

/**
 * Created by Timo on 24/06/2016.
 */
public class Some<T> implements Option<T> {
    public T Value;

    public Some(T Value) { this.Value = Value; } //constructor

    @Override
    public <U> U Visit(IOptionVisitor<T, U> visitor) throws Exception {
        return visitor.onSome(this.Value);
    }

    @Override
    public boolean IsSome() {
        return true;
    }
}
