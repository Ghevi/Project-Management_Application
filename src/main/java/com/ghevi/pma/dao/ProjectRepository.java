package com.ghevi.pma.dao;

import com.ghevi.pma.dto.ChartData;
import com.ghevi.pma.entities.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Long> {

    @Override
    public List<Project> findAll();

    @Query(nativeQuery = true, value="SELECT stage as label, COUNT(*) as value " + // need a space at the end
            "FROM project " + // need a space at the end
            "GROUP BY stage")
    public List<ChartData> getProjectStatus();

}
