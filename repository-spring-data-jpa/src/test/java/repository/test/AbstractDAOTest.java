package repository.test;

import java.sql.Connection;

import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@ContextConfiguration(locations = { "/META-INF/applicationContext.xml", "/META-INF/applicationContext-test.xml" })
public abstract class AbstractDAOTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Before
    public void onSetUpInTransaction() throws Exception {
        Connection con = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
        IDatabaseConnection dbUnitCon = new DatabaseConnection(con);
        DatabaseConfig config = dbUnitCon.getConfig();
        config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new HsqlDataTypeFactory());

        try {
            String[] files = getTestFiles();

            if (files != null && files.length > 0) {
                for (int x = 0; x < files.length; x++) {
                    org.springframework.core.io.Resource resource = this.applicationContext.getResource(files[x]);
                    if (resource.exists()) {
                        DatabaseOperation.CLEAN_INSERT.execute(dbUnitCon,
                                new FlatXmlDataSetBuilder().build(resource.getInputStream()));
                    }
                }
            }
        } finally {
            DataSourceUtils.releaseConnection(con, jdbcTemplate.getDataSource());
        }
    }

    protected abstract String[] getTestFiles();
}
