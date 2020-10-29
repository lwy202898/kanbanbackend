package com.kanbanboard.controller;


import com.kanbanboard.common.lang.Result;
import com.kanbanboard.entity.Applicant;
import com.kanbanboard.entity.Comment;
import com.kanbanboard.service.ApplicantService;
import com.kanbanboard.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Frontend Controller
 * </p>
 *
 * @author Wenyan Liu
 * @since 2020-10-27
 */
@RestController
public class ApplicantController {
    @Autowired
    ApplicantService applicantService;
    @Autowired
    CommentService commentService;
    @RequestMapping(value = "/check-applicant", method = RequestMethod.GET)
    public Result getInfo(@RequestParam("contact") String contact) {
        Applicant applicant = applicantService.getById(contact);
        if (applicant != null) {
            return Result.succ('1');
        }
        return Result.succ(null);
    }
    @RequestMapping(value = "/get-all-applicants", method = RequestMethod.GET)
    public Result getAllInfo() {
        List<Applicant> allApplicants = applicantService.list();
        List<Comment> allComments = commentService.list();
        Map<String, List> dataObjects = new HashMap<>();
        dataObjects.put("Applicant", allApplicants);
        dataObjects.put("Comment", allComments);
        return Result.succ(dataObjects);
    }
    @PostMapping(value = "/add-applicant")
    public Result addApplicant(@RequestBody Applicant applicant) {
        applicant.setRateCount(0);
        applicant.setRate(0.0);
        applicantService.save(applicant);
        return Result.succ(null);
    }

    @PostMapping(value = "/add-rate")
    public Result addRate(@RequestBody Applicant applicant) {
        Applicant exist = applicantService.getById(applicant.getContact());
        applicant.setRateCount(exist.getRateCount() + 1);
        applicant.setRate((applicant.getRate() + exist.getRate()) / applicant.getRateCount());
        applicant.setStatus(exist.getStatus());
        applicantService.updateById(applicant);
        return Result.succ(null);
    }

    @PostMapping(value = "/update-applicant-status")
    public Result updateStatus(@RequestBody Applicant applicant) {
        Applicant exist = applicantService.getById(applicant.getContact());
        applicant.setRateCount(exist.getRateCount());
        applicant.setRate(exist.getRate());
        applicantService.updateById(applicant);
        return Result.succ(null);
    }
}
