package br.com.gabrielrubens.filme.helper;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.hsqldb.HsqldbDataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.internal.SessionImpl;

public class DBUnitHelper {
	private static final String XML = ".xml";
	private static EntityManagerFactory entityManagerFactory;
	private static IDatabaseConnection connection;
	private static List<IDataSet> datasets = new ArrayList<>();
	protected static EntityManager entityManager;

	@SuppressWarnings("rawtypes")
	public static void beforeClass(Class ... clazz) {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("default");
			entityManager = entityManagerFactory.createEntityManager();
			connection = new DatabaseConnection(((SessionImpl) (entityManager.getDelegate())).connection());
			connection.getConfig().setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new HsqldbDataTypeFactory());
	
			FlatXmlDataSetBuilder flatXmlDataSetBuilder = new FlatXmlDataSetBuilder();
			flatXmlDataSetBuilder.setColumnSensing(true);
			ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
			
			IDataSet dataset = null;
			for (Class name : clazz) {
				dataset = flatXmlDataSetBuilder.build(contextClassLoader.getResourceAsStream("dataset/"+name.getSimpleName().toLowerCase()+XML));
				datasets.add(dataset);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void afterClass() {
		entityManager.close();
		entityManagerFactory.close();
	}
	
	public static void before(){
		entityManager.getTransaction().begin();
		try {
			for (IDataSet data : datasets) {
				DatabaseOperation.CLEAN_INSERT.execute(connection, data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static EntityManager getEntityManager() {
		return entityManager;
	}

	public static void after() {
		entityManager.getTransaction().rollback();
	}
}
