package cs544.finalproject.application;

import java.util.Collection;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author suman
 * Description: ExampleService. Call crud operations from here. Add other related methods. Remember SOC and DRY
 */
public class ExampleService implements IExampleService {
	private IExampleDao exampleDao;
	public IExampleDao getExampleDao() {
		return exampleDao;
	}
	public void setExampleDao(IExampleDao exampleDao) {
		this.exampleDao = exampleDao;
	}
	@Override
	@Transactional
	public void saveExample(ExampleDomain e) {
		exampleDao.saveExample(e);
	}
	@Override
	@Transactional
	public void updateExample(ExampleDomain e) {
		exampleDao.updateExample(e);
	}
	@Override
	@Transactional
	public ExampleDomain loadExample(int eNo) {
		return exampleDao.loadExample(eNo);
	}
	@Override
	public Collection<ExampleDomain> getExamples() {
		// To prevent our Lazy Initialization problems
		// we don't have open session in view, so instead we have to eagerly load!
		return exampleDao.getExamples();
	}
}
