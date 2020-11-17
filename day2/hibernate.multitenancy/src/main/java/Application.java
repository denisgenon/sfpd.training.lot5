import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.function.Consumer;

import org.hibernate.MultiTenancyStrategy;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Environment;
import org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

public class Application {

	private static final String CLASSIC_MODEL_1 = "classicmodels_1";
	private static final String CLASSIC_MODEL_2 = "classicmodels_2";

	private Map<String, ConnectionProvider> connectionProviderMap;
	private SessionFactory sessionFactory;

	private void doInSession(String tenant, Consumer<Session> function) {
		Session session = null;
		Transaction txn = null;
		try {
			session = HibernateUtil.getSessionFactory()
					.withOptions()
					.tenantIdentifier(tenant)
					.openSession();
			txn = session.getTransaction();
			txn.begin();
			function.accept(session);
			txn.commit();
		} catch (Throwable e) {
			if (txn != null) {
				txn.rollback();
			}
			throw e;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void init() throws IOException {
		registerConnectionProvider(CLASSIC_MODEL_1);
		registerConnectionProvider(CLASSIC_MODEL_2);

		Map<String, Object> settings = new HashMap<>();

		settings.put(AvailableSettings.MULTI_TENANT, MultiTenancyStrategy.SCHEMA);
		settings.put(AvailableSettings.MULTI_TENANT_CONNECTION_PROVIDER,
					 new ConfigurableMultiTenantConnectionProvider(connectionProviderMap));

		/* Todo put settings
		sessionFactory = HibernateUtil.getSessionFactory() */
	}

	public void registerConnectionProvider(String tenantIdentifier) throws IOException {
		Properties properties = new Properties();
		properties.load(getClass().getResourceAsStream("/hibernate.properties"));

		properties.put(Environment.URL, tenantUrl(properties.getProperty(Environment.URL), tenantIdentifier));

		DriverManagerConnectionProviderImpl connectionProvider = new DriverManagerConnectionProviderImpl();
		connectionProvider.configure(properties);
		connectionProviderMap.put(tenantIdentifier, connectionProvider);
	}

	private Object tenantUrl(String property, String tenantIdentifier) {
		return null;
	}

	public static void main(String[] args) {
		Application app = new Application();

		try {
			app.init();
		} catch (IOException e) {
			e.printStackTrace();
		}

		app.doInSession(Application.CLASSIC_MODEL_1, session -> {
			/* Employee employee = new Employee();
			session.persist(employee); */
		});

		app.doInSession(Application.CLASSIC_MODEL_2, session -> {/* stuff */});
	}
}
