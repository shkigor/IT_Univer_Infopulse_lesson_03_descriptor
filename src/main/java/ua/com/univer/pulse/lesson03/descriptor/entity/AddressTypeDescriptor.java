package ua.com.univer.pulse.lesson03.descriptor.entity;

import org.hibernate.type.descriptor.WrapperOptions;
import org.hibernate.type.descriptor.java.AbstractTypeDescriptor;

/**
 * Created by IShklyar on 11.04.2017.
 */
public class AddressTypeDescriptor extends AbstractTypeDescriptor<Address> {

    public static final AddressTypeDescriptor INSTANCE = new AddressTypeDescriptor();

    protected AddressTypeDescriptor() {
        super(Address.class);
    }

    @Override
    public String toString(Address address) {
        return address.getCity() + ";" + address.getStreet();
    }

    @Override
    public Address fromString(String string) {
        String[] arr = string.split(";");
        Address address = new Address();
        address.setCity(arr[0]);
        address.setStreet(arr[1]);
        return address;
    }

    @Override
    public <X> X unwrap(Address address, Class<X> type, WrapperOptions options) {
        if (address == null) {
            return null;
        }
        if (Address.class.isAssignableFrom(type)) {
            return (X) address;
        }
        if (String.class.isAssignableFrom(type)) {
            return (X) toString(address);
        }
        throw unknownUnwrap(type);
    }

    @Override
    public <X> Address wrap(X x, WrapperOptions options) {
        if (x == null) {
            return null;
        }
        if (String.class.isInstance(x)) {
            return fromString((String) x);
        }
        if (Address.class.isInstance(x)) {
            return (Address) x;
        }
        throw unknownWrap(x.getClass());
    }
}
