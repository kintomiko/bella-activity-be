package org.bella.fanclub.activity.services;

import org.bella.fanclub.activity.modules.DBFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by kindai on 23/07/16.
 */
public interface FileService {
    static final String ROOT = "upload-dir";

    String generatePath();

    DBFile saveFile(String fileName, String contentType, InputStream inputStream) throws IOException;
}
