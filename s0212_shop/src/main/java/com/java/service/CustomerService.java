package com.java.service;

import java.util.ArrayList;
import java.util.Map;

import com.java.dto.BoardDto;

public interface CustomerService {

	Map<String, Object> notice(int page,String category, String searchW);

	Map<String, Object> nview(int bno);

}
