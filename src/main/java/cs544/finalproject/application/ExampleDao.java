package cs544.finalproject.application;

import java.util.Collection;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
/**
 * @author suman
 * Description: ExampleDao. Only crud operations to be added here. {May be validations as well}
 */
public class ExampleDao implements IExampleDao {
	private SessionFactory sf;

	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	@Override
	@Transactional
	public void saveExample(ExampleDomain e) {
		sf.openSession().persist(e);
	}
	@Override
	@Transactional
	public void updateExample(ExampleDomain e) {
		sf.openSession().saveOrUpdate(e);
	}
	@Override
	@Transactional
	public ExampleDomain loadExample(int eNo) {
		return (ExampleDomain) sf.openSession().get(ExampleDomain.class, eNo);
	}
	@Override
	@SuppressWarnings("unchecked")
	public Collection<ExampleDomain> getExamples() {
		// To prevent our Lazy Initialization problems
		// we don't have open session in view, so instead we have to eagerly load!
		return sf.openSession().createQuery("select distinct e from Example e").list();
	}

}
