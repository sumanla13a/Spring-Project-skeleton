package cs544.finalproject.application;

import java.util.Collection;

public interface IExampleService {
	public void saveExample(ExampleDomain e);
	public void updateExample(ExampleDomain e);
	public ExampleDomain loadExample(int e);
	public Collection<ExampleDomain> getExamples();
}
