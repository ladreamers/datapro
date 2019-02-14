package com.fork.cash.services.xxservice;

import com.fork.cash.services.entity.ProjectionSummary;

import java.util.List;

public interface ProjectedCash {
    List<ProjectionSummary> findProjectedCash();
}
