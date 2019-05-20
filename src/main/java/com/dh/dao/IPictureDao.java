package com.dh.dao;

import java.util.List;
import java.util.Map;

import com.dh.entity.Picture;

public interface IPictureDao {

	List<Picture> queryContents(Picture picture);

	int deletePic(Picture picture);
	 
	int insertPicByMap(Map map);

	int updatePic(Map map);

	Picture selectPicById(Picture picture);
}
