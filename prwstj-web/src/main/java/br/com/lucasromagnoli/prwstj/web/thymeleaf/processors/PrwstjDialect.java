package br.com.lucasromagnoli.prwstj.web.thymeleaf.processors;

import java.util.HashSet;
import java.util.Set;

import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

public class PrwstjDialect extends AbstractProcessorDialect {

	public PrwstjDialect() {
		super("Lucas Romagnoli Prwstj", "prwstj", StandardDialect.PROCESSOR_PRECEDENCE);
	}

	@Override
	public Set<IProcessor> getProcessors(String dialectPrefix) {
		final Set<IProcessor> processors = new HashSet<>();
		processors.add(new MessageElementTagProcessor(dialectPrefix));
		
		return processors;
	}

}
