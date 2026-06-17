package com.gaurikumari.marketplace.repository;

import com.gaurikumari.marketplace.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository
        extends JpaRepository<Project, Long> {
}
