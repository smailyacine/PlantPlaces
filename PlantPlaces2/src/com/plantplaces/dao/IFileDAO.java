package com.plantplaces.dao;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public interface IFileDAO {

	/**
	 * save data from an input stream to an output file
	 * @param inputStream
	 * @param file
	 * @throws IOException
	 */
	void save(InputStream inputStream, File file) throws IOException;

}