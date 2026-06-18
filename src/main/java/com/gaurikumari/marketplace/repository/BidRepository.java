package com.gaurikumari.marketplace.repository;

import com.gaurikumari.marketplace.model.Bid;
import com.gaurikumari.marketplace.model.Project;
import com.gaurikumari.marketplace.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface BidRepository extends JpaRepository<Bid, Long> {

    List<Bid> findByProject(Project project);

    List<Bid> findByFreelancer(User freelancer);

    Optional<Bid> findByProjectAndFreelancer(Project project, User freelancer);
    List<Bid> findByProjectId(Long projectId);


    List<Bid> findByFreelancerId(Long freelancerId);

}