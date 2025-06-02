package info.htoomaungthait.ems_backend.mapper;

import info.htoomaungthait.ems_backend.dto.DepartmentDto;
import info.htoomaungthait.ems_backend.model.Department;
import info.htoomaungthait.ems_backend.request.DepartmentRequest;

public class DepartmentMapper {

    public static DepartmentDto mapToDepartmentDto(Department department){
        return new DepartmentDto(
                department.getId(),
                department.getName(),
                department.getDescription(),
                department.getStatus()
        );

    }

    public static Department mapToDepartment(DepartmentDto departmentDto){
        return new Department(
                departmentDto.getId(),
                departmentDto.getName(),
                departmentDto.getDescription(),
                departmentDto.getStatus()
        );
    }

    public  static  Department mapRequestToDepartment(DepartmentRequest departmentRequest){
        return new Department(
                departmentRequest.getName(),
                departmentRequest.getDescription(),
                departmentRequest.getStatus()
        );
    }
}
