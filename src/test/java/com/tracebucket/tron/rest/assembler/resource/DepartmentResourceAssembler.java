package com.tracebucket.tron.rest.assembler.resource;

import com.tracebucket.tron.domain.Department;
import com.tracebucket.tron.rest.resource.DepartmentResource;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by sadath on 06-Apr-15.
 */
@Component
public class DepartmentResourceAssembler extends ResourceAssembler<DepartmentResource, Department> {

    @Override
    public DepartmentResource toResource(Department entity) {
        DepartmentResource departmentResource = null;
        if(entity != null) {
            departmentResource = new DepartmentResource();
            departmentResource.setUid(entity.getEntityId().getId());
            departmentResource.setName(entity.getName());
            departmentResource.setDescription(entity.getDescription());
        }
        return departmentResource;
    }

    @Override
    public Set<DepartmentResource> toResources(Collection<Department> entities) {
        Set<DepartmentResource> departmentResources = new HashSet<DepartmentResource>();
        if(entities != null) {
            Iterator<Department> iterator = entities.iterator();
            if(iterator.hasNext()) {
                Department department = iterator.next();
                departmentResources.add(toResource(department));
            }
        }
        return departmentResources;    }
}