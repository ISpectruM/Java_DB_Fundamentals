package app.model;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class MappingUtil {

    public static <S, D> D convertFromDto(S source, Class<D> destinationClass){
        ModelMapper mapper = new ModelMapper();
        D map = mapper.map(source, destinationClass);
        return map;
    }

    public static <S, D> List<D> convertToDto(List<S> sourceList,
                                              Class <D> destinationClass){
        ModelMapper mapper = new ModelMapper();
        List<D> resultObjects = new ArrayList<>();
        for (S sourceObject : sourceList) {
            resultObjects.add(mapper.map(sourceObject, destinationClass));
        }
        return resultObjects;
    }

    public static <S, D> Set<D> convertToDtoSet(Set<S> sourceList,
                                             Class <D> destinationClass){
        ModelMapper mapper = new ModelMapper();
        Set<D> resultObjects = new HashSet<>();
        for (S sourceObject : sourceList) {
            resultObjects.add(mapper.map(sourceObject, destinationClass));
        }
        return resultObjects;
    }
}
