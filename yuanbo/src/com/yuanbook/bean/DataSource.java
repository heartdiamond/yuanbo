package com.yuanbook.bean;

import java.util.Properties;

public class DataSource {
	private Properties property;

	@Override
	public String toString() {
		return "DataSource [property=" + property + "]";
	}

	public Properties getProperty() {
		return property;
	}

	public void setProperty(Properties property) {
		this.property = property;
	}

}
