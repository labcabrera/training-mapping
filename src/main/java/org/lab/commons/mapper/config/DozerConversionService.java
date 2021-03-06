package org.lab.commons.mapper.config;

import javax.inject.Inject;

import org.dozer.Mapper;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;

class DozerConversionService implements ConversionService {

	@Inject
	private Mapper mapper;

	@Override
	public boolean canConvert(Class<?> sourceType, Class<?> targetType) {
		return true;
	}

	@Override
	public boolean canConvert(TypeDescriptor sourceType, TypeDescriptor targetType) {
		return true;
	}

	@Override
	public <T> T convert(Object source, Class<T> targetType) {
		return mapper.map(source, targetType);
	}

	@Override
	public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
		return convert(source, targetType.getClass());
	}
}
