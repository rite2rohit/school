package com.kstech.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kstech.model.Project;

public interface ProjectDAO extends JpaRepository<Project, Long> {

}
