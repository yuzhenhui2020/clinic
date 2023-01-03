package com.xiaoniucr.controller.base;

import com.xiaoniucr.service.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 基础控制器
 */
public class BaseController {

    @Autowired
    public UserService userService;

    @Autowired
    public DoctorService doctorService;

    @Autowired
    public NoticeService noticeService;

    @Autowired
    public AdminService adminService;

    @Autowired
    public FeedbackService feedbackService;

    @Autowired
    public DeptService deptService;

    @Autowired
    public DrugService drugService;

    @Autowired
    public PlanService planService;

    @Autowired
    public SourceService sourceService;

    @Autowired
    public AppointService appointService;

    @Autowired
    public HistoryService historyService;

    @Autowired
    public BillService billService;

    @Autowired
    public RecipeService recipeService;

}
