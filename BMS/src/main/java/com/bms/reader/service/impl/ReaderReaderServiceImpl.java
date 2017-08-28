package com.bms.reader.service.impl;

import com.bms.reader.common.ContextHolder;
import com.bms.reader.constant.ParamConstants;
import com.bms.reader.model.ReaderReader;
import com.bms.reader.model.ReaderUser;
import com.bms.reader.persist.ReaderReaderMapper;
import com.bms.reader.persist.ReaderUserMapper;
import com.bms.reader.service.ReaderReaderService;
import com.bms.reader.service.ReaderUserService;
import com.bms.reader.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @ClassName: ReaderuserService
 * @Description: 用户相关service实现类
 * @author: shenlx
 * @date: 2017年3月29日 上午8:51:12
 */
@Service
public class ReaderReaderServiceImpl implements ReaderReaderService {

	@Autowired
	private ReaderReaderMapper readerReaderMapper;


	@Override
	public void updataavatar(String path,String readerId) {
		readerReaderMapper.updataavatar(path,readerId);
		
	}

}
