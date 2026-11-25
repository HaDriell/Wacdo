package fr.hadriel.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import fr.hadriel.model.dto.EmployeeCreateDTO;
import fr.hadriel.model.dto.EmployeeDTO;
import fr.hadriel.model.dto.EmployeeUpdateDTO;
import fr.hadriel.repositories.EmployeeRepository;
import fr.hadriel.services.mapper.EmployeeMapper;

@Service
public class EmployeeService {

    private final EmployeeMapper employeeMapper;
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeMapper employeeMapper, EmployeeRepository employeeRepository) {
        this.employeeMapper = employeeMapper;
        this.employeeRepository = employeeRepository;
    }

    public EmployeeDTO create(EmployeeCreateDTO dto) {
        var entity = employeeMapper.toEntity(dto);

        entity = employeeRepository.save(entity);

        return employeeMapper.toDto(entity);
    }

    public EmployeeDTO update(long id, EmployeeUpdateDTO dto) {
        var entity = employeeRepository.findById(id).orElseThrow();

        employeeMapper.copy(dto, entity);
        entity = employeeRepository.save(entity);

        return employeeMapper.toDto(entity);
    }

    public void delete(long id) {
        employeeRepository.deleteById(id);
    }

    public Optional<EmployeeDTO> find(long id) {
        return employeeRepository.findById(id).map(employeeMapper::toDto);
    }

    public List<EmployeeDTO> all() {
        return employeeRepository.findAll().stream()
            .map(employeeMapper::toDto)
            .collect(Collectors.toList());
    }
}
