package repository.test;

import java.util.ArrayList;
import java.util.Collection;

import org.dbunit.dataset.datatype.DataType;
import org.dbunit.dataset.datatype.DataTypeException;
import org.dbunit.dataset.datatype.DefaultDataTypeFactory;
import org.hsqldb.Types;

public class HsqlDataTypeFactory extends DefaultDataTypeFactory {

    /** {@inheritDoc} */
    public DataType createDataType(int sqlType, String sqlTypeName) throws DataTypeException {
        if (sqlType == Types.BOOLEAN) {
            return DataType.BOOLEAN;
        }

        return super.createDataType(sqlType, sqlTypeName);
    }

    @Override
    public Collection<?> getValidDbProducts() {
        final Collection<String> dbs = new ArrayList<>();

        dbs.add("HSQL Database Engine");

        return dbs;
    }
}
