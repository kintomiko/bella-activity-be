package org.bella.fanclub.activity.services.impl;

import org.bella.fanclub.activity.modules.DBFile;
import org.bella.fanclub.activity.services.FileService;
import org.kin.common.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by kindai on 23/07/16.
 */
public class FileServiceImpl implements FileService {

    @Autowired
    @Qualifier("fileDao")
    DAO<DBFile> dbFileDAO;

    @Override
    public String generatePath() {
        return FileRepositoryUtils.getPathForId(System.currentTimeMillis(), '/', true, false);
    }

    @Override
    public DBFile saveFile(String fileName, String contentType, InputStream inputStream) throws IOException {
        DBFile dbFile = new DBFile();
        dbFile.setFileName(fileName);
        dbFile.setContentType(contentType);
        dbFile.setFilePath(this.generatePath());

        String dir = dbFile.getFilePath().substring(0, dbFile.getFilePath().lastIndexOf('/'));
        if(!Files.exists(Paths.get(FileService.ROOT, dir))){
            Files.createDirectories(Paths.get(FileService.ROOT, dir));
        }
        dbFile.setSize(Files.copy(inputStream, Paths.get(FileService.ROOT, dbFile.getFilePath())));
        DBFile rstFile = dbFileDAO.create(dbFile);
        return rstFile;
    }
}
