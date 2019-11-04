package com.education.api.controller;

import com.education.center.organization.service.OrganizationService;
import com.education.framework.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Carl
 * @ClassName OrganizationController
 * @Description
 * @date 2019-11-04 23:40
 **/
@RestController
@RequestMapping("mng/api/organization")
public class OrganizationController extends BaseController {

    @Resource
    private OrganizationService organizationService;

}
