package org.bella.fanclub.activity.modules;

import org.kin.common.model.Entity;

/**
 * Created by kindai on 23/07/16.
 */
public class DBFile extends Entity{

    String fileName;
    String filePath;
    String contentType;
    private long size;

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getSize() {
        return size;
    }
}
