package com.prlens.issue.repository;

import com.prlens.issue.entity.IssueEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IssueRepository extends JpaRepository<IssueEntity, UUID> {
}
