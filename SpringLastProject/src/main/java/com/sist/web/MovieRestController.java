package com.sist.web;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.manager.YoutubeManager;import com.sist.vo.MemberVO;
import com.sist.vo.MovieVO;

@RestController
public class MovieRestController {
	@Autowired
	private YoutubeManager ym;
	
	@GetMapping("movie/find_vue.do")
	public Map movie_find(String fd) {
		Map map = new HashMap();
		// 동영상 제목 / 동영상 키 
		try {
			String json=ym.youtubeJsonData(fd);
			//System.out.println(json);
			JSONParser jp=new JSONParser();
			JSONObject root=(JSONObject)jp.parse(json);
			JSONArray items=(JSONArray)root.get("items");
			List<MovieVO> list=new ArrayList<MovieVO>();
			for (int i = 0; i < items.size(); i++) {
				JSONObject obj=(JSONObject)items.get(i);
				MovieVO vo=new MovieVO();
				JSONObject id=(JSONObject)obj.get("id");
				String key=(String)id.get("videoId");
				JSONObject sni=(JSONObject)obj.get("snippet");
				String title=(String)sni.get("title");
				
				vo.setTitle(title);
				vo.setVedioId(title);
				list.add(vo);
			}
			map.put("list", list);
		}catch(Exception ex) {}
		return map;
	}
}
