package ua.com.univer.pulse.lesson03.descriptor.entity;

import org.hibernate.dialect.Dialect;
import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.type.DiscriminatorType;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;

/**
 * Created by IShklyar on 11.04.2017.
 */
public class AddressType extends AbstractSingleColumnStandardBasicType<Address> implements DiscriminatorType<Address> {

    public static final AddressType INSTANCE = new AddressType();

    public AddressType() {
        super(VarcharTypeDescriptor.INSTANCE, AddressTypeDescriptor.INSTANCE);
    }

    @Override
    public String getName() {
        return "address";
    }

    @Override
    public Address stringToObject(String string) throws Exception {
        return fromString(string);
    }

    @Override
    public String objectToSQLString(Address address, Dialect dialect) throws Exception {
        return toString(address);
    }
}
