package fr.hadriel.services.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import fr.hadriel.model.Employee;
import fr.hadriel.model.dto.EmployeeCreateDTO;
import fr.hadriel.model.dto.EmployeeDTO;
import fr.hadriel.model.dto.EmployeeUpdateDTO;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    public static final EmployeeMapper MAPPER = Mappers.getMapper(EmployeeMapper.class);

    @Mapping(target = "id", ignore = true)
    Employee toEntity(EmployeeCreateDTO dto);

    EmployeeDTO toDto(Employee entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password", ignore = true)
    void copy(EmployeeUpdateDTO dto, @MappingTarget Employee entity);
}
