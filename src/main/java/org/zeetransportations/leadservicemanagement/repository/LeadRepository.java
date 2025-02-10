package org.zeetransportations.leadservicemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zeetransportations.leadservicemanagement.entity.Lead;

@Repository
public interface LeadRepository extends JpaRepository<Lead,Integer> {
}
