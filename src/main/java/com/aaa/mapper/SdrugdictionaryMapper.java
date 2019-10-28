package com.aaa.mapper;

import com.aaa.entity.Area;
import com.aaa.entity.Sdrugdictionary;
import com.aaa.entity.Type;
import com.aaa.entity.Unit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SdrugdictionaryMapper {
    List<SdrugdictionaryMapper> findAllSdrugdictionary(Sdrugdictionary sdrugdictionary);
    int addSdrugdictionary(Sdrugdictionary sdrugdictionary);
    int editSdrugdictionary(Sdrugdictionary sdrugdictionary);
    int deleteSdrugdictionary(Integer drugId);
    List<Unit> findAllUnit();
    List<Area> findAllArea();
    List<Type> findAllType();
}