package com.gaurikumari.marketplace.service.impl;

import com.gaurikumari.marketplace.dto.Request.BidRequest;
import com.gaurikumari.marketplace.dto.Response.BidResponse;
import com.gaurikumari.marketplace.enums.BidStatus;
import com.gaurikumari.marketplace.enums.ProjectStatus;
import lombok.RequiredArgsConstructor;
import com.gaurikumari.marketplace.model.Bid;
import com.gaurikumari.marketplace.model.Project;
import com.gaurikumari.marketplace.model.User;
import org.springframework.stereotype.Service;
import com.gaurikumari.marketplace.repository.BidRepository;
import com.gaurikumari.marketplace.repository.ProjectRepository;
import com.gaurikumari.marketplace.repository.UserRepository;
import com.gaurikumari.marketplace.service.BidService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BidServiceImpl implements BidService {

    private final BidRepository bidRepository;
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    @Override
    public BidResponse createBid(BidRequest request) {

        // 1. Find Project
        Project project = projectRepository.findById(request.getProjectId())
                .orElseThrow(() -> new RuntimeException("Project not found with id: " + request.getProjectId()));

        // 2. Find Freelancer
        User freelancer = userRepository.findById(request.getFreelancerId())
                .orElseThrow(() -> new RuntimeException("Freelancer not found with id: " + request.getFreelancerId()));

        // 3. Validate: Project must be OPEN
        if (project.getStatus() != ProjectStatus.OPEN) {
            throw new RuntimeException("Bids can only be placed on OPEN projects. Current status: " + project.getStatus());
        }

        // 4. Validate: Prevent duplicate bid (same freelancer bidding twice on same project)
        if (bidRepository.findByProjectAndFreelancer(project, freelancer).isPresent()) {
            throw new RuntimeException("Freelancer with id: " + request.getFreelancerId()
                    + " has already placed a bid on project with id: " + request.getProjectId());
        }

        // 5. Create Bid
        Bid bid = new Bid();
        bid.setProject(project);
        bid.setFreelancer(freelancer);
        bid.setProposedAmount(request.getProposedAmount());
        bid.setProposal(request.getProposal());
        bid.setEstimatedDays(request.getEstimatedDays());

        // 6. Always set status to PENDING on creation
        bid.setStatus(BidStatus.PENDING);

        // 7. Save Bid
        Bid savedBid = bidRepository.save(bid);

        // 8. Return Response DTO
        return mapToResponse(savedBid);
    }

    @Override
    public List<BidResponse> getProjectBids(Long projectId) {
        return bidRepository.findByProjectId(projectId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<BidResponse> getFreelancerBids(Long freelancerId) {
        return bidRepository.findByFreelancerId(freelancerId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private BidResponse mapToResponse(Bid bid) {
        BidResponse response = new BidResponse();

        // Direct fields (usually safe unless 'bid' itself is null)
        response.setId(bid.getId());
        response.setProposedAmount(bid.getProposedAmount());
        response.setProposal(bid.getProposal());
        response.setEstimatedDays(bid.getEstimatedDays());
        response.setStatus(bid.getStatus());
        response.setCreatedAt(bid.getCreatedAt());


        if (bid.getProject() != null) {
            response.setProjectId(bid.getProject().getId());
            response.setProjectTitle(bid.getProject().getTitle()); // Or whatever your title field is named
        }


        if (bid.getFreelancer() != null) {
            response.setFreelancerId(bid.getFreelancer().getId());
            response.setFreelancerName(bid.getFreelancer().getFullName()); // Or whatever your name field is named
        }

        return response;
    }

}