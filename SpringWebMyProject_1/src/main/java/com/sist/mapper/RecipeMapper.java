package com.sist.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface RecipeMapper {
	@Select("SELECT * FROM recipe ORDER BY no")
	public List<RecipeVO> recipeListData();
}
