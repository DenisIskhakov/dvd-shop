package com.dvdshop.dto;

import com.dvdshop.model.Actor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;


import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ActorDTO {
    private String firstName;
    private String lastName;
    private List<FilmDTO> films;
    @Mapper
    @Component
    public abstract static class MapToView {
        public static final ActorDTO.MapToView mapActor = Mappers.getMapper(ActorDTO.MapToView.class);


        @Mappings({
        })
        public abstract ActorDTO toView(Actor entity);

        @Mappings({
        })
        public abstract Actor toEntity(ActorDTO dto);


        @AfterMapping
        void customMapping(@MappingTarget ActorDTO dto, Actor entity) {
            entity.setLastUpdate(new Date());
        }
    }
}