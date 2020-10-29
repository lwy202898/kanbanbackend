package com.kanbanboard.controller;


import com.kanbanboard.common.lang.Result;
import com.kanbanboard.entity.Applicant;
import com.kanbanboard.entity.Hruser;
import com.kanbanboard.service.ApplicantService;
import com.kanbanboard.service.HruserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  Frontend Controller
 * </p>
 *
 * @author Wenyan Liu
 * @since 2020-10-27
 */
@RestController
@RequestMapping("/hruser")
public class HruserController {
    @Autowired
    HruserService hruserService;

    @RequiresAuthentication
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Result getInfo() {
        Hruser hruser = hruserService.getById("wenyanli@alumni.cmu.edu");
        return Result.succ(hruser);
    }

    @PostMapping("/save")
    public Result save(@Validated @RequestBody Hruser user) {
        return Result.succ(user);
    }


}
